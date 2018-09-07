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
import org.mtransit.parser.mt.data.MDirectionType;
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

	private static final String RSN_VINE = "Vine";

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

	private static final Pattern STARTS_WITH_RSN = Pattern.compile("(^[0-9]+ \\- )", Pattern.CASE_INSENSITIVE);

	private String cleanRouteLongName(String gRouteLongName) {
		gRouteLongName = STARTS_WITH_RSN.matcher(gRouteLongName).replaceAll(StringUtils.EMPTY);
		return CleanUtils.cleanLabel(gRouteLongName);
	}

	private static final String TRANSIT_CENTER_SHORT = "TC";
	private static final String VANCOUVER_SHORT = "Van";
	//
	private static final String _152ND_AVENUE = "152nd Ave";
	private static final String _162ND_AVENUE = "162nd Ave";
	private static final String _45TH_STREET = "45th St";
	private static final String _99TH_STREET_TRANSIT_CENTER = "99th St " + TRANSIT_CENTER_SHORT;
	private static final String BATTLE_GROUND = "Battle Ground";
	private static final String DELTA_PARK = "Delta Pk";
	private static final String DOWNTOWN_VANCOUVER = "Downtown " + VANCOUVER_SHORT;
	private static final String FISHER_S_LANDING_TRANSIT_CENTER = "Fisher's Landing " + TRANSIT_CENTER_SHORT;
	private static final String FRUIT_VALLEY = "Fruit Vly";
	private static final String GRAND_CENTRAL = "Grand Central"; // Grand Ctrl
	private static final String MAX = "MAX";
	private static final String PARKROSE_MAX = "Parkrose " + MAX;
	private static final String PORTLAND = "Portland";
	private static final String VANCOUVER = "Vancouver"; // VANCOUVER_SHORT
	private static final String VANCOUVER_MALL_TRANSIT_CENTER = VANCOUVER_SHORT + " Mall " + TRANSIT_CENTER_SHORT;
	private static final String WSU_VANCOUVER = "WSU " + VANCOUVER_SHORT;
	private static final String YACOLT = "Yacolt";

	private static HashMap<Long, RouteTripSpec> ALL_ROUTE_TRIPS2;
	static {
		HashMap<Long, RouteTripSpec> map2 = new HashMap<Long, RouteTripSpec>();
		map2.put(2l, new RouteTripSpec(2l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("632"), // Broadway & Evergreen Blvd
								Stops.ALL_STOPS.get("110"), // 99th Street TC & NE 7th Ave
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("110"), // 99th Street TC & NE 7th Ave
								Stops.ALL_STOPS.get("2003"), // ==
								Stops.ALL_STOPS.get("3260"), // !=
								Stops.ALL_STOPS.get("3492"), // !=
								Stops.ALL_STOPS.get("579"), // ==
								Stops.ALL_STOPS.get("632"), // Broadway & Evergreen Blvd
						})) //
				.compileBothTripSort());
		map2.put(6l, new RouteTripSpec(6l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, GRAND_CENTRAL, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FRUIT_VALLEY) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6023"), // Fruit Valley Rd & La Frambois
								Stops.ALL_STOPS.get("1607"), // VA Transit Center
								Stops.ALL_STOPS.get("6066"), // Columbia House Blvd at Park & Ride
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6066"), // Columbia House Blvd at Park & Ride
								Stops.ALL_STOPS.get("1607"), // VA Transit Center
								Stops.ALL_STOPS.get("6023"), // Fruit Valley Rd & La Frambois
						})) //
				.compileBothTripSort());
		map2.put(7l, new RouteTripSpec(7l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, BATTLE_GROUND, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6137"), // Van Mall Transit Center
								Stops.ALL_STOPS.get("3076"), // Grace & Rasmussen
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("3076"), // Grace & Rasmussen
								Stops.ALL_STOPS.get("6137"), // Van Mall Transit Center
						})) //
				.compileBothTripSort());
		map2.put(9l, new RouteTripSpec(
				9l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, "139th St & 10th Ave", MDirectionType.SOUTH.intValue(),
				MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("110"), // 99th Street TC
								Stops.ALL_STOPS.get("6014"), // NE 139th St & 10th Ave
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6014"), // NE 139th St & 10th Ave
								Stops.ALL_STOPS.get("110"), // 99th Street TC
						})) //
				.compileBothTripSort());
		map2.put(19l, new RouteTripSpec(19l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, WSU_VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("110"), // 99th Street TC
								Stops.ALL_STOPS.get("6122"), // NE 29th Ave & WSUV Trailhead
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6122"), // NE 29th Ave & WSUV Trailhead
								Stops.ALL_STOPS.get("110"), // 99th Street TC
						})) //
				.compileBothTripSort());
		map2.put(25l, new RouteTripSpec(25l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("3492"), // Mill Plain & Franklin [eb]
								Stops.ALL_STOPS.get("1104"), // Evergreen Blvd & C St
								Stops.ALL_STOPS.get("110"), // 99th Street TC {
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("110"), // 99th Street TC {,
								Stops.ALL_STOPS.get("3492"), // Mill Plain & Franklin [eb]
						})) //
				.compileBothTripSort());
		map2.put(30l, new RouteTripSpec(30l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("632"), // Broadway & Evergreen Blvd
								Stops.ALL_STOPS.get("3058"), // NE 18th St & 65th Ave [eb]
								Stops.ALL_STOPS.get("106"), // Fisher's Landing Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("106"), // Fisher's Landing Transit Center
								Stops.ALL_STOPS.get("1076"), // NE 18th St & 65th Ave [wb]
								Stops.ALL_STOPS.get("632"), // Broadway & Evergreen Blvd
						})) //
				.compileBothTripSort());
		map2.put(37l, new RouteTripSpec(37l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) // Evergreen Blvd & C St
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("1104"), // Evergreen Blvd & C St
								Stops.ALL_STOPS.get("1202"), // Mill Plain 6600 Block
								Stops.ALL_STOPS.get("1312"), // == Mill Plain 16000 Block
								Stops.ALL_STOPS.get("1310"), // != SE 164th Ave 900 Block
								Stops.ALL_STOPS.get("1318"), // != SE 164th Ave & 32nd St
								Stops.ALL_STOPS.get("2919"), // != Mill Plain & 172nd Ave [eb]
								Stops.ALL_STOPS.get("6086"), // != SE 34th St & 172nd Ave [wb]
								Stops.ALL_STOPS.get("106"), // Fisher's Landing Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("106"), // Fisher's Landing Transit Center
								Stops.ALL_STOPS.get("6087"), // != SE 34th Street & 172nd Avenue [eb]
								Stops.ALL_STOPS.get("6043"), // != Mill Plain & 172nd Ave [wb]
								Stops.ALL_STOPS.get("1316"), // != SE 164th Ave 3200 Block
								Stops.ALL_STOPS.get("2130"), // != SE 164th Ave 1400 Block
								Stops.ALL_STOPS.get("1320"), // == Mill Plain & 164th Ave [wb]
								Stops.ALL_STOPS.get("1104"), // Evergreen Blvd & C St
						})) //
				.compileBothTripSort());
		map2.put(39l, new RouteTripSpec(39l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, "Stapleton", //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("1607"), // VA Transit Center
								Stops.ALL_STOPS.get("632"), // Broadway & Evergreen Blvd
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("632"), // Broadway & Evergreen Blvd
								Stops.ALL_STOPS.get("1607"), // VA Transit Center
						})) //
				.compileBothTripSort());
		map2.put(41l, new RouteTripSpec(41l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) // E 15th St & Broadway [wb
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6046"), // E 15th St & Broadway [wb]
								Stops.ALL_STOPS.get("6053"), // Washington St & W 9th St fs
								Stops.ALL_STOPS.get("106"), // Fisher's Landing Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("106"), // Fisher's Landing Transit Center
								Stops.ALL_STOPS.get("6046"), // E 15th St & Broadway [wb]
						})) //
				.compileBothTripSort());
		map2.put(47l, new RouteTripSpec(47l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, YACOLT, // BATTLE_GROUND // Fairgrounds Ave at Ball
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) // Washington St & W 9th St
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("631"), // Broadway & 7th St
								Stops.ALL_STOPS.get("632"), // ++ Broadway & Evergreen Blvd
								Stops.ALL_STOPS.get("831"), // ++ W Main & SE Clark Ave [eb]
								Stops.ALL_STOPS.get("3741"), // ++ Yacolt Rd & Railroad Ave
								Stops.ALL_STOPS.get("6038"), // Fairgrounds Ave at Ball Park
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6038"), // Fairgrounds Ave at Ball Park
								Stops.ALL_STOPS.get("3741"), // ++ Yacolt Rd & Railroad Ave
								Stops.ALL_STOPS.get("835"), // ++ W Main & 3rd Ave [wb]
								Stops.ALL_STOPS.get("579"), // ++ Washington & 13th St
								Stops.ALL_STOPS.get("6053"), // Washington St & W 9th St fs
						})) //
				.compileBothTripSort());
		map2.put(60l, new RouteTripSpec(60l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DELTA_PARK) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("111"), // Delta Park/Vanport MAX
								Stops.ALL_STOPS.get("1612"), // != N Hayden Island Dr & N Tomahawk Dr
								Stops.ALL_STOPS.get("6052"), // != 12100 N. Pavilion
								Stops.ALL_STOPS.get("631"), // Broadway & 7th St
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("631"), // Broadway & 7th St
								Stops.ALL_STOPS.get("6154"), // == Broadway & 12th St fs
								Stops.ALL_STOPS.get("6013"), // != Jantzen Beach Main Stop
								Stops.ALL_STOPS.get("6052"), // != 12100 N. Pavilion
								Stops.ALL_STOPS.get("111"), // Delta Park/Vanport MAX
						})) //
				.compileBothTripSort());
		map2.put(65l, new RouteTripSpec(65l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PARKROSE_MAX) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("101"), // Parkrose/Sumner Transit Center
								Stops.ALL_STOPS.get("106"), // Fisher's Landing Transit Center
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("106"), // Fisher's Landing Transit Center
								Stops.ALL_STOPS.get("101"), // Parkrose/Sumner Transit Center
						})) //
				.compileBothTripSort());
		map2.put(71l, new RouteTripSpec(71l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("632"), // Broadway & Evergreen Blvd
								Stops.ALL_STOPS.get("110"), // 99th Street TC
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("110"), // 99th Street TC
								Stops.ALL_STOPS.get("632"), // Broadway & Evergreen Blvd
						})) //
				.compileBothTripSort());
		map2.put(72l, new RouteTripSpec(72l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, _152ND_AVENUE, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6137"), // Van Mall Transit Center
								Stops.ALL_STOPS.get("1095"), // NE 76th St & Ward Rd
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("1095"), // NE 76th St & Ward Rd
								Stops.ALL_STOPS.get("6137"), // Van Mall Transit Center
						})) //
				.compileBothTripSort());
		map2.put(73l, new RouteTripSpec(73l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, "") //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6137"), // Van Mall Transit Center
								Stops.ALL_STOPS.get("6117"), // Van Mall Loop & East Trailhead
								Stops.ALL_STOPS.get("6116"), // Van Mall Loop & West Trailhead
								Stops.ALL_STOPS.get("6137"), // Van Mall Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						// no stops
						})) //
				.compileBothTripSort());
		map2.put(74l, new RouteTripSpec(74l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, _162ND_AVENUE, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6137"), // Van Mall Transit Center
								Stops.ALL_STOPS.get("6174"), // NE Ward Rd. & NE 162nd Ave.
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6174"), // NE Ward Rd. & NE 162nd Ave.
								Stops.ALL_STOPS.get("6137"), // Van Mall Transit Center
						})) //
				.compileBothTripSort());
		map2.put(78l, new RouteTripSpec(78l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("110"), // 99th Street TC
								Stops.ALL_STOPS.get("6137"), // Van Mall Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6137"), // Van Mall Transit Center
								Stops.ALL_STOPS.get("110"), // 99th Street TC
						})) //
				.compileBothTripSort());
		map2.put(80l, new RouteTripSpec(80l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6137"), // Van Mall Transit Center
								Stops.ALL_STOPS.get("106"), // Fisher's Landing Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("106"), // Fisher's Landing Transit Center
								Stops.ALL_STOPS.get("6137"), // Van Mall Transit Center
						})) //
				.compileBothTripSort());
		map2.put(92L, new RouteTripSpec(92L, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, _45TH_STREET, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("106"), // Fisher's Landing Transit Center
								Stops.ALL_STOPS.get("2336"), // == E Street 2900 Block
								Stops.ALL_STOPS.get("252"), // != Addy St & Addy Loop =>
								Stops.ALL_STOPS.get("6178"), // != 39th St. & J St. =>
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6178"), // != 39th St. & J St. <=
								Stops.ALL_STOPS.get("252"), // != Addy St & Addy Loop <=
								Stops.ALL_STOPS.get("2348"), // != Addy St 3300 Block
								Stops.ALL_STOPS.get("2350"), // == Main St 3000 Block
								Stops.ALL_STOPS.get("106"), // Fisher's Landing Transit Center
						})) //
				.compileBothTripSort());
		map2.put(105L, new RouteTripSpec(105L, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6002"), // SW 6th & Columbia <=
								Stops.ALL_STOPS.get("6006"), // != SW 6th & Stark
								Stops.ALL_STOPS.get("5001"), // != SW 5th & Alder <=
								Stops.ALL_STOPS.get("5009"), // != != SW 5th & Hall
								Stops.ALL_STOPS.get("631"), // == Broadway & 7th St
								Stops.ALL_STOPS.get("633"), // != Broadway & 13th St fs [nb]
								Stops.ALL_STOPS.get("110"), // <> 99th Street TC
								Stops.ALL_STOPS.get("105"), // != Salmon Creek & Park and Ride #PORTLAND
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("105"), // != Salmon Creek & Park and Ride #PORTLAND
								Stops.ALL_STOPS.get("110"), // <> 99th Street TC
								Stops.ALL_STOPS.get("6046"), // != E 15th St & Broadway
								Stops.ALL_STOPS.get("6053"), // == Washington St & W 9th St
								Stops.ALL_STOPS.get("5001"), // != SW 5th & Alder
								Stops.ALL_STOPS.get("6002"), // != SW 6th & Columbia ==> END
						})) //
				.compileBothTripSort());
		map2.put(134L, new RouteTripSpec(134L, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6002"), // SW 6th & Columbia
								Stops.ALL_STOPS.get("6006"), // == == SW 6th & Stark
								Stops.ALL_STOPS.get("110"), // <> != 99th Street TC
								Stops.ALL_STOPS.get("105"), // == == Salmon Creek P&R
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("105"), // == == Salmon Creek P&R
								Stops.ALL_STOPS.get("110"), // <> != 99th Street TC
								Stops.ALL_STOPS.get("5001"), // == == SW 5th & Alder
								Stops.ALL_STOPS.get("5009"), // SW 5th & Hall
						})) //
				.compileBothTripSort());
		map2.put(157l, new RouteTripSpec(157l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, // 99th Street TC
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) // NE Multnomah & 3rd [wb]
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("3171"), // NE Wheeler & Multnomah
								Stops.ALL_STOPS.get("3170"), // NE Multnomah & 3rd [wb]
								Stops.ALL_STOPS.get("110"), // <> 99th Street TC
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("110"), // <> 99th Street TC
								Stops.ALL_STOPS.get("3171"), // NE Wheeler & Multnomah
								Stops.ALL_STOPS.get("3170"), // NE Multnomah & 3rd [wb]
						})) //
				.compileBothTripSort());
		map2.put(164L, new RouteTripSpec(164L, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, // Fisher's Landing Transit
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6001"), // SW 6th & Market <= START
								Stops.ALL_STOPS.get("6003"), // SW 6th & Salmon
								Stops.ALL_STOPS.get("6005"), // SW 6th & Washington
								Stops.ALL_STOPS.get("5002"), // SW 5th & Morrison <= START
								Stops.ALL_STOPS.get("5005"), // <> SW 5th & Madison
								Stops.ALL_STOPS.get("5006"), // <> SW 5th & Columbia
								Stops.ALL_STOPS.get("5008"), // SW 5th & Harrison
								Stops.ALL_STOPS.get("106"), // Fisher's Landing Transit Center
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("106"), // Fisher's Landing Transit Center
								Stops.ALL_STOPS.get("6001"), // SW 6th & Market => END
								Stops.ALL_STOPS.get("5002"), // != SW 5th & Morrison => END
								Stops.ALL_STOPS.get("5005"), // <> SW 5th & Madison
								Stops.ALL_STOPS.get("5006"), // <> SW 5th & Columbia
								Stops.ALL_STOPS.get("5008"), // SW 5th & Harrison => END
						})) //
				.compileBothTripSort());
		map2.put(177L, new RouteTripSpec(177L, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6001"), // SW 6th & Market <= START
								Stops.ALL_STOPS.get("6005"), // SW 6th & Washington
								Stops.ALL_STOPS.get("5008"), // SW 5th & Harrison <= START
								Stops.ALL_STOPS.get("102"), // == Evergreen Park & Ride
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("102"), // Evergreen Park & Ride
								Stops.ALL_STOPS.get("5002"), // SW 5th & Morrison
								Stops.ALL_STOPS.get("5008"), // SW 5th & Harrison => END
								Stops.ALL_STOPS.get("6001"), // SW 6th & Market => END
						})) //
				.compileBothTripSort());
		map2.put(190l, new RouteTripSpec(190l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("3185"), // SW US Veterans Rd & Bldg #16
								Stops.ALL_STOPS.get("6019"), // SW Campus Dr & Terwilliger
								Stops.ALL_STOPS.get("112"), // Andresen P&R
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("112"), // Andresen P&R
								Stops.ALL_STOPS.get("3185"), // SW US Veterans Rd & Bldg #16
								Stops.ALL_STOPS.get("6019"), // SW Campus Dr & Terwilliger
						})) //
				.compileBothTripSort());
		map2.put(VIDE_RID, new RouteTripSpec(VIDE_RID, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6136"), // 7th Street at Turtle Place
								Stops.ALL_STOPS.get("6137"), // Van Mall Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						Stops.ALL_STOPS.get("6137"), // Van Mall Transit Center
								Stops.ALL_STOPS.get("6136"), // 7th Street at Turtle Place
						})) //
				.compileBothTripSort());
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
		if (isGoodEnoughAccepted()) {
			mTrip.setHeadsignString(cleanTripHeadsign(gTrip.getTripHeadsign()), gTrip.getDirectionId() == null ? 0 : gTrip.getDirectionId());
			return;
		}
		System.out.printf("\n%s: Unexpected trip %s!\n", mRoute.getId(), gTrip);
		System.exit(-1);
	}

	@Override
	public boolean mergeHeadsign(MTrip mTrip, MTrip mTripToMerge) {
		List<String> headsignsValues = Arrays.asList(mTrip.getHeadsignValue(), mTripToMerge.getHeadsignValue());
		if (mTrip.getRouteId() == 199L) {
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
