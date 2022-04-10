package com.Dmitrii.client.commandhub;

import java.util.TreeMap;
import com.Dmitrii.client.worker.*;

/**
 *
 * Команда, удаляющая всех рабов меньше чем заданный.
 */
@CommandAnnotation(
		description = "Убрать рабов которые меньше чем заданый",
		needWorker = true,
		needId = false,
		needPath = false)
public class RemoveLower extends Command {

	private Worker worker;

	public RemoveLower() {
	}

	public RemoveLower(Worker w) {
		this.worker = w;
	}

	public boolean execute() {
		WorkerCollection.removeLower(worker);
		return true;
	}
}
