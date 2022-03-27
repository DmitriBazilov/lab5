package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.worker.WorkerCollection;

@CommandAnnotation(description = "Информация о коллекции", needWorker = false, needId = false, amountArgs = 0)
public class Info extends Command {

	public boolean execute() {
		WorkerCollection.info();
		return true;
	} 
}
