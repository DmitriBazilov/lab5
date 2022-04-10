package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.reader.ArgumentsReader;
import java.lang.reflect.*;
import com.Dmitrii.client.worker.*;
import java.io.InputStream;
import java.time.format.DateTimeParseException;

/**
 *
 * Класс работающий с выборкой команд, их запуском, чтением аргументов.
 */
public class CommandFetcher {

	private boolean needId;
	private boolean needWorker;
	private boolean needPath;
	private String description;

	public CommandFetcher() {
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean getNeedId() {
		return needId;
	}
	
	public boolean getNeedWorker() {
		return needWorker;
	}
	
	public boolean getNeedPath() {
		return needPath;
	}
	
	/**
	 * 
	 * Метод проверяющий поля аннотации над командой
	 */
	public void checkAnnotation(Class command) {
			CommandAnnotation comAnn = (CommandAnnotation) command.getAnnotation(CommandAnnotation.class);
			needId = comAnn.needId();
			needWorker = comAnn.needWorker();
			needPath = comAnn.needPath();
			description = comAnn.description();
	}
	
	/**
	 * 
	 * Метод, выбирающий по строке от пользователя нужный класс команды
	 */
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
	
	/**
	 * 
	 * Метод запускающий команды без аргументов.
	 */
	public void startCommand(Class command) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		try {
			//Перенести проверку аннотации
			Command comInstance = (Command) command.newInstance();
			boolean returnCode = comInstance.execute();
		} catch (IllegalAccessException e) {
			throw new IllegalAccessException("БЛАБЛАБЛА");
        } catch (InstantiationException e) {
			throw new InstantiationException("СОС");
		}
	}
	
	/**
	 * 
	 * Метод, запускающий команды, требующие id.
	 */
	public void startCommand(Class command, Integer id) throws NoSuchMethodException, 
														SecurityException, 
														InstantiationException,
														IllegalAccessException,
														IllegalArgumentException,
														InvocationTargetException {
		
			Constructor<Command> cons = command.getDeclaredConstructor(Integer.class);
			Command comInstance = cons.newInstance(id);
			boolean returnCode = comInstance.execute();
	}
	
	/**
	 * 
	 * Метод, запускающий команды, требующие раба.
	 */
	public void startCommand(Class command, Worker worker) throws NoSuchMethodException, 
															InstantiationException, 
															IllegalAccessException, 
															IllegalArgumentException, 
															InvocationTargetException {
		Constructor<Command> cons = command.getDeclaredConstructor(Worker.class);
		Command comInstance = cons.newInstance(worker);
		comInstance.execute();
			
	}
	
	/**
	 * 
	 * Метод, запускающий команды, требующие id и раба.
	 */
	public void startCommand(Class command, Integer id, Worker worker) throws NoSuchMethodException, 
																		InstantiationException, 
																		IllegalAccessException, 
																		IllegalArgumentException, 
																		InvocationTargetException {
		Constructor<Command> cons = command.getDeclaredConstructor(Integer.class, Worker.class);
		Command comInstance = cons.newInstance(id, worker);
		comInstance.execute();
	}
	
	/**
	 * 
	 * Метод считывающий id.
	 */
	public Integer readId(InputStream stream) throws IllegalArgumentException {
		if (!needId) 
			return null;
		System.out.println("Введите id");
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
	
	/**
	 * 
	 * Метод считывающий раба.
	 */
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
	
	/**
	 * 
	 * Метод считывающий путь до файла.
	 */
	public String readPath(InputStream stream) {
		if (!needPath)
			return null;
		ArgumentsReader reader = new ArgumentsReader(stream);
		String result = null;
		while (result == null) {
			result = reader.readPath();
		}
		return result;
	} 
	
	public void clear() {
	}

	
}
