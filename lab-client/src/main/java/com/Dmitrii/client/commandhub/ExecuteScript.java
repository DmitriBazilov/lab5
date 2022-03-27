package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.reader.*;
import com.Dmitrii.client.worker.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecuteScript extends Command {

	private String path;
	
	public ExecuteScript() {
	}
	
	public ExecuteScript(String path) {
		this.path = path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public boolean execute() {
		MessageListener listener = new MessageListener();
		FileInputStream stream;
		try {
			stream = new FileInputStream(new File(path));
			listener.startListen(stream);
		} catch (FileNotFoundException e) {
			return false;
		}
		return true;
	}
}
