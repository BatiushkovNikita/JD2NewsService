package by.news.service.web.command.impl;

import by.news.service.web.command.interf.Command;

public class CommandFactory {
	public static Command getCommand(String paramCommand) {
		CommandType commandType = CommandType.valueOf(paramCommand.toUpperCase());
		return commandType.getCommand();
	}
}