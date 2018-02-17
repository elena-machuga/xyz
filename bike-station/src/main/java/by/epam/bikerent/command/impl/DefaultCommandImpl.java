package by.epam.bikerent.command.impl;

import static by.epam.bikerent.service.util.RequestParameter.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.bikerent.command.BaseCommand;
import by.epam.bikerent.command.PagePath;

public class DefaultCommandImpl implements BaseCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute(REQUEST_ERROR_MSG, "invalid action");
		return PagePath.PAGE_ERROR;
	}

}
