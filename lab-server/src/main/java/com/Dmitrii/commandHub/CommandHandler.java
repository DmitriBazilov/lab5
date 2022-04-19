package com.Dmitrii.commandHub;

import com.Dmitrii.common.networkhub.Request;
import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.server.WorkerCollection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dmitrii
 */
public class CommandHandler {
	
	private static final Map<String, Command> commands = new HashMap<>();
	private static WorkerCollection collection;
	
	static {
		commands.put("info", new Info());
		commands.put("insert", new Insert());
		commands.put("remove_key", new RemoveKey());
	}
	
	public static void setCollection(WorkerCollection collection) {
		CommandHandler.collection = collection;
	}
	
	public static WorkerCollection getCollection() {
		return collection;
	}
	
	public Command getCommandByName(String name) {
		return commands.get(name);
	} 
	
	public static Response executeCommandByRequest(Request request) {
		return (Response) commands.get(request.getCommandName()).execute(request.getArgs());
	}
}
