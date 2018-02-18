package by.epam.bikerent.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.bikerent.command.BaseCommand;
import by.epam.bikerent.command.PagePath;

public class GoToAdminWelcomePageCommandImpl implements BaseCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(false) == null) {
			return PagePath.PAGE_INDEX;
		} else {
			return PagePath.PAGE_ADMIN_MAIN;
		}
	}

}
