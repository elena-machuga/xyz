package by.epam.bikerent.service.util;

public class Verificator {

	private Verificator() {
	}
	
	public static void verifyPassword(String password, String repassword) throws VerificatorException {
		if(!password.equals(repassword)) {
			throw new VerificatorException();
		}
	}

}
