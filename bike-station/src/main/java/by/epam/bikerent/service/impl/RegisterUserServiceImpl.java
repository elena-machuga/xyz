package by.epam.bikerent.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.epam.bikerent.dao.UserDAO;
import by.epam.bikerent.domain.User;
import by.epam.bikerent.service.RegisterUserService;

public class RegisterUserServiceImpl implements RegisterUserService {
	
	private UserDAO userDao = new UserDAO();

	@Override
	public int registerUser(String name, String address, String phone, String login, String pass) {
		
		int result = 0;
		List<User> listBeforeInsert = userDao.requestUserList();
		int numOfUsersBefore = listBeforeInsert.size();
		userDao.createUser(name, address, phone, login, pass);
		List<User> listAfterInsert = userDao.requestUserList();
		int numOfUsersAfter = listAfterInsert.size();
		
		if ((numOfUsersAfter-numOfUsersBefore) == 1) {
			result = 1;
		} 
		return result;
	}

}
