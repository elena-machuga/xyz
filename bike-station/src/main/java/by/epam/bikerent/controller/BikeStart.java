package by.epam.bikerent.controller;

import static by.epam.bikerent.command.ActionFactory.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.bikerent.command.BaseCommand;

public class BikeStart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BikeStart() {
    	super();
    	System.out.println("Servlet constructor");
    }

	public void init(ServletConfig config) throws ServletException {
		super.init();
		System.out.println("Servlet init");
	}
	
	public void destroy() {
		super.destroy();
		System.out.println("Servlet destroyed");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
		System.out.println("Servlet service");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BaseCommand command = defineCommand(request);
		String path = command.execute(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BaseCommand command = defineCommand(request);
		String path = command.execute(request, response);
		
		response.sendRedirect(path);
	}

}
