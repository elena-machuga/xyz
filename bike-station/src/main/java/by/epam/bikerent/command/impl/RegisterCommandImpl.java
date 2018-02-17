package by.epam.bikerent.command.impl;

import static by.epam.bikerent.service.util.RequestParameter.*;
import static by.epam.bikerent.service.util.RequestParameterValidator.validateUserName;
import static by.epam.bikerent.service.util.RequestParameterValidator.validateUserPassword;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.bikerent.command.BaseCommand;
import by.epam.bikerent.command.PagePath;
import by.epam.bikerent.domain.User;
import by.epam.bikerent.service.LoginService;
import by.epam.bikerent.service.RegisterUserService;
import by.epam.bikerent.service.impl.LoginServiceImpl;
import by.epam.bikerent.service.impl.RegisterUserServiceImpl;
import by.epam.bikerent.service.util.ValidatorException;

public class RegisterCommandImpl implements BaseCommand {

	private RegisterUserService service = new RegisterUserServiceImpl();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String userLogin = request.getParameter(REQUEST_REGISTER_LOGIN);
		String userPassword = request.getParameter(REQUEST_REGISTER_PASSWORD);
		String userName = request.getParameter(REQUEST_REGISTER_USERNAME);
		String userAddress = request.getParameter(REQUEST_REGISTER_ADDRESS);
		String userPhone = request.getParameter(REQUEST_REGISTER_PHONE);

		int result = service.registerUser(userName, userAddress, userPhone, userLogin, userPassword);

		if (result == 1) {			
			return "bikes?action=go_to_registered_page";			
		} else {
			return PagePath.PAGE_ERROR;
		}
	}

}
