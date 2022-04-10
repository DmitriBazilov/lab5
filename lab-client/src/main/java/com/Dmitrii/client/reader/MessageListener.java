package com.Dmitrii.client.reader;

import java.io.IOException;
import java.io.InputStream;
import com.Dmitrii.client.commandhub.CommandFetcher;
import com.Dmitrii.client.commandhub.ExecuteScript;
import com.Dmitrii.client.worker.*;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.time.format.DateTimeParseException;

/**
 *
 * Класс - листенер. Слушает команды пользователя.
 */
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
			if (!(stream instanceof FileInputStream))
				System.out.println("Введите команду : ");
			currentMessage = lineReader.readLine();
			System.out.println(currentMessage);
			
			try {
				Class command = fetcher.fetchCommand(currentMessage);
				fetcher.checkAnnotation(command);
				if (!(stream instanceof FileInputStream))
					System.out.println(fetcher.getDescription());
				Integer id = fetcher.readId(stream);
				Worker worker = fetcher.readWorker(stream);
				String path = fetcher.readPath(stream);
				if (path != null) {
					try {
						ExecuteScript script = new ExecuteScript(path);
						script.execute();
						
					} catch (Exception e) {
						System.out.println("Неправильный скрипт");
					}
					continue;
				}
				if (id != null && worker != null)
					fetcher.startCommand(command, id, worker);
				else if (id != null && worker == null) 
					fetcher.startCommand(command, id);
				else if (id == null && worker != null)
					fetcher.startCommand(command, worker);
				else
					fetcher.startCommand(command);
				System.out.println("Готово");
			} catch (IllegalAccessException | InstantiationException | NoSuchMethodException | 
					InvocationTargetException | IllegalArgumentException | DateTimeParseException | NullPointerException ex) {
				
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
