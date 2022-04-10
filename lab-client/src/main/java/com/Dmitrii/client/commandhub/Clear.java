package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.worker.WorkerCollection;

/**
 * Класс команды очистки коллекции.
 * 
 */
@CommandAnnotation(description = "Убрать всех рабов", needWorker = false, needId = false, needPath = false)
public class Clear extends Command {

	public boolean execute() {
		WorkerCollection.clear();
		return true;
	}
}
