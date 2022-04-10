package com.Dmitrii.client.commandhub;

import java.util.TreeMap;
import com.Dmitrii.client.worker.*;

/**
 *
 * Команда добавления раба.
 */
@CommandAnnotation(description = "Добавление раба", needWorker = true, needId = false, needPath = false)
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
