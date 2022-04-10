package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.worker.*;

/**
 *
 * Команда вывода коллекции по возрастанию ключа.
 */
@CommandAnnotation(description = "Вывод коллекции по возрастанию", needWorker = false, needId = false, needPath = false)
public class PrintAscending extends Command {

	public boolean execute() {
		WorkerCollection.show();
		return true;
	}
}
