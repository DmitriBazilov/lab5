package com.Dmitrii.server;

import com.Dmitrii.common.parserhub.*;
import com.Dmitrii.common.worker.*;
import java.io.File;
import java.time.LocalDateTime;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author dmitrii
 */
public class WorkerCollection {
	
	private TreeMap<Coordinates, Worker> collection;
	private LocalDateTime creationDate;
	private Parser parser;

	public WorkerCollection(File file) {
		creationDate = LocalDateTime.now();
		parser = new JsonParser();
		collection.putAll(parser.getClasses(file).stream()
			.collect(Collectors.toMap(Worker::getCoordinates, Function.identity())));
	}
	
	public String getInfo() {
		return String.join(", ", creationDate.toString(), Integer.toString(collection.size()));
	}
	
	public void insert(Worker worker) {
		collection.put(worker.getCoordinates(), worker);
	}
	
	public void removeKey(Coordinates coords) {
		collection.remove(coords);
	}
}
