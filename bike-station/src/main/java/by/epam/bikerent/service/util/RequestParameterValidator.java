package by.epam.bikerent.service.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RequestParameterValidator {

	private final static String EMAIL_REGEX = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
	private final static String PASSWORD_REGEX = "[a-zA-Z0-9-_]+";
	private final static String NAME_REGEX = "[a-zA-Z-\\s']+";
	private final static String ADDRESS_REGEX = "[a-zA-Z0-9-\\s'.,]+";
	private final static String PHONE_REGEX = "[0-9] {12}";

	private RequestParameterValidator() {
	}

	public static void validateUserLogin(String userLogin) throws ValidatorException {

		if (userLogin == null || userLogin.isEmpty() || !matcher(EMAIL_REGEX, userLogin)) {
			throw new ValidatorException("Invalid login");
		}
	}

	public static void validateUserPassword(String userPassword) throws ValidatorException {

		if (userPassword == null || userPassword.isEmpty() || !matcher(PASSWORD_REGEX, userPassword)) {
			throw new ValidatorException("Invalid user password");
		}
	}
	
	public static void validateUserRePassword(String userRePassword) throws ValidatorException {

		if (userRePassword == null || userRePassword.isEmpty() || !matcher(PASSWORD_REGEX, userRePassword)) {
			throw new ValidatorException("Invalid user password retype");
		}
	}

	public static void validateUserName(String userName) throws ValidatorException {

		if (userName == null || userName.isEmpty() || !matcher(NAME_REGEX, userName)) {
			throw new ValidatorException("Invalid user name");
		}
	}

	public static void validateUserAddress(String userAddress) throws ValidatorException {

		if (userAddress == null || userAddress.isEmpty() || !matcher(ADDRESS_REGEX, userAddress)) {
			throw new ValidatorException("Invalid user address");
		}
	}

	public static void validateUserPhone(String userPhone) throws ValidatorException {

		if (userPhone == null || userPhone.isEmpty() || !matcher(ADDRESS_REGEX, userPhone)) {
			throw new ValidatorException("Invalid user address");
		}
	}

	private static boolean matcher(String regex, String text) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher match = pattern.matcher(text);
		boolean result = match.matches();
		return result;
	}
}
