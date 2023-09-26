package org.mtransit.parser.us_clark_county_c_tran_bus;

import static org.mtransit.commons.StringUtils.EMPTY;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mtransit.commons.CleanUtils;
import org.mtransit.parser.ColorUtils;
import org.mtransit.parser.DefaultAgencyTools;
import org.mtransit.parser.gtfs.data.GRoute;
import org.mtransit.parser.gtfs.data.GStop;
import org.mtransit.parser.mt.data.MAgency;

import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

// https://www.c-tran.com/about-c-tran/business/c-tran-gtfs-data
public class ClarkCountyCTRANBusAgencyTools extends DefaultAgencyTools {

	public static void main(@NotNull String[] args) {
		new ClarkCountyCTRANBusAgencyTools().start(args);
	}

	@Nullable
	@Override
	public List<Locale> getSupportedLanguages() {
		return LANG_EN;
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

	@Override
	public boolean defaultRouteIdEnabled() {
		return true;
	}

	@Override
	public boolean useRouteShortNameForRouteId() {
		return true;
	}

	@Nullable
	@Override
	public Long convertRouteIdFromShortNameNotSupported(@NotNull String routeShortName) {
		switch (routeShortName) {
		case "Vine":
			return 50L;
		case "Red":
			return 1018L;
		case "Green":
			return 1007L;
		}
		return super.convertRouteIdFromShortNameNotSupported(routeShortName);
	}

	private static final Pattern STARTS_WITH_0_ = Pattern.compile("(^0+)");

	@NotNull
	@Override
	public String cleanRouteShortName(@NotNull String routeShortName) {
		routeShortName = STARTS_WITH_0_.matcher(routeShortName).replaceAll(EMPTY);
		return super.cleanRouteShortName(routeShortName);
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

	@Nullable
	@Override
	public String fixColor(@Nullable String color) {
		if (ColorUtils.BLACK.equalsIgnoreCase(color)) {
			return null;
		}
		return super.fixColor(color);
	}

	@SuppressWarnings("DuplicateBranchesInSwitch")
	@Nullable
	@Override
	public String provideMissingRouteColor(@NotNull GRoute gRoute) {
		switch (getRouteShortName(gRoute)) {
		// @formatter:off
		case "2": return "956338";
		case "3": return "00A651";
		case "4": return "B99874";
		case "6": return "01A553";
		case "7": return "8DC63F";
		case "9": return "8781BD";
		case "19": return "32BCAD";
		case "25": return "C1B400";
		case "30": return "BA6831";
		case "32": return "2E3092";
		case "37": return "F7941E";
		case "38": return "B41E8E";
		case "39": return "EC008E";
		case "41": return LIMITED_ROUTES_COLOR;
		case "44": return LIMITED_ROUTES_COLOR;
		case "47": return LIMITED_ROUTES_COLOR;
		case "Vine": return "78BE20";
		case "50": return "78BE20"; // VINE
		case "60": return LIMITED_ROUTES_COLOR;
		case "65": return LIMITED_ROUTES_COLOR;
		case "67": return LIMITED_ROUTES_COLOR;
		case "71": return "FDB913";
		case "72": return "92278F";
		case "73": return "BA7031";
		case "74": return "F573A9";
		case "78": return "00AEEf";
		case "80": return "0072BC";
		case "92": return "BC9632";
		case "105": return EXPRESS_ROUTES_COLOR;
		case "134": return EXPRESS_ROUTES_COLOR;
		case "157": return EXPRESS_ROUTES_COLOR;
		case "164": return EXPRESS_ROUTES_COLOR;
		case "177": return EXPRESS_ROUTES_COLOR;
		case "190": return EXPRESS_ROUTES_COLOR;
		case "199": return EXPRESS_ROUTES_COLOR;
		// @formatter:on
		}
		return super.provideMissingRouteColor(gRoute);
	}

	@Override
	public boolean defaultRouteLongNameEnabled() {
		return true;
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
	public String cleanDirectionHeadsign(int directionId, boolean fromStopName, @NotNull String directionHeadSign) {
		directionHeadSign = super.cleanDirectionHeadsign(directionId, fromStopName, directionHeadSign);
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
