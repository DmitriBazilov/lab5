package com.Dmitrii.client.commandhub;

import java.lang.reflect.*;
import com.Dmitrii.client.reader.LineReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.Dmitrii.client.worker.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandFetcher {

	private List<String> splitResult;
	private WorkerCollection collection;
	private boolean needId;
	private boolean needWorker;
	private int amountArgs;

	public CommandFetcher() {
	}
	
	public CommandFetcher(WorkerCollection collection) {
		splitResult = new ArrayList<>();
		this.collection = collection;
	}
	
	public void splitLine(String line) {
		String[] temp = line.split("\\s+");
		splitResult = Arrays.asList(temp);
	}
	
	public void checkAnnotation(Class command) {
			CommandAnnotation comAnn = (CommandAnnotation) command.getAnnotation(CommandAnnotation.class);
			needId = comAnn.needId();
			needWorker = comAnn.needWorker();
			amountArgs = comAnn.amountArgs();
	}
	
	public Class fetchCommand() {
		String name = splitResult.get(0);
		Commands[] coms = Commands.values();
		for (Commands c : coms) {
			//System.out.println(c.getCommandName());
			if (name.equals(c.getCommandName())) {
				return c.getCommandClass();
			}
		}
		return null;
	}
	
	public Integer fetchId() {
		String stringId = splitResult.get(1);
		Integer result = Integer.parseInt(stringId);
		return result;
	}

	public String[] fetchLineArgs() {
		int temp = needId ? 1 : 0;
		return (String[]) splitResult.subList(1 + temp, splitResult.size() - 1).toArray();
	}
	
	public boolean checkAmountArgs(int number) {
		return number == amountArgs;
	}
	
	public void startCommand(Class command) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		try {
			//Перенести проверку аннотации
			Command comInstance = (Command) command.newInstance();
			boolean returnCode = comInstance.execute();
			System.out.println("YA DAUN");
		} catch (IllegalAccessException e) {
			throw new IllegalAccessException("БЛАБЛАБЛА");
        } catch (InstantiationException e) {
			throw new InstantiationException("СОС");
		}
	}
	
	public void startCommand(Class command, Integer id) throws Exception {
		try {
			Constructor<Command> cons = command.getDeclaredConstructor(Integer.class);
			Command comInstance = cons.newInstance(id);
			boolean returnCode = comInstance.execute();
			System.out.println("TbI DAUN");
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void startCommand(Class command, Worker worker) {
		
	}
	
	public void startCommand(Class command, Integer id, Worker worker) {
		
	}

	public String[] readArgs() {
		return null;
	}
	
	public void clear() {
		
	}
}
