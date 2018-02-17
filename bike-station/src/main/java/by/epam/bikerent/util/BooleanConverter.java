package by.epam.bikerent.util;

public class BooleanConverter {

	public static Boolean stringToBoolean(String str) {
		Boolean bool = null;
		if ("Y".equals(str)) {
			bool = Boolean.TRUE;
		} else {
			bool = Boolean.FALSE;
		}
		return bool;
	}
	
	public static String booleanToString(Boolean bool) {
		String str = null;
		if (bool.valueOf(false)) {
			str = "N";
		} else {
			str = "Y";
		}
		return str;
	}

}
