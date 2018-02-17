package by.epam.bikerent.service.util;

public final class RequestParameterValidator {

	private RequestParameterValidator() {
	}

	public static void validateUserName(String userName) throws ValidatorException {

		if (userName == null || userName.isEmpty()) {
			throw new ValidatorException("Invalid username");
		}
	}

	public static void validateUserPassword(String userPassword) throws ValidatorException {

		if (userPassword == null || userPassword.isEmpty()) {
			throw new ValidatorException("Invalid user password");
		}
	}
}
