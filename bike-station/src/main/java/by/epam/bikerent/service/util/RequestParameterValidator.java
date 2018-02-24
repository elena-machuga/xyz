package by.epam.bikerent.service.util;

public final class RequestParameterValidator {
	
	private final static String EMAIL_REGEX = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

	private RequestParameterValidator() {
	}

	public static void validateUserLogin(String userName) throws ValidatorException {

		if (userName == null || userName.isEmpty()) {
			throw new ValidatorException("Invalid username");
		} else if(true) {
			
		}
	}

	public static void validateUserPassword(String userPassword) throws ValidatorException {

		if (userPassword == null || userPassword.isEmpty()) {
			throw new ValidatorException("Invalid user password");
		}
	}
	
	
}
