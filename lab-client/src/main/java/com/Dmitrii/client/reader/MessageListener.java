package com.Dmitrii.client.reader;

import java.io.IOException;
import java.io.InputStream;
import com.Dmitrii.client.commandhub.CommandFetcher;
import com.Dmitrii.client.worker.*;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.time.format.DateTimeParseException;

public class MessageListener {

	private LineReader lineReader;
	private String currentMessage;
	private CommandFetcher fetcher;	
	
	public MessageListener() {

	}

	public void startListen(InputStream stream) {
		lineReader = new LineReader(stream);
		fetcher = new CommandFetcher();
		while (true) {
			fetcher.clear();
			this.currentMessage = lineReader.readLine();
			System.out.println(currentMessage);
			try {
				Class command = fetcher.fetchCommand(currentMessage);
				if (command == null) {
					System.out.println("Сори, такой команды нет");
					continue;
				}
				
				fetcher.checkAnnotation(command);
				Integer id = fetcher.readId(stream);
				Worker worker = fetcher.readWorker(stream);
				
				if (id != null && worker != null)
					fetcher.startCommand(command, id, worker);
				else if (id != null && worker == null) 
					fetcher.startCommand(command, id);
				else if (id == null && worker != null)
					fetcher.startCommand(command, worker);
				else
					fetcher.startCommand(command);
			} catch (IllegalAccessException | InstantiationException | NoSuchMethodException | 
					InvocationTargetException | IllegalArgumentException | DateTimeParseException | NullPointerException ex) {
				if (stream instanceof FileInputStream) {
					endListen();
					System.out.println("Неправильный скрипт ");
				}
				System.out.println(ex.getMessage());
			}
			
		}
	}

	public void endListen() {
		try {
			lineReader.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
