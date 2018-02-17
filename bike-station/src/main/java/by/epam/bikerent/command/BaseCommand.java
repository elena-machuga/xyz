package by.epam.bikerent.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BaseCommand {

	public String execute(HttpServletRequest request, HttpServletResponse response);
}
