package by.epam.bikerent.command.impl;

import static by.epam.bikerent.service.util.RequestParameter.*;
import static by.epam.bikerent.service.util.RequestParameterValidator.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.bikerent.command.BaseCommand;
import by.epam.bikerent.domain.Role;
import by.epam.bikerent.domain.User;
import by.epam.bikerent.service.LoginService;
import by.epam.bikerent.service.impl.LoginServiceImpl;
import by.epam.bikerent.service.util.ValidatorException;
import by.epam.bikerent.service.util.ValidatorException.*;

public class LoginCommandImpl implements BaseCommand {

	private LoginService service = new LoginServiceImpl(); // add IoC

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String userName = request.getParameter(REQUEST_LOGIN_USERNAME);
		String userPassword = request.getParameter(REQUEST_LOGIN_PASSWORD);

		User user = service.authorizeUser(userName, userPassword);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		if (user == null) {
			return "bikes?action=go_to_error_page";
		} else if (Role.ADMIN.equals(user.getRole())) {
			return "bikes?action=go_to_admin_welcome_page";
		} else if (Role.USER.equals(user.getRole())) {
			return "bikes?action=go_to_user_welcome_page";
		} else {
			return "bikes?action=go_to_guest_welcome_page";
		}

	}

}

