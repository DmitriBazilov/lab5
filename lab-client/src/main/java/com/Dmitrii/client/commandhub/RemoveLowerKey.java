package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.worker.*;

@CommandAnnotation(
		description = "Убрать рабов у которых айди меньше заданого",
		needWorker = false,
		needId = true,
		amountArgs = 0)
public class RemoveLowerKey extends Command {

	private Integer key;

	public RemoveLowerKey() {
	}

	public RemoveLowerKey(Integer key) {
		this.key = key;
	}

	public boolean execute() {
		WorkerCollection.removeLowerKey(key);
		return true;
	}
}
