package org.mtransit.parser.us_clark_county_c_tran_bus;

import java.util.HashMap;

public class Stops {
	public static HashMap<String, String> ALL_STOPS;
	static {
		HashMap<String, String> allStops = new HashMap<String, String>();
		// rm -r input/gtfs
		// unzip input/gtfs.zip -d input/gtfs
		// awk -F "\"*,\"*" '{print "allStops.put(\"" $2 "\", \"" $1"\"); // " $3}' input/gtfs/stops.txt > output/output.java
		allStops.put("2962", "245"); // NW 99th St & 16th Ave
		allStops.put("598", "338"); // NE 18th St & Todd [wb]
		allStops.put("6061", "1022"); // Fourth Plain & Washington St [eb]
		allStops.put("747", "254"); // NW 9th Ave & 84th St
		allStops.put("6083", "1060"); // SE 34th St & 189th Ave [wb]
		allStops.put("1144", "386"); // Evergreen Blvd & Grove St
		allStops.put("545", "53"); // Lincoln & 41st St [nb]
		allStops.put("3297", "608"); // Kauffman & 32nd St
		allStops.put("1342", "760"); // Hwy 99 10600 Block
		allStops.put("6120", "1055"); // NE 99th St & Highway 99 [eb]
		allStops.put("3343", "625"); // NE 99th St & 122nd Ave
		allStops.put("975", "651"); // Ft Vancouver Wy & 28th St
		allStops.put("1281", "489"); // SE 164th Ave 2100 Block
		allStops.put("1202", "741"); // Mill Plain 6600 Block
		allStops.put("2024", "16"); // Washington & 9th St
		allStops.put("3028", "696"); // Hazel Dell Ave 8900 Block
		allStops.put("607", "93"); // E 33rd St & W St [wb]
		allStops.put("4174", "712"); // NW 99th St & 9th Ave [wb]
		allStops.put("2983", "247"); // NW 99th St & 12th Ave [eb]
		allStops.put("1112", "385"); // Evergreen Blvd & Ash St
		allStops.put("236", "680"); // E 33rd St & Main
		allStops.put("2033", "118"); // Fourth Plain & Wintler Dr
		allStops.put("3303", "611"); // Grand & 13th St
		allStops.put("6040", "1003"); // Rasmussen & Parkway Ave
		allStops.put("2270", "368"); // NE 76th St & 120th Ave
		allStops.put("6161", "1120"); // Grand Boulevard [eb]
		allStops.put("6056", "1035"); // Kauffman & 36th Street [nb]
		allStops.put("1137", "401"); // Andresen & Missouri Dr
		allStops.put("907", "875"); // Covington Rd & 100th Ave [nb]
		allStops.put("3233", "585"); // NE 162nd Ave & 18th St [nb]
		allStops.put("3322", "622"); // NE 28th St & 135th Ave
		allStops.put("3239", "590"); // NE 162nd Ave & 18th St [sb]
		allStops.put("3074", "870"); // Grace Ave & 4th St
		allStops.put("768", "932"); // Hwy 99 & 129th St [sb]
		allStops.put("794", "520"); // Hazel Dell Ave 7200 Block
		allStops.put("1305", "341"); // Ft Vancouver Wy 1200 Block
		allStops.put("117", "973"); // I-5 && BURNSIDE
		allStops.put("2367", "501"); // Mill Plain & Hearthwood [eb]
		allStops.put("111", "833"); // Delta Park/Vanport MAX
		allStops.put("3383", "972"); // NE 3rd Ave & Wedgewood Ct
		allStops.put("725", "126"); // Fourth Plain & T St [wb]
		allStops.put("3128", "578"); // Burton & 87th Ave
		allStops.put("2065", "387"); // Evergreen Blvd & Beech St
		allStops.put("3485", "969"); // SE 164th Ave & 6th St [sb]
		allStops.put("2395", "156"); // NE 117th Ave & 149th St [sb]
		allStops.put("1336", "542"); // Hwy 99 8500 Block
		allStops.put("5005", "947"); // SW 5th & Madison
		allStops.put("2323", "425"); // NE 3rd Ave at LaCamas Center
		allStops.put("303", "890"); // NE 136th Ave 200 Block  [sb]
		allStops.put("1245", "452"); // Mill Plain 6500 Block
		allStops.put("3002", "218"); // Bliss Rd & 21st Ave
		allStops.put("6048", "1006"); // NE 3rd Ave & Franklin St [eb]
		allStops.put("3235", "587"); // NE 162nd Ave & 28th St [nb]
		allStops.put("6085", "1062"); // SE 34th St & 177th Ave [wb]
		allStops.put("903", "139"); // NE 76th St & 97th Ave [wb]
		allStops.put("1612", "919"); // N Hayden Isl Dr & N Tomahawk Isl Dr
		allStops.put("550", "45"); // Lincoln & 51st St [nb]
		allStops.put("6068", "1050"); // Evergreen Blvd & Grant
		allStops.put("992", "304"); // St Johns 8200 Block
		allStops.put("803", "270"); // Main & 39th St
		allStops.put("5003", "945"); // SW 5th & Salmon
		allStops.put("3102", "204"); // NE 39th St & 162nd Ave
		allStops.put("3132", "398"); // Andresen & Gulf Dr
		allStops.put("2056", "388"); // Evergreen Blvd 3400 Block
		allStops.put("848", "149"); // NE 117th Ave & 107th St [sb]
		allStops.put("6038", "1000"); // Fairgrounds Ave at Ball Park
		allStops.put("908", "874"); // Covington Rd & 76th St [nb]
		allStops.put("2345", "435"); // Addy St 3900 Block
		allStops.put("6165", "1124"); // 57th Avenue [eb]
		allStops.put("1013", "306"); // St Johns 8600 Block
		allStops.put("904", "181"); // Covington Rd & 76th St [sb]
		allStops.put("3347", "669"); // NE 99th St & 144th Ct
		allStops.put("3015", "221"); // NW 36th Ave & 131st St
		allStops.put("4147", "703"); // Hazel Dell Ave & 60th St
		allStops.put("6124", "1032"); // SE 136th Ave & Mill Plain [sb]
		allStops.put("2350", "439"); // Main St 3000 Block
		allStops.put("2989", "561"); // NW 9th Ave 8200 Block
		allStops.put("6144", "1104"); // Stapleton Road [wb]
		allStops.put("2315", "448"); // NE 3rd Ave & Crown Rd
		allStops.put("1109", "381"); // Evergreen Blvd & V St [eb]
		allStops.put("3320", "621"); // NE 28th St & 129th Ave
		allStops.put("1242", "454"); // Mill Plain & Morrison Ave
		allStops.put("2839", "40"); // NW 78th St & 12th Ave [wb]
		allStops.put("2999", "226"); // NW 36th Ave & 124th St [nb]
		allStops.put("6052", "1016"); // 12100 N. Pavilion
		allStops.put("6014", "985"); // NE 139th St & 10th Ave
		allStops.put("6043", "1005"); // Mill Plain & 172nd Ave [wb]
		allStops.put("784", "251"); // NW 9th Ave & 94th St [sb]
		allStops.put("6129", "1082"); // SE 136th Ave & McGillivray
		allStops.put("702", "112"); // Van Mall Dr & 94th Ave [eb]
		allStops.put("1100", "733"); // Fourth Plain & 112th Ave [wb]
		allStops.put("2108", "473"); // Mill Plain & 126th Ave [eb]
		allStops.put("2706", "36"); // NW 78th St & Fruit Valley Rd [wb]
		allStops.put("1337", "541"); // Hwy 99 & 88th St
		allStops.put("2997", "547"); // NE 78th St 5600 Block
		allStops.put("2949", "174"); // Andresen & 58th St [sb]
		allStops.put("3361", "634"); // Mill Plain & Lieser Rd [wb]
		allStops.put("2845", "51"); // Lincoln & 43rd St [sb]
		allStops.put("2054", "400"); // Andresen & Louisiana Dr [sb]
		allStops.put("6116", "1077"); // Van Mall Loop & West Trailhead
		allStops.put("1141", "391"); // Evergreen Blvd 4100 Block
		allStops.put("2069", "403"); // Andresen & Wichita Dr [nb]
		allStops.put("2106", "466"); // Mill Plain & 98th Ave
		allStops.put("721", "121"); // Fourth Plain & Norris [wb]
		allStops.put("937", "185"); // NE 112th Ave & 46th St [sb]
		allStops.put("1310", "751"); // SE 164th Ave 900 Block
		allStops.put("2275", "364"); // Fourth Plain 12500 Block
		allStops.put("4108", "665"); // Ward Rd & Fourth Plain
		allStops.put("828", "161"); // W Main St & SW 3rd Ave [eb]
		allStops.put("301", "895"); // NE 136th Ave & 9th St [sb]
		allStops.put("2322", "424"); // NE 3rd Ave 3100 Block
		allStops.put("631", "907"); // Broadway & 7th St
		allStops.put("3188", "916"); // 3505 SW US Veterans Rd
		allStops.put("6079", "1030"); // SE 192nd Ave & Mill Plain
		allStops.put("1344", "534"); // Hwy 99 & 107th St
		allStops.put("1107", "376"); // Evergreen Blvd & Reserve St [eb]
		allStops.put("1098", "351"); // NE 76th St 13300 Block
		allStops.put("6063", "1024"); // Grand & McLoughlin [sb]
		allStops.put("2272", "877"); // NE 102nd Ave & Fourth Plain
		allStops.put("1043", "319"); // Burton & Bridge Creek Ave
		allStops.put("4177", "716"); // Bliss Rd & 26th Ave [eb]
		allStops.put("4145", "933"); // Hwy 99 & 129th St [nb]
		allStops.put("1060", "309"); // NE 28th St 13400 Block
		allStops.put("1189", "476"); // Mill Plain & Ft Vancouver Wy [eb]
		allStops.put("2274", "353"); // Fourth Plain 10200 Block
		allStops.put("2961", "246"); // NW 99th St & 12th Ave [wb]
		allStops.put("2836", "37"); // NW 78th St & 15th Ave
		allStops.put("818", "145"); // NE 117th Ave 11600 Block [nb]
		allStops.put("2063", "380"); // Evergreen Blvd & U St [eb]
		allStops.put("3200", "574"); // NW 99th Street 200 Block
		allStops.put("4138", "675"); // Kauffman & 25th St [nb]
		allStops.put("2695", "134"); // NE 76th St 11000 Block
		allStops.put("1068", "324"); // Burton & 98th Ave [wb]
		allStops.put("315", "687"); // St Johns & 78th St [nb]
		allStops.put("118", "975"); // I-5 && LOMBARD
		allStops.put("2679", "781"); // Van Mall Dr 7500 Block [eb]
		allStops.put("3494", "699"); // NE 39th St & 149th Ave
		allStops.put("6114", "1089"); // Fourth Plain & 143rd Ave
		allStops.put("2911", "940"); // Mill Plain & 190th Ave [eb]
		allStops.put("3230", "580"); // NE 39th St & Rancho Dr
		allStops.put("6050", "1011"); // Scotton Way & 13th St [eb]
		allStops.put("6168", "1127"); // 78th Avenue [eb]
		allStops.put("731", "271"); // Main & 38th St
		allStops.put("533", "13"); // Columbia & McLoughlin Blvd
		allStops.put("3003", "215"); // Hathaway Rd 1800 Block
		allStops.put("6086", "1063"); // SE 34th St & 172nd Ave [wb]
		allStops.put("609", "97"); // E 33rd St & S St [wb]
		allStops.put("3319", "620"); // NE 28th St 12400 Block
		allStops.put("990", "298"); // St Johns & 40th Ave
		allStops.put("6113", "1088"); // Ward Rd & 152nd Ave
		allStops.put("1350", "763"); // Hwy 99 & 82nd St
		allStops.put("6167", "1126"); // Andresen Road [eb]
		allStops.put("4119", "876"); // Covington Rd & 102nd Ave
		allStops.put("3236", "582"); // NE 162nd Ave & 34th St [nb]
		allStops.put("6003", "955"); // SW 6th & Salmon
		allStops.put("905", "729"); // Covington Rd & 73rd St
		allStops.put("211", "677"); // W Main St & 20th Ave [eb]
		allStops.put("981", "280"); // St Johns & 45th St
		allStops.put("3492", "824"); // Mill Plain & Franklin [eb]
		allStops.put("750", "250"); // NW 9th Ave 9600 Block [nb]
		allStops.put("3273", "597"); // Grand & 1st St [nb]
		allStops.put("1340", "758"); // Hwy 99 7700 Block
		allStops.put("6008", "982"); // I-5 && NE 94TH STREET
		allStops.put("6065", "1028"); // Grand Blvd & 16th St
		allStops.put("2978", "235"); // NW 21st Ave & 111th St
		allStops.put("3329", "624"); // Mill Plain & Garrison Rd [wb]
		allStops.put("3173", "791"); // NE Multnomah & Grand [wb]
		allStops.put("2140", "503"); // Mill Plain & 136th Ave [eb]
		allStops.put("6175", "1136"); // NE 162nd Ave. & NE 78th St.
		allStops.put("2844", "48"); // Lincoln & 46th St [sb]
		allStops.put("6132", "1072"); // Columbia & 6th Street
		allStops.put("1087", "361"); // Fourth Plain & 121st Ave [eb]
		allStops.put("4109", "666"); // Fourth Plain & 137th Ave [wb]
		allStops.put("829", "163"); // W Main St & Parkway [eb]
		allStops.put("1047", "844"); // Burton 7700 Block [eb]
		allStops.put("3487", "671"); // NE 152nd Ave & 91st St
		allStops.put("553", "61"); // Lincoln & 59th St [nb]
		allStops.put("6119", "1054"); // NE 99th St & Hwy 99 [wb]
		allStops.put("979", "278"); // St Johns & 41st St
		allStops.put("1214", "461"); // Mill Plain & 89th Ave
		allStops.put("3051", "594"); // NE 78th St 3300 Block
		allStops.put("804", "272"); // Main & 36th St [sb]
		allStops.put("1257", "477"); // Mill Plain & Ft Vancouver Wy [wb]
		allStops.put("1019", "293"); // St Johns & 65th St
		allStops.put("2403", "859"); // W Main & 20th Ave
		allStops.put("685", "726"); // Caples at Post Office [nb]
		allStops.put("3026", "785"); // Hazel Dell Ave & 84th St
		allStops.put("1314", "753"); // SE 164th Ave & McGillivray [nb]
		allStops.put("1119", "402"); // Andresen & MacArthur Blvd [nb]
		allStops.put("3107", "573"); // NE 138th Ave & 28th St
		allStops.put("3221", "570"); // NE 117th Ave & 87th St [nb]
		allStops.put("6152", "1112"); // McLoughlin & Washington Street [wb]
		allStops.put("1086", "360"); // Fourth Plain & Vancouver Pl
		allStops.put("3022", "526"); // Hazel Dell Ave 7900 Block
		allStops.put("6019", "993"); // SW Campus Dr & Terwilliger
		allStops.put("2862", "313"); // NE 28th St & 119th Ave
		allStops.put("3192", "802"); // SW Sam Jackson Pk & OHSU
		allStops.put("1234", "462"); // Mill Plain & 90th Ave
		allStops.put("972", "647"); // Ft Vancouver Wy at O'Connell Sports Ctr [nb]
		allStops.put("6058", "1036"); // Fourth Plain & Esther
		allStops.put("977", "652"); // St Johns & 32nd St [nb]
		allStops.put("600", "82"); // NE 18th St & Murton [wb]
		allStops.put("6084", "1061"); // SE 34th St & Hiddenbrook [wb]
		allStops.put("1076", "328"); // NE 18th St & 65th Ave [wb]
		allStops.put("2078", "297"); // St Johns 7300 Block
		allStops.put("3172", "790"); // NE Multnomah & 3rd [eb]
		allStops.put("4179", "717"); // Tenney Rd at Fred Meyer
		allStops.put("836", "159"); // W Main St 600 Block [wb]
		allStops.put("1339", "538"); // Hwy 99 9400 Block
		allStops.put("6146", "1106"); // Todd Road [wb]
		allStops.put("660", "66"); // McLoughlin & Z St [wb]
		allStops.put("3060", "412"); // Andresen & 18th St [sb]
		allStops.put("6136", "1018"); // 7th Street at Turtle Place
		allStops.put("744", "672"); // NW 9th Ave & 78th St
		allStops.put("2104", "662"); // Ft Vancouver Wy at O'Connell Sports Center [sb]
		allStops.put("2967", "236"); // NW 21st Ave & 111th St
		allStops.put("1020", "286"); // St James & Minnehaha
		allStops.put("2182", "187"); // NE 112th Ave & 42nd St
		allStops.put("2346", "436"); // Addy St 3700 Block [wb]
		allStops.put("3304", "612"); // Grand & 9th St [sb]
		allStops.put("581", "78"); // McLoughlin & F St [eb]
		allStops.put("6159", "1118"); // Gaiser Hall [nb]
		allStops.put("6153", "1113"); // Washington & 12th Street [sb]
		allStops.put("936", "182"); // NE 112th Ave & 51st St [sb]
		allStops.put("2348", "438"); // Addy St 3300 Block [wb]
		allStops.put("3234", "586"); // NE 162nd Ave & 23rd St [nb]
		allStops.put("4152", "923"); // Hazel Dell Ave & 94th St [nb]
		allStops.put("610", "98"); // E 33rd St & Q St [wb]
		allStops.put("6163", "1122"); // General Anderson [eb]
		allStops.put("1611", "920"); // Jantzen Beach Main Stop
		allStops.put("6177", "1137"); // NE 114th Ave. & Fourth Plain [nb]
		allStops.put("6174", "1134"); // NE Ward Rd. & NE 162nd Ave.
		allStops.put("1244", "745"); // Mill Plain & Andresen [wb]
		allStops.put("2688", "170"); // Van Mall Dr 7500 Block [wb]
		allStops.put("1095", "347"); // NE 76th St & Ward Rd
		allStops.put("2141", "692"); // Mill Plain & 136th Ave [wb]
		allStops.put("932", "188"); // NE 112th Ave & 39th St [sb]
		allStops.put("1397", "968"); // SE 164th Ave & 5th St
		allStops.put("322", "689"); // Ward Rd & 76th St
		allStops.put("3194", "918"); // SW Sam Jackson Pk & Campus Dr
		allStops.put("524", "9"); // Kauffman Ave & 22nd St
		allStops.put("665", "75"); // McLoughlin at Marshall Center
		allStops.put("1082", "355"); // Fourth Plain 10400 Block
		allStops.put("3043", "219"); // Seward Rd & Creekside Dr
		allStops.put("1110", "384"); // Evergreen Blvd & Z St
		allStops.put("3275", "600"); // Grand & 6th St [nb]
		allStops.put("1338", "539"); // Hwy 99 9100 Block
		allStops.put("1345", "535"); // Hwy 99 & 104th St
		allStops.put("935", "183"); // NE 112th Ave & 51st St [nb]
		allStops.put("659", "65"); // McLoughlin & Grand [wb]
		allStops.put("1132", "822"); // Andresen & Fourth Plain [sb]
		allStops.put("687", "117"); // Plomondon & Caples [eb]
		allStops.put("588", "67"); // McLoughlin & Z St [eb]
		allStops.put("3274", "599"); // Grand 300 Block [nb]
		allStops.put("2672", "21"); // Columbia & Fourth Plain
		allStops.put("2347", "437"); // Addy St 3500 Block [wb]
		allStops.put("4148", "704"); // Hazel Dell Ave 5200 Block [nb]
		allStops.put("849", "150"); // NE 117th Ave & 99th St [sb]
		allStops.put("4183", "720"); // Lincoln & 53rd St [sb]
		allStops.put("1105", "370"); // Evergreen Blvd at Grant House [eb]
		allStops.put("601", "84"); // E 20th St & Grand [wb]
		allStops.put("984", "283"); // St Johns & 54th St
		allStops.put("3372", "635"); // E St & 15th St
		allStops.put("2974", "232"); // NW 119th St & 31st Ave
		allStops.put("3031", "259"); // NE 78th St & Hwy 99
		allStops.put("2381", "157"); // W Main St & 12th Ave
		allStops.put("3380", "643"); // NE 3rd Ave & 1st Ave [wb]
		allStops.put("6006", "950"); // SW 6th & Stark
		allStops.put("3306", "613"); // Grand & 6th St [sb]
		allStops.put("2965", "239"); // NW 21st Ave 10400 Block [nb]
		allStops.put("2736", "556"); // NE 78th St & 19th Ct
		allStops.put("2661", "101"); // E 33rd St & O St [eb]
		allStops.put("1040", "331"); // E 18th St & Devine
		allStops.put("4121", "872"); // Covington Rd & 102nd Ave [sb]
		allStops.put("3061", "3"); // Fruit Valley Rd & 27th St [nb]
		allStops.put("2004", "25"); // Columbia & 23rd St [nb]
		allStops.put("5009", "964"); // SW 5th & Hall
		allStops.put("4110", "667"); // Fourth Plain & 131st Ave [wb]
		allStops.put("1146", "383"); // Evergreen Blvd 2500 Block
		allStops.put("3070", "871"); // SW 20th Ave & 6th St [sb]
		allStops.put("6134", "1102"); // Thurston Way [nb]
		allStops.put("6039", "1002"); // Rasmussen & Clark Ave
		allStops.put("3315", "616"); // Burton & 109th Ave [eb]
		allStops.put("728", "129"); // Fourth Plain & F St [wb]
		allStops.put("1071", "828"); // Burton & 84th Ave
		allStops.put("4161", "708"); // NE 76th St & 115th Ave [eb]
		allStops.put("3237", "583"); // NE 162nd Ave & 28th St [sb]
		allStops.put("613", "104"); // E 33rd St & H St [wb]
		allStops.put("6106", "1074"); // Columbia & 13th St
		allStops.put("2886", "197"); // NE 162nd Ave & 15th St
		allStops.put("3017", "225"); // NW 36th Ave & 124th St [sb]
		allStops.put("6111", "1087"); // NE 162nd Ave & 73rd St
		allStops.put("6158", "1117"); // Central Campus [nb]
		allStops.put("1316", "837"); // SE 164th Ave 3200 Block
		allStops.put("643", "88"); // Grand & 32nd St [sb]
		allStops.put("6060", "1038"); // Fourth Plain & Daniels
		allStops.put("4180", "718"); // NW 139th St 600 Block
		allStops.put("980", "279"); // St Johns 4200 Block
		allStops.put("1030", "657"); // Ft Vancouver Wy & St Johns
		allStops.put("3498", "702"); // Hazel Dell Ave & 82nd St [sb]
		allStops.put("1147", "382"); // Evergreen Blvd & V St [wb]
		allStops.put("6016", "990"); // SW Campus Dr & Loading Dock 5
		allStops.put("6162", "1121"); // Todd Road [eb]
		allStops.put("801", "269"); // Main & 45th St [sb]
		allStops.put("1203", "743"); // Mill Plain & Andresen [eb]
		allStops.put("798", "516"); // Hazel Dell Ave 6000 Block
		allStops.put("739", "521"); // Hazel Dell Ave & Repass Rd
		allStops.put("6094", "1071"); // SE 192nd Avenue & Westridge Blvd
		allStops.put("1084", "359"); // Fourth Plain & Gher Rd
		allStops.put("3356", "633"); // Mill Plain & Lieser Rd [eb]
		allStops.put("126", "1144"); // SR-14 Fwy Stop WB #1 E End
		allStops.put("1282", "487"); // McGillivray & Briarwood Dr [wb]
		allStops.put("3348", "629"); // NE 99th St & 149th Ave
		allStops.put("2130", "201"); // SE 164th Ave 1400 Block
		allStops.put("1118", "396"); // Andresen & Evergreen Blvd [nb]
		allStops.put("2156", "509"); // SE 164th Ave & 12th St
		allStops.put("1115", "392"); // Evergreen Blvd & Fairview Dr
		allStops.put("102", "816"); // Evergreen Park & Ride
		allStops.put("983", "282"); // St Johns & 52nd St
		allStops.put("3294", "607"); // Kauffman & 25th St [sb]
		allStops.put("6053", "1094"); // Washington St & W 9th St fs
		allStops.put("332", "980"); // NE 136th Ave 1400 Block
		allStops.put("6066", "1026"); // Columbia House Blvd at Park & Ride
		allStops.put("1075", "326"); // NE 18th St & Andresen [wb]
		allStops.put("6082", "1059"); // SE 192nd Ave & 31st St [sb]
		allStops.put("231", "679"); // E 33rd St & Main
		allStops.put("324", "894"); // NE 136th Ave at Firstenburg Center
		allStops.put("675", "130"); // Fourth Plain & D St
		allStops.put("548", "47"); // Lincoln 4600 Block
		allStops.put("900", "137"); // NE 76th St & 103rd Ave [wb]
		allStops.put("6047", "1008"); // NE 3rd Ave & Franklin St [wb]
		allStops.put("2327", "428"); // E St & 9th St
		allStops.put("6054", "1017"); // NW 119th Street & 23rd Avenue
		allStops.put("782", "927"); // NE 9th Ave & 101st St
		allStops.put("3186", "800"); // US Veterans Hospital
		allStops.put("701", "113"); // Van Mall Dr & 94th Ave [wb]
		allStops.put("2221", "540"); // Hwy 99 at WalMart
		allStops.put("2203", "190"); // NE 112th Ave 3300 Block
		allStops.put("2321", "423"); // NE 3rd Ave & Shepherd Rd
		allStops.put("217", "419"); // Andresen & Fourth Plain [nb]
		allStops.put("310", "886"); // Village Loop & Fernwood [nb]
		allStops.put("3032", "550"); // NE 78th St & St Johns Rd [eb]
		allStops.put("105", "178"); // Salmon Creek P&R
		allStops.put("5007", "949"); // SW 5th & Clay
		allStops.put("6117", "1076"); // Van Mall Loop & East Trailhead
		allStops.put("6098", "1044"); // NE 117th Ave & 71st Street [nb]
		allStops.put("2091", "902"); // St Johns & 93rd St
		allStops.put("2942", "173"); // Andresen & Van Mall Dr [nb]
		allStops.put("326", "897"); // NE 138th Ave & 18th St [nb]
		allStops.put("879", "132"); // NE 76th St & 103rd Ave [eb]
		allStops.put("2917", "203"); // NE 162nd Ave & 13th St
		allStops.put("2333", "432"); // E St 2200 Block
		allStops.put("3385", "645"); // Adams & 5th Ave
		allStops.put("3375", "638"); // E St 700 Block
		allStops.put("1138", "397"); // Andresen & Evergreen Blvd [sb]
		allStops.put("2737", "558"); // NE 78th St 1600 Block
		allStops.put("628", "111"); // Broadway & 24th St
		allStops.put("901", "138"); // NE 76th St & 101st Ave [wb]
		allStops.put("3076", "868"); // Grace & Rasmussen
		allStops.put("1091", "731"); // Fourth Plain & 137th Ave [eb]
		allStops.put("5001", "941"); // SW 5th & Alder
		allStops.put("789", "256"); // NW 9th Ave & 79th St
		allStops.put("3310", "926"); // NE 105th St & Hazel Dell Ave
		allStops.put("536", "22"); // Columbia & 27th St [nb]
		allStops.put("6108", "1085"); // Fourth Plain & 147th Ave
		allStops.put("2969", "233"); // NW 119th St & 26th Ave [eb]
		allStops.put("293", "323"); // Burton & 98th Ave [eb]
		allStops.put("6017", "991"); // 700 SW Campus Dr at Doernbecher
		allStops.put("749", "252"); // NW 9th Ave & 94th St [nb]
		allStops.put("1097", "350"); // NE 76th St & 137th Ave
		allStops.put("1360", "764"); // W Main & 29th St [eb]
		allStops.put("534", "11"); // Columbia & 20 St [nb]
		allStops.put("2353", "450"); // Main & 22nd St
		allStops.put("2982", "244"); // NW 99th St & 18th Ave
		allStops.put("2932", "966"); // Mill Plain & 188th Ave
		allStops.put("2383", "164"); // E Main St 500 Block
		allStops.put("3229", "581"); // NE 39th St & 141st Ave
		allStops.put("1044", "322"); // Burton & 92nd Ave [eb]
		allStops.put("1169", "446"); // NE 3rd Ave 1400 Block
		allStops.put("4123", "961"); // NE 102nd Ave & 63rd St [sb]
		allStops.put("6013", "987"); // Jantzen Beach Main Stop
		allStops.put("6164", "1123"); // Stapleton Road [eb]
		allStops.put("551", "55"); // Lincoln & 53rd St [nb]
		allStops.put("1324", "756"); // Mill Plain 15800 Block
		allStops.put("619", "108"); // Broadway & 25th St
		allStops.put("2115", "451"); // Mill Plain & Missoula
		allStops.put("2998", "230"); // NW 36th Ave & 122nd St
		allStops.put("985", "284"); // St Johns & 58th St
		allStops.put("3378", "641"); // NE 3rd Ave & Sheperd Rd [wb]
		allStops.put("582", "73"); // McLoughlin Blvd 1000 Block
		allStops.put("6049", "1010"); // Scotton Way & 13th St [wb]
		allStops.put("2125", "507"); // NW 6th Ave 400 Block [wb]
		allStops.put("1033", "661"); // Ft Vancouver Wy & McLoughlin [sb]
		allStops.put("3344", "626"); // NE 99th St & 126th Ave
		allStops.put("1278", "485"); // McGillivray & Park Crest Ave [eb]
		allStops.put("1038", "335"); // E 18th St 4600 Block [eb]
		allStops.put("599", "81"); // NE 18th St & Norris [wb]
		allStops.put("2743", "564"); // NE 99th St & 25th Ave
		allStops.put("1320", "754"); // Mill Plain & 164th Ave [wb]
		allStops.put("2735", "554"); // NE 78th St & 25th Ave
		allStops.put("3010", "209"); // NW 139th St & 2nd Ave [wb]
		allStops.put("2117", "460"); // Mill Plain & Ogden Ave [wb]
		allStops.put("3203", "571"); // NE 137th Ave & 39th St [nb]
		allStops.put("2099", "290"); // St James & 50th Cir
		allStops.put("1349", "543"); // Hwy 99 & 86th St
		allStops.put("6018", "992"); // SW Campus Dr & Main Dental School
		allStops.put("1031", "658"); // Ft Vancouver Wy & 25th St
		allStops.put("6025", "999"); // W 39th St & Fruit Valley Rd
		allStops.put("2996", "549"); // NE 78th St 4800 Block
		allStops.put("2677", "780"); // Andresen & 40th St
		allStops.put("649", "83"); // E 18th St & Murton [eb]
		allStops.put("1205", "453"); // Mill Plain & Morrison Wy
		allStops.put("4153", "924"); // NE 94th St & Hazel Dell Ave
		allStops.put("2137", "496"); // Mill Plain & 160th Ave
		allStops.put("644", "87"); // Grand & 29th St [sb]
		allStops.put("2840", "38"); // NW 78th St & 14th Ave
		allStops.put("3119", "786"); // NE 112th Ave & 44th St
		allStops.put("3016", "223"); // NW 36th Ave & 127th St
		allStops.put("3071", "873"); // SW 20th Ave & 6th St [nb]
		allStops.put("2062", "372"); // Evergreen Blvd 1200 Block [eb]
		allStops.put("3092", "193"); // NE 39th St & 157th Ave
		allStops.put("684", "119"); // Fourth Plain & Falk Rd [eb]
		allStops.put("2943", "175"); // Andresen & 58th St [nb]
		allStops.put("2312", "644"); // NE 3rd Ave 2100 Block
		allStops.put("3313", "930"); // NE 7th Ave & 101st St
		allStops.put("1229", "470"); // Mill Plain & 104th Ave
		allStops.put("2708", "29"); // Bernie Dr 6400 Block
		allStops.put("793", "524"); // Hazel Dell Ave 7400 Block
		allStops.put("2059", "373"); // Evergreen Blvd 1200 Block [wb]
		allStops.put("2909", "200"); // SE 164th Ave at Fred Meyer [nb]
		allStops.put("729", "277"); // Main & 30th St [nb]
		allStops.put("3195", "805"); // N Vancouver & Weidler
		allStops.put("2696", "141"); // NE 117th Ave & 78th Wy
		allStops.put("1233", "464"); // Mill Plain & 92nd Ave [wb]
		allStops.put("3072", "166"); // SW 20th Ave & 2nd St
		allStops.put("2233", "773"); // NW 99th St 100 Block
		allStops.put("606", "91"); // E 33rd St & Y St [wb]
		allStops.put("6069", "1051"); // Franklin & 13th St
		allStops.put("2410", "831"); // NW 119th St at Felida Elementary
		allStops.put("537", "19"); // Columbia & 29th St [nb]
		allStops.put("2660", "102"); // E 33rd St & L St [eb]
		allStops.put("1018", "294"); // St Johns & 68th St
		allStops.put("2732", "548"); // NE 78th St & 58th Ave
		allStops.put("1254", "479"); // Mill Plain & V St [wb]
		allStops.put("781", "530"); // Hazel Dell Ave & 105th St
		allStops.put("1343", "533"); // Hwy 99 & 112th St
		allStops.put("115", "937"); // I-5 SOUTH && COLUMBIA WAY
		allStops.put("986", "285"); // St Johns & Minnehaha
		allStops.put("2664", "94"); // E 33rd St & V St [eb]
		allStops.put("820", "845"); // NE 117th Ave & Caples Rd [nb]
		allStops.put("1032", "659"); // Ft Vancouver Wy 1900 Block
		allStops.put("1356", "268"); // Hwy 99 & Ross St [sb]
		allStops.put("4176", "714"); // NW 119th St & 33rd Ave [wb]
		allStops.put("1222", "472"); // Mill Plain & 123rd Ave
		allStops.put("1064", "312"); // NE 28th St at Cascadia Technical Academy
		allStops.put("890", "979"); // NE 99th St & 118th Ave
		allStops.put("316", "891"); // NE 136th Ave 200 Block  [nb]
		allStops.put("2314", "447"); // NE 3rd Ave & E First Ave
		allStops.put("1077", "330"); // NE 18th St & Devine
		allStops.put("1194", "481"); // Mill Plain & Grand [eb]
		allStops.put("2861", "135"); // NE 76th St 11100 Block [wb]
		allStops.put("106", "493"); // Fisher's Landing Transit Center
		allStops.put("2750", "928"); // NE 99th St & 26th Ave
		allStops.put("3193", "804"); // SW Sam Jackson Pk & US Veterans
		allStops.put("2920", "865"); // Mill Plain & 190th Ave [wb]
		allStops.put("6137", "1096"); // Van Mall Transit Center
		allStops.put("3284", "603"); // Kauffman & 29th St [sb]
		allStops.put("2079", "299"); // St Johns & 43rd Ave [nb]
		allStops.put("6002", "956"); // SW 6th & Columbia
		allStops.put("3242", "596"); // Bernie Dr & Fruit Valley Rd
		allStops.put("2382", "160"); // W Main & 5th Ave
		allStops.put("939", "189"); // NE 112th Ave & 34th Cir
		allStops.put("2966", "238"); // NW 21st Ave & 108th St
		allStops.put("2689", "171"); // Van Mall Dr & 72nd Ave
		allStops.put("1122", "417"); // Andresen at LH Church
		allStops.put("805", "273"); // Main St 3400 Block [sb]
		allStops.put("2116", "768"); // Mill Plain & Devine [wb]
		allStops.put("6147", "1107"); // Grand Boulevard [wb]
		allStops.put("6007", "981"); // NE 11th Ave & Holladay
		allStops.put("1351", "544"); // Hwy 99 8000 Block
		allStops.put("6021", "1013"); // Mill Plain & 18000 Block [wb]
		allStops.put("3114", "31"); // Bernie Dr & Lupin St [wb]
		allStops.put("6172", "1091"); // Broadway & 16th Street [nb]
		allStops.put("2988", "559"); // NE 78th St & 13th Ave
		allStops.put("933", "771"); // NE 112th Ave & 39th St [nb]
		allStops.put("6059", "1037"); // Fourth Plain & Harney
		allStops.put("1231", "465"); // Mill Plain & 97th Ave
		allStops.put("978", "654"); // St Johns & Petticoat Ln
		allStops.put("2726", "562"); // NE 99th St & 43rd Ave
		allStops.put("1252", "490"); // Mill Plain & Z St [wb]
		allStops.put("967", "506"); // NW 6th Ave & 6th Ave [eb]
		allStops.put("2218", "532"); // Hwy 99 11300 Block
		allStops.put("6142", "1100"); // 65th Avenue [wb]
		allStops.put("1066", "316"); // NE 28th St & 109th Ave
		allStops.put("3090", "192"); // NE 39th St & 152nd Ave
		allStops.put("1079", "334"); // NE 18th St & General Anderson [wb]
		allStops.put("2930", "32"); // Bernie Dr & Lupin St
		allStops.put("3171", "788"); // NE Wheeler & Multnomah
		allStops.put("3205", "572"); // NE 137th Ave & 39th St [sb]
		allStops.put("3465", "664"); // NW 9th Ave & 87th St [nb]
		allStops.put("5002", "943"); // SW 5th & Morrison
		allStops.put("2172", "770"); // Gher Rd & Coxley Dr [nb]
		allStops.put("3381", "811"); // NE 3rd Ave 2000 Block
		allStops.put("6089", "1066"); // SE 34th Street & Hiddenbrook Dr [eb]
		allStops.put("3325", "623"); // Andresen 4200 Block
		allStops.put("973", "648"); // Ft Vancouver Wy at Gaiser Hall [nb]
		allStops.put("2984", "248"); // NW 99th St 900 Block
		allStops.put("2070", "721"); // Andresen & Mill Plain [nb]
		allStops.put("2994", "552"); // NE 78th St & 30th Ave
		allStops.put("579", "14"); // Washington & 13th St
		allStops.put("6064", "1040"); // Grand & 20th Street
		allStops.put("1023", "289"); // St James & 52nd St
		allStops.put("3702", "856"); // NE 139th St at Legacy Hospital
		allStops.put("6135", "1103"); // Thurston Way [sb]
		allStops.put("1104", "345"); // Evergreen Blvd & C St
		allStops.put("664", "71"); // McLoughlin & Ft Vancouver Wy [wb]
		allStops.put("3308", "614"); // Grand 300 Block [sb]
		allStops.put("3374", "637"); // E St & 9th St
		allStops.put("1151", "343"); // Evergreen Blvd 800 Block
		allStops.put("6123", "1047"); // NE 20th Ave & 144th St
		allStops.put("560", "60"); // Lincoln & 59th St [sb]
		allStops.put("3232", "827"); // NE 162nd Ave & 34th St [sb]
		allStops.put("724", "125"); // Fourth Plain & Ft Vancouver Wy [wb]
		allStops.put("2001", "8"); // Kauffman & 21st St
		allStops.put("676", "128"); // Fourth Plain & F St [eb]
		allStops.put("2058", "377"); // Evergreen Blvd & Reserve St [wb]
		allStops.put("652", "63"); // E 18th St & Brandt [eb]
		allStops.put("2673", "344"); // Evergreen Blvd 400 Block [wb]
		allStops.put("2990", "694"); // NE 99th St & 50th Ave [eb]
		allStops.put("3346", "628"); // NE 99th St & 134th Ave
		allStops.put("755", "529"); // Hazel Dell Ave & 103rd St
		allStops.put("2138", "497"); // Mill Plain & 155th Ave
		allStops.put("3176", "793"); // Multnomah & 11th
		allStops.put("2944", "177"); // Andresen & 63rd St [nb]
		allStops.put("3089", "191"); // NE 39th St & 146th Ave
		allStops.put("2114", "455"); // Mill Plain & Garrison Rd [eb]
		allStops.put("112", "690"); // Andresen P&R
		allStops.put("1145", "736"); // Evergreen Blvd & Grand [wb]
		allStops.put("1133", "418"); // Andresen Rd 2700 Block
		allStops.put("2225", "264"); // Hwy 99 6300 Block
		allStops.put("6055", "1034"); // Kauffman & 36th St [sb]
		allStops.put("302", "892"); // NE 136th Ave & 4th St [sb]
		allStops.put("1037", "336"); // E 18th St & Bryant [eb]
		allStops.put("3178", "796"); // NE 13th Ave & Holladay
		allStops.put("2951", "172"); // Van Mall Dr & 72nd Ave [eb]
		allStops.put("816", "144"); // NE 117th Ave & 107th St [nb]
		allStops.put("2324", "426"); // NE 3rd Ave 3500 Block
		allStops.put("2928", "867"); // SE 164th Ave & 1st St [nb]
		allStops.put("2993", "555"); // NE 78th St & 26th Ave
		allStops.put("3035", "563"); // NE 99th St & 39th Ave [eb]
		allStops.put("1149", "375"); // Evergreen Blvd 1400 Block [wb]
		allStops.put("2399", "151"); // NE 117th Ave 9000 Block
		allStops.put("3259", "593"); // W 15th St 400 Block
		allStops.put("1330", "265"); // Hwy 99 & 63rd St [nb]
		allStops.put("554", "28"); // Lincoln & Bernie Dr
		allStops.put("1230", "467"); // Mill Plain 9900 Block
		allStops.put("6011", "984"); // W Main St & 15th Ave [wb]
		allStops.put("6169", "1128"); // 86th Avenue [eb]
		allStops.put("2053", "405"); // Andresen & Mill Plain [sb]
		allStops.put("680", "123"); // Fourth Plain & Z St
		allStops.put("1308", "750"); // Mill Plain 14300 Block [eb]
		allStops.put("6130", "1083"); // SE 136th Ave & Block 1200
		allStops.put("116", "977"); // I-84 && NE 82ND AVENUE
		allStops.put("3105", "207"); // NE 39th St & 145th Ave
		allStops.put("2159", "492"); // NW 6th Ave 400 Block [eb]
		allStops.put("1220", "513"); // Mill Plain 11700 Block
		allStops.put("1306", "748"); // NE 136th Ave & Mill Plain
		allStops.put("3181", "795"); // NE Multnomah & Grand [eb]
		allStops.put("2319", "421"); // NE 3rd Ave 2700 Block
		allStops.put("5006", "948"); // SW 5th & Columbia
		allStops.put("1108", "378"); // Evergreen Blvd & S St
		allStops.put("1218", "577"); // Mill Plain & 105th Ave
		allStops.put("786", "568"); // NW 9th Ave & 92nd St
		allStops.put("1080", "337"); // NE 18th St 4000 Block
		allStops.put("300", "898"); // NE 138th Ave & 22nd St
		allStops.put("1250", "457"); // Mill Plain & Brandt Rd
		allStops.put("730", "275"); // Main & 33rd St [nb]
		allStops.put("627", "110"); // Broadway & 22nd St
		allStops.put("6128", "1081"); // McGillivray & Blairmont Dr
		allStops.put("3254", "809"); // Hwy 99 & NE 104th St
		allStops.put("1142", "389"); // Evergreen Blvd & Harney Wy [wb]
		allStops.put("572", "17"); // Columbia 3100 Block
		allStops.put("321", "820"); // Fourth Plain & St Johns [eb]
		allStops.put("305", "889"); // SE 162nd Ave & Village Loop
		allStops.put("3187", "917"); // 3515 SW US Veterans Rd
		allStops.put("1083", "357"); // Fourth Plain 10700 Block [eb]
		allStops.put("2213", "772"); // Hwy 99 11200 Block
		allStops.put("549", "46"); // Lincoln & 49th St [nb]
		allStops.put("2926", "39"); // NW 78th St & 12th Ave [eb]
		allStops.put("982", "281"); // St Johns & 49th St
		allStops.put("3034", "905"); // NE 99th St & 39th Ave [wb]
		allStops.put("525", "7"); // Kauffman & 19th St [sb]
		allStops.put("1139", "735"); // Evergreen Blvd 4700 Block [wb]
		allStops.put("1171", "431"); // E St 1700 Block
		allStops.put("633", "911"); // Broadway & 13th St fs [nb]
		allStops.put("963", "508"); // NW 6th Ave & Ivy [wb]
		allStops.put("110", "878"); // 99th Street TC
		allStops.put("6005", "952"); // SW 6th & Washington
		allStops.put("6125", "1078"); // SE 136th Ave & 1200 Block [sb]
		allStops.put("638", "915"); // W 8th Street & Main [eb]
		allStops.put("323", "884"); // Village Loop & McGillivray [sb]
		allStops.put("650", "80"); // E 18th St 3200 Block
		allStops.put("934", "186"); // NE 112th Ave & 46th St [nb]
		allStops.put("3376", "639"); // NE 3rd Ave & Weir
		allStops.put("2148", "499"); // Mill Plain 14900 Block
		allStops.put("252", "684"); // Addy St & Addy Loop
		allStops.put("2060", "369"); // Evergreen Blvd at Howard House
		allStops.put("2093", "307"); // St Johns 8900 Block
		allStops.put("559", "27"); // Bernie Dr & Lincoln
		allStops.put("6157", "1116"); // Marshall/Luepke Center [eb]
		allStops.put("1283", "486"); // McGillivray & Park Crest Ave [wb]
		allStops.put("3075", "697"); // Main & 40th St [sb]
		allStops.put("6127", "1080"); // McGillivray & Blairmont
		allStops.put("1092", "732"); // Fourth Plain & 140th Ave
		allStops.put("733", "706"); // Main & 40th St [nb]
		allStops.put("3377", "640"); // NE 3rd Ave & 4th St
		allStops.put("6090", "1067"); // SE 34th Street & 189th Avenue [eb]
		allStops.put("2847", "54"); // W 39th St & Kauffman [eb]
		allStops.put("4175", "713"); // NW 119th St 2100 Block
		allStops.put("3314", "615"); // Burton & 103rd Ave [eb]
		allStops.put("543", "826"); // Columbia & 33rd St [sb]
		allStops.put("6126", "1079"); // McGillivray & 136th Ave
		allStops.put("6118", "1053"); // LaLonde & St Johns [wb]
		allStops.put("2703", "528"); // Hazel Dell Ave 8500 Block
		allStops.put("2411", "830"); // NW 119th St & 31st Ave
		allStops.put("1121", "415"); // Andresen at WINCO [nb]
		allStops.put("4181", "719"); // Bliss Rd & 26th Ave
		allStops.put("3382", "812"); // NE 3rd Ave & Joy
		allStops.put("505", "10"); // Kauffman & 23rd St
		allStops.put("1136", "404"); // Andresen & Wichita Dr [sb]
		allStops.put("6166", "1125"); // 65th Avenue [eb]
		allStops.put("2946", "140"); // Andresen & 78th St
		allStops.put("3058", "842"); // NE 18th St & 65th Ave [eb]
		allStops.put("678", "127"); // Fourth Plain & T St [eb]
		allStops.put("6041", "1004"); // Parkway Ave & 3rd St
		allStops.put("6140", "1098"); // 78th Avenue [wb]
		allStops.put("2702", "527"); // Hazel Dell Ave & 82nd St [nb]
		allStops.put("1334", "757"); // Hwy 99 & 99th St [sb]
		allStops.put("6155", "1114"); // Broadway & 13th Street [nb]
		allStops.put("2237", "325"); // NE 28th St & 138th Ave
		allStops.put("689", "114"); // Stapleton Rd 2800 Block
		allStops.put("1347", "537"); // Hwy 99 at WINCO
		allStops.put("2980", "240"); // NW 21st Ave 10400 Block [sb]
		allStops.put("3701", "971"); // NE 139th St & 29th Ave [eb]
		allStops.put("2277", "722"); // Fourth Plain & 135th Ave
		allStops.put("688", "115"); // Plomondon & Stapleton [eb]
		allStops.put("3202", "569"); // E 33rd St & I St
		allStops.put("3041", "220"); // NW 36th Ave at Salmon Creek Trail
		allStops.put("1192", "478"); // Mill Plain & V St [eb]
		allStops.put("3106", "208"); // NE 39th St & 141st Ave
		allStops.put("2647", "340"); // Ft Vancouver Wy & McLoughlin [nb]
		allStops.put("6093", "1070"); // SE 192nd Avenue & 15th Street [nb]
		allStops.put("6023", "996"); // Fruit Valley Rd & La Frambois
		allStops.put("1225", "474"); // Mill Plain & 131st Ave [wb]
		allStops.put("3029", "591"); // NE 78th St & Andresen
		allStops.put("573", "20"); // Columbia & 29th St [sb]
		allStops.put("1196", "456"); // Mill Plain & Rhododendron
		allStops.put("1062", "310"); // NE 28th St & 129th Ave
		allStops.put("1046", "579"); // NE 25th & Andresen
		allStops.put("2709", "34"); // Lakeshore Dr & Bernie
		allStops.put("835", "162"); // W Main & 3rd Ave [wb]
		allStops.put("1256", "747"); // Mill Plain & Reserve [wb]
		allStops.put("800", "514"); // Hazel Dell Ave 4900 Block
		allStops.put("3175", "792"); // NE Multnomah & 9th [wb]
		allStops.put("812", "142"); // NE 117th Ave & Padden Parkway [nb]
		allStops.put("2224", "262"); // Hwy 99 & 68th St
		allStops.put("6141", "1099"); // Andresen Road [wb]
		allStops.put("3170", "797"); // NE Multnomah & 3rd [wb]
		allStops.put("1116", "734"); // Evergreen Blvd 4700 Block [eb]
		allStops.put("2868", "33"); // Bernie Dr 6700 Block
		allStops.put("1063", "311"); // NE 28th St & 124th Ave
		allStops.put("546", "50"); // Lincoln & 43rd St [nb]
		allStops.put("1318", "199"); // SE 164th Ave & 32nd St
		allStops.put("535", "24"); // Columbia St & 24th St [nb]
		allStops.put("1215", "463"); // Mill Plain & 92nd Ave [eb]
		allStops.put("964", "505"); // NW 6th Ave & Norwood
		allStops.put("2011", "26"); // Columbia & 23rd St [sb]
		allStops.put("317", "893"); // NE 136th Ave & 4th St [nb]
		allStops.put("1026", "292"); // St James 4300 Block
		allStops.put("6080", "1057"); // SE 192nd Ave & 15th Street [sb]
		allStops.put("2866", "395"); // Evergreen Blvd & Shorewood Dr
		allStops.put("850", "821"); // NE 117th Ave & 95th St [sb]
		allStops.put("3495", "700"); // Grand & 1st St [sb]
		allStops.put("3005", "588"); // NW 139th St & 10th Ct
		allStops.put("3379", "642"); // NE 3rd Ave 2700 Block
		allStops.put("3285", "604"); // Kauffman & Fourth Plain [sb]
		allStops.put("544", "832"); // Columbia & 33rd St [nb]
		allStops.put("4111", "668"); // Fourth Plain 12300 Block [wb]
		allStops.put("1312", "838"); // Mill Plain 16000 Block
		allStops.put("2212", "536"); // Hwy 99 & 99th St [nb]
		allStops.put("1120", "410"); // Andresen & 18th St [nb]
		allStops.put("748", "253"); // NW 9th Ave 9200 Block [nb]
		allStops.put("558", "30"); // Bernie Dr 6400 Block
		allStops.put("6062", "1039"); // Grand Blvd & 20th St
		allStops.put("799", "515"); // Hazel Dell Ave 5200 block [sb]
		allStops.put("663", "70"); // McLoughlin at Clark College [wb]
		allStops.put("6004", "954"); // SW 6th & Taylor
		allStops.put("6091", "1068"); // SE 192nd Avenue & 31st Street [nb]
		allStops.put("3741", "852"); // Yacolt Rd & Railroad Ave
		allStops.put("666", "77"); // McLoughlin & F St [wb]
		allStops.put("2694", "133"); // NE 76th St 10600 Block
		allStops.put("1384", "765"); // W 6th St & Washington
		allStops.put("1022", "288"); // St James & 54th St
		allStops.put("630", "107"); // Broadway & 28th St
		allStops.put("783", "249"); // NW 9th Ave & 99th St
		allStops.put("3251", "808"); // NE 78th St 4200 Block
		allStops.put("6173", "1133"); // NE 99th St & 32nd Ave [eb]
		allStops.put("2977", "234"); // NW 21st Ave & 113th St
		allStops.put("6095", "1041"); // NE 117th Ave & 71st St [sb]
		allStops.put("1089", "365"); // Fourth Plain & 127th Ave
		allStops.put("4182", "814"); // NW 119th St & 35th Ave
		allStops.put("6088", "1065"); // SE 34th Street & 176th Avenue
		allStops.put("3422", "646"); // NE 76th St & 142nd Ave
		allStops.put("3293", "606"); // Kauffman & Mill Plain
		allStops.put("4151", "936"); // Hwy 99 & 122nd St [nb]
		allStops.put("4143", "676"); // Hazel Dell Ave & 101st St
		allStops.put("4137", "673"); // Kauffman & Fourth Plain [nb]
		allStops.put("3317", "619"); // NE 28th St & 119th Ave [eb]
		allStops.put("2680", "169"); // Van Mall Dr & Loowit Loop
		allStops.put("3300", "609"); // W 33rd St & Main [eb]
		allStops.put("2973", "217"); // Hathaway & 19th Ave
		allStops.put("3283", "810"); // Kauffman 3100 Block
		allStops.put("6110", "1086"); // NE 162nd Ave & Fourth Plain
		allStops.put("3006", "210"); // NW 139th St & 2nd Ave [eb]
		allStops.put("2045", "469"); // Mill Plain & 102nd Ave [wb]
		allStops.put("2173", "131"); // NE 76th St & 101st Ave
		allStops.put("127", "1146"); // SR-14 Fwy Stop WB #2 W End
		allStops.put("1352", "257"); // Hwy 99 at Fred Meyer
		allStops.put("788", "727"); // NW 9th Ave & 82nd St
		allStops.put("6081", "1058"); // SE 192nd Ave & 20th St [sb]
		allStops.put("2915", "202"); // NE 162nd Ave & 9th St
		allStops.put("325", "896"); // NE 138th Ave & 18th St [sb]
		allStops.put("2676", "779"); // Andresen & Van Mall Dr [sb]
		allStops.put("296", "686"); // Hazel Dell Ave & 63rd St
		allStops.put("2981", "242"); // NW 21st Ave & 99th St
		allStops.put("2733", "783"); // NE 78th St 4700 Block
		allStops.put("2933", "967"); // Mill Plain & 177th Ave
		allStops.put("719", "120"); // Fourth Plain & Falk Rd [wb]
		allStops.put("3037", "227"); // NW 36th Ave & 122nd St
		allStops.put("2828", "308"); // St Johns & NE 50th Ave
		allStops.put("2734", "553"); // NE 78th St 2800 Block
		allStops.put("2710", "35"); // NW 78th St & Fruit Valley Rd [eb]
		allStops.put("3038", "212"); // NW 139th St at Sky View High School
		allStops.put("6067", "1049"); // Evergreen Blvd & Daniels
		allStops.put("3148", "576"); // Mill Plain & 126th Ave [wb]
		allStops.put("589", "64"); // McLoughlin Blvd & Grand [eb]
		allStops.put("2964", "241"); // NW 21st Ave & 101st St
		allStops.put("2007", "59"); // Lincolin & 57th St [sb]
		allStops.put("3093", "194"); // NE 39th St & 159th Ave
		allStops.put("6020", "1012"); // Mill Plain & 18000 Block [eb]
		allStops.put("504", "6"); // Kauffman & 19th St [nb]
		allStops.put("645", "86"); // Grand & 26th St
		allStops.put("6121", "1056"); // LaLonde Dr & St Johns [eb]
		allStops.put("6151", "1111"); // Marshall/Luepke Center [wb]
		allStops.put("3039", "213"); // NW 139th St 1300 Block
		allStops.put("2991", "557"); // NE 78th St & 16th Ave
		allStops.put("635", "913"); // Evergreen Blvd & Broadway
		allStops.put("2838", "43"); // NW 78th St & 10th Ave [wb]
		allStops.put("2919", "864"); // Mill Plain & 172nd Ave [eb]
		allStops.put("3095", "195"); // NE 162nd Ave & 39th St
		allStops.put("611", "100"); // E 33rd St & O St [wb]
		allStops.put("2883", "862"); // Fourth Plain & 121st Ave [wb]
		allStops.put("1103", "356"); // Fourth Plain & 105th Ave
		allStops.put("1353", "260"); // Hwy 99 & 72nd St
		allStops.put("307", "887"); // Village Loop & Fernwood [sb]
		allStops.put("1017", "295"); // St Johns & 37th Ave [sb]
		allStops.put("3000", "224"); // NW 36th Ave & 126th St
		allStops.put("597", "62"); // NE 18th St & Brandt [wb]
		allStops.put("2320", "422"); // NE 3rd Ave 2800 Block
		allStops.put("3011", "211"); // NW 139th St & 11th Ave
		allStops.put("3012", "214"); // Bliss Rd 1800 Block
		allStops.put("6170", "1129"); // 86th Avenue [wb]
		allStops.put("1199", "739"); // Mill Plain & Ogden [eb]
		allStops.put("6148", "1108"); // Ft. Vancouver Way & Fourth Plain [sb]
		allStops.put("3001", "222"); // NW 36th Ave & 129th St
		allStops.put("5004", "946"); // SW 5th & Main
		allStops.put("2095", "302"); // St Johns 7900 Block
		allStops.put("552", "57"); // Lincoln 5500 Block
		allStops.put("1090", "366"); // Fourth Plain & 131st Ave [eb]
		allStops.put("2331", "430"); // E St & Washougal River Rd
		allStops.put("780", "929"); // NE 7th Ave & 101st St
		allStops.put("852", "153"); // NE 117th Ave & Padden Parkway [sb]
		allStops.put("2149", "498"); // Mill Plain 15400 Block
		allStops.put("2273", "354"); // Fourth Plain & 102nd Ave
		allStops.put("6171", "1090"); // Fourth Plain & Z Street [wb]
		allStops.put("329", "899"); // NE 138th Ave & 22nd St
		allStops.put("2692", "154"); // NE 76th St & 115th Ave
		allStops.put("815", "143"); // NE 117th Ave & 100th St [nb]
		allStops.put("899", "136"); // NE 76th St & 107th Ave [wb]
		allStops.put("753", "565"); // NW 99th St & 4th Ave [eb]
		allStops.put("2865", "819"); // Van Mall Dr & 77th Ave
		allStops.put("2659", "105"); // E 33rd St & Main [eb]
		allStops.put("6022", "995"); // NE 39th St & 152nd Ave [wb]
		allStops.put("3351", "631"); // NE 152nd Ave & 86th St
		allStops.put("796", "519"); // Hazel Dell Ave & 68th St [sb]
		allStops.put("6015", "989"); // NE 139th St & 3rd Ct
		allStops.put("561", "56"); // Lincoln & 55th Loop
		allStops.put("1099", "352"); // NE 76th St & 130th Ave
		allStops.put("1067", "317"); // NE 28th St & 103rd Ave [wb]
		allStops.put("2267", "589"); // NE 76th St & 126th Ave
		allStops.put("2161", "769"); // Gher Rd & Fourth Plain Blvd [sb]
		allStops.put("6107", "1073"); // Columbia & Evergreen Blvd
		allStops.put("3198", "806"); // SW Terwilliger & Campus
		allStops.put("538", "18"); // Columbia & 31st St [nb]
		allStops.put("1346", "761"); // Hwy 99 7900 Block
		allStops.put("2057", "379"); // Evergreen Blvd & U St [wb]
		allStops.put("6122", "1045"); // NE 29th Ave & WSUV Trailhead
		allStops.put("2663", "96"); // E 33rd St & S St [eb]
		allStops.put("1102", "358"); // Fourth Plain 10700 Block [wb]
		allStops.put("101", "723"); // Parkrose/Sumner Transit Center
		allStops.put("2316", "777"); // NE 3rd Ave 1800 Block
		allStops.put("1014", "303"); // St Johns & 82nd St
		allStops.put("2351", "440"); // Main & 28th St
		allStops.put("6156", "1115"); // Broadway & 15th Street [nb]
		allStops.put("1096", "349"); // NE 76th St & 147th Ave
		allStops.put("632", "909"); // Broadway & Evergreen Blvd
		allStops.put("1176", "442"); // Main St & 24th St
		allStops.put("2210", "931"); // Hwy 99 6600 Block [nb]
		allStops.put("3486", "670"); // NE 152nd Ave & 94th St
		allStops.put("6057", "1020"); // Fourth Plain & Washington [wb]
		allStops.put("1015", "300"); // St Johns & 78th St [sb]
		allStops.put("576", "12"); // Columbia & 20th St [sb]
		allStops.put("2665", "89"); // E 33rd St & Y St [eb]
		allStops.put("617", "106"); // Main St & 30th St
		allStops.put("3179", "794"); // NE Multnomah & 9th
		allStops.put("6096", "1042"); // NE 117th Ave & 65th St [sb]
		allStops.put("4149", "705"); // Hazel Dell Ave 4900 Block [nb]
		allStops.put("1024", "291"); // St James 4600 Block
		allStops.put("2139", "500"); // Mill Plain & Hearthwood [wb]
		allStops.put("1094", "840"); // Fourth Plain 11300 Block
		allStops.put("2080", "305"); // St Johns 8600 Block
		allStops.put("3260", "698"); // Mill Plain & Franklin [wb]
		allStops.put("2846", "52"); // Lincoln & 41st St [sb]
		allStops.put("3013", "216"); // Hathaway Rd 1900 Block
		allStops.put("2000", "4"); // Kauffman & 17th St [nb]
		allStops.put("6145", "1105"); // General Anderson [wb]
		allStops.put("2948", "176"); // Andresen & 63rd St [sb]
		allStops.put("3206", "575"); // NE 78th St 1700 Block
		allStops.put("1140", "394"); // Evergreen Blvd & 5th St [wb]
		allStops.put("124", "1140"); // SR-14 Fwy Stop EB #2 I-205 Ramp
		allStops.put("3312", "925"); // NE 9th Ave & 105th St
		allStops.put("2325", "427"); // E St 600 Block
		allStops.put("6143", "1101"); // 57th Avenue [wb]
		allStops.put("1135", "409"); // Andresen & Kansas St
		allStops.put("3104", "206"); // NE 39th St & 155th Ave
		allStops.put("2638", "778"); // W Main & 29th Ave [wb]
		allStops.put("2963", "243"); // NW 99th St & 20th Ave
		allStops.put("1329", "267"); // Hwy 99 & Ross St [nb]
		allStops.put("243", "682"); // Evergreen Blvd & Grand [eb]
		allStops.put("3185", "799"); // SW US Veterans Rd & Bldg #16
		allStops.put("1354", "263"); // Hwy 99 6600 Block [sb]
		allStops.put("2489", "934"); // Hwy 99 & 122nd St [sb]
		allStops.put("2648", "342"); // Ft Vancouver Wy & Mill Plain [nb]
		allStops.put("682", "122"); // Fourth Plain & Norris [eb]
		allStops.put("3352", "632"); // NE 152nd Ave & 80th St
		allStops.put("2231", "566"); // NE 99th St & 4th Ave
		allStops.put("1106", "374"); // Evergreen Blvd 1400 Block [eb]
		allStops.put("1177", "443"); // Main St 2000 Block
		allStops.put("2334", "433"); // E St & 24th  St
		allStops.put("6070", "1052"); // Evergreen Blvd & Columbia
		allStops.put("1217", "468"); // Mill Plain & 102nd Ave [eb]
		allStops.put("2055", "399"); // Andresen at St Joseph Church
		allStops.put("1065", "314"); // NE 28th St & 112th Ave
		allStops.put("587", "68"); // McLoughlin & W St [eb]
		allStops.put("989", "296"); // St Johns & 37th Ave [nb]
		allStops.put("1224", "475"); // Mill Plain & 131st Ave [eb]
		allStops.put("6092", "1069"); // SE 192nd Avenue & 20th Street [nb]
		allStops.put("1227", "471"); // Mill Plain & 120th Ave
		allStops.put("2216", "531"); // Hwy 99 & 117th [sb]
		allStops.put("1279", "488"); // McGillivray & Briarwood Dr [eb]
		allStops.put("3131", "787"); // Andresen & Louisiana [nb]
		allStops.put("1173", "434"); // E St 2600 Block
		allStops.put("1307", "502"); // Mill Plain 14100 Block [eb]
		allStops.put("6087", "1064"); // SE 34th Street & 172nd Avenue [eb]
		allStops.put("3024", "695"); // Hazel Dell Ave & 94th St [sb]
		allStops.put("1039", "332"); // E 18th St & Carlson Rd
		allStops.put("4162", "710"); // St Johns & 68th St [nb]
		allStops.put("1088", "363"); // Fourth Plain & 123rd Ave
		allStops.put("1200", "740"); // Mill Plain & Devine [eb]
		allStops.put("2013", "109"); // Broadway & 19th St [sb]
		allStops.put("6046", "1092"); // E 15th St & Broadway [wb]
		allStops.put("3276", "601"); // Grand 700 Block
		allStops.put("6131", "1084"); // SE 136th Ave & 7th St
		allStops.put("6160", "1119"); // Fourth Plain & Ft. Vancouver Way [eb]
		allStops.put("4150", "935"); // Hwy 99 & 117th St [nb]
		allStops.put("2318", "449"); // NE 3rd Ave & 3rd Loop
		allStops.put("125", "1142"); // SR-14 Fwy Stop EB #3 E End
		allStops.put("2284", "841"); // Adams St & 5th Ave
		allStops.put("1219", "744"); // Mill Plain & Chkalov Dr
		allStops.put("5008", "962"); // SW 5th & Harrison
		allStops.put("2662", "99"); // E 33rd St & Q St [eb]
		allStops.put("1078", "333"); // NE 18th St & Carlson
		allStops.put("311", "885"); // Village Loop & McGillivray [nb]
		allStops.put("1028", "655"); // St Johns & 32nd St [sb]
		allStops.put("1085", "730"); // Fourth Plain & 112th Ave [eb]
		allStops.put("2336", "512"); // Evergreen Wy 3100 Block
		allStops.put("737", "518"); // Hazel Dell Ave & 68th St [nb]
		allStops.put("1150", "371"); // Evergreen Blvd at Grant House [wb]
		allStops.put("1193", "480"); // Mill Plain & Z St [eb]
		allStops.put("6001", "958"); // SW 6th & Market
		allStops.put("4165", "711"); // Jefferson & 12th St [nb]
		allStops.put("906", "180"); // Covington Rd & 101st Ave [sb]
		allStops.put("6133", "1075"); // Columbia & 15th St
		allStops.put("648", "85"); // E 20th St & Grand [eb]
		allStops.put("2241", "320"); // Burton & 83rd Ave
		allStops.put("4159", "707"); // W Main 1700 Block
		allStops.put("308", "888"); // Village Loop & 162nd Ave
		allStops.put("1074", "829"); // Burton 7700 Block [wb]
		allStops.put("2278", "774"); // Fourth Plain & 103rd Ave
		allStops.put("1249", "459"); // Mill Plain & Manzanita Wy [wb]
		allStops.put("575", "23"); // Columbia & 24th St [sb]
		allStops.put("6097", "1043"); // NE 117th Ave & 65th Street [nb]
		allStops.put("612", "103"); // E 33rd St & L St [wb]
		allStops.put("752", "567"); // NW 99th St & 8th Ave
		allStops.put("2927", "41"); // NW 78th St & 10th Ave [eb]
		allStops.put("3277", "602"); // Grand & Mill Plain [nb]
		allStops.put("608", "95"); // E 33rd St & U St [wb]
		allStops.put("1117", "393"); // Evergreen Blvd & 5th St [eb]
		allStops.put("2992", "903"); // NE 99th St & 50th Ave [wb]
		allStops.put("1178", "444"); // C St & Pendleton
		allStops.put("2725", "904"); // NE 99th St & 41st Ct
		allStops.put("6024", "998"); // Fruit Valley Rd & 37th St [nb]
		allStops.put("2887", "198"); // NE 162nd Ave & 11th St
		allStops.put("2098", "287"); // St James & 59th St
		allStops.put("3316", "617"); // NE 28th St & 114th Ave [eb]
		allStops.put("547", "49"); // Lincoln 4500 Block
		allStops.put("1114", "390"); // Evergreen Blvd & Harney Wy [eb]
		allStops.put("3350", "630"); // NE 152nd Ave & 96th St
		allStops.put("1134", "413"); // Andresen at WINCO [sb]
		allStops.put("1311", "752"); // Mill Plain & Olympia Dr
		allStops.put("851", "152"); // NE 117th Ave & 87th St [sb]
		allStops.put("814", "836"); // NE 117th Ave & 95th St [nb]
		allStops.put("1375", "511"); // W Main & 13th Ave [wb]
		allStops.put("318", "922"); // NE 136th Ave & 9th St [nb]
		allStops.put("1315", "510"); // SE 164th Ave & McGillivray [sb]
		allStops.put("3033", "592"); // NE 78th St & 66th Ave
		allStops.put("3703", "860"); // NE 139th St at Vancouver Clinic
		allStops.put("227", "339"); // McLoughlin at Clark College [eb]
		allStops.put("2947", "545"); // Andresen & 70th St [sb]
		allStops.put("2745", "906"); // NE 99th St at Gaiser Middle School [wb]
		allStops.put("2957", "546"); // Andresen & 70th St [nb]
		allStops.put("1323", "970"); // SE 164th Ave & 1st St [sb]
		allStops.put("2329", "429"); // E St 1200 Block
		allStops.put("583", "72"); // McLoughlin & Ft Vancouver Wy [eb]
		allStops.put("2006", "58"); // Lincolin & 57th St [nb]
		allStops.put("827", "158"); // W Main St 800 Block [eb]
		allStops.put("4122", "960"); // NE 102nd Ave & 63rd St [nb]
		allStops.put("6154", "1130"); // Broadway & 12th St fs
		allStops.put("831", "165"); // W Main & SE Clark Ave [eb]
		allStops.put("1251", "483"); // Mill Plain & Grand [wb]
		allStops.put("846", "147"); // NE 117th Ave 11500 Block [sb]
		allStops.put("2687", "168"); // Van Mall Dr & Thurston Wy
		allStops.put("2179", "184"); // NE 112th Ave & 49th St
		allStops.put("330", "900"); // NE 138th Ave & 28th St
		allStops.put("734", "728"); // Main & 45th St [nb]
		allStops.put("1168", "445"); // NE 3rd Ave & Joy St [eb]
		allStops.put("853", "818"); // NE 117th Ave & 76th St [sb]
		allStops.put("2279", "775"); // Fourth Plain 14000 Block
		allStops.put("974", "650"); // Ft Vancouver Wy & 25th St
		allStops.put("2705", "782"); // Hazel Dell Ave at Target
		allStops.put("1197", "458"); // Mill Plain & Manzanita Wy [eb]
		allStops.put("3238", "584"); // NE 162nd Ave & 23rd St [sb]
		allStops.put("2242", "318"); // NE 25th St & Andresen
		allStops.put("3307", "846"); // NE 112th Ave & 28th St [nb]
		allStops.put("3296", "663"); // Kauffman & 29th St [nb]
		allStops.put("787", "255"); // NW 9th Ave & 85th St
		allStops.put("2268", "367"); // NE 76th St & 124th Ave
		allStops.put("3253", "595"); // NE 78th St 3300 Block
		allStops.put("1607", "881"); // VA Medical Center
		allStops.put("2082", "767"); // St James & Cherry Rd
		allStops.put("3345", "627"); // NE 99th St & 130th Ave
		allStops.put("1190", "738"); // Mill Plain & Reserve [eb]
		allStops.put("4184", "815"); // Lincoln & 49th St [sb]
		allStops.put("1393", "407"); // Andresen & Mill Plain
		allStops.put("651", "79"); // E 18th St 3600 Block [eb]
		allStops.put("740", "522"); // Hazel Dell Ave & 76th St [nb]
		allStops.put("4178", "813"); // NW 139th St at HB Fuller Park
		allStops.put("679", "124"); // Fourth Plain & Ft Vancouver Wy [eb]
		allStops.put("661", "69"); // McLoughlin & W St [wb]
		allStops.put("1332", "261"); // Hwy 99 7000 Block
		allStops.put("2979", "237"); // NW 21st Ave & 108th St
		allStops.put("968", "491"); // NW 6th Ave & Ivy [eb]
		allStops.put("123", "1138"); // SR-14 Fwy Stop EB #1 W End
		allStops.put("1355", "266"); // Hwy 99 & 63rd St [sb]
		allStops.put("736", "517"); // Hazel Dell Ave & Hazel Dell Wy
		allStops.put("1070", "321"); // Burton & 92nd Ave [wb]
		allStops.put("6150", "1110"); // Central Campus [sb]
		allStops.put("294", "901"); // St Johns & 88th St [nb]
		allStops.put("290", "725"); // NE 3rd Ave & 3rd Pl [wb]
		allStops.put("6149", "1109"); // Gaiser Hall [sb]
		allStops.put("2003", "5"); // Kauffman & 17th St [sb]
		allStops.put("3373", "636"); // E St 1100 Block
		ALL_STOPS = allStops;
	}
}
