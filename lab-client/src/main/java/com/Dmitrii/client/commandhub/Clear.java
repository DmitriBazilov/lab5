package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.worker.WorkerCollection;

@CommandAnnotation(description = "SOSY", needWorker = false, needId = false, amountArgs = 0)
public class Clear extends Command {

	public boolean execute() {
		WorkerCollection.clear();
		return true;
	}
}
