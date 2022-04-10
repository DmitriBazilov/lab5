package com.Dmitrii.client;

import com.Dmitrii.client.worker.*;
import com.Dmitrii.client.worker.validator.*;
import com.Dmitrii.client.parserhub.*;
import com.Dmitrii.client.reader.*;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public final class Client {
    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) throws IOException {
		
		//String path = "/home/dmitrii/Документы/Programming_univer/Lab_5/lab/lab-client/src/main/java/com/Dmitrii/client/data.json";
		String path = System.getenv("DATAPATH");
		File workers = new File(path);
		JsonParser parser = new JsonParser();
		List<Worker> worker = new ArrayList<>();
		worker = parser.getClasses(workers);
		for (Worker w : worker) {
			w.setId();
			try {
				WorkerValidator.validateWorker(w);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		WorkerCollection.initCollection(worker);
		MessageListener listener = new MessageListener();
		listener.startListen(System.in);
	}
}
