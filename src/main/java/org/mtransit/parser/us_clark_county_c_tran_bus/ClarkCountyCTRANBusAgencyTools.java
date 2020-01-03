package org.mtransit.parser.us_clark_county_c_tran_bus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.mtransit.parser.CleanUtils;
import org.mtransit.parser.DefaultAgencyTools;
import org.mtransit.parser.Pair;
import org.mtransit.parser.SplitUtils;
import org.mtransit.parser.SplitUtils.RouteTripSpec;
import org.mtransit.parser.Utils;
import org.mtransit.parser.gtfs.data.GCalendar;
import org.mtransit.parser.gtfs.data.GCalendarDate;
import org.mtransit.parser.gtfs.data.GRoute;
import org.mtransit.parser.gtfs.data.GSpec;
import org.mtransit.parser.gtfs.data.GStop;
import org.mtransit.parser.gtfs.data.GTrip;
import org.mtransit.parser.gtfs.data.GTripStop;
import org.mtransit.parser.mt.data.MAgency;
import org.mtransit.parser.mt.data.MRoute;
import org.mtransit.parser.mt.data.MTrip;
import org.mtransit.parser.mt.data.MTripStop;

// https://www.c-tran.com/about-c-tran/business/c-tran-gtfs-data
// https://www.c-tran.com/images/Google/GoogleTransitUpload.zip
public class ClarkCountyCTRANBusAgencyTools extends DefaultAgencyTools {

	public static void main(String[] args) {
		if (args == null || args.length == 0) {
			args = new String[3];
			args[0] = "input/gtfs.zip";
			args[1] = "../../mtransitapps/us-clark-county-c-tran-bus-android/res/raw/";
			args[2] = ""; // files-prefix
		}
		new ClarkCountyCTRANBusAgencyTools().start(args);
	}

	private HashSet<String> serviceIds;

	@Override
	public void start(String[] args) {
		System.out.printf("\nGenerating C-TRAN bus data...");
		long start = System.currentTimeMillis();
		this.serviceIds = extractUsefulServiceIds(args, this, true);
		super.start(args);
		System.out.printf("\nGenerating C-TRAN bus data... DONE in %s.\n", Utils.getPrettyDuration(System.currentTimeMillis() - start));
	}

	@Override
	public boolean excludingAll() {
		return this.serviceIds != null && this.serviceIds.isEmpty();
	}

	@Override
	public boolean excludeCalendar(GCalendar gCalendar) {
		if (this.serviceIds != null) {
			return excludeUselessCalendar(gCalendar, this.serviceIds);
		}
		return super.excludeCalendar(gCalendar);
	}

	@Override
	public boolean excludeCalendarDate(GCalendarDate gCalendarDates) {
		if (this.serviceIds != null) {
			return excludeUselessCalendarDate(gCalendarDates, this.serviceIds);
		}
		return super.excludeCalendarDate(gCalendarDates);
	}

	@Override
	public boolean excludeTrip(GTrip gTrip) {
		if (this.serviceIds != null) {
			return excludeUselessTrip(gTrip, this.serviceIds);
		}
		return super.excludeTrip(gTrip);
	}

	@Override
	public Integer getAgencyRouteType() {
		return MAgency.ROUTE_TYPE_BUS;
	}

	private static final String RSN_VINE = "The Vine";

	private static final long VIDE_RID = 50L;

	@Override
	public long getRouteId(GRoute gRoute) {
		if (RSN_VINE.equalsIgnoreCase(gRoute.getRouteShortName())) {
			return VIDE_RID;
		}
		return Long.parseLong(gRoute.getRouteShortName()); // using route short name as route ID
	}

	// private static final String AGENCY_COLOR_BLUE = "065AC2"; // BLUE (from web site CSS)
	private static final String AGENCY_COLOR_BLUE = "036CB6"; // BLUE (from map PDF)

	private static final String AGENCY_COLOR = AGENCY_COLOR_BLUE;

	@Override
	public String getAgencyColor() {
		return AGENCY_COLOR;
	}

	private static final String EXPRESS_ROUTES_COLOR = "ED1A3B"; // RED (from PDF map)
	private static final String LIMITED_ROUTES_COLOR = "191919"; // "000000" // BLACK (from PDF map)

