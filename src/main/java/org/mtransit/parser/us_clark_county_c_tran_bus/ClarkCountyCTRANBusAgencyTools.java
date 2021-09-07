package org.mtransit.parser.us_clark_county_c_tran_bus;

import static org.mtransit.commons.StringUtils.EMPTY;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mtransit.commons.CleanUtils;
import org.mtransit.commons.StringUtils;
import org.mtransit.parser.DefaultAgencyTools;
import org.mtransit.parser.MTLog;
import org.mtransit.parser.gtfs.data.GRoute;
import org.mtransit.parser.gtfs.data.GStop;
import org.mtransit.parser.mt.data.MAgency;

import java.util.regex.Pattern;

// https://www.c-tran.com/about-c-tran/business/c-tran-gtfs-data
// https://www.c-tran.com/images/Google/GoogleTransitUpload.zip
public class ClarkCountyCTRANBusAgencyTools extends DefaultAgencyTools {

	public static void main(@NotNull String[] args) {
		new ClarkCountyCTRANBusAgencyTools().start(args);
	}

	@Override
	public boolean defaultExcludeEnabled() {
		return true;
	}

	@NotNull
	public String getAgencyName() {
		return "C-TRAN";
	}

	@NotNull
	@Override
	public Integer getAgencyRouteType() {
		return MAgency.ROUTE_TYPE_BUS;
	}

	private static final String RSN_VINE = "Vine";

	private static final long VIDE_RID = 50L;

	@Override
	public long getRouteId(@NotNull GRoute gRoute) {
		if (RSN_VINE.equalsIgnoreCase(gRoute.getRouteShortName())) {
			return VIDE_RID;
		}
		return Long.parseLong(gRoute.getRouteShortName()); // using route short name as route ID
	}

	@Override
	public boolean defaultAgencyColorEnabled() {
		return true;
	}

	// private static final String AGENCY_COLOR_BLUE = "065AC2"; // BLUE (from web site CSS)
	private static final String AGENCY_COLOR_BLUE = "036CB6"; // BLUE (from map PDF)

	private static final String AGENCY_COLOR = AGENCY_COLOR_BLUE;

	@NotNull
	@Override
	public String getAgencyColor() {
		return AGENCY_COLOR;
	}

	private static final String EXPRESS_ROUTES_COLOR = "ED1A3B"; // RED (from PDF map)
	private static final String LIMITED_ROUTES_COLOR = "191919"; // "000000" // BLACK (from PDF map)

	@SuppressWarnings("DuplicateBranchesInSwitch")
	@Nullable
	@Override
	public String getRouteColor(@NotNull GRoute gRoute, @NotNull MAgency agency) {
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
			throw new MTLog.Fatal("Unexpected route color %s!", gRoute);
		}
		return super.getRouteColor(gRoute, agency);
	}

	@NotNull
	@Override
	public String cleanRouteLongName(@NotNull String routeLongName) {
		return CleanUtils.cleanLabel(routeLongName);
	}

	@Override
	public boolean directionFinderEnabled() {
		return true;
	}

	private static final Pattern ENDS_WITH_NO_ = Pattern.compile("( no .*$)", Pattern.CASE_INSENSITIVE);

	private static final Pattern STARTS_WITH_BOUNDS_ = Pattern.compile("(^(SW|NW|SE|NE) )", Pattern.CASE_INSENSITIVE);

	@NotNull
	@Override
	public String cleanDirectionHeadsign(boolean fromStopName, @NotNull String directionHeadSign) {
		directionHeadSign = super.cleanDirectionHeadsign(fromStopName, directionHeadSign);
		directionHeadSign = STARTS_WITH_BOUNDS_.matcher(directionHeadSign).replaceAll(EMPTY);
		directionHeadSign = ENDS_WITH_NO_.matcher(directionHeadSign).replaceAll(EMPTY);
		return directionHeadSign;
	}

	@NotNull
	@Override
	public String cleanTripHeadsign(@NotNull String tripHeadsign) {
		tripHeadsign = CleanUtils.CLEAN_AT.matcher(tripHeadsign).replaceAll(CleanUtils.CLEAN_AT_REPLACEMENT);
		tripHeadsign = CleanUtils.keepToAndRemoveVia(tripHeadsign);
		tripHeadsign = CleanUtils.cleanSlashes(tripHeadsign);
		tripHeadsign = CleanUtils.cleanNumbers(tripHeadsign);
		tripHeadsign = CleanUtils.cleanBounds(tripHeadsign);
		tripHeadsign = CleanUtils.cleanStreetTypes(tripHeadsign);
		return CleanUtils.cleanLabel(tripHeadsign);
	}

	@NotNull
	@Override
	public String cleanStopName(@NotNull String gStopName) {
		gStopName = CleanUtils.SAINT.matcher(gStopName).replaceAll(CleanUtils.SAINT_REPLACEMENT);
		gStopName = CleanUtils.CLEAN_AND.matcher(gStopName).replaceAll(CleanUtils.CLEAN_AND_REPLACEMENT);
		gStopName = CleanUtils.CLEAN_AT.matcher(gStopName).replaceAll(CleanUtils.CLEAN_AT_REPLACEMENT);
		gStopName = CleanUtils.cleanSlashes(gStopName);
		gStopName = CleanUtils.cleanBounds(gStopName);
		gStopName = CleanUtils.cleanStreetTypes(gStopName);
		return CleanUtils.cleanLabel(gStopName);
	}

	@Override
	public int getStopId(@NotNull GStop gStop) {
		return Integer.parseInt(gStop.getStopCode()); // use stop CODE as stop ID
	}
}
