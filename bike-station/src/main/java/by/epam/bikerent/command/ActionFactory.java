package by.epam.bikerent.command;

import javax.servlet.http.HttpServletRequest;

import by.epam.bikerent.command.impl.DefaultCommandImpl;

public final class ActionFactory {
	
	private static final String ACTION = "action";

	private ActionFactory() {
	}

	public static BaseCommand defineCommand(HttpServletRequest request) {
		BaseCommand command = new DefaultCommandImpl();
		String userAction = request.getParameter(ACTION);
		if (userAction == null || userAction.isEmpty()) {
			return command;
		}
		try {
		userAction = userAction.toUpperCase();
		command = CommandName.valueOf(userAction).getCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", userAction);
		}

		return command;
	}

}