	@Override
	public String getRouteColor(GRoute gRoute) {
		if (StringUtils.isEmpty(gRoute.getRouteColor()) //
				|| "000000".equalsIgnoreCase(gRoute.getRouteColor())) {
			if (RSN_VINE.equalsIgnoreCase(gRoute.getRouteShortName())) {
				return "78BE20";
			}
			int rsn = Integer.parseInt(gRoute.getRouteShortName());
			switch (rsn) {
				// @formatter:off
				case 2: return "956338";
				case 3: return "00A651";
				case 4: return "B99874";
				case 6: return "01A553";
				case 7: return "8DC63F";
				case 9: return "8781BD";
				case 19: return "32BCAD";
				case 25: return "C1B400";
				case 30: return "BA6831";
				case 32: return "2E3092";
				case 37: return "F7941E";
				case 38: return "B41E8E";
				case 39: return "EC008E";
				case 41: return LIMITED_ROUTES_COLOR;
				case 44: return LIMITED_ROUTES_COLOR;
				case 47: return LIMITED_ROUTES_COLOR;
				case 50: return "78BE20"; // VINE
				case 60: return LIMITED_ROUTES_COLOR;
				case 65: return LIMITED_ROUTES_COLOR;
				case 67: return LIMITED_ROUTES_COLOR;
				case 71: return "FDB913";
				case 72: return "92278F";
				case 73: return "BA7031";
				case 74: return "F573A9";
				case 78: return "00AEEf";
				case 80: return "0072BC";
				case 92: return "BC9632";
				case 105: return EXPRESS_ROUTES_COLOR;
				case 134: return EXPRESS_ROUTES_COLOR;
				case 157: return EXPRESS_ROUTES_COLOR;
				case 164: return EXPRESS_ROUTES_COLOR;
				case 177: return EXPRESS_ROUTES_COLOR;
				case 190: return EXPRESS_ROUTES_COLOR;
				case 199: return EXPRESS_ROUTES_COLOR;
				// @formatter:on
			}
			if (isGoodEnoughAccepted()) {
				return null;
			}
			System.out.printf("\nUnexpected route color %s!\n", gRoute);
			System.exit(-1);
			return null;
		}
		return super.getRouteColor(gRoute);
	}

	@Override
	public String getRouteLongName(GRoute gRoute) {
		String gRouteLongName = gRoute.getRouteLongName();
		return cleanRouteLongName(gRouteLongName);
	}

	private static final Pattern STARTS_WITH_RSN = Pattern.compile("(^[0-9]+ - )", Pattern.CASE_INSENSITIVE);

	private String cleanRouteLongName(String gRouteLongName) {
		gRouteLongName = STARTS_WITH_RSN.matcher(gRouteLongName).replaceAll(StringUtils.EMPTY);
		return CleanUtils.cleanLabel(gRouteLongName);
	}

	private static HashMap<Long, RouteTripSpec> ALL_ROUTE_TRIPS2;

	static {
		HashMap<Long, RouteTripSpec> map2 = new HashMap<Long, RouteTripSpec>();
		ALL_ROUTE_TRIPS2 = map2;
	}

	@Override
	public int compareEarly(long routeId, List<MTripStop> list1, List<MTripStop> list2, MTripStop ts1, MTripStop ts2, GStop ts1GStop, GStop ts2GStop) {
		if (ALL_ROUTE_TRIPS2.containsKey(routeId)) {
			return ALL_ROUTE_TRIPS2.get(routeId).compare(routeId, list1, list2, ts1, ts2, ts1GStop, ts2GStop, this);
		}
		return super.compareEarly(routeId, list1, list2, ts1, ts2, ts1GStop, ts2GStop);
	}

	@Override
	public ArrayList<MTrip> splitTrip(MRoute mRoute, GTrip gTrip, GSpec gtfs) {
		if (ALL_ROUTE_TRIPS2.containsKey(mRoute.getId())) {
			return ALL_ROUTE_TRIPS2.get(mRoute.getId()).getAllTrips();
		}
		return super.splitTrip(mRoute, gTrip, gtfs);
	}

	@Override
	public Pair<Long[], Integer[]> splitTripStop(MRoute mRoute, GTrip gTrip, GTripStop gTripStop, ArrayList<MTrip> splitTrips, GSpec routeGTFS) {
		if (ALL_ROUTE_TRIPS2.containsKey(mRoute.getId())) {
			return SplitUtils.splitTripStop(mRoute, gTrip, gTripStop, routeGTFS, ALL_ROUTE_TRIPS2.get(mRoute.getId()), this);
		}
		return super.splitTripStop(mRoute, gTrip, gTripStop, splitTrips, routeGTFS);
	}

	@Override
	public void setTripHeadsign(MRoute mRoute, MTrip mTrip, GTrip gTrip, GSpec gtfs) {
		if (ALL_ROUTE_TRIPS2.containsKey(mRoute.getId())) {
			return; // split
		}
		final int headSignId = gTrip.getDirectionId() == null ? 0 : gTrip.getDirectionId();
		mTrip.setHeadsignString(cleanTripHeadsign(gTrip.getTripHeadsign()), headSignId);
	}

