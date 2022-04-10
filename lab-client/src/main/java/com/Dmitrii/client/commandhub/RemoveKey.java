package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.worker.*;

/**
 *
 * Команда, удаления раба по id.
 */
@CommandAnnotation(
		description = "Убрать раба по айди",
		needWorker = false,
		needId = true,
		needPath = false)
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
