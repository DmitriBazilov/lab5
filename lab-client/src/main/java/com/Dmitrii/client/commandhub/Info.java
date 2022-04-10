package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.worker.WorkerCollection;

/**
 *
 * Команда, предоставляющая информацию о коллекции.
 */
@CommandAnnotation(description = "Информация о коллекции", needWorker = false, needId = false, needPath = false)
public class Info extends Command {

	public boolean execute() {
		WorkerCollection.info();
		return true;
	} 
}
