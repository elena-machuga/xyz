package by.epam.bikerent.service;

import by.epam.bikerent.domain.User;

public interface LoginService {

	public User authorizeUser(String userName, String userPassword);
	
}
