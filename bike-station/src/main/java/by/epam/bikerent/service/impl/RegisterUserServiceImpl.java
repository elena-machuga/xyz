package by.epam.bikerent.service.impl;

import static by.epam.bikerent.service.util.RequestParameterValidator.*;
import static by.epam.bikerent.service.util.Verificator.*;
import static by.epam.bikerent.service.util.Md5Hash.hash;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.bikerent.dao.UserDAO;
import by.epam.bikerent.dao.exception.UserDaoException;
import by.epam.bikerent.domain.User;
import by.epam.bikerent.service.RegisterUserService;
import by.epam.bikerent.service.util.ValidatorException;
import by.epam.bikerent.service.util.VerificatorException;

public class RegisterUserServiceImpl implements RegisterUserService {

	private static final Logger LOG = LogManager.getLogger(LoginServiceImpl.class.getName());

	private UserDAO userDao = new UserDAO();

	@Override
	public int registerUser(String name, String address, String phone, String login, String pass, String repassword) {
		try {
			validateUserName(name);
			validateUserAddress(address);
			validateUserPhone(phone);
			validateUserLogin(login);
			validateUserPassword(pass);
			validateUserRePassword(repassword);
			verifyPassword(pass, repassword);
		} catch (ValidatorException e1) {
			LOG.error("User data validation failed", e1);
		} catch (VerificatorException e) {
			LOG.error("Pssword and retyped password don't match", e);
		}
		
		String hashPassword = hash(pass);
		int result = 0;
		List<User> listBeforeInsert;
		List<User> listAfterInsert;
		try {
			
			listBeforeInsert = userDao.requestUserList();
			int numOfUsersBefore = listBeforeInsert.size();
			userDao.createUser(name, address, phone, login, hashPassword);
			listAfterInsert = userDao.requestUserList();
			int numOfUsersAfter = listAfterInsert.size();

			if ((numOfUsersAfter - numOfUsersBefore) == 1) {
				result = 1;
			}
		} catch (UserDaoException e) {
			LOG.error("User can't be registered", e);
		}

		return result;
	}

}
