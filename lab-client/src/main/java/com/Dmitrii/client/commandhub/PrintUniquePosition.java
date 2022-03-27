package com.Dmitrii.client.commandhub;

import java.util.TreeMap;
import com.Dmitrii.client.worker.*;

@CommandAnnotation(
		description = "Вывод уникальных позиций",
		needWorker = false,
		needId = false,
		amountArgs = 0)
public class PrintUniquePosition extends Command {

	public boolean execute() {
		WorkerCollection.printUniquePosition(); 
		return true;
	}
}