	@Override
	public boolean mergeHeadsign(MTrip mTrip, MTrip mTripToMerge) {
		List<String> headsignsValues = Arrays.asList(mTrip.getHeadsignValue(), mTripToMerge.getHeadsignValue());
		if (mTrip.getRouteId() == 6L) {
			if (Arrays.asList( //
					"VA Medical Ctr", // <>
					"Fruit Vly Rd & La Fra" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Fruit Vly Rd & La Fra", mTrip.getHeadsignId()); // FRUIT_VALLEY
				return true;
			}
			if (Arrays.asList( //
					"VA Transit Ctr", // <>
					"Fruit Vly Rd & La Fra" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Fruit Vly Rd & La Fra", mTrip.getHeadsignId()); // FRUIT_VALLEY
				return true;
			}
			if (Arrays.asList( //
					"VA Medical Ctr", // <>
					"Columbia House Blvd @ P" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Columbia House Blvd @ P", mTrip.getHeadsignId()); // GRAND_CENTRAL
				return true;
			}
			if (Arrays.asList( //
					"VA Transit Ctr", // <>
					"Columbia House Blvd @ P" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Columbia House Blvd @ P", mTrip.getHeadsignId()); // GRAND_CENTRAL
				return true;
			}
		} else if (mTrip.getRouteId() == 25L) {
			if (Arrays.asList( //
					"Evergreen Blvd & C St", //
					"99th St TC" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("99th St TC", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 41L) {
			if (Arrays.asList( //
					"Washington St & W 9th St", //
					"Fisher's Lndg Transit" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Fisher's Lndg Transit", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 60L) {
			if (Arrays.asList( //
					"City Ctr No Jantzen", //
					"City Ctr" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("City Ctr", mTrip.getHeadsignId());
				return true;
			}
			if (Arrays.asList( //
					"Broadway & 12th St Fs", //
					"Delta Pk No Jantzen", //
					"Delta Pk" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Delta Pk", mTrip.getHeadsignId());
				return true;
			}
			if (Arrays.asList( //
					"Broadway & 12th St Fs", //
					"Delta Pk / Vanport MAX" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Delta Pk / Vanport MAX", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 65L) {
			if (Arrays.asList( //
					"39th St. & J St. [nb]", //
					"Addy St & Addy Loop" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Addy St & Addy Loop", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 80L) {
			if (Arrays.asList( //
					"VM", //
					"Van Mall TC" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Van Mall TC", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 92L) {
			if (Arrays.asList( //
					"39th St. & J St. [nb]", //
					"Addy St & Addy Loop" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Addy St & Addy Loop", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 105L) {
			if (Arrays.asList( //
					"SW 5th & Alder", //
					"SW 6th & Columbia" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("SW 6th & Columbia", mTrip.getHeadsignId()); // Portland SOUTH
				return true;
			}
		} else if (mTrip.getRouteId() == 134L) {
			if (Arrays.asList( //
					"PDX", //
					"SW 5th & Hall" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("SW 5th & Hall", mTrip.getHeadsignId());
				return true;
			}
			if (Arrays.asList( //
					"SC", //
					"Salmon Crk P&R" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("Salmon Crk P&R", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 164L) {
			if (Arrays.asList( //
					"SW 5th & Morrison", //
					"SW 5th & Harrison" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("SW 5th & Harrison", mTrip.getHeadsignId());
				return true;
			}
			if (Arrays.asList( //
					"SW 5th & Morrison", //
					"SW 5th & Harrison", //
					"SW 6th & Mkt" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("SW 6th & Mkt", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 177L) {
			if (Arrays.asList( //
					"SW 5th & Harrison", //
					"SW 6th & Mkt" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("SW 6th & Mkt", mTrip.getHeadsignId());
				return true;
			}
		} else if (mTrip.getRouteId() == 199L) {
			if (Arrays.asList( //
					"SW 6th & Columbia", //
					"SW 5th & Hall" //
			).containsAll(headsignsValues)) {
				mTrip.setHeadsignString("SW 5th & Hall", mTrip.getHeadsignId());
				return true;
			}
		}
		System.out.printf("\nUnexpected trips to merge: %s & %s!\n", mTrip, mTripToMerge);
		System.exit(-1);
		return false;
	}

	@Override
	public String cleanTripHeadsign(String tripHeadsign) {
		tripHeadsign = CleanUtils.CLEAN_AT.matcher(tripHeadsign).replaceAll(CleanUtils.CLEAN_AT_REPLACEMENT);
		tripHeadsign = CleanUtils.keepToAndRevoveVia(tripHeadsign);
		tripHeadsign = CleanUtils.cleanSlashes(tripHeadsign);
		tripHeadsign = CleanUtils.cleanNumbers(tripHeadsign);
		tripHeadsign = CleanUtils.cleanStreetTypes(tripHeadsign);
		return cleanRouteLongName(tripHeadsign);
	}

	@Override
	public String cleanStopName(String gStopName) {
		gStopName = CleanUtils.SAINT.matcher(gStopName).replaceAll(CleanUtils.SAINT_REPLACEMENT);
		gStopName = CleanUtils.CLEAN_AND.matcher(gStopName).replaceAll(CleanUtils.CLEAN_AND_REPLACEMENT);
		gStopName = CleanUtils.CLEAN_AT.matcher(gStopName).replaceAll(CleanUtils.CLEAN_AT_REPLACEMENT);
		gStopName = CleanUtils.cleanSlashes(gStopName);
		gStopName = CleanUtils.removePoints(gStopName);
		gStopName = CleanUtils.cleanStreetTypes(gStopName);
		return cleanRouteLongName(gStopName);
	}

	@Override
	public int getStopId(GStop gStop) {
		return Integer.parseInt(gStop.getStopCode()); // use stop CODE as stop ID
	}
}
