package by.epam.bikerent.service.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Hash {
	
	public static String hash(String s) {
		String result = DigestUtils.md5Hex(s);
		return result;
	}

}
