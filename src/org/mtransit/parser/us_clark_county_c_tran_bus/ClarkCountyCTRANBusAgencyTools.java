package org.mtransit.parser.us_clark_county_c_tran_bus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

	private static final String RSN_VINE = "vine";
	@Override
	public long getRouteId(GRoute gRoute) {
		if (RSN_VINE.equalsIgnoreCase(gRoute.getRouteShortName())) {
			return 1000l;
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
		if (StringUtils.isEmpty(gRoute.getRouteColor())) {
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
			System.out.printf("\nUnexpected route color %s!\n", gRoute);
			System.exit(-1);
			return null;
		}
		return super.getRouteColor(gRoute);
	}

	private static final String TRANSIT_CENTER_SHORT = "TC";
	private static final String VANCOUVER_SHORT = "Van";
	//
	private static final String _152ND_AVENUE = "152nd Ave";
	private static final String _162ND_AVENUE = "162nd Ave";
	private static final String _192ND_AVENUE = "192nd Ave";
	private static final String _45TH_STREET = "45th St";
	private static final String _99TH_STREET_TRANSIT_CENTER = "99th St " + TRANSIT_CENTER_SHORT;
	private static final String A = "A";
	private static final String B = "B";
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
	private static final String VANCOUVERPORT_MAX = VANCOUVER_SHORT + "port " + MAX;
	private static final String WSU_VANCOUVER = "WSU " + VANCOUVER_SHORT;
	private static final String WARD_ROAD = "Ward Rd";
	private static final String YACOLT = "Yacolt";

	private static HashMap<Long, RouteTripSpec> ALL_ROUTE_TRIPS2;
	static {
		HashMap<Long, RouteTripSpec> map2 = new HashMap<Long, RouteTripSpec>();
		map2.put(2l, new RouteTripSpec(2l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"632", // Broadway & Evergreen Blvd
								"3259", // !=
								"3260", // ==
								"2000", // !=
								"2006", //
								"110" // 99th Street TC & NE 7th Ave
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"110", // 99th Street TC & NE 7th Ave
								"4183", //
								"2003", // ==
								"3260", // !=
								"3492", // !=
								"579", //
								"632" // Broadway & Evergreen Blvd
						})) //
				.compileBothTripSort());
		map2.put(3l, new RouteTripSpec(3l, // 3 loop in 2 directions (A/B)
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, B, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, A) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "1607", "321", //
								"606", "639", "3275", //
								"664", "1607" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "1607", "2104", //
								"3304", "1384", "2852", //
								"725", "1607" })) //
				.compileBothTripSort());
		map2.put(4l, new RouteTripSpec(4l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVERPORT_MAX) // DELTA_PARK + SLASH +
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { "632", "238", "104" })) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { "104", "2875", "632" })) //
				.compileBothTripSort());
		map2.put(6l, new RouteTripSpec(6l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, GRAND_CENTRAL, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FRUIT_VALLEY) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { "6023", "676", "1607", "321", "6066" })) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { "6066", "725", "1607", "728", "6023" })) //
				.compileBothTripSort());
		map2.put(7l, new RouteTripSpec(7l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, BATTLE_GROUND, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"6137", // Van Mall Transit Center
								"814", //
								"3076" // Grace & Rasmussen
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"3076", // Grace & Rasmussen
								"2399", //
								"6137" // Van Mall Transit Center
						})) //
				.compileBothTripSort());
		map2.put(9l, new RouteTripSpec(9l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, SALMON_CREEK, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "110", "2411", "105" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "105", "2974", "110" })) //
				.compileBothTripSort());
		map2.put(19l, new RouteTripSpec(19l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, WSU_VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "110", "6122" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "6122", "110" })) //
				.compileBothTripSort());
		map2.put(25l, new RouteTripSpec(25l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "3492", "1104", "110" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "110", "3492" })) //
				.compileBothTripSort());
		map2.put(30l, new RouteTripSpec(30l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { "632", "589", "3058", "3089", "106" })) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { "106", "3106", "1076", "660", "632" })) //
				.compileBothTripSort());
		map2.put(32l, new RouteTripSpec(32l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						"110", // 9th Street TC & NE 7th Ave
								"1104", // Evergreen Blvd & C St
								"2069", //
								"6137" // Van Mall Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						"6137", // Van Mall Transit Center
								"2057", //
								"110" // 9th Street TC & NE 7th Ave
						})) //
				.compileBothTripSort());
		map2.put(37l, new RouteTripSpec(37l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						"1104", "1202", //
								"1312", // ==
								"1310", "1318", // !=
								"2919", "6086", // !=
								"106" //
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						"106", //
								"6087", "6043", // !=
								"1316", "2130", // !=
								"1320", // ==
								"1104" //
						})) //
				.compileBothTripSort());
		map2.put(38l, new RouteTripSpec(38l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, _192ND_AVENUE, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { "1104", "2106", "2912" })) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { "2912", "1231", "1104" })) //
				.compileBothTripSort());
		map2.put(39l, new RouteTripSpec(39l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, "Stapleton", //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { "1607", "632" })) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { "632", "1607" })) //
				.compileBothTripSort());
		map2.put(41l, new RouteTripSpec(41l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { "579", "6053", "106" })) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { "106", "6046", "579" })) //
				.compileBothTripSort());
		map2.put(44l, new RouteTripSpec(44l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, WARD_ROAD, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVERPORT_MAX) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { "111", "104", "2885" })) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { "2885", "322", "2279", "104", "2875", "1032", "111" })) //
				.compileBothTripSort());
		map2.put(47l, new RouteTripSpec(47l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, YACOLT, // BATTLE_GROUND
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVERPORT_MAX) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "111", "2381", "6038" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "6038", "2403", "111" })) //
				.compileBothTripSort());
		map2.put(60l, new RouteTripSpec(60l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DELTA_PARK) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"111", // Delta Park/Vanport & MAX Station
								"631" // Broadway & 7th St
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"631", // Broadway & 7th St
								"111" // Delta Park/Vanport & MAX Station
						})) //
				.compileBothTripSort());
		map2.put(65l, new RouteTripSpec(65l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PARKROSE_MAX) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "101", "106" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "106", "101" })) //
				.compileBothTripSort());
		map2.put(71l, new RouteTripSpec(71l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, DOWNTOWN_VANCOUVER) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "632", "734", "110" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "110", "1356", "632" })) //
				.compileBothTripSort());
		map2.put(72l, new RouteTripSpec(72l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, _152ND_AVENUE, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						"6137", // Van Mall Transit Center
								"1095" // NE 76th St & Ward Rd
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						"1095", // NE 76th St & Ward Rd
								"6137" // Van Mall Transit Center
						})) //
				.compileBothTripSort());
		map2.put(73l, new RouteTripSpec(73l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, "") //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						"6137", // Van Mall Transit Center
								"6117", //
								"6116", //
								"6137" // Van Mall Transit Center
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
						"6137", // Van Mall Transit Center
								"6112" // NE 78th St & 162nd Ave
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						"6112", // NE 78th St & 162nd Ave
								"6137" // Van Mall Transit Center
						})) //
				.compileBothTripSort());
		map2.put(78l, new RouteTripSpec(78l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, _99TH_STREET_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						"110", // 99th Street TC & NE 7th Ave
								"3032", //
								"6137", // Van Mall Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						"6137", // Van Mall Transit Center
								"3251", //
								"110" // 99th Street TC & NE 7th Ave
						})) //
				.compileBothTripSort());
		map2.put(80l, new RouteTripSpec(80l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						"6137", // Van Mall Transit Center
								"325", //
								"106", // Fisher's Landing & Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						"106", // Fisher's Landing & Transit Center
								"2237", //
								"6137", // Van Mall Transit Center
						})) //
				.compileBothTripSort());
		map2.put(92l, new RouteTripSpec(92l, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, _45TH_STREET, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, FISHER_S_LANDING_TRANSIT_CENTER) //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { "106", //
								"968", "969", "2159", //
								"252" })) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { "252", "3375", "106" })) //
				.compileBothTripSort());
		map2.put(105l, new RouteTripSpec(105l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"6002", // SW 6th & Columbia
								"6006", // !=
								"5001", // SW 5th & Alder
								"5009", // !=
								"631", // ==
								"105" // Salmon Creek & Park and Ride #PORTLAND
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"105", // Salmon Creek & Park and Ride #PORTLAND
								"6046", // E 15th St & Broadway
								"6053", // ==
								"5001", // != SW 5th & Alder
								"6002" // != SW 6th & Columbia
						})) //
				.compileBothTripSort());
		map2.put(134l, new RouteTripSpec(134l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "6002", "6006", "110", "105" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "105", "110", "5001", "5009" })) //
				.compileBothTripSort());
		map2.put(157l, new RouteTripSpec(157l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "3171", "3170", "3160", "110" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "110", "3171", "3170" })) //
				.compileBothTripSort());
		map2.put(164l, new RouteTripSpec(164l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { //
						"6001", // SW 6th & Market
								"6003", //
								"6005", //
								"5002", // SW 5th & Morrison
								"5005", "5006", //
								"5008", // SW 5th & Harrison
								"106" // Fisher's Landing & Transit Center
						})) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { //
						"106", // Fisher's Landing & Transit Center
								"5002", // SW 5th & Morrison
								"5005", "5006", //
								"5008", // SW 5th & Harrison
								"6001" // SW 6th & Market
						})) //
				.compileBothTripSort());
		map2.put(177l, new RouteTripSpec(177l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "6001", "6005", //
								"5008", //
								"102" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "102", //
								"5002", "5008", //
								"6001" })) //
				.compileBothTripSort());
		map2.put(190l, new RouteTripSpec(190l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "3198", "6019", "112" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "112", "3198", "6019" })) //
				.compileBothTripSort());
		map2.put(199l, new RouteTripSpec(199l, //
				MDirectionType.NORTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER, //
				MDirectionType.SOUTH.intValue(), MTrip.HEADSIGN_TYPE_STRING, PORTLAND) //
				.addTripSort(MDirectionType.NORTH.intValue(), //
						Arrays.asList(new String[] { "6002", "6006", "110" })) //
				.addTripSort(MDirectionType.SOUTH.intValue(), //
						Arrays.asList(new String[] { "110", "5001", "5009" })) //
				.compileBothTripSort());
		INCLUDE_ROUTE_ID_GT = null; // DEBUG // TODO null
		INCLUDE_ROUTE_ID = null; // DEBUG // TODO null
		INCLUDE_ROUTE_ID_LT = null; // DEBUG // TODO null
		map2.put(1000L, new RouteTripSpec(1000L, //
				MDirectionType.EAST.intValue(), MTrip.HEADSIGN_TYPE_STRING, VANCOUVER_MALL_TRANSIT_CENTER, //
				MDirectionType.WEST.intValue(), MTrip.HEADSIGN_TYPE_STRING, "Turtle Pl Sta") //
				.addTripSort(MDirectionType.EAST.intValue(), //
						Arrays.asList(new String[] { //
						"6136", // 7th Street at Turtle Place
								"6137", // Van Mall Transit Center
						})) //
				.addTripSort(MDirectionType.WEST.intValue(), //
						Arrays.asList(new String[] { //
						"6137", // Van Mall Transit Center
								"6136", // 7th Street at Turtle Place
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
		System.out.printf("\n%s: Unexpected trip %s!\n", mRoute.getId(), gTrip);
		System.exit(-1);
	}

	@Override
	public boolean mergeHeadsign(MTrip mTrip, MTrip mTripToMerge) {
		System.out.printf("\nUnexpected trips to merge: %s & %s!\n", mTrip, mTripToMerge);
		System.exit(-1);
		return false;
	}

	@Override
	public String cleanTripHeadsign(String tripHeadsign) {
		tripHeadsign = CleanUtils.cleanSlashes(tripHeadsign);
		tripHeadsign = CleanUtils.cleanNumbers(tripHeadsign);
		tripHeadsign = CleanUtils.cleanStreetTypes(tripHeadsign);
		return CleanUtils.cleanLabel(tripHeadsign);
	}

	@Override
	public String cleanStopName(String gStopName) {
		gStopName = CleanUtils.SAINT.matcher(gStopName).replaceAll(CleanUtils.SAINT_REPLACEMENT);
		gStopName = CleanUtils.CLEAN_AND.matcher(gStopName).replaceAll(CleanUtils.CLEAN_AND_REPLACEMENT);
		gStopName = CleanUtils.CLEAN_AT.matcher(gStopName).replaceAll(CleanUtils.CLEAN_AT_REPLACEMENT);
		gStopName = CleanUtils.cleanSlashes(gStopName);
		gStopName = CleanUtils.removePoints(gStopName);
		gStopName = CleanUtils.cleanStreetTypes(gStopName);
		return CleanUtils.cleanLabel(gStopName);
	}
}
