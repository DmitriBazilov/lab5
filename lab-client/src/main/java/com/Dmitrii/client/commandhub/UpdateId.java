package com.Dmitrii.client.commandhub;

import java.util.TreeMap;
import com.Dmitrii.client.worker.*;

@CommandAnnotation(
		description = "Заменить раба на нового",
		needWorker = true,
		needId = true,
		amountArgs = 3)
public class UpdateId extends Command {

	private Integer id;
	private Worker worker;

	public UpdateId() {
	}

	public UpdateId(Integer id, Worker worker) {
		this.id = id;
		this.worker = worker;
	}

	public boolean execute() {
		WorkerCollection.update(id, worker);
		return true;
	}
}
