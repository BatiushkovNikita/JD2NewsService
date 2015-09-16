package by.news.service.web.command.impl;

import by.news.service.web.command.impl.commands.AddNewsCommand;
import by.news.service.web.command.impl.commands.LoginCommand;
import by.news.service.web.command.impl.commands.LogoutCommand;
import by.news.service.web.command.impl.commands.ManageNewsCommand;
import by.news.service.web.command.impl.commands.NewsFeedCommand;
import by.news.service.web.command.impl.commands.ProfileCommand;
import by.news.service.web.command.impl.commands.RegistrationCommand;
import by.news.service.web.command.interf.Command;

public enum CommandType {
	LOGIN {
		@Override
		public Command getCommand() {
			return new LoginCommand();
		}
	},
	REGISTRATION {
		@Override
		public Command getCommand() {
			return new RegistrationCommand();
		}
	},
	NEWS_FEED {
		@Override
		public Command getCommand() {
			return new NewsFeedCommand();
		}
	},
	PROFILE {
		@Override
		public Command getCommand() {
			return new ProfileCommand();
		}
	},
	MANAGE_NEWS {
		@Override
		public Command getCommand() {
			return new ManageNewsCommand();
		}
	},
	ADD_NEWS {
		@Override
		public Command getCommand() {
			return new AddNewsCommand();
		}

	}, LOGOUT {

		@Override
		public Command getCommand() {
			// TODO Auto-generated method stub
			return new LogoutCommand();
		}
		
	};

	public abstract Command getCommand();
}
