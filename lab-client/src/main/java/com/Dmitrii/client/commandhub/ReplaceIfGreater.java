package com.Dmitrii.client.commandhub;

import java.util.TreeMap;
import com.Dmitrii.client.worker.*;

/**
 *
 * Команда, которая заменяет раба если он больше.
 */
@CommandAnnotation(
		description = "заменить раба, если новый раб круче старого",
		needWorker = true,
		needId = true,
		needPath = false)
public class ReplaceIfGreater extends Command {

	private Integer id;
	private Worker worker;

	public ReplaceIfGreater() {
	}

	public ReplaceIfGreater(Integer id, Worker worker) {
		this.id = id;
		this.worker = worker;
	}

	public boolean execute() {
		worker.setId(id);
		WorkerCollection.replaceIfGreater(id, worker);	
		return true;
	}
}
