package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.worker.WorkerCollection;

/**
 *
 * Команда вывода коллекции.
 */
@CommandAnnotation(
		description = "Вывести всех рабов",
		needWorker = false,
		needId = false,
		needPath = false)
public class Show extends Command {

	public boolean execute() {
		WorkerCollection.show();
		return true;
	}
}
