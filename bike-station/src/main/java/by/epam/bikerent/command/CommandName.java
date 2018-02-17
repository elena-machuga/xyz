package by.epam.bikerent.command;

import by.epam.bikerent.command.impl.ChangeLanguageCommandImpl;
import by.epam.bikerent.command.impl.GoToAdminWelcomePageCommandImpl;
import by.epam.bikerent.command.impl.GoToErrorPageCommandImpl;
import by.epam.bikerent.command.impl.GoToGuestWelcomePageCommandImpl;
import by.epam.bikerent.command.impl.GoToLoginationPageCommandImpl;
import by.epam.bikerent.command.impl.GoToRegisteredPageCommandImpl;
import by.epam.bikerent.command.impl.GoToRegistrationPageCommandImpl;
import by.epam.bikerent.command.impl.GoToUserWelcomePageCommandImpl;
import by.epam.bikerent.command.impl.LoginCommandImpl;
import by.epam.bikerent.command.impl.LogoutCommandImpl;
import by.epam.bikerent.command.impl.RegisterCommandImpl;

public enum CommandName {
	GO_TO_LOGINATION_PAGE{
		{
			this.command = new GoToLoginationPageCommandImpl();
		}
	},
	LOGIN {
		{
			this.command = new LoginCommandImpl();
		}
	},
	GO_TO_REGISTRATION_PAGE{
		{
			this.command = new GoToRegistrationPageCommandImpl();
		}
	},
	REGISTER {
		{
			this.command = new RegisterCommandImpl();
		}
	},
	GO_TO_REGISTERED_PAGE {
		{
			this.command = new GoToRegisteredPageCommandImpl(); 
		}
	},
	GO_TO_USER_WELCOME_PAGE {
		{
			this.command = new GoToUserWelcomePageCommandImpl();
		}
	}, GO_TO_ADMIN_WELCOME_PAGE {
		{
			this.command = new GoToAdminWelcomePageCommandImpl();
		}
	},
	GO_TO_ERROR_PAGE {
		{
			this.command = new GoToErrorPageCommandImpl();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommandImpl();
		}
	},
	CHANGE_LANGUAGE {
		{
			this.command = new ChangeLanguageCommandImpl();
		}
	},
	GO_TO_GUEST_WELCOME_PAGE {
		{
			this.command = new GoToGuestWelcomePageCommandImpl();
		}
	};

	BaseCommand command;

	public BaseCommand getCommand() {
		return command;
	}

}
