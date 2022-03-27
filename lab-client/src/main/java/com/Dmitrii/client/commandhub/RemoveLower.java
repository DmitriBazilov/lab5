package com.Dmitrii.client.commandhub;

import java.util.TreeMap;
import com.Dmitrii.client.worker.*;

@CommandAnnotation(
		description = "Убрать рабов которые меньше чем заданый",
		needWorker = true,
		needId = false,
		amountArgs = 3)
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
