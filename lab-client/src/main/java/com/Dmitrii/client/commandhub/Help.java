package com.Dmitrii.client.commandhub;

@CommandAnnotation(description = "Список команд", needWorker = false, needId = false, amountArgs = 0)
public class Help extends Command {

	public boolean execute() {
		System.out.println(); //Написать справку
		return true;
	}
}
