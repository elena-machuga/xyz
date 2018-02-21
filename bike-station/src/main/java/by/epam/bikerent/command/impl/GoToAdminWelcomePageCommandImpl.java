package by.epam.bikerent.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.bikerent.command.BaseCommand;
import by.epam.bikerent.command.PagePath;
import by.epam.bikerent.domain.Role;
import by.epam.bikerent.domain.User;

public class GoToAdminWelcomePageCommandImpl implements BaseCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(false) == null) {
			return PagePath.PAGE_INDEX;
		} else {
			User user = (User) request.getSession().getAttribute("user");
			if (user != null && Role.ADMIN.equals(user.getRole())) {
				return PagePath.PAGE_ADMIN_MAIN;
			} else {
				return PagePath.PAGE_INDEX;
			}
		}
	}

}
