package com.Dmitrii.client.reader;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;

public class LineReader {

	private InputStreamReader streamReader;
	
	public LineReader(InputStream stream) {
		streamReader = new InputStreamReader(stream);
	}

	public String readLine() {
		char ch;
		String line = "";
		try {
			while ((ch = (char) streamReader.read()) != '\n') {
				line += ch;
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return line.substring(0, line.length());
	}

	public void close() throws IOException {
		streamReader.close();
	}
}
