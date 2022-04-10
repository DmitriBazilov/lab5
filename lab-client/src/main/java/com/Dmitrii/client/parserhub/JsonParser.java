package com.Dmitrii.client.parserhub;

import com.Dmitrii.client.worker.Worker;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Collection;

/**
 *
 * Класс - парсер. Парсит json. Умеет записывать и доставать рабов из файла.
 */
public class JsonParser extends Parser {

	public List<Worker> getClasses(File jsonFile) {
		ObjectMapper mapper = new ObjectMapper()
			.findAndRegisterModules();
		List<Worker> objList = new ArrayList<>();
		try {
			objList = mapper.readValue(jsonFile, new TypeReference<List<Worker>>(){});
		} catch (IOException e) {
			System.out.println(e);
		}
		//МБ НАДО СВОЙ ДЕСЕРЕАЛИЗАТОР ПИСАТЬ НА ДЭЙТТАЙМЫ
		return objList;
	}

	public void writeClasses(File file, TreeMap<Integer, Worker> classes) throws IOException {
		ObjectMapper mapper = new ObjectMapper()
			.findAndRegisterModules();
		Collection<Worker> collection = classes.values();
		mapper.writerWithDefaultPrettyPrinter().writeValue(file, collection);
	}
}
