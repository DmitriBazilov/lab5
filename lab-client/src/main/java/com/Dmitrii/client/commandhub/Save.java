package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.parserhub.JsonParser;
import com.Dmitrii.client.worker.WorkerCollection;
import java.util.TreeMap;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@CommandAnnotation(
		description = "Сохранить коллекцию",
		needWorker = false,
		needId = false,
		amountArgs = 0)
public class Save extends Command {

	public boolean execute() {
		JsonParser parser = new JsonParser();
		try {
			parser.writeClasses(new File("/home/dmitrii/Документы/Programming_univer/Lab_5/lab/lab-client/src/main/java/com/Dmitrii/client/data.json"), 
				WorkerCollection.getCollection()); // ДОПИСАТЬ ПЕРЕМЕННУЮ ОКРУЖЕНИЯ
		} catch (IOException e) {
			return false;
		}
		return true;
	}
}
