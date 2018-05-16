package org.mtransit.parser.us_clark_county_c_tran_bus;

import java.util.HashMap;

public class Stops {
	public static HashMap<String, String> ALL_STOPS;
	static {
		HashMap<String, String> allStops = new HashMap<String, String>();
		allStops.put("stop_code", "stop_id"); // stop_name
		allStops.put("3307", "845"); // NE 112th Ave & 28th St [nb]
		allStops.put("6098", "1043"); // NE 117th Ave & 71st Street [nb]
		allStops.put("1329", "266"); // Hwy 99 & Ross St [nb]
		allStops.put("1229", "469"); // Mill Plain & 104th Ave
		allStops.put("3329", "623"); // Mill Plain & Garrison Rd [wb]
		allStops.put("2957", "545"); // Andresen & 70th St [nb]
		allStops.put("3308", "613"); // Grand 300 Block [sb]
		allStops.put("3322", "621"); // NE 28th St & 135th Ave
		allStops.put("6150", "1111"); // Central Campus [sb]
		allStops.put("3000", "223"); // NW 36th Ave & 126th St
		allStops.put("2866", "394"); // Evergreen Blvd & Shorewood Dr
		allStops.put("853", "817"); // NE 117th Ave & 76th St [sb]
		allStops.put("1022", "287"); // St James & 54th St
		allStops.put("6127", "1079"); // McGillivray & Blairmont
		allStops.put("293", "322"); // Burton & 98th Ave [eb]
		allStops.put("1044", "321"); // Burton & 92nd Ave [eb]
		allStops.put("982", "280"); // St Johns & 49th St
		allStops.put("6005", "951"); // SW 6th & Washington
		allStops.put("2946", "139"); // Andresen & 78th St
		allStops.put("663", "69"); // McLoughlin at Clark College [wb]
		allStops.put("583", "71"); // McLoughlin & Ft Vancouver Wy [eb]
		allStops.put("2928", "866"); // SE 164th Ave & 1st St [nb]
		allStops.put("1190", "737"); // Mill Plain & Reserve [eb]
		allStops.put("3013", "215"); // Hathaway Rd 1900 Block
		allStops.put("2865", "818"); // Van Mall Dr & 77th Ave
		allStops.put("1026", "291"); // St James 4300 Block
		allStops.put("6124", "1031"); // SE 136th Ave & Mill Plain [sb]
		allStops.put("3303", "610"); // Grand & 13th St
		allStops.put("3293", "605"); // Kauffman & Mill Plain
		allStops.put("3486", "669"); // NE 152nd Ave & 94th St
		allStops.put("992", "303"); // St Johns 8200 Block
		allStops.put("3010", "208"); // NW 139th St & 2nd Ave [wb]
		allStops.put("2329", "428"); // E St 1200 Block
		allStops.put("2862", "312"); // NE 28th St & 119th Ave
		allStops.put("2117", "459"); // Mill Plain & Ogden Ave [wb]
		allStops.put("6008", "981"); // I-5 && NE 94TH STREET
		allStops.put("2006", "57"); // Lincolin & 57th St [nb]
		allStops.put("1133", "417"); // Andresen Rd 2700 Block
		allStops.put("3343", "624"); // NE 99th St & 122nd Ave
		allStops.put("1039", "331"); // E 18th St & Carlson Rd
		allStops.put("848", "148"); // NE 117th Ave & 107th St [sb]
		allStops.put("2992", "902"); // NE 99th St & 50th Ave [wb]
		allStops.put("1032", "658"); // Ft Vancouver Wy 1900 Block
		allStops.put("688", "114"); // Plomondon & Stapleton [eb]
		allStops.put("3310", "925"); // NE 105th St & Hazel Dell Ave
		allStops.put("2676", "778"); // Andresen & Van Mall Dr [sb]
		allStops.put("4178", "812"); // NW 139th St at HB Fuller Park
		allStops.put("6169", "1130"); // 86th Avenue [eb]
		allStops.put("3012", "213"); // Bliss Rd 1800 Block
		allStops.put("1109", "380"); // Evergreen Blvd & V St [eb]
		allStops.put("2327", "427"); // E St & 9th St
		allStops.put("1071", "827"); // Burton & 84th Ave
		allStops.put("2708", "28"); // Bernie Dr 6400 Block
		allStops.put("721", "120"); // Fourth Plain & Norris [wb]
		allStops.put("2410", "830"); // NW 119th St at Felida Elementary
		allStops.put("6014", "984"); // NE 139th St & 10th Ave
		allStops.put("1250", "456"); // Mill Plain & Brandt Rd
		allStops.put("1176", "441"); // Main St & 24th St
		allStops.put("1060", "308"); // NE 28th St 13400 Block
		allStops.put("132", "1157"); // I-5 & Columbia Way Fwy Stop SB
		allStops.put("2489", "933"); // Hwy 99 & 122nd St [sb]
		allStops.put("6048", "1005"); // NE 3rd Ave & Franklin St [eb]
		allStops.put("2734", "552"); // NE 78th St 2800 Block
		allStops.put("798", "515"); // Hazel Dell Ave 6000 Block
		allStops.put("900", "136"); // NE 76th St & 103rd Ave [wb]
		allStops.put("6057", "1019"); // Fourth Plain & Washington [wb]
		allStops.put("3381", "810"); // NE 3rd Ave 2000 Block
		allStops.put("4161", "707"); // NE 76th St & 115th Ave [eb]
		allStops.put("1360", "763"); // W Main & 29th St [eb]
		allStops.put("1079", "333"); // NE 18th St & General Anderson [wb]
		allStops.put("3200", "573"); // NW 99th Street 200 Block
		allStops.put("6121", "1055"); // LaLonde Dr & St Johns [eb]
		allStops.put("1037", "335"); // E 18th St & Bryant [eb]
		allStops.put("129", "1151"); // I-5 & Columbia Way Fwy Stop NB
		allStops.put("818", "144"); // NE 117th Ave 11600 Block [nb]
		allStops.put("106", "492"); // Fisher's Landing Transit Center
		allStops.put("846", "146"); // NE 117th Ave 11500 Block [sb]
		allStops.put("890", "978"); // NE 99th St & 118th Ave
		allStops.put("6134", "1102"); // Thurston Way [nb]
		allStops.put("6172", "1090"); // Broadway & 16th Street [nb]
		allStops.put("6149", "1109"); // Gaiser Hall [sb]
		allStops.put("2694", "132"); // NE 76th St 10600 Block
		allStops.put("2161", "768"); // Gher Rd & Fourth Plain Blvd [sb]
		allStops.put("1308", "749"); // Mill Plain 14300 Block [eb]
		allStops.put("6108", "1084"); // Fourth Plain & 147th Ave
		allStops.put("2099", "289"); // St James & 50th Cir
		allStops.put("747", "253"); // NW 9th Ave & 84th St
		allStops.put("786", "567"); // NW 9th Ave & 92nd St
		allStops.put("6024", "997"); // Fruit Valley Rd & 37th St [nb]
		allStops.put("2108", "472"); // Mill Plain & 126th Ave [eb]
		allStops.put("2323", "424"); // NE 3rd Ave at LaCamas Center
		allStops.put("1108", "377"); // Evergreen Blvd & S St
		allStops.put("3114", "30"); // Bernie Dr & Lupin St [wb]
		allStops.put("3181", "794"); // NE Multnomah & Grand [eb]
		allStops.put("2284", "840"); // Adams St & 5th Ave
		allStops.put("2735", "553"); // NE 78th St & 25th Ave
		allStops.put("3498", "701"); // Hazel Dell Ave & 82nd St [sb]
		allStops.put("1203", "742"); // Mill Plain & Andresen [eb]
		allStops.put("1084", "358"); // Fourth Plain & Gher Rd
		allStops.put("3314", "614"); // Burton & 103rd Ave [eb]
		allStops.put("972", "646"); // Ft Vancouver Wy at O'Connell Sports Ctr [nb]
		allStops.put("937", "184"); // NE 112th Ave & 46th St [sb]
		allStops.put("2001", "8"); // Kauffman & 21st St
		allStops.put("980", "278"); // St Johns 4200 Block
		allStops.put("1178", "443"); // C St & Pendleton
		allStops.put("252", "683"); // Addy St & Addy Loop
		allStops.put("1192", "477"); // Mill Plain & V St [eb]
		allStops.put("1122", "416"); // Andresen at LH Church
		allStops.put("3304", "611"); // Grand & 9th St [sb]
		allStops.put("2725", "903"); // NE 99th St & 41st Ct
		allStops.put("6047", "1007"); // NE 3rd Ave & Franklin St [wb]
		allStops.put("1332", "260"); // Hwy 99 7000 Block
		allStops.put("3325", "622"); // Andresen 4200 Block
		allStops.put("3104", "205"); // NE 39th St & 155th Ave
		allStops.put("2213", "771"); // Hwy 99 11200 Block
		allStops.put("2403", "858"); // W Main & 20th Ave
		allStops.put("2677", "779"); // Andresen & 40th St
		allStops.put("675", "129"); // Fourth Plain & D St
		allStops.put("6017", "990"); // 700 SW Campus Dr at Doernbecher
		allStops.put("4153", "923"); // NE 94th St & Hazel Dell Ave
		allStops.put("1089", "364"); // Fourth Plain & 127th Ave
		allStops.put("2320", "421"); // NE 3rd Ave 2800 Block
		allStops.put("2965", "238"); // NW 21st Ave 10400 Block [nb]
		allStops.put("2836", "36"); // NW 78th St & 15th Ave
		allStops.put("2984", "247"); // NW 99th St 900 Block
		allStops.put("1104", "344"); // Evergreen Blvd & C St
		allStops.put("6123", "1046"); // NE 20th Ave & 144th St
		allStops.put("6025", "998"); // W 39th St & Fruit Valley Rd
		allStops.put("3385", "644"); // Adams & 5th Ave
		allStops.put("3060", "411"); // Andresen & 18th St [sb]
		allStops.put("2216", "530"); // Hwy 99 & 117th [sb]
		allStops.put("1088", "362"); // Fourth Plain & 123rd Ave
		allStops.put("2920", "864"); // Mill Plain & 190th Ave [wb]
		allStops.put("2647", "339"); // Ft Vancouver Wy & McLoughlin [nb]
		allStops.put("2078", "296"); // St Johns 7300 Block
		allStops.put("310", "885"); // Village Loop & Fernwood [nb]
		allStops.put("1305", "340"); // Ft Vancouver Wy 1200 Block
		allStops.put("725", "125"); // Fourth Plain & T St [wb]
		allStops.put("2982", "243"); // NW 99th St & 18th Ave
		allStops.put("1345", "534"); // Hwy 99 & 104th St
		allStops.put("2980", "239"); // NW 21st Ave 10400 Block [sb]
		allStops.put("933", "770"); // NE 112th Ave & 39th St [nb]
		allStops.put("6175", "1137"); // NE 162nd Ave. & NE 78th St.
		allStops.put("1033", "660"); // Ft Vancouver Wy & McLoughlin [sb]
		allStops.put("2979", "236"); // NW 21st Ave & 108th St
		allStops.put("2182", "186"); // NE 112th Ave & 42nd St
		allStops.put("4180", "717"); // NW 139th St 600 Block
		allStops.put("1063", "310"); // NE 28th St & 124th Ave
		allStops.put("2665", "88"); // E 33rd St & Y St [eb]
		allStops.put("1118", "395"); // Andresen & Evergreen Blvd [nb]
		allStops.put("628", "110"); // Broadway & 24th St
		allStops.put("3170", "796"); // NE Multnomah & 3rd [wb]
		allStops.put("1098", "350"); // NE 76th St 13300 Block
		allStops.put("1307", "501"); // Mill Plain 14100 Block [eb]
		allStops.put("687", "116"); // Plomondon & Caples [eb]
		allStops.put("2242", "317"); // NE 25th St & Andresen
		allStops.put("561", "55"); // Lincoln & 55th Loop
		allStops.put("6006", "949"); // SW 6th & Stark
		allStops.put("2926", "38"); // NW 78th St & 12th Ave [eb]
		allStops.put("6095", "1040"); // NE 117th Ave & 71st St [sb]
		allStops.put("2994", "551"); // NE 78th St & 30th Ave
		allStops.put("676", "127"); // Fourth Plain & F St [eb]
		allStops.put("1078", "332"); // NE 18th St & Carlson
		allStops.put("1281", "488"); // SE 164th Ave 2100 Block
		allStops.put("2231", "565"); // NE 99th St & 4th Ave
		allStops.put("985", "283"); // St Johns & 58th St
		allStops.put("332", "979"); // NE 136th Ave 1400 Block
		allStops.put("1224", "474"); // Mill Plain & 131st Ave [eb]
		allStops.put("231", "678"); // E 33rd St & Main
		allStops.put("302", "891"); // NE 136th Ave & 4th St [sb]
		allStops.put("753", "564"); // NW 99th St & 4th Ave [eb]
		allStops.put("3011", "210"); // NW 139th St & 11th Ave
		allStops.put("6113", "1087"); // Ward Rd & 152nd Ave
		allStops.put("3093", "193"); // NE 39th St & 159th Ave
		allStops.put("6141", "1099"); // Andresen Road [wb]
		allStops.put("1121", "414"); // Andresen at WINCO [nb]
		allStops.put("3072", "165"); // SW 20th Ave & 2nd St
		allStops.put("3275", "599"); // Grand & 6th St [nb]
		allStops.put("739", "520"); // Hazel Dell Ave & Repass Rd
		allStops.put("6122", "1044"); // NE 29th Ave & WSUV Trailhead
		allStops.put("6007", "980"); // NE 11th Ave & Holladay
		allStops.put("2315", "447"); // NE 3rd Ave & Crown Rd
		allStops.put("130", "1153"); // I-5 & E 39th St Fwy Stop NB
		allStops.put("3320", "620"); // NE 28th St & 129th Ave
		allStops.put("2324", "425"); // NE 3rd Ave 3500 Block
		allStops.put("4123", "960"); // NE 102nd Ave & 63rd St [sb]
		allStops.put("6148", "1108"); // Ft. Vancouver Way & Fourth Plain [sb]
		allStops.put("6053", "1093"); // Washington St & W 9th St fs
		allStops.put("1106", "373"); // Evergreen Blvd 1400 Block [eb]
		allStops.put("4165", "710"); // Jefferson & 12th St [nb]
		allStops.put("1338", "538"); // Hwy 99 9100 Block
		allStops.put("582", "72"); // McLoughlin Blvd 1000 Block
		allStops.put("3002", "217"); // Bliss Rd & 21st Ave
		allStops.put("2828", "307"); // St Johns & NE 50th Ave
		allStops.put("748", "252"); // NW 9th Ave 9200 Block [nb]
		allStops.put("131", "1155"); // I-5 & E 39th St Fwy Stop SB
		allStops.put("737", "517"); // Hazel Dell Ave & 68th St [nb]
		allStops.put("1047", "843"); // Burton 7700 Block [eb]
		allStops.put("2115", "450"); // Mill Plain & Missoula
		allStops.put("3095", "194"); // NE 162nd Ave & 39th St
		allStops.put("6117", "1075"); // Van Mall Loop & East Trailhead
		allStops.put("2887", "197"); // NE 162nd Ave & 11th St
		allStops.put("545", "52"); // Lincoln & 41st St [nb]
		allStops.put("1020", "285"); // St James & Minnehaha
		allStops.put("2314", "446"); // NE 3rd Ave & E First Ave
		allStops.put("2680", "168"); // Van Mall Dr & Loowit Loop
		allStops.put("1323", "969"); // SE 164th Ave & 1st St [sb]
		allStops.put("4137", "672"); // Kauffman & Fourth Plain [nb]
		allStops.put("2104", "661"); // Ft Vancouver Wy at O'Connell Sports Center [sb]
		allStops.put("4119", "875"); // Covington Rd & 102nd Ave
		allStops.put("3128", "577"); // Burton & 87th Ave
		allStops.put("2662", "98"); // E 33rd St & Q St [eb]
		allStops.put("546", "49"); // Lincoln & 43rd St [nb]
		allStops.put("6050", "1010"); // Scotton Way & 13th St [eb]
		allStops.put("3296", "662"); // Kauffman & 29th St [nb]
		allStops.put("2660", "101"); // E 33rd St & L St [eb]
		allStops.put("2063", "379"); // Evergreen Blvd & U St [eb]
		allStops.put("6069", "1050"); // Franklin & 13th St
		allStops.put("6040", "1002"); // Rasmussen & Parkway Ave
		allStops.put("852", "152"); // NE 117th Ave & Padden Parkway [sb]
		allStops.put("307", "886"); // Village Loop & Fernwood [sb]
		allStops.put("755", "528"); // Hazel Dell Ave & 103rd St
		allStops.put("308", "887"); // Village Loop & 162nd Ave
		allStops.put("1132", "821"); // Andresen & Fourth Plain [sb]
		allStops.put("3028", "695"); // Hazel Dell Ave 8900 Block
		allStops.put("290", "724"); // NE 3rd Ave & 3rd Pl [wb]
		allStops.put("1283", "485"); // McGillivray & Park Crest Ave [wb]
		allStops.put("4176", "713"); // NW 119th St & 33rd Ave [wb]
		allStops.put("3259", "592"); // W 15th St 400 Block
		allStops.put("829", "162"); // W Main St & Parkway [eb]
		allStops.put("2062", "371"); // Evergreen Blvd 1200 Block [eb]
		allStops.put("661", "68"); // McLoughlin & W St [wb]
		allStops.put("1225", "473"); // Mill Plain & 131st Ave [wb]
		allStops.put("6111", "1086"); // NE 162nd Ave & 73rd St
		allStops.put("112", "689"); // Andresen P&R
		allStops.put("1107", "375"); // Evergreen Blvd & Reserve St [eb]
		allStops.put("544", "831"); // Columbia & 33rd St [nb]
		allStops.put("2696", "140"); // NE 117th Ave & 78th Wy
		allStops.put("3345", "626"); // NE 99th St & 130th Ave
		allStops.put("814", "835"); // NE 117th Ave & 95th St [nb]
		allStops.put("812", "141"); // NE 117th Ave & Padden Parkway [nb]
		allStops.put("2321", "422"); // NE 3rd Ave & Shepherd Rd
		allStops.put("3703", "859"); // NE 139th St at Vancouver Clinic
		allStops.put("3041", "219"); // NW 36th Ave at Salmon Creek Trail
		allStops.put("1196", "455"); // Mill Plain & Rhododendron
		allStops.put("575", "22"); // Columbia & 24th St [sb]
		allStops.put("3319", "619"); // NE 28th St 12400 Block
		allStops.put("573", "19"); // Columbia & 29th St [sb]
		allStops.put("3092", "192"); // NE 39th St & 157th Ave
		allStops.put("6070", "1051"); // Evergreen Blvd & Columbia
		allStops.put("2325", "426"); // E St 600 Block
		allStops.put("1068", "323"); // Burton & 98th Ave [wb]
		allStops.put("1349", "542"); // Hwy 99 & 86th St
		allStops.put("4184", "814"); // Lincoln & 49th St [sb]
		allStops.put("2346", "435"); // Addy St 3700 Block [wb]
		allStops.put("322", "688"); // Ward Rd & 76th St
		allStops.put("608", "94"); // E 33rd St & U St [wb]
		allStops.put("1086", "359"); // Fourth Plain & Vancouver Pl
		allStops.put("3372", "634"); // E St & 15th St
		allStops.put("2274", "352"); // Fourth Plain 10200 Block
		allStops.put("2347", "436"); // Addy St 3500 Block [wb]
		allStops.put("548", "46"); // Lincoln 4600 Block
		allStops.put("719", "119"); // Fourth Plain & Falk Rd [wb]
		allStops.put("978", "653"); // St Johns & Petticoat Ln
		allStops.put("2695", "133"); // NE 76th St 11000 Block
		allStops.put("1043", "318"); // Burton & Bridge Creek Ave
		allStops.put("2059", "372"); // Evergreen Blvd 1200 Block [wb]
		allStops.put("2399", "150"); // NE 117th Ave 9000 Block
		allStops.put("3195", "805"); // N Vancouver & Weidler
		allStops.put("5003", "944"); // SW 5th & Salmon
		allStops.put("3382", "811"); // NE 3rd Ave & Joy
		allStops.put("2917", "202"); // NE 162nd Ave & 13th St
		allStops.put("5002", "942"); // SW 5th & Morrison
		allStops.put("1014", "302"); // St Johns & 82nd St
		allStops.put("1112", "384"); // Evergreen Blvd & Ash St
		allStops.put("6114", "1088"); // Fourth Plain & 143rd Ave
		allStops.put("294", "900"); // St Johns & 88th St [nb]
		allStops.put("123", "1139"); // SR-14 Fwy Stop EB #1 W End
		allStops.put("6133", "1074"); // Columbia & 15th St
		allStops.put("3465", "663"); // NW 9th Ave & 87th St [nb]
		allStops.put("2057", "378"); // Evergreen Blvd & U St [wb]
		allStops.put("984", "282"); // St Johns & 54th St
		allStops.put("6166", "1127"); // 65th Avenue [eb]
		allStops.put("1222", "471"); // Mill Plain & 123rd Ave
		allStops.put("6080", "1056"); // SE 192nd Ave & 15th Street [sb]
		allStops.put("6086", "1062"); // SE 34th St & 172nd Ave [wb]
		allStops.put("3346", "627"); // NE 99th St & 134th Ave
		allStops.put("6023", "995"); // Fruit Valley Rd & La Frambois
		allStops.put("2114", "454"); // Mill Plain & Garrison Rd [eb]
		allStops.put("6020", "1011"); // Mill Plain & 18000 Block [eb]
		allStops.put("1347", "536"); // Hwy 99 at WINCO
		allStops.put("2963", "242"); // NW 99th St & 20th Ave
		allStops.put("2333", "431"); // E St 2200 Block
		allStops.put("1351", "543"); // Hwy 99 8000 Block
		allStops.put("3061", "3"); // Fruit Valley Rd & 27th St [nb]
		allStops.put("2060", "368"); // Evergreen Blvd at Howard House
		allStops.put("2868", "32"); // Bernie Dr 6700 Block
		allStops.put("2275", "363"); // Fourth Plain 12500 Block
		allStops.put("3022", "525"); // Hazel Dell Ave 7900 Block
		allStops.put("1019", "292"); // St Johns & 65th St
		allStops.put("6137", "1095"); // Van Mall Transit Center
		allStops.put("2692", "153"); // NE 76th St & 115th Ave
		allStops.put("1149", "374"); // Evergreen Blvd 1400 Block [wb]
		allStops.put("504", "6"); // Kauffman & 19th St [nb]
		allStops.put("6161", "1122"); // Grand Boulevard [eb]
		allStops.put("750", "249"); // NW 9th Ave 9600 Block [nb]
		allStops.put("3016", "222"); // NW 36th Ave & 127th St
		allStops.put("684", "118"); // Fourth Plain & Falk Rd [eb]
		allStops.put("3273", "596"); // Grand & 1st St [nb]
		allStops.put("1062", "309"); // NE 28th St & 129th Ave
		allStops.put("1038", "334"); // E 18th St 4600 Block [eb]
		allStops.put("3102", "203"); // NE 39th St & 162nd Ave
		allStops.put("3089", "190"); // NE 39th St & 146th Ave
		allStops.put("6171", "1089"); // Fourth Plain & Z Street [wb]
		allStops.put("1249", "458"); // Mill Plain & Manzanita Wy [wb]
		allStops.put("6126", "1078"); // McGillivray & 136th Ave
		allStops.put("1375", "510"); // W Main & 13th Ave [wb]
		allStops.put("788", "726"); // NW 9th Ave & 82nd St
		allStops.put("2000", "4"); // Kauffman & 17th St [nb]
		allStops.put("783", "248"); // NW 9th Ave & 99th St
		allStops.put("2664", "93"); // E 33rd St & V St [eb]
		allStops.put("1220", "512"); // Mill Plain 11700 Block
		allStops.put("899", "135"); // NE 76th St & 107th Ave [wb]
		allStops.put("2702", "526"); // Hazel Dell Ave & 82nd St [nb]
		allStops.put("2221", "539"); // Hwy 99 at WalMart
		allStops.put("973", "647"); // Ft Vancouver Wy at Gaiser Hall [nb]
		allStops.put("1103", "355"); // Fourth Plain & 105th Ave
		allStops.put("6152", "1113"); // McLoughlin & Washington Street [wb]
		allStops.put("305", "888"); // SE 162nd Ave & Village Loop
		allStops.put("549", "45"); // Lincoln & 49th St [nb]
		allStops.put("2149", "497"); // Mill Plain 15400 Block
		allStops.put("1252", "489"); // Mill Plain & Z St [wb]
		allStops.put("116", "976"); // I-84 && NE 82ND AVENUE
		allStops.put("6106", "1073"); // Columbia & 13th St
		allStops.put("1312", "837"); // Mill Plain 16000 Block
		allStops.put("2969", "232"); // NW 119th St & 26th Ave [eb]
		allStops.put("907", "874"); // Covington Rd & 100th Ave [nb]
		allStops.put("1077", "329"); // NE 18th St & Devine
		allStops.put("6154", "1132"); // Broadway & 12th St fs
		allStops.put("2726", "561"); // NE 99th St & 43rd Ave
		allStops.put("2156", "508"); // SE 164th Ave & 12th St
		allStops.put("4122", "959"); // NE 102nd Ave & 63rd St [nb]
		allStops.put("323", "883"); // Village Loop & McGillivray [sb]
		allStops.put("1330", "264"); // Hwy 99 & 63rd St [nb]
		allStops.put("2999", "225"); // NW 36th Ave & 124th St [nb]
		allStops.put("1612", "918"); // N Hayden Isl Dr & N Tomahawk Isl Dr
		allStops.put("2710", "34"); // NW 78th St & Fruit Valley Rd [eb]
		allStops.put("630", "106"); // Broadway & 28th St
		allStops.put("2659", "104"); // E 33rd St & Main [eb]
		allStops.put("3229", "580"); // NE 39th St & 141st Ave
		allStops.put("2210", "930"); // Hwy 99 6600 Block [nb]
		allStops.put("3001", "221"); // NW 36th Ave & 129th St
		allStops.put("1116", "733"); // Evergreen Blvd 4700 Block [eb]
		allStops.put("787", "254"); // NW 9th Ave & 85th St
		allStops.put("6082", "1058"); // SE 192nd Ave & 31st St [sb]
		allStops.put("118", "974"); // I-5 && LOMBARD
		allStops.put("3313", "929"); // NE 7th Ave & 101st St
		allStops.put("1110", "383"); // Evergreen Blvd & Z St
		allStops.put("111", "832"); // Delta Park/Vanport MAX
		allStops.put("3024", "694"); // Hazel Dell Ave & 94th St [sb]
		allStops.put("2106", "465"); // Mill Plain & 98th Ave
		allStops.put("631", "906"); // Broadway & 7th St
		allStops.put("2705", "781"); // Hazel Dell Ave at Target
		allStops.put("3175", "791"); // NE Multnomah & 9th [wb]
		allStops.put("666", "76"); // McLoughlin & F St [wb]
		allStops.put("820", "844"); // NE 117th Ave & Caples Rd [nb]
		allStops.put("525", "7"); // Kauffman & 19th St [sb]
		allStops.put("2069", "402"); // Andresen & Wichita Dr [nb]
		allStops.put("589", "63"); // McLoughlin Blvd & Grand [eb]
		allStops.put("6038", "999"); // Fairgrounds Ave at Ball Park
		allStops.put("2140", "502"); // Mill Plain & 136th Ave [eb]
		allStops.put("2949", "173"); // Andresen & 58th St [sb]
		allStops.put("678", "126"); // Fourth Plain & T St [eb]
		allStops.put("3300", "608"); // W 33rd St & Main [eb]
		allStops.put("579", "14"); // Washington & 13th St
		allStops.put("781", "529"); // Hazel Dell Ave & 105th St
		allStops.put("3315", "615"); // Burton & 109th Ave [eb]
		allStops.put("850", "820"); // NE 117th Ave & 95th St [sb]
		allStops.put("533", "13"); // Columbia & McLoughlin Blvd
		allStops.put("1343", "532"); // Hwy 99 & 112th St
		allStops.put("3260", "697"); // Mill Plain & Franklin [wb]
		allStops.put("2224", "261"); // Hwy 99 & 68th St
		allStops.put("1136", "403"); // Andresen & Wichita Dr [sb]
		allStops.put("2983", "246"); // NW 99th St & 12th Ave [eb]
		allStops.put("1193", "479"); // Mill Plain & Z St [eb]
		allStops.put("1611", "919"); // Jantzen Beach Main Stop
		allStops.put("5007", "948"); // SW 5th & Clay
		allStops.put("4177", "715"); // Bliss Rd & 26th Ave [eb]
		allStops.put("2056", "387"); // Evergreen Blvd 3400 Block
		allStops.put("650", "79"); // E 18th St 3200 Block
		allStops.put("2947", "544"); // Andresen & 70th St [sb]
		allStops.put("2331", "429"); // E St & Washougal River Rd
		allStops.put("627", "109"); // Broadway & 22nd St
		allStops.put("1324", "755"); // Mill Plain 15800 Block
		allStops.put("1095", "346"); // NE 76th St & Ward Rd
		allStops.put("3253", "594"); // NE 78th St 3300 Block
		allStops.put("967", "505"); // NW 6th Ave & 6th Ave [eb]
		allStops.put("701", "112"); // Van Mall Dr & 94th Ave [wb]
		allStops.put("2911", "939"); // Mill Plain & 190th Ave [eb]
		allStops.put("3188", "915"); // 3505 SW US Veterans Rd
		allStops.put("600", "81"); // NE 18th St & Murton [wb]
		allStops.put("3187", "916"); // 3515 SW US Veterans Rd
		allStops.put("3492", "823"); // Mill Plain & Franklin [eb]
		allStops.put("2844", "47"); // Lincoln & 46th St [sb]
		allStops.put("2095", "301"); // St Johns 7900 Block
		allStops.put("6004", "953"); // SW 6th & Taylor
		allStops.put("3350", "629"); // NE 152nd Ave & 96th St
		allStops.put("851", "151"); // NE 117th Ave & 87th St [sb]
		allStops.put("644", "86"); // Grand & 29th St [sb]
		allStops.put("1066", "315"); // NE 28th St & 109th Ave
		allStops.put("243", "681"); // Evergreen Blvd & Grand [eb]
		allStops.put("804", "271"); // Main & 36th St [sb]
		allStops.put("3132", "397"); // Andresen & Gulf Dr
		allStops.put("975", "650"); // Ft Vancouver Wy & 28th St
		allStops.put("6087", "1063"); // SE 34th Street & 172nd Avenue [eb]
		allStops.put("2839", "39"); // NW 78th St & 12th Ave [wb]
		allStops.put("1194", "480"); // Mill Plain & Grand [eb]
		allStops.put("3205", "571"); // NE 137th Ave & 39th St [sb]
		allStops.put("315", "686"); // St Johns & 78th St [nb]
		allStops.put("6107", "1072"); // Columbia & Evergreen Blvd
		allStops.put("598", "337"); // NE 18th St & Todd [wb]
		allStops.put("311", "884"); // Village Loop & McGillivray [nb]
		allStops.put("535", "23"); // Columbia St & 24th St [nb]
		allStops.put("2172", "769"); // Gher Rd & Coxley Dr [nb]
		allStops.put("1017", "294"); // St Johns & 37th Ave [sb]
		allStops.put("2745", "905"); // NE 99th St at Gaiser Middle School [wb]
		allStops.put("2733", "782"); // NE 78th St 4700 Block
		allStops.put("3070", "870"); // SW 20th Ave & 6th St [sb]
		allStops.put("211", "676"); // W Main St & 20th Ave [eb]
		allStops.put("3017", "224"); // NW 36th Ave & 124th St [sb]
		allStops.put("1105", "369"); // Evergreen Blvd at Grant House [eb]
		allStops.put("805", "272"); // Main St 3400 Block [sb]
		allStops.put("572", "16"); // Columbia 3100 Block
		allStops.put("3352", "631"); // NE 152nd Ave & 80th St
		allStops.put("2383", "163"); // E Main St 500 Block
		allStops.put("3232", "826"); // NE 162nd Ave & 34th St [sb]
		allStops.put("3234", "585"); // NE 162nd Ave & 23rd St [nb]
		allStops.put("3006", "209"); // NW 139th St & 2nd Ave [eb]
		allStops.put("1233", "463"); // Mill Plain & 92nd Ave [wb]
		allStops.put("3075", "696"); // Main & 40th St [sb]
		allStops.put("611", "99"); // E 33rd St & O St [wb]
		allStops.put("4174", "711"); // NW 99th St & 9th Ave [wb]
		allStops.put("635", "912"); // Evergreen Blvd & Broadway
		allStops.put("329", "898"); // NE 138th Ave & 22nd St
		allStops.put("6120", "1054"); // NE 99th St & Highway 99 [eb]
		allStops.put("6064", "1039"); // Grand & 20th Street
		allStops.put("782", "926"); // NE 9th Ave & 101st St
		allStops.put("6003", "954"); // SW 6th & Salmon
		allStops.put("1114", "389"); // Evergreen Blvd & Harney Wy [eb]
		allStops.put("1393", "406"); // Andresen & Mill Plain
		allStops.put("734", "727"); // Main & 45th St [nb]
		allStops.put("1314", "752"); // SE 164th Ave & McGillivray [nb]
		allStops.put("1147", "381"); // Evergreen Blvd & V St [wb]
		allStops.put("1169", "445"); // NE 3rd Ave 1400 Block
		allStops.put("632", "908"); // Broadway & Evergreen Blvd
		allStops.put("1171", "430"); // E St 1700 Block
		allStops.put("110", "877"); // 99th Street TC
		allStops.put("4147", "702"); // Hazel Dell Ave & 60th St
		allStops.put("3285", "603"); // Kauffman & Fourth Plain [sb]
		allStops.put("4152", "922"); // Hazel Dell Ave & 94th St [nb]
		allStops.put("1023", "288"); // St James & 52nd St
		allStops.put("1067", "316"); // NE 28th St & 103rd Ave [wb]
		allStops.put("2974", "231"); // NW 119th St & 31st Ave
		allStops.put("1145", "735"); // Evergreen Blvd & Grand [wb]
		allStops.put("326", "896"); // NE 138th Ave & 18th St [nb]
		allStops.put("2241", "319"); // Burton & 83rd Ave
		allStops.put("101", "722"); // Parkrose/Sumner Transit Center
		allStops.put("685", "725"); // Caples at Post Office [nb]
		allStops.put("303", "889"); // NE 136th Ave 200 Block  [sb]
		allStops.put("3071", "872"); // SW 20th Ave & 6th St [nb]
		allStops.put("2990", "693"); // NE 99th St & 50th Ave [eb]
		allStops.put("300", "897"); // NE 138th Ave & 22nd St
		allStops.put("2082", "766"); // St James & Cherry Rd
		allStops.put("2973", "216"); // Hathaway & 19th Ave
		allStops.put("2977", "233"); // NW 21st Ave & 113th St
		allStops.put("1384", "764"); // W 6th St & Washington
		allStops.put("537", "18"); // Columbia & 29th St [nb]
		allStops.put("6002", "955"); // SW 6th & Columbia
		allStops.put("1311", "751"); // Mill Plain & Olympia Dr
		allStops.put("4121", "871"); // Covington Rd & 102nd Ave [sb]
		allStops.put("6060", "1037"); // Fourth Plain & Daniels
		allStops.put("2137", "495"); // Mill Plain & 160th Ave
		allStops.put("3348", "628"); // NE 99th St & 149th Ave
		allStops.put("1397", "967"); // SE 164th Ave & 5th St
		allStops.put("6163", "1124"); // General Anderson [eb]
		allStops.put("2312", "643"); // NE 3rd Ave 2100 Block
		allStops.put("3741", "851"); // Yacolt Rd & Railroad Ave
		allStops.put("6091", "1067"); // SE 192nd Avenue & 31st Street [nb]
		allStops.put("2138", "496"); // Mill Plain & 155th Ave
		allStops.put("1257", "476"); // Mill Plain & Ft Vancouver Wy [wb]
		allStops.put("3172", "789"); // NE Multnomah & 3rd [eb]
		allStops.put("934", "185"); // NE 112th Ave & 46th St [nb]
		allStops.put("581", "77"); // McLoughlin & F St [eb]
		allStops.put("1231", "464"); // Mill Plain & 97th Ave
		allStops.put("1099", "351"); // NE 76th St & 130th Ave
		allStops.put("133", "1159"); // I-5 & Lombard Fwy Stop SB
		allStops.put("2961", "245"); // NW 99th St & 12th Ave [wb]
		allStops.put("1320", "753"); // Mill Plain & 164th Ave [wb]
		allStops.put("6015", "988"); // NE 139th St & 3rd Ct
		allStops.put("1092", "731"); // Fourth Plain & 140th Ave
		allStops.put("1139", "734"); // Evergreen Blvd 4700 Block [wb]
		allStops.put("6142", "1100"); // 65th Avenue [wb]
		allStops.put("3356", "632"); // Mill Plain & Lieser Rd [eb]
		allStops.put("1215", "462"); // Mill Plain & 92nd Ave [eb]
		allStops.put("2679", "780"); // Van Mall Dr 7500 Block [eb]
		allStops.put("1251", "482"); // Mill Plain & Grand [wb]
		allStops.put("2915", "201"); // NE 162nd Ave & 9th St
		allStops.put("3377", "639"); // NE 3rd Ave & 4th St
		allStops.put("601", "83"); // E 20th St & Grand [wb]
		allStops.put("2861", "134"); // NE 76th St 11100 Block [wb]
		allStops.put("6143", "1101"); // 57th Avenue [wb]
		allStops.put("6039", "1001"); // Rasmussen & Clark Ave
		allStops.put("1031", "657"); // Ft Vancouver Wy & 25th St
		allStops.put("6094", "1070"); // SE 192nd Avenue & Westridge Blvd
		allStops.put("3316", "616"); // NE 28th St & 114th Ave [eb]
		allStops.put("1218", "576"); // Mill Plain & 105th Ave
		allStops.put("1334", "756"); // Hwy 99 & 99th St [sb]
		allStops.put("2093", "306"); // St Johns 8900 Block
		allStops.put("3074", "869"); // Grace Ave & 4th St
		allStops.put("551", "54"); // Lincoln & 53rd St [nb]
		allStops.put("3495", "699"); // Grand & 1st St [sb]
		allStops.put("1030", "656"); // Ft Vancouver Wy & St Johns
		allStops.put("1097", "349"); // NE 76th St & 137th Ave
		allStops.put("2267", "588"); // NE 76th St & 126th Ave
		allStops.put("1119", "401"); // Andresen & MacArthur Blvd [nb]
		allStops.put("599", "80"); // NE 18th St & Norris [wb]
		allStops.put("1242", "453"); // Mill Plain & Morrison Ave
		allStops.put("2159", "491"); // NW 6th Ave 400 Block [eb]
		allStops.put("3238", "583"); // NE 162nd Ave & 23rd St [sb]
		allStops.put("1065", "313"); // NE 28th St & 112th Ave
		allStops.put("2080", "304"); // St Johns 8600 Block
		allStops.put("6145", "1105"); // General Anderson [wb]
		allStops.put("3487", "670"); // NE 152nd Ave & 91st St
		allStops.put("2942", "172"); // Andresen & Van Mall Dr [nb]
		allStops.put("6013", "986"); // Jantzen Beach Main Stop
		allStops.put("2279", "774"); // Fourth Plain 14000 Block
		allStops.put("1151", "342"); // Evergreen Blvd 800 Block
		allStops.put("736", "516"); // Hazel Dell Ave & Hazel Dell Wy
		allStops.put("3376", "638"); // NE 3rd Ave & Weir
		allStops.put("3105", "206"); // NE 39th St & 145th Ave
		allStops.put("102", "815"); // Evergreen Park & Ride
		allStops.put("2345", "434"); // Addy St 3900 Block
		allStops.put("3029", "590"); // NE 78th St & Andresen
		allStops.put("576", "12"); // Columbia & 20th St [sb]
		allStops.put("2270", "367"); // NE 76th St & 120th Ave
		allStops.put("2007", "58"); // Lincolin & 57th St [sb]
		allStops.put("2013", "108"); // Broadway & 19th St [sb]
		allStops.put("979", "277"); // St Johns & 41st St
		allStops.put("6156", "1116"); // Broadway & 15th Street [nb]
		allStops.put("2053", "404"); // Andresen & Mill Plain [sb]
		allStops.put("1219", "743"); // Mill Plain & Chkalov Dr
		allStops.put("6043", "1004"); // Mill Plain & 172nd Ave [wb]
		allStops.put("2277", "721"); // Fourth Plain & 135th Ave
		allStops.put("939", "188"); // NE 112th Ave & 34th Cir
		allStops.put("3033", "591"); // NE 78th St & 66th Ave
		allStops.put("613", "103"); // E 33rd St & H St [wb]
		allStops.put("645", "85"); // Grand & 26th St
		allStops.put("6092", "1068"); // SE 192nd Avenue & 20th Street [nb]
		allStops.put("908", "873"); // Covington Rd & 76th St [nb]
		allStops.put("3058", "841"); // NE 18th St & 65th Ave [eb]
		allStops.put("553", "60"); // Lincoln & 59th St [nb]
		allStops.put("4109", "665"); // Fourth Plain & 137th Ave [wb]
		allStops.put("607", "92"); // E 33rd St & W St [wb]
		allStops.put("1310", "750"); // SE 164th Ave 900 Block
		allStops.put("609", "96"); // E 33rd St & S St [wb]
		allStops.put("552", "56"); // Lincoln 5500 Block
		allStops.put("3380", "642"); // NE 3rd Ave & 1st Ave [wb]
		allStops.put("236", "679"); // E 33rd St & Main
		allStops.put("932", "187"); // NE 112th Ave & 39th St [sb]
		allStops.put("768", "931"); // Hwy 99 & 129th St [sb]
		allStops.put("1138", "396"); // Andresen & Evergreen Blvd [sb]
		allStops.put("2689", "170"); // Van Mall Dr & 72nd Ave
		allStops.put("1142", "388"); // Evergreen Blvd & Harney Wy [wb]
		allStops.put("660", "65"); // McLoughlin & Z St [wb]
		allStops.put("6159", "1119"); // Gaiser Hall [nb]
		allStops.put("1256", "746"); // Mill Plain & Reserve [wb]
		allStops.put("4110", "666"); // Fourth Plain & 131st Ave [wb]
		allStops.put("3031", "258"); // NE 78th St & Hwy 99
		allStops.put("733", "705"); // Main & 40th St [nb]
		allStops.put("2350", "438"); // Main St 3000 Block
		allStops.put("3230", "579"); // NE 39th St & Rancho Dr
		allStops.put("6079", "1029"); // SE 192nd Ave & Mill Plain
		allStops.put("4183", "719"); // Lincoln & 53rd St [sb]
		allStops.put("6162", "1123"); // Todd Road [eb]
		allStops.put("3035", "562"); // NE 99th St & 39th Ave [eb]
		allStops.put("612", "102"); // E 33rd St & L St [wb]
		allStops.put("1144", "385"); // Evergreen Blvd & Grove St
		allStops.put("752", "566"); // NW 99th St & 8th Ave
		allStops.put("217", "418"); // Andresen & Fourth Plain [nb]
		allStops.put("744", "671"); // NW 9th Ave & 78th St
		allStops.put("2395", "155"); // NE 117th Ave & 149th St [sb]
		allStops.put("827", "157"); // W Main St 800 Block [eb]
		allStops.put("4149", "704"); // Hazel Dell Ave 4900 Block [nb]
		allStops.put("2919", "863"); // Mill Plain & 172nd Ave [eb]
		allStops.put("1080", "336"); // NE 18th St 4000 Block
		allStops.put("2348", "437"); // Addy St 3300 Block [wb]
		allStops.put("550", "44"); // Lincoln & 51st St [nb]
		allStops.put("1245", "451"); // Mill Plain 6500 Block
		allStops.put("905", "728"); // Covington Rd & 73rd St
		allStops.put("6155", "1115"); // Broadway & 13th Street [nb]
		allStops.put("879", "131"); // NE 76th St & 103rd Ave [eb]
		allStops.put("2732", "547"); // NE 78th St & 58th Ave
		allStops.put("2058", "376"); // Evergreen Blvd & Reserve St [wb]
		allStops.put("1350", "762"); // Hwy 99 & 82nd St
		allStops.put("903", "138"); // NE 76th St & 97th Ave [wb]
		allStops.put("6011", "983"); // W Main St & 15th Ave [wb]
		allStops.put("2237", "324"); // NE 28th St & 138th Ave
		allStops.put("1083", "356"); // Fourth Plain 10700 Block [eb]
		allStops.put("617", "105"); // Main St & 30th St
		allStops.put("558", "29"); // Bernie Dr 6400 Block
		allStops.put("3383", "971"); // NE 3rd Ave & Wedgewood Ct
		allStops.put("643", "87"); // Grand & 32nd St [sb]
		allStops.put("3361", "633"); // Mill Plain & Lieser Rd [wb]
		allStops.put("1028", "654"); // St Johns & 32nd St [sb]
		allStops.put("1217", "467"); // Mill Plain & 102nd Ave [eb]
		allStops.put("6041", "1003"); // Parkway Ave & 3rd St
		allStops.put("2846", "51"); // Lincoln & 41st St [sb]
		allStops.put("3351", "630"); // NE 152nd Ave & 86th St
		allStops.put("1306", "747"); // NE 136th Ave & Mill Plain
		allStops.put("6160", "1121"); // Fourth Plain & Ft. Vancouver Way [eb]
		allStops.put("638", "914"); // W 8th Street & Main [eb]
		allStops.put("3131", "786"); // Andresen & Louisiana [nb]
		allStops.put("977", "651"); // St Johns & 32nd St [nb]
		allStops.put("2065", "386"); // Evergreen Blvd & Cedar St
		allStops.put("4181", "718"); // Bliss Rd & 26th Ave
		allStops.put("6144", "1104"); // Stapleton Road [wb]
		allStops.put("3242", "595"); // Bernie Dr & Fruit Valley Rd
		allStops.put("125", "1143"); // SR-14 Fwy Stop EB #3 E End
		allStops.put("2336", "511"); // Evergreen Wy 3100 Block
		allStops.put("2316", "776"); // NE 3rd Ave 1800 Block
		allStops.put("2141", "691"); // Mill Plain & 136th Ave [wb]
		allStops.put("2116", "767"); // Mill Plain & Devine [wb]
		allStops.put("1352", "256"); // Hwy 99 at Fred Meyer
		allStops.put("2319", "420"); // NE 3rd Ave 2700 Block
		allStops.put("6066", "1025"); // Columbia House Blvd at Park & Ride
		allStops.put("2932", "965"); // Mill Plain & 188th Ave
		allStops.put("964", "504"); // NW 6th Ave & Norwood
		allStops.put("2055", "398"); // Andresen at St Joseph Church
		allStops.put("3251", "807"); // NE 78th St 4200 Block
		allStops.put("2966", "237"); // NW 21st Ave & 108th St
		allStops.put("1278", "484"); // McGillivray & Park Crest Ave [eb]
		allStops.put("6093", "1069"); // SE 192nd Avenue & 15th Street [nb]
		allStops.put("559", "26"); // Bernie Dr & Lincoln
		allStops.put("2273", "353"); // Fourth Plain & 102nd Ave
		allStops.put("2688", "169"); // Van Mall Dr 7500 Block [wb]
		allStops.put("2278", "773"); // Fourth Plain & 103rd Ave
		allStops.put("664", "70"); // McLoughlin & Ft Vancouver Wy [wb]
		allStops.put("2687", "167"); // Van Mall Dr & Thurston Wy
		allStops.put("2998", "229"); // NW 36th Ave & 122nd St
		allStops.put("2930", "31"); // Bernie Dr & Lupin St
		allStops.put("849", "149"); // NE 117th Ave & 99th St [sb]
		allStops.put("1150", "370"); // Evergreen Blvd at Grant House [wb]
		allStops.put("5008", "961"); // SW 5th & Harrison
		allStops.put("227", "338"); // McLoughlin at Clark College [eb]
		allStops.put("1200", "739"); // Mill Plain & Devine [eb]
		allStops.put("3003", "214"); // Hathaway Rd 1800 Block
		allStops.put("4145", "932"); // Hwy 99 & 129th St [nb]
		allStops.put("3037", "226"); // NW 36th Ave & 122nd St
		allStops.put("1316", "836"); // SE 164th Ave 3200 Block
		allStops.put("6049", "1009"); // Scotton Way & 13th St [wb]
		allStops.put("4108", "664"); // Ward Rd & Fourth Plain
		allStops.put("6059", "1036"); // Fourth Plain & Harney
		allStops.put("2218", "531"); // Hwy 99 11300 Block
		allStops.put("534", "11"); // Columbia & 20 St [nb]
		allStops.put("128", "1149"); // I-5 & Lombard Fwy Stop NB
		allStops.put("1137", "400"); // Andresen & Missouri Dr
		allStops.put("2981", "241"); // NW 21st Ave & 99th St
		allStops.put("3237", "582"); // NE 162nd Ave & 28th St [sb]
		allStops.put("1013", "305"); // St Johns 8600 Block
		allStops.put("1227", "470"); // Mill Plain & 120th Ave
		allStops.put("325", "895"); // NE 138th Ave & 18th St [sb]
		allStops.put("789", "255"); // NW 9th Ave & 79th St
		allStops.put("2179", "183"); // NE 112th Ave & 49th St
		allStops.put("3106", "207"); // NE 39th St & 141st Ave
		allStops.put("4151", "935"); // Hwy 99 & 122nd St [nb]
		allStops.put("2353", "449"); // Main & 22nd St
		allStops.put("2845", "50"); // Lincoln & 43rd St [sb]
		allStops.put("1046", "578"); // NE 25th & Andresen
		allStops.put("6062", "1038"); // Grand Blvd & 20th St
		allStops.put("3373", "635"); // E St 1100 Block
		allStops.put("794", "519"); // Hazel Dell Ave 7200 Block
		allStops.put("3206", "574"); // NE 78th St 1700 Block
		allStops.put("1189", "475"); // Mill Plain & Ft Vancouver Wy [eb]
		allStops.put("3026", "784"); // Hazel Dell Ave & 84th St
		allStops.put("2091", "901"); // St Johns & 93rd St
		allStops.put("1018", "293"); // St Johns & 68th St
		allStops.put("665", "74"); // McLoughlin at Marshall Center
		allStops.put("1082", "354"); // Fourth Plain 10400 Block
		allStops.put("6174", "1135"); // NE Ward Rd. & NE 162nd Ave.
		allStops.put("3276", "600"); // Grand 700 Block
		allStops.put("652", "62"); // E 18th St & Brandt [eb]
		allStops.put("6061", "1021"); // Fourth Plain & Washington St [eb]
		allStops.put("1214", "460"); // Mill Plain & 89th Ave
		allStops.put("6157", "1117"); // Marshall/Luepke Center [eb]
		allStops.put("682", "121"); // Fourth Plain & Norris [eb]
		allStops.put("2736", "555"); // NE 78th St & 19th Ct
		allStops.put("728", "128"); // Fourth Plain & F St [wb]
		allStops.put("6153", "1114"); // Washington & 12th Street [sb]
		allStops.put("5001", "940"); // SW 5th & Alder
		allStops.put("3005", "587"); // NW 139th St & 10th Ct
		allStops.put("3317", "618"); // NE 28th St & 119th Ave [eb]
		allStops.put("6058", "1035"); // Fourth Plain & Esther
		allStops.put("127", "1147"); // SR-14 Fwy Stop WB #2 W End
		allStops.put("2988", "558"); // NE 78th St & 13th Ave
		allStops.put("554", "27"); // Lincoln & Bernie Dr
		allStops.put("1230", "466"); // Mill Plain 9900 Block
		allStops.put("1346", "760"); // Hwy 99 7900 Block
		allStops.put("3274", "598"); // Grand 300 Block [nb]
		allStops.put("3344", "625"); // NE 99th St & 126th Ave
		allStops.put("1135", "408"); // Andresen & Kansas St
		allStops.put("3702", "855"); // NE 139th St at Legacy Hospital
		allStops.put("2991", "556"); // NE 78th St & 16th Ave
		allStops.put("3494", "698"); // NE 39th St & 149th Ave
		allStops.put("1336", "541"); // Hwy 99 8500 Block
		allStops.put("1064", "311"); // NE 28th St at Cascadia Technical Academy
		allStops.put("3347", "668"); // NE 99th St & 144th Ct
		allStops.put("815", "142"); // NE 117th Ave & 100th St [nb]
		allStops.put("2054", "399"); // Andresen & Louisiana Dr [sb]
		allStops.put("936", "181"); // NE 112th Ave & 51st St [sb]
		allStops.put("3379", "641"); // NE 3rd Ave 2700 Block
		allStops.put("4162", "709"); // St Johns & 68th St [nb]
		allStops.put("3306", "612"); // Grand & 6th St [sb]
		allStops.put("1199", "738"); // Mill Plain & Ogden [eb]
		allStops.put("6046", "1091"); // E 15th St & Broadway [wb]
		allStops.put("6110", "1085"); // NE 162nd Ave & Fourth Plain
		allStops.put("505", "10"); // Kauffman & 23rd St
		allStops.put("3239", "589"); // NE 162nd Ave & 18th St [sb]
		allStops.put("986", "284"); // St Johns & Minnehaha
		allStops.put("6019", "992"); // SW Campus Dr & Terwilliger
		allStops.put("3179", "793"); // NE Multnomah & 9th
		allStops.put("2737", "557"); // NE 78th St 1600 Block
		allStops.put("2993", "554"); // NE 78th St & 26th Ave
		allStops.put("3192", "802"); // SW Sam Jackson Pk & OHSU
		allStops.put("963", "507"); // NW 6th Ave & Ivy [wb]
		allStops.put("6119", "1053"); // NE 99th St & Hwy 99 [wb]
		allStops.put("3202", "568"); // E 33rd St & I St
		allStops.put("2886", "196"); // NE 162nd Ave & 15th St
		allStops.put("105", "177"); // Salmon Creek P&R
		allStops.put("749", "251"); // NW 9th Ave & 94th St [nb]
		allStops.put("126", "1145"); // SR-14 Fwy Stop WB #1 E End
		allStops.put("3194", "917"); // SW Sam Jackson Pk & Campus Dr
		allStops.put("2045", "468"); // Mill Plain & 102nd Ave [wb]
		allStops.put("796", "518"); // Hazel Dell Ave & 68th St [sb]
		allStops.put("1244", "744"); // Mill Plain & Andresen [wb]
		allStops.put("2334", "432"); // E St & 24th  St
		allStops.put("6090", "1066"); // SE 34th Street & 189th Avenue [eb]
		allStops.put("6021", "1012"); // Mill Plain & 18000 Block [wb]
		allStops.put("2933", "966"); // Mill Plain & 177th Ave
		allStops.put("780", "928"); // NE 7th Ave & 101st St
		allStops.put("318", "921"); // NE 136th Ave & 9th St [nb]
		allStops.put("6022", "994"); // NE 39th St & 152nd Ave [wb]
		allStops.put("2673", "343"); // Evergreen Blvd 400 Block [wb]
		allStops.put("597", "61"); // NE 18th St & Brandt [wb]
		allStops.put("2318", "448"); // NE 3rd Ave & 3rd Loop
		allStops.put("2909", "199"); // SE 164th Ave at Fred Meyer [nb]
		allStops.put("1197", "457"); // Mill Plain & Manzanita Wy [eb]
		allStops.put("1100", "732"); // Fourth Plain & 112th Ave [wb]
		allStops.put("3284", "602"); // Kauffman & 29th St [sb]
		allStops.put("689", "113"); // Stapleton Rd 2800 Block
		allStops.put("6140", "1098"); // 78th Avenue [wb]
		allStops.put("2838", "42"); // NW 78th St & 10th Ave [wb]
		allStops.put("317", "892"); // NE 136th Ave & 4th St [nb]
		allStops.put("799", "514"); // Hazel Dell Ave 5200 block [sb]
		allStops.put("831", "164"); // W Main & SE Clark Ave [eb]
		allStops.put("2411", "829"); // NW 119th St & 31st Ave
		allStops.put("1040", "330"); // E 18th St & Devine
		allStops.put("2212", "535"); // Hwy 99 & 99th St [nb]
		allStops.put("2978", "234"); // NW 21st Ave & 111th St
		allStops.put("6056", "1034"); // Kauffman & 36th Street [nb]
		allStops.put("835", "161"); // W Main & 3rd Ave [wb]
		allStops.put("6016", "989"); // SW Campus Dr & Loading Dock 5
		allStops.put("729", "276"); // Main & 30th St [nb]
		allStops.put("330", "899"); // NE 138th Ave & 28th St
		allStops.put("2964", "240"); // NW 21st Ave & 101st St
		allStops.put("6131", "1083"); // SE 136th Ave & 7th St
		allStops.put("1354", "262"); // Hwy 99 6600 Block [sb]
		allStops.put("6081", "1057"); // SE 192nd Ave & 20th St [sb]
		allStops.put("1074", "828"); // Burton 7700 Block [wb]
		allStops.put("1353", "259"); // Hwy 99 & 72nd St
		allStops.put("1356", "267"); // Hwy 99 & Ross St [sb]
		allStops.put("1318", "198"); // SE 164th Ave & 32nd St
		allStops.put("6067", "1048"); // Evergreen Blvd & Daniels
		allStops.put("3374", "636"); // E St & 9th St
		allStops.put("6084", "1060"); // SE 34th St & Hiddenbrook [wb]
		allStops.put("3119", "785"); // NE 112th Ave & 44th St
		allStops.put("6146", "1106"); // Todd Road [wb]
		allStops.put("968", "490"); // NW 6th Ave & Ivy [eb]
		allStops.put("6177", "1138"); // NE 114th Ave. & Fourth Plain [nb]
		allStops.put("2268", "366"); // NE 76th St & 124th Ave
		allStops.put("321", "819"); // Fourth Plain & St Johns [eb]
		allStops.put("793", "523"); // Hazel Dell Ave 7400 Block
		allStops.put("904", "180"); // Covington Rd & 76th St [sb]
		allStops.put("2672", "20"); // Columbia & Fourth Plain
		allStops.put("536", "21"); // Columbia & 27th St [nb]
		allStops.put("2847", "53"); // W 39th St & Kauffman [eb]
		allStops.put("2948", "175"); // Andresen & 63rd St [sb]
		allStops.put("2125", "506"); // NW 6th Ave 400 Block [wb]
		allStops.put("3378", "640"); // NE 3rd Ave & Sheperd Rd [wb]
		allStops.put("3034", "904"); // NE 99th St & 39th Ave [wb]
		allStops.put("5006", "947"); // SW 5th & Columbia
		allStops.put("3312", "924"); // NE 9th Ave & 105th St
		allStops.put("6055", "1033"); // Kauffman & 36th St [sb]
		allStops.put("6125", "1077"); // SE 136th Ave & 1200 Block [sb]
		allStops.put("6132", "1071"); // Columbia & 6th Street
		allStops.put("6147", "1107"); // Grand Boulevard [wb]
		allStops.put("1344", "533"); // Hwy 99 & 107th St
		allStops.put("6088", "1064"); // SE 34th Street & 176th Avenue
		allStops.put("2148", "498"); // Mill Plain 14900 Block
		allStops.put("6096", "1041"); // NE 117th Ave & 65th St [sb]
		allStops.put("2233", "772"); // NW 99th St 100 Block
		allStops.put("3032", "549"); // NE 78th St & St Johns Rd [eb]
		allStops.put("3051", "593"); // NE 78th St 3300 Block
		allStops.put("1094", "839"); // Fourth Plain 11300 Block
		allStops.put("6128", "1080"); // McGillivray & Blairmont Dr
		allStops.put("3422", "645"); // NE 76th St & 142nd Ave
		allStops.put("610", "97"); // E 33rd St & Q St [wb]
		allStops.put("5005", "946"); // SW 5th & Madison
		allStops.put("6085", "1061"); // SE 34th St & 177th Ave [wb]
		allStops.put("2648", "341"); // Ft Vancouver Wy & Mill Plain [nb]
		allStops.put("3107", "572"); // NE 138th Ave & 28th St
		allStops.put("2382", "159"); // W Main & 5th Ave
		allStops.put("4159", "706"); // W Main 1700 Block
		allStops.put("1015", "299"); // St Johns & 78th St [sb]
		allStops.put("2367", "500"); // Mill Plain & Hearthwood [eb]
		allStops.put("3203", "570"); // NE 137th Ave & 39th St [nb]
		allStops.put("1337", "540"); // Hwy 99 & 88th St
		allStops.put("4182", "813"); // NW 119th St & 35th Ave
		allStops.put("3076", "867"); // Grace & Rasmussen
		allStops.put("3090", "191"); // NE 39th St & 152nd Ave
		allStops.put("1202", "740"); // Mill Plain 6600 Block
		allStops.put("3235", "586"); // NE 162nd Ave & 28th St [nb]
		allStops.put("6130", "1082"); // SE 136th Ave & Block 1200
		allStops.put("836", "158"); // W Main St 600 Block [wb]
		allStops.put("935", "182"); // NE 112th Ave & 51st St [nb]
		allStops.put("1070", "320"); // Burton & 92nd Ave [wb]
		allStops.put("2139", "499"); // Mill Plain & Hearthwood [wb]
		allStops.put("3148", "575"); // Mill Plain & 126th Ave [wb]
		allStops.put("3039", "212"); // NW 139th St 1300 Block
		allStops.put("2225", "263"); // Hwy 99 6300 Block
		allStops.put("6116", "1076"); // Van Mall Loop & West Trailhead
		allStops.put("6164", "1125"); // Stapleton Road [eb]
		allStops.put("4175", "712"); // NW 119th St 2100 Block
		allStops.put("1339", "537"); // Hwy 99 9400 Block
		allStops.put("1173", "433"); // E St 2600 Block
		allStops.put("3221", "569"); // NE 117th Ave & 87th St [nb]
		allStops.put("3283", "809"); // Kauffman 3100 Block
		allStops.put("3171", "787"); // NE Wheeler & Multnomah
		allStops.put("6018", "991"); // SW Campus Dr & Main Dental School
		allStops.put("816", "143"); // NE 117th Ave & 107th St [nb]
		allStops.put("2011", "25"); // Columbia & 23rd St [sb]
		allStops.put("2381", "156"); // W Main St & 12th Ave
		allStops.put("296", "685"); // Hazel Dell Ave & 63rd St
		allStops.put("648", "84"); // E 20th St & Grand [eb]
		allStops.put("2706", "35"); // NW 78th St & Fruit Valley Rd [wb]
		allStops.put("588", "66"); // McLoughlin & Z St [eb]
		allStops.put("3254", "808"); // Hwy 99 & NE 104th St
		allStops.put("2024", "15"); // Washington & 9th St
		allStops.put("3294", "606"); // Kauffman & 25th St [sb]
		allStops.put("633", "910"); // Broadway & 13th St fs [nb]
		allStops.put("1140", "393"); // Evergreen Blvd & 5th St [wb]
		allStops.put("1279", "487"); // McGillivray & Briarwood Dr [eb]
		allStops.put("828", "160"); // W Main St & SW 3rd Ave [eb]
		allStops.put("6063", "1023"); // Grand & McLoughlin [sb]
		allStops.put("2033", "117"); // Fourth Plain & Wintler Dr
		allStops.put("6168", "1129"); // 78th Avenue [eb]
		allStops.put("4179", "716"); // Tenney Rd at Fred Meyer
		allStops.put("3375", "637"); // E St 700 Block
		allStops.put("2130", "200"); // SE 164th Ave 1400 Block
		allStops.put("4143", "675"); // Hazel Dell Ave & 101st St
		allStops.put("1075", "325"); // NE 18th St & Andresen [wb]
		allStops.put("2351", "439"); // Main & 28th St
		allStops.put("1205", "452"); // Mill Plain & Morrison Wy
		allStops.put("6118", "1052"); // LaLonde & St Johns [wb]
		allStops.put("4138", "674"); // Kauffman & 25th St [nb]
		allStops.put("6083", "1059"); // SE 34th St & 189th Ave [wb]
		allStops.put("2927", "40"); // NW 78th St & 10th Ave [eb]
		allStops.put("115", "936"); // I-5 SOUTH && COLUMBIA WAY
		allStops.put("1076", "327"); // NE 18th St & 65th Ave [wb]
		allStops.put("2272", "876"); // NE 102nd Ave & Fourth Plain
		allStops.put("5009", "963"); // SW 5th & Hall
		allStops.put("651", "78"); // E 18th St 3600 Block [eb]
		allStops.put("1315", "509"); // SE 164th Ave & McGillivray [sb]
		allStops.put("6158", "1118"); // Central Campus [nb]
		allStops.put("2703", "527"); // Hazel Dell Ave 8500 Block
		allStops.put("983", "281"); // St Johns & 52nd St
		allStops.put("1090", "365"); // Fourth Plain & 131st Ave [eb]
		allStops.put("543", "825"); // Columbia & 33rd St [sb]
		allStops.put("1117", "392"); // Evergreen Blvd & 5th St [eb]
		allStops.put("6089", "1065"); // SE 34th Street & Hiddenbrook Dr [eb]
		allStops.put("3701", "970"); // NE 139th St & 29th Ave [eb]
		allStops.put("2203", "189"); // NE 112th Ave 3300 Block
		allStops.put("2951", "171"); // Van Mall Dr & 72nd Ave [eb]
		allStops.put("1120", "409"); // Andresen & 18th St [nb]
		allStops.put("1096", "348"); // NE 76th St & 147th Ave
		allStops.put("3193", "804"); // SW Sam Jackson Pk & US Veterans
		allStops.put("1234", "461"); // Mill Plain & 90th Ave
		allStops.put("803", "269"); // Main & 39th St
		allStops.put("4150", "934"); // Hwy 99 & 117th St [nb]
		allStops.put("680", "122"); // Fourth Plain & Z St
		allStops.put("6054", "1016"); // NW 119th Street & 23rd Avenue
		allStops.put("3277", "601"); // Grand & Mill Plain [nb]
		allStops.put("538", "17"); // Columbia & 31st St [nb]
		allStops.put("906", "179"); // Covington Rd & 101st Ave [sb]
		allStops.put("587", "67"); // McLoughlin & W St [eb]
		allStops.put("2070", "720"); // Andresen & Mill Plain [nb]
		allStops.put("1141", "390"); // Evergreen Blvd 4100 Block
		allStops.put("801", "268"); // Main & 45th St [sb]
		allStops.put("6068", "1049"); // Evergreen Blvd & Grant
		allStops.put("3043", "218"); // Seward Rd & Creekside Dr
		allStops.put("3178", "795"); // NE 13th Ave & Holladay
		allStops.put("4148", "703"); // Hazel Dell Ave 5200 Block [nb]
		allStops.put("1102", "357"); // Fourth Plain 10700 Block [wb]
		allStops.put("6170", "1131"); // 86th Avenue [wb]
		allStops.put("6097", "1042"); // NE 117th Ave & 65th Street [nb]
		allStops.put("1085", "729"); // Fourth Plain & 112th Ave [eb]
		allStops.put("679", "123"); // Fourth Plain & Ft Vancouver Wy [eb]
		allStops.put("730", "274"); // Main & 33rd St [nb]
		allStops.put("3233", "584"); // NE 162nd Ave & 18th St [nb]
		allStops.put("1282", "486"); // McGillivray & Briarwood Dr [wb]
		allStops.put("5004", "945"); // SW 5th & Main
		allStops.put("2840", "37"); // NW 78th St & 14th Ave
		allStops.put("3186", "800"); // US Veterans Hospital
		allStops.put("1342", "759"); // Hwy 99 10600 Block
		allStops.put("1087", "360"); // Fourth Plain & 121st Ave [eb]
		allStops.put("3173", "790"); // NE Multnomah & Grand [wb]
		allStops.put("3297", "607"); // Kauffman & 32nd St
		allStops.put("974", "649"); // Ft Vancouver Wy & 25th St
		allStops.put("6167", "1128"); // Andresen Road [eb]
		allStops.put("606", "90"); // E 33rd St & Y St [wb]
		allStops.put("3176", "792"); // Multnomah & 11th
		allStops.put("2944", "176"); // Andresen & 63rd St [nb]
		allStops.put("524", "9"); // Kauffman Ave & 22nd St
		allStops.put("4111", "667"); // Fourth Plain 12300 Block [wb]
		allStops.put("547", "48"); // Lincoln 4500 Block
		allStops.put("649", "82"); // E 18th St & Murton [eb]
		allStops.put("6165", "1126"); // 57th Avenue [eb]
		allStops.put("2967", "235"); // NW 21st Ave & 111th St
		allStops.put("6065", "1027"); // Grand Blvd & 16th St
		allStops.put("724", "124"); // Fourth Plain & Ft Vancouver Wy [wb]
		allStops.put("981", "279"); // St Johns & 45th St
		allStops.put("2638", "777"); // W Main & 29th Ave [wb]
		allStops.put("3236", "581"); // NE 162nd Ave & 34th St [nb]
		allStops.put("2003", "5"); // Kauffman & 17th St [sb]
		allStops.put("659", "64"); // McLoughlin & Grand [wb]
		allStops.put("301", "894"); // NE 136th Ave & 9th St [sb]
		allStops.put("2962", "244"); // NW 99th St & 16th Ave
		allStops.put("2322", "423"); // NE 3rd Ave 3100 Block
		allStops.put("124", "1141"); // SR-14 Fwy Stop EB #2 I-205 Ramp
		allStops.put("2098", "286"); // St James & 59th St
		allStops.put("1134", "412"); // Andresen at WINCO [sb]
		allStops.put("324", "893"); // NE 136th Ave at Firstenburg Center
		allStops.put("560", "59"); // Lincoln & 59th St [sb]
		allStops.put("6173", "1134"); // NE 99th St & 32nd Ave [eb]
		allStops.put("3485", "968"); // SE 164th Ave & 6th St [sb]
		allStops.put("6136", "1017"); // 7th Street at Turtle Place
		allStops.put("2173", "130"); // NE 76th St & 101st Ave
		allStops.put("1355", "265"); // Hwy 99 & 63rd St [sb]
		allStops.put("117", "972"); // I-5 && BURNSIDE
		allStops.put("3185", "798"); // SW US Veterans Rd & Bldg #16
		allStops.put("619", "107"); // Broadway & 25th St
		allStops.put("6129", "1081"); // SE 136th Ave & McGillivray
		allStops.put("2997", "546"); // NE 78th St 5600 Block
		allStops.put("2079", "298"); // St Johns & 43rd Ave [nb]
		allStops.put("1115", "391"); // Evergreen Blvd & Fairview Dr
		allStops.put("731", "270"); // Main & 38th St
		allStops.put("2663", "95"); // E 33rd St & S St [eb]
		allStops.put("901", "137"); // NE 76th St & 101st Ave [wb]
		allStops.put("1340", "757"); // Hwy 99 7400 Block
		allStops.put("2883", "861"); // Fourth Plain & 121st Ave [wb]
		allStops.put("6151", "1112"); // Marshall/Luepke Center [wb]
		allStops.put("2743", "563"); // NE 99th St & 25th Ave
		allStops.put("1091", "730"); // Fourth Plain & 137th Ave [eb]
		allStops.put("1024", "290"); // St James 4600 Block
		allStops.put("2750", "927"); // NE 99th St & 26th Ave
		allStops.put("6052", "1015"); // 12100 N. Pavilion
		allStops.put("3015", "220"); // NW 36th Ave & 131st St
		allStops.put("784", "250"); // NW 9th Ave & 94th St [sb]
		allStops.put("990", "297"); // St Johns & 40th Ave
		allStops.put("316", "890"); // NE 136th Ave 200 Block  [nb]
		allStops.put("740", "521"); // Hazel Dell Ave & 76th St [nb]
		allStops.put("1254", "478"); // Mill Plain & V St [wb]
		allStops.put("1168", "444"); // NE 3rd Ave & Joy St [eb]
		allStops.put("1607", "880"); // VA Medical Center
		allStops.put("3038", "211"); // NW 139th St at Sky View High School
		allStops.put("989", "295"); // St Johns & 37th Ave [nb]
		allStops.put("702", "111"); // Van Mall Dr & 94th Ave [eb]
		allStops.put("1146", "382"); // Evergreen Blvd 2500 Block
		allStops.put("2709", "33"); // Lakeshore Dr & Bernie
		allStops.put("2989", "560"); // NW 9th Ave 8200 Block
		allStops.put("2004", "24"); // Columbia & 23rd St [nb]
		allStops.put("800", "513"); // Hazel Dell Ave 4900 Block
		allStops.put("6135", "1103"); // Thurston Way [sb]
		allStops.put("2943", "174"); // Andresen & 58th St [nb]
		allStops.put("6001", "957"); // SW 6th & Market
		allStops.put("2661", "100"); // E 33rd St & O St [eb]
		allStops.put("2996", "548"); // NE 78th St 4800 Block
		ALL_STOPS = allStops;
	}
}

