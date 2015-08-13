package by.news.service.web.command.impl;

import by.news.service.web.command.interf.Command;
import by.news.service.web.command.interf.CommandType;

public class CommandFactory {
	public static Command getCommand(String paramCommand) {
		CommandType commandType = CommandTypeImpl.valueOf(paramCommand.toUpperCase());
		return commandType.getCommand();
	}
}
