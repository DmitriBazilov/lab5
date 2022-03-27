package com.Dmitrii.client.commandhub;

import java.util.TreeMap;
import com.Dmitrii.client.worker.Worker;
import com.Dmitrii.client.worker.WorkerCollection;
import java.util.Collection;

@CommandAnnotation(description = "Вывод самого успешного раба", needWorker = false, needId = false, amountArgs = 0)
public class MaxBySalary extends Command {

	public boolean execute() {
		WorkerCollection.maxBySalary();
		return true;
	}
}
