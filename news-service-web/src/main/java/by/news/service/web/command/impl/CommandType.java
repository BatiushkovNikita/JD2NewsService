package by.news.service.web.command.impl;

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
	};

	public abstract Command getCommand();
}
