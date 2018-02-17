package by.epam.bikerent.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.bikerent.command.BaseCommand;
import by.epam.bikerent.command.PagePath;

public class LogoutCommandImpl implements BaseCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(false) != null) {
			request.getSession(false).invalidate();
		}
		return PagePath.PAGE_INDEX;
	}

}
