package com.Dmitrii.client.commandhub;

@CommandAnnotation(description = "LIV IZ PROGI", needWorker = false, needId = false, amountArgs = 0)
public class Exit extends Command {

	public boolean execute() {
		System.exit(0);
		return true;
	}
}
