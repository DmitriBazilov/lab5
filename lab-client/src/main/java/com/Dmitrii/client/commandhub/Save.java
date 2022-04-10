package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.parserhub.JsonParser;
import com.Dmitrii.client.worker.WorkerCollection;
import java.io.File;
import java.io.IOException;

/**
 *
 * Команда сохранения коллекции.
 */
@CommandAnnotation(
		description = "Сохранить коллекцию",
		needWorker = false,
		needId = false,
		needPath = false)
public class Save extends Command {

	public boolean execute() {
		JsonParser parser = new JsonParser();
		try {
			String path = System.getenv("DATAPATH");
			parser.writeClasses(new File(path), 
				WorkerCollection.getCollection()); // ДОПИСАТЬ ПЕРЕМЕННУЮ ОКРУЖЕНИЯ
		} catch (IOException e) {
			return false;
		}
		return true;
	}
}
