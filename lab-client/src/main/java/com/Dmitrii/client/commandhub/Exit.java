package com.Dmitrii.client.commandhub;

/**
 *
 * Команда, выхода из программы.
 */
@CommandAnnotation(description = "LIV IZ PROGI", needWorker = false, needId = false, needPath = false)
public class Exit extends Command {

	public boolean execute() {
		System.exit(0);
		return true;
	}
}
