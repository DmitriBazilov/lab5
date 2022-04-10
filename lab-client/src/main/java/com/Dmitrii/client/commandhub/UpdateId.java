package com.Dmitrii.client.commandhub;

import java.util.TreeMap;
import com.Dmitrii.client.worker.*;

/**
 *
 * Команда обновления раба, требуется id.
 */
@CommandAnnotation(
		description = "Заменить раба на нового",
		needWorker = true,
		needId = true,
		needPath = false)
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
		worker.setId(id);
		WorkerCollection.update(id, worker);
		return true;
	}
}
