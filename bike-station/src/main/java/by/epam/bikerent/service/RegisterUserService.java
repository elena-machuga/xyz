package by.epam.bikerent.service;

import by.epam.bikerent.domain.User;

public interface RegisterUserService {
	
	public int registerUser (String name, String address, String phone, String login, String pass, String repassword);

}
