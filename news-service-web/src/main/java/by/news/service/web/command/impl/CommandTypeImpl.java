package by.news.service.web.command.impl;

import by.news.service.web.command.interf.Command;
import by.news.service.web.command.interf.CommandType;

public enum CommandTypeImpl implements CommandType {
	LOGIN {
		@Override
		public Command getCommand() {
			return new LoginCommand();
		}
		
	};
}
