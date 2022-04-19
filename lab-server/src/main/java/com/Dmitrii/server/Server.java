package com.Dmitrii.server;

import com.Dmitrii.commandHub.CommandHandler;
import java.io.File;
import java.io.IOException;

public final class Server {

    private Server() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) throws IOException {
		String path = "/home/dmitrii/Документы/Programming_univer/Lab_5/lab/lab-server/src/main/java/com/Dmitrii/data.json";
		File file = new File(path);
		if (file.exists())
			System.out.println("YA DAUN");
		WorkerCollection collection = new WorkerCollection(file);
		CommandHandler.setCollection(collection);
		
		ServerListener clientListener = new ServerListener(1234);
		clientListener.startListen();
    }
}