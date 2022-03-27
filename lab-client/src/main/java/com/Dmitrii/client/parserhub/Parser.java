package com.Dmitrii.client.parserhub;

import java.util.List;
import java.io.File;
import com.Dmitrii.client.worker.*;
import java.io.IOException;
import java.util.TreeMap;

public abstract class Parser {

	public abstract List<Worker> getClasses(File file);

	public abstract void writeClasses(File file, TreeMap<Integer, Worker> classes) throws IOException;
}
