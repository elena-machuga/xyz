package by.epam.bikerent.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.bikerent.command.BaseCommand;
import by.epam.bikerent.command.PagePath;

public class ChangeLanguageCommandImpl implements BaseCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String language = request.getParameter("lang");
		HttpSession session = request.getSession(false);
		if(session == null) {
			session = request.getSession();
		}
		session.setAttribute("locale", language);
//		return "bikes?action=go_to_guest_welcome_page";
		return PagePath.PAGE_INDEX;
	}

}
