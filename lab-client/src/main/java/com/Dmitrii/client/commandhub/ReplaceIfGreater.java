package com.Dmitrii.client.commandhub;

import java.util.TreeMap;
import com.Dmitrii.client.worker.*;

@CommandAnnotation(
		description = "заменить раба, если новый раб круче старого",
		needWorker = true,
		needId = true,
		amountArgs = 3)
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
		WorkerCollection.replaceIfGreater(id, worker);	
		return true;
	}
}
