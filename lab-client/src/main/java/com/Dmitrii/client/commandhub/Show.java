package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.worker.Worker;
import com.Dmitrii.client.worker.WorkerCollection;
import java.util.TreeMap;

@CommandAnnotation(
		description = "Вывести всех рабов",
		needWorker = false,
		needId = false,
		amountArgs = 0)
public class Show extends Command {

	public boolean execute() {
		WorkerCollection.show();
		return true;
	}
}
