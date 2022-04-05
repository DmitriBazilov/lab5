package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.reader.ArgumentsReader;
import java.lang.reflect.*;
import com.Dmitrii.client.worker.*;
import java.io.InputStream;
import java.time.format.DateTimeParseException;

public class CommandFetcher {

	private boolean needId;
	private boolean needWorker;
	private int amountArgs;

	public CommandFetcher() {
	}
	
	public void checkAnnotation(Class command) {
			CommandAnnotation comAnn = (CommandAnnotation) command.getAnnotation(CommandAnnotation.class);
			needId = comAnn.needId();
			needWorker = comAnn.needWorker();
			amountArgs = comAnn.amountArgs();
	}
	
	public Class fetchCommand(String line) {
		String name = line;
		Commands[] coms = Commands.values();
		for (Commands c : coms) {
			//System.out.println(c.getCommandName());
			if (name.equals(c.getCommandName())) {
				return c.getCommandClass();
			}
		}
		throw new IllegalArgumentException("Сорян такой команды нет");
	}
	
	public Integer fetchId(String line) {
		Integer result = Integer.parseInt(line);
		return result;
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
	
	public void startCommand(Class command, Integer id) throws NoSuchMethodException, 
														SecurityException, 
														InstantiationException,
														IllegalAccessException,
														IllegalArgumentException,
														InvocationTargetException {
		
			System.out.println(command);
			Constructor<Command> cons = command.getDeclaredConstructor(Integer.class);
			System.out.println("PIDOR");
			Command comInstance = cons.newInstance(id);
			System.out.println("PIDOR");
			boolean returnCode = comInstance.execute();
			System.out.println("TbI DAUN");
	}
	
	public void startCommand(Class command, Worker worker) throws NoSuchMethodException, 
															InstantiationException, 
															IllegalAccessException, 
															IllegalArgumentException, 
															InvocationTargetException {
			System.out.println(command);
			Constructor<Command> cons = command.getDeclaredConstructor(Worker.class);
			Command comInstance = cons.newInstance(worker);
			comInstance.execute();
			
	}
	
	public void startCommand(Class command, Integer id, Worker worker) {
		
	}
	
	public Integer readId(InputStream stream) throws IllegalArgumentException {
		if (!needId) 
			return null;
		ArgumentsReader reader = new ArgumentsReader(stream);
		Integer result = null;
		while (result == null) {
			try {
				result = reader.readId();
			} catch (IllegalArgumentException e) {
				throw e;
			}
		}
		return result;
	}
	
	public Worker readWorker(InputStream stream) {
		if (!needWorker)
			return null;
		ArgumentsReader reader = new ArgumentsReader(stream);
		Worker result = null;
		while (result == null) {
			try {
				result = reader.readWorker();
			} catch (IllegalArgumentException | NullPointerException e) {
				throw e;
			}
		}
		return result;
	}
	
	public void clear() {
	}

	
}
