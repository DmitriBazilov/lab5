package com.Dmitrii.client.reader;

import java.io.IOException;
import java.io.InputStream;
import com.Dmitrii.client.commandhub.CommandFetcher;
import com.Dmitrii.client.worker.*;
import com.Dmitrii.client.commandhub.CommandAnnotation;
import java.lang.reflect.InvocationTargetException;

public class MessageListener {

	private LineReader lineReader;
	private String currentMessage;
	private CommandFetcher fetcher;
	private WorkerCollection collection;

	public MessageListener() {

	}

	public void startListen(InputStream stream) {
		lineReader = new LineReader(stream);
		fetcher = new CommandFetcher(collection);
		while (true) {
			fetcher.clear();
			this.currentMessage = lineReader.readLine();
			fetcher.splitLine(currentMessage);
			System.out.println(currentMessage);
			Class command = fetcher.fetchCommand();
			if (command == null) {
				System.out.println("Сори, такой команды нет");
				continue;
			}
			fetcher.checkAnnotation(command);
			//может быть стоит куда-то вынести
			
			try {
				fetcher.startCommand(command);
			} catch (IllegalAccessException ex) {
			} catch (InstantiationException ex) {
			} catch (NoSuchMethodException ex) {
			} catch (InvocationTargetException ex) {
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
