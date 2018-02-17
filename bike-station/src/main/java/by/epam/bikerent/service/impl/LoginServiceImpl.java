package by.epam.bikerent.service.impl;

import static by.epam.bikerent.service.util.RequestParameterValidator.validateUserName;
import static by.epam.bikerent.service.util.RequestParameterValidator.validateUserPassword;

import by.epam.bikerent.dao.UserDAO;
import by.epam.bikerent.domain.User;
import by.epam.bikerent.service.LoginService;
import by.epam.bikerent.service.util.ValidatorException;

public class LoginServiceImpl implements LoginService{
	
	private UserDAO userDao = new UserDAO();

	@Override
	public User authorizeUser(String userName, String userPassword) {

		User user = null;
		try {
			validateUserName(userName);
			validateUserPassword(userPassword);
			user = userDao.readUserAuthorization(userName, userPassword);
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		return user;
	}


}
