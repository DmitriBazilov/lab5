package com.Dmitrii.client.commandhub;

import java.util.TreeMap;
import com.Dmitrii.client.worker.*;

@CommandAnnotation(description = "Добавление раба", needWorker = true, needId = false, amountArgs = 3)
public class Insert extends Command {

	private Worker worker;

	public Insert() {
	}

	public Insert(Worker w) {
		this.worker = w;
	} 

	public boolean execute() {
		WorkerCollection.add(worker.getId(), worker);
		return true;
	}
}
