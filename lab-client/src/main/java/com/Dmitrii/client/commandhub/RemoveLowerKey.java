package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.worker.*;

/**
 *
 * Команда, удаляюшая рабов, у который id меньше чем заданный.
 */
@CommandAnnotation(
		description = "Убрать рабов у которых айди меньше заданого",
		needWorker = false,
		needId = true,
		needPath = false)
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
