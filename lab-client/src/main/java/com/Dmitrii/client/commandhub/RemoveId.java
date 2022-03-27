package com.Dmitrii.client.commandhub;

import java.util.TreeMap;
import com.Dmitrii.client.worker.*;

@CommandAnnotation(
		description = "Убрать раба по айди",
		needWorker = false,
		needId = true,
		amountArgs = 0)
public class RemoveId extends Command {

	private Integer id;

	public RemoveId() {
	}

	public RemoveId(Integer id) {
		this.id = id;
	}

	public boolean execute() {
		WorkerCollection.removeId(id);
		return true;
	}
}
