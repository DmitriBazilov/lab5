package com.Dmitrii.client.worker;

import java.util.TreeMap;
import java.util.List;
import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class WorkerCollection {

	private static TreeMap<Integer, Worker> workerCollection;
	private static Date creationDate;

	public WorkerCollection() {
		workerCollection = new TreeMap<>();
	}

	public static void initCollection(List<Worker> workers) {
		creationDate = new Date();
		workerCollection = new TreeMap<>();
		for (Worker w : workers) {
			workerCollection.put(w.getId(), w);
		}
	}

	public static void setDate() {
		creationDate = new Date();
	}

	public static TreeMap<Integer, Worker> getCollection() {
		return workerCollection;
	}

	public static Date getDate() {
		return creationDate;
	}

	public static void add(Integer key, Worker worker) {
		workerCollection.put(key, worker);
	}

	public static void update(Integer id, Worker worker) {
		workerCollection.remove(id);
		workerCollection.put(id, worker);
	}

	public static void clear() {
		workerCollection.clear();
	}

	public static void info() {
		System.out.println(workerCollection.getClass().toString() +  " " + creationDate +  " " + workerCollection.size());
	}

	public static void show() {
		Collection<Worker> workers = workerCollection.values();
		for (Worker w : workers) {
			System.out.println(w.toString());
		}
	}

	public static void removeId(Integer id) {
		workerCollection.remove(id);
	}

	public static void removeLower(Worker worker) {
		Integer id = worker.getId() - 1;
		while (workerCollection.floorKey(id) != null) 
			WorkerCollection.removeId(workerCollection.floorKey(id));
	}
	
	public static void removeLowerKey(Integer key) {
		while (workerCollection.floorKey(key) != null) 
			WorkerCollection.removeId(key);
	}

	public static void replaceIfGreater(Integer id, Worker worker) {
	}

	public static void maxBySalary() {
		Collection<Worker> workers = workerCollection.values();
		Long result = 0l;
		for (Worker worker : workers) {
			if (result.compareTo(worker.getSalary()) < 0)
				result = worker.getSalary();
		}
		System.out.println(result);
	}

	public static void printUniquePosition() {
		Set<Position> set = new HashSet<Position>();
		Collection<Worker> workers = workerCollection.values();
		for (Worker worker : workers) {
			set.add(worker.getPosition());
		}
		for (Position pos : set) {
			System.out.print(pos.toString() + " ");
		}
		System.out.println("");
	} 
	
	
}

