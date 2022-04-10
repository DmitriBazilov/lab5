package com.Dmitrii.client.commandhub;

/**
 *
 * Команда, выводящая список всех комманд и их описание.
 */
@CommandAnnotation(description = "Список команд", needWorker = false, needId = false, needPath = false)
public class Help extends Command {

	public boolean execute() {
		Commands[] coms = Commands.values();
		for (Commands c : coms) {
			CommandAnnotation comAnn;
			comAnn = (CommandAnnotation) c.getCommandClass().getAnnotation(CommandAnnotation.class);
			System.out.println(c.getCommandName() + " " + comAnn.description());
		}
		return true;
	}
}
