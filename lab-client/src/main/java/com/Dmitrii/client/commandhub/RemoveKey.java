package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.worker.*;

@CommandAnnotation(
		description = "Убрать раба по ключу",
		needWorker = false,
		needId = true,
		amountArgs = 0)
public class RemoveKey extends Command {

	private Integer key;

	public RemoveKey() {
	}

	public RemoveKey(Integer key) {
		this.key = key;
	}

	public boolean execute() {
		WorkerCollection.removeId(key);
		return true;
	}
}
