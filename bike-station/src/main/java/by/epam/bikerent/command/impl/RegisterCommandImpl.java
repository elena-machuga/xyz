package by.epam.bikerent.command.impl;

import static by.epam.bikerent.service.util.RequestParameter.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.bikerent.command.BaseCommand;
import by.epam.bikerent.command.PagePath;
import by.epam.bikerent.service.RegisterUserService;
import by.epam.bikerent.service.impl.RegisterUserServiceImpl;

public class RegisterCommandImpl implements BaseCommand {

	private RegisterUserService service = new RegisterUserServiceImpl();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String userLogin = request.getParameter(REQUEST_LOGIN);
		String userPassword = request.getParameter(REQUEST_PASSWORD);
		String userRePassword = request.getParameter(REQUEST_REPASSWORD);
		String userName = request.getParameter(REQUEST_USERNAME);
		String userAddress = request.getParameter(REQUEST_ADDRESS);
		String userPhone = request.getParameter(REQUEST_PHONE);

		int result = service.registerUser(userName, userAddress, userPhone, userLogin, userPassword, userRePassword);

		if (result == 1) {			
			return "bikes?action=go_to_registered_page";			
		} else {
			return PagePath.PAGE_ERROR;
		}
	}

}
