package by.epam.bikerent.command.impl;

import static by.epam.bikerent.service.util.RequestParameter.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.bikerent.command.BaseCommand;
import by.epam.bikerent.domain.Role;
import by.epam.bikerent.domain.User;
import by.epam.bikerent.service.LoginService;
import by.epam.bikerent.service.impl.LoginServiceImpl;

public class LoginCommandImpl implements BaseCommand {
	
	private static final Logger LOG = LogManager.getLogger(LoginCommandImpl.class.getName());

	private LoginService service = new LoginServiceImpl(); // add IoC

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String userName = request.getParameter(REQUEST_USERNAME);
		String userPassword = request.getParameter(REQUEST_PASSWORD);

		User user = service.authorizeUser(userName, userPassword);
		HttpSession session = request.getSession(true);
		session.setAttribute("user", user);

		if (user == null) {
			LOG.error("User not found: " + userName);
			return "bikes?action=go_to_guest_welcome_page";
		} else if (Role.ADMIN.equals(user.getRole())) {
			return "bikes?action=go_to_admin_welcome_page";
		} else if (Role.USER.equals(user.getRole())) {
			return "bikes?action=go_to_user_welcome_page";
		} else {
			return "bikes?action=go_to_guest_welcome_page";
		}
	}

}

