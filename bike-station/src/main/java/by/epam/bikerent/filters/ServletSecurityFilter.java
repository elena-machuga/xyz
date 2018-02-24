package by.epam.bikerent.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.bikerent.command.PagePath;
import by.epam.bikerent.domain.Role;

//@WebFilter(urlPatterns = {"/bikes"}, servletNames = {"BikeStart"})
public class ServletSecurityFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Role type = (Role) session.getAttribute("role");
		if (type == null) {
			type = Role.GUEST;
			session.setAttribute("role", type);
			RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.PAGE_GUEST);
			dispatcher.forward(req, resp);
			return;
		}
		chain.doFilter(request, response);

	}

	public void destroy() {
	}
}
