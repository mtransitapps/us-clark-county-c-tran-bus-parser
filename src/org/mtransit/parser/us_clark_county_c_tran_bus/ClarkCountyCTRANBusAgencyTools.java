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

	private static final String RSN_VINE = "50";
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
	private static final String SALMON_CREEK = "Salmon Crk";
	private static final String VANCOUVER = "Vancouver"; // VANCOUVER_SHORT
	private static final String VANCOUVER_MALL_TRANSIT_CENTER = VANCOUVER_SHORT + " Mall " + TRANSIT_CENTER_SHORT;
	private static final String WSU_VANCOUVER = "WSU " + VANCOUVER_SHORT;
	private static final String YACOLT = "Yacolt";

	private static final String STOP_0101 = "725";
	private static final String STOP_0102 = "818";
	private static final String STOP_0105 = "180";
	private static final String STOP_0106 = "495";
	private static final String STOP_0110 = "880";
	private static final String STOP_0111 = "835";
	private static final String STOP_0112 = "692";
	private static final String STOP_0115 = "939";
	private static final String STOP_0116 = "979";
	private static final String STOP_0117 = "975";
	private static final String STOP_0118 = "977";
	private static final String STOP_0123 = "1139";
	private static final String STOP_0124 = "1141";
	private static final String STOP_0125 = "1143";
	private static final String STOP_0127 = "1147";
	private static final String STOP_0252 = "686";
	private static final String STOP_0579 = "14";
	private static final String STOP_0631 = "909";
	private static final String STOP_0632 = "911";
	private static final String STOP_0633 = "913";
	private static final String STOP_0831 = "167";
	private static final String STOP_0835 = "164";
	private static final String STOP_1076 = "330";
	private static final String STOP_1095 = "349";
	private static final String STOP_1104 = "347";
	private static final String STOP_1202 = "743";
	private static final String STOP_1310 = "753";
	private static final String STOP_1312 = "840";
	private static final String STOP_1316 = "839";
	private static final String STOP_1318 = "201";
	private static final String STOP_1320 = "756";
	private static final String STOP_1607 = "883";
	private static final String STOP_1612 = "921";
	private static final String STOP_2003 = "5";
	private static final String STOP_2130 = "203";
	private static final String STOP_2919 = "866";
	private static final String STOP_3058 = "844";
	private static final String STOP_3076 = "870";
	private static final String STOP_3170 = "799";
	private static final String STOP_3171 = "790";
	private static final String STOP_3198 = "808";
	private static final String STOP_3260 = "700";
	private static final String STOP_3492 = "826";
	private static final String STOP_3741 = "854";
	private static final String STOP_5001 = "943";
	private static final String STOP_5002 = "945";
	private static final String STOP_5005 = "949";
	private static final String STOP_5006 = "950";
	private static final String STOP_5008 = "964";
	private static final String STOP_5009 = "966";
	private static final String STOP_6001 = "960";
	private static final String STOP_6002 = "958";
	private static final String STOP_6003 = "957";
	private static final String STOP_6005 = "954";
	private static final String STOP_6006 = "952";
	private static final String STOP_6008 = "984";
	private static final String STOP_6013 = "988";
	private static final String STOP_6019 = "994";
	private static final String STOP_6023 = "997";
	private static final String STOP_6038 = "1001";
	private static final String STOP_6043 = "1006";
	private static final String STOP_6046 = "1093";
	private static final String STOP_6052 = "1017";
	private static final String STOP_6053 = "1095";
	private static final String STOP_6066 = "1027";
	private static final String STOP_6086 = "1064";
	private static final String STOP_6087 = "1065";
	private static final String STOP_6116 = "1078";
	private static final String STOP_6117 = "1077";
	private static final String STOP_6122 = "1046";
	private static final String STOP_6136 = "1019";
	private static final String STOP_6137 = "1097";
	private static final String STOP_6154 = "1131";
	private static final String STOP_6174 = "1135";

	private static HashMap<Long, RouteTripSpec> ALL_ROUTE_TRIPS2;
	static {
		HashMap<Long, RouteTripSpec> map2 = new HashMap<Long, RouteTripSpec>();
		map2.put(2l, new RouteTripSpec(2l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0632, // Broadway & Evergreen Blvd
								STOP_0110, // 99th Street TC & NE 7th Ave
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0110, // "110", // 99th Street TC & NE 7th Ave
								STOP_2003, // ==
								STOP_3260, // !=
								STOP_3492, // !=
								STOP_0579, // ==
								STOP_0632, // "632", // Broadway & Evergreen Blvd
						})) //
				.compileBothTripSort());
		map2.put(6l, new RouteTripSpec(6l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, GRAND_CENTRAL, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FRUIT_VALLEY) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6023, // Fruit Valley Rd & La Frambois
								STOP_1607, // VA Transit Center
								STOP_6066, // Columbia House Blvd at Park & Ride
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6066, // Columbia House Blvd at Park & Ride
								STOP_1607, // VA Transit Center
								STOP_6023, // Fruit Valley Rd & La Frambois
						})) //
				.compileBothTripSort());
		map2.put(7l, new RouteTripSpec(7l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, BATTLE_GROUND, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6137, // Van Mall Transit Center
								STOP_3076, // Grace & Rasmussen
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_3076, // Grace & Rasmussen
								STOP_6137, // Van Mall Transit Center
						})) //
				.compileBothTripSort());
		map2.put(9l, new RouteTripSpec(9l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, SALMON_CREEK, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0110, // 99th Street TC
								STOP_0105, // "105", // Salmon Creek P&R
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0105, // "105", // Salmon Creek P&R
								STOP_0110, // "110", // 99th Street TC
						})) //
				.compileBothTripSort());
		map2.put(19l, new RouteTripSpec(19l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, WSU_VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0110, // 99th Street TC
								STOP_6122, // NE 29th Ave & WSUV Trailhead
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6122, // NE 29th Ave & WSUV Trailhead
								STOP_0110, // 99th Street TC
						})) //
				.compileBothTripSort());
		map2.put(25l, new RouteTripSpec(25l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_3492, // Mill Plain & Franklin [eb]
								STOP_1104, // Evergreen Blvd & C St
								STOP_0110, // 99th Street TC {
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0110, // 99th Street TC {,
								STOP_3492, // Mill Plain & Franklin [eb]
						})) //
				.compileBothTripSort());
		map2.put(30l, new RouteTripSpec(30l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0632, // Broadway & Evergreen Blvd
								STOP_3058, // NE 18th St & 65th Ave [eb]
								STOP_0106, // Fisher's Landing Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0106, // Fisher's Landing Transit Center
								STOP_1076, // NE 18th St & 65th Ave [wb]
								STOP_0632, // Broadway & Evergreen Blvd
						})) //
				.compileBothTripSort());
		map2.put(32l, new RouteTripSpec(32l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0110, // 99th Street TC
								STOP_1104, // Evergreen Blvd & C St
								STOP_6137, // Van Mall Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6137, // Van Mall Transit Center
								STOP_0110, // 99th Street TC
						})) //
				.compileBothTripSort());
		map2.put(37l, new RouteTripSpec(37l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) // Evergreen Blvd & C St
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_1104, // Evergreen Blvd & C St
								STOP_1202, // Mill Plain 6600 Block
								STOP_1312, // == Mill Plain 16000 Block
								STOP_1310, // != SE 164th Ave 900 Block
								STOP_1318, // != SE 164th Ave & 32nd St
								STOP_2919, // != Mill Plain & 172nd Ave [eb]
								STOP_6086, // != SE 34th St & 172nd Ave [wb]
								STOP_0106, // Fisher's Landing Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0106, // Fisher's Landing Transit Center
								STOP_6087, // != SE 34th Street & 172nd Avenue [eb]
								STOP_6043, // != Mill Plain & 172nd Ave [wb]
								STOP_1316, // != SE 164th Ave 3200 Block
								STOP_2130, // != SE 164th Ave 1400 Block
								STOP_1320, // == Mill Plain & 164th Ave [wb]
								STOP_1104, // Evergreen Blvd & C St
						})) //
				.compileBothTripSort());
		map2.put(39l, new RouteTripSpec(39l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, "Stapleton", //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_1607, // VA Transit Center
								STOP_0632, // Broadway & Evergreen Blvd
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0632, // Broadway & Evergreen Blvd
								STOP_1607, // VA Transit Center
						})) //
				.compileBothTripSort());
		map2.put(41l, new RouteTripSpec(41l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) // E 15th St & Broadway [wb
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6046, // E 15th St & Broadway [wb]
								STOP_6053, // Washington St & W 9th St fs
								STOP_0106, // Fisher's Landing Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0106, // Fisher's Landing Transit Center
								STOP_6046, // E 15th St & Broadway [wb]
						})) //
				.compileBothTripSort());
		map2.put(47l, new RouteTripSpec(47l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, YACOLT, // BATTLE_GROUND // Fairgrounds Ave at Ball
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) // Washington St & W 9th St
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0631, // Broadway & 7th St
								STOP_0632, // ++ Broadway & Evergreen Blvd
								STOP_0831, // ++ W Main & SE Clark Ave [eb]
								STOP_3741, // ++ Yacolt Rd & Railroad Ave
								STOP_6038, // Fairgrounds Ave at Ball Park
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6038, // Fairgrounds Ave at Ball Park
								STOP_3741, // ++ Yacolt Rd & Railroad Ave
								STOP_0835, // ++ W Main & 3rd Ave [wb]
								STOP_0579, // ++ Washington & 13th St
								STOP_6053, // Washington St & W 9th St fs
						})) //
				.compileBothTripSort());
		map2.put(60l, new RouteTripSpec(60l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DELTA_PARK) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0111, // Delta Park/Vanport MAX
								STOP_1612, // != N Hayden Island Dr & N Tomahawk Dr
								STOP_6052, // != 12100 N. Pavilion
								STOP_0631, // Broadway & 7th St
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0631, // Broadway & 7th St
								STOP_6154, // == Broadway & 12th St fs
								STOP_6013, // != Jantzen Beach Main Stop
								STOP_6052, // != 12100 N. Pavilion
								STOP_0111, // Delta Park/Vanport MAX
						})) //
				.compileBothTripSort());
		map2.put(65l, new RouteTripSpec(65l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PARKROSE_MAX) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0101, // Parkrose/Sumner Transit Center
								STOP_0106, // Fisher's Landing Transit Center
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0106, // Fisher's Landing Transit Center
								STOP_0101, // Parkrose/Sumner Transit Center
						})) //
				.compileBothTripSort());
		map2.put(71l, new RouteTripSpec(71l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0632, // Broadway & Evergreen Blvd
								STOP_0110, // 99th Street TC
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0110, // 99th Street TC
								STOP_0632, // Broadway & Evergreen Blvd
						})) //
				.compileBothTripSort());
		map2.put(72l, new RouteTripSpec(72l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, _152ND_AVENUE, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6137, // Van Mall Transit Center
								STOP_1095, // NE 76th St & Ward Rd
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_1095, // NE 76th St & Ward Rd
								STOP_6137, // Van Mall Transit Center
						})) //
				.compileBothTripSort());
		map2.put(73l, new RouteTripSpec(73l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, "") //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6137, // Van Mall Transit Center
								STOP_6117, // Van Mall Loop & East Trailhead
								STOP_6116, // Van Mall Loop & West Trailhead
								STOP_6137, // Van Mall Transit Center
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
						STOP_6137, // Van Mall Transit Center
								STOP_6174, // NE Ward Rd. & NE 162nd Ave.
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6174, // NE Ward Rd. & NE 162nd Ave.
								STOP_6137, // Van Mall Transit Center
						})) //
				.compileBothTripSort());
		map2.put(78l, new RouteTripSpec(78l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0110, // 99th Street TC
								STOP_6137, // Van Mall Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6137, // Van Mall Transit Center
								STOP_0110, // 99th Street TC
						})) //
				.compileBothTripSort());
		map2.put(80l, new RouteTripSpec(80l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6137, // Van Mall Transit Center
								STOP_0106, // Fisher's Landing Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0106, // Fisher's Landing Transit Center
								STOP_6137, // Van Mall Transit Center
						})) //
				.compileBothTripSort());
		map2.put(92l, new RouteTripSpec(92l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, _45TH_STREET, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0106, // Fisher's Landing Transit Center
								STOP_0252, // Addy St & Addy Loop
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0252, // Addy St & Addy Loop
								STOP_0106, // Fisher's Landing Transit Center
						})) //
				.compileBothTripSort());
		map2.put(105l, new RouteTripSpec(105l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6002, // SW 6th & Columbia <= START
								STOP_6006, // != SW 6th & Stark
								STOP_5001, // != SW 5th & Alder <= START
								STOP_5009, // != != SW 5th & Hall
								STOP_0117, // != <> I-5 && BURNSIDE
								STOP_0118, // == <> I-5 && LOMBARD
								STOP_0631, // == != Broadway & 7th St
								STOP_0633, // != Broadway & 13th St fs [nb]
								STOP_0110, // <> 99th Street TC
								STOP_0105, // Salmon Creek & Park and Ride #PORTLAND
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0105, // Salmon Creek & Park and Ride #PORTLAND
								STOP_0110, // <> 99th Street TC
								STOP_6046, // E 15th St & Broadway [wb]
								STOP_5001, // != SW 5th & Alder
								STOP_6053, // == != Washington St & W 9th St fs
								STOP_0118, // == <> I-5 && LOMBARD
								STOP_0117, // != I-5 && BURNSIDE
								STOP_6002, // != SW 6th & Columbia ==> END
						})) //
				.compileBothTripSort());
		map2.put(134l, new RouteTripSpec(134l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6002, // SW 6th & Columbia
								STOP_6006, // != SW 6th & Stark
								STOP_0118, // <> I-5 && LOMBARD
								STOP_0115, // <> I-5 SOUTH && COLUMBIA WAY
								STOP_6008, // <> I-5 && NE 94TH STREET
								STOP_0110, // <> 99th Street TC
								STOP_0105, // Salmon Creek P&R
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0105, // Salmon Creek P&R
								STOP_0110, // <> 99th Street TC
								STOP_6008, // <> I-5 && NE 94TH STREET
								STOP_0115, // <> I-5 SOUTH && COLUMBIA WAY
								STOP_0118, // <> I-5 && LOMBARD
								STOP_5001, // != SW 5th & Alder
								STOP_5009, // SW 5th & Hall
						})) //
				.compileBothTripSort());
		map2.put(157l, new RouteTripSpec(157l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, // 99th Street TC
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) // NE Multnomah & 3rd [wb]
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_3171, // NE Wheeler & Multnomah
								STOP_3170, // NE Multnomah & 3rd [wb]
								STOP_0110, // <> 99th Street TC
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0110, // <> 99th Street TC
								STOP_3171, // NE Wheeler & Multnomah
								STOP_3170, // NE Multnomah & 3rd [wb]
						})) //
				.compileBothTripSort());
		map2.put(164l, new RouteTripSpec(164l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, // Fisher's Landing Transit
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6001, // SW 6th & Market <= START
								STOP_6003, // SW 6th & Salmon
								STOP_6005, // SW 6th & Washington
								STOP_0123, // != SR-14 Fwy Stop EB #1 W End
								STOP_5002, // SW 5th & Morrison <= START
								STOP_5005, // <> SW 5th & Madison
								STOP_5006, // <> SW 5th & Columbia
								STOP_5008, // SW 5th & Harrison
								STOP_0117, // <> I-5 && BURNSIDE
								STOP_0116, // <> I-84 && NE 82ND AVENUE
								STOP_0124, // != SR-14 Fwy Stop EB #2 I-205 Ramp
								STOP_0125, // == SR-14 Fwy Stop EB #3 E End
								STOP_0106, // Fisher's Landing Transit Center
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0106, // Fisher's Landing Transit Center
								STOP_0127, // == != SR-14 Fwy Stop WB #2 W End
								STOP_0116, // == <> I-84 && NE 82ND AVENUE
								STOP_0117, // != <> I-5 && BURNSIDE
								STOP_6001, // SW 6th & Market => END
								STOP_5002, // != SW 5th & Morrison => END
								STOP_5005, // <> SW 5th & Madison
								STOP_5006, // <> SW 5th & Columbia
								STOP_5008, // SW 5th & Harrison => END
						})) //
				.compileBothTripSort());
		map2.put(177l, new RouteTripSpec(177l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6001, // SW 6th & Market <= START
								STOP_6005, // SW 6th & Washington
								STOP_0115, // I-5 SOUTH && COLUMBIA WAY
								STOP_5008, // SW 5th & Harrison <= START
								STOP_0117, // <> I-5 && BURNSIDE
								STOP_0116, // <> I-84 && NE 82ND AVENUE
								STOP_0102, // == Evergreen Park & Ride
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0102, // Evergreen Park & Ride
								STOP_0116, // <> I-84 && NE 82ND AVENUE
								STOP_5002, // SW 5th & Morrison
								STOP_5008, // SW 5th & Harrison => END
								STOP_0117, // <> I-5 && BURNSIDE
								STOP_6001, // SW 6th & Market => END
						})) //
				.compileBothTripSort());
		map2.put(190l, new RouteTripSpec(190l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_3198, // SW Terwilliger & Campus
								STOP_6019, // SW Campus Dr & Terwilliger
								STOP_0112, // Andresen P&R
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0112, // Andresen P&R
								STOP_3198, // SW Terwilliger & Campus
								STOP_6019, // SW Campus Dr & Terwilliger
						})) //
				.compileBothTripSort());
		map2.put(199l, new RouteTripSpec(199l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6002, // SW 6th & Columbia
								STOP_0110, // 99th Street TC
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						STOP_0110, // 99th Street TC
								STOP_5009, // "5009", // SW 5th & Hall
						})) //
				.compileBothTripSort());
		map2.put(VIDE_RID, new RouteTripSpec(VIDE_RID, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6136, // 7th Street at Turtle Place
								STOP_6137, // Van Mall Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						STOP_6137, // Van Mall Transit Center
								STOP_6136, // 7th Street at Turtle Place
						})) //
				.compileBothTripSort());
		ALL_ROUTE_TRIPS2 = map2;
	}

	@Override
	public int compareEarly(long routeId, List<MTripStop> list1, List<MTripStop> list2, MTripStop ts1, MTripStop ts2, GStop ts1GStop, GStop ts2GStop) {
		if (ALL_ROUTE_TRIPS2.containsKey(routeId)) {
			return ALL_ROUTE_TRIPS2.get(routeId).compare(routeId, list1, list2, ts1, ts2, ts1GStop, ts2GStop);
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
			return SplitUtils.splitTripStop(mRoute, gTrip, gTripStop, routeGTFS, ALL_ROUTE_TRIPS2.get(mRoute.getId()));
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
		if (isGoodEnoughAccepted()) {
			return super.mergeHeadsign(mTrip, mTripToMerge);
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
