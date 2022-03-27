package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.worker.*;

@CommandAnnotation(description = "Вывод коллекции по возрастанию", needWorker = false, needId = false, amountArgs = 0)
public class PrintAscending extends Command {

	public boolean execute() {
		WorkerCollection.show();
		return true;
	}
}
