package by.epam.bikerent.service.impl;

import static by.epam.bikerent.service.util.RequestParameterValidator.validateUserLogin;
import static by.epam.bikerent.service.util.RequestParameterValidator.validateUserPassword;
import static by.epam.bikerent.service.util.Md5Hash.hash;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.bikerent.dao.UserDAO;
import by.epam.bikerent.domain.User;
import by.epam.bikerent.service.LoginService;
import by.epam.bikerent.service.util.ValidatorException;

public class LoginServiceImpl implements LoginService{
	
	private static final Logger LOG = LogManager.getLogger(LoginServiceImpl.class.getName());
	
	private UserDAO userDao = new UserDAO();

	@Override
	public User authorizeUser(String userName, String userPassword) {

		User user = null;
		try {
			validateUserLogin(userName);
			validateUserPassword(userPassword);
			String hashPassword = hash(userPassword);
			user = userDao.readUserAuthorization(userName, hashPassword);
		} catch (ValidatorException e) {
			LOG.error("Validation error ", e);
		}
		return user;
	}


}
