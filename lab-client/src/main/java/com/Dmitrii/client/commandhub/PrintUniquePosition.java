package com.Dmitrii.client.commandhub;

import java.util.TreeMap;
import com.Dmitrii.client.worker.*;

/**
 *
 * Команда вывода уникальных должностей рабов.
 */
@CommandAnnotation(
		description = "Вывод уникальных позиций",
		needWorker = false,
		needId = false,
		needPath = false)
public class PrintUniquePosition extends Command {

	public boolean execute() {
		WorkerCollection.printUniquePosition(); 
		return true;
	}
}
