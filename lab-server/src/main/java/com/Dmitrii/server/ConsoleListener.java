package com.Dmitrii.server;

import java.util.Scanner;

/**
 *
 * @author dmitrii
 */
public class ConsoleListener extends Thread {
	
	private boolean isOn = true;
	
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (isOn) {
			String message = scanner.nextLine().trim();
			if ("exit".equals(message))
				System.exit(1);
			else {
				System.out.println("ИДЕШЬ НАХУЙ");
			}
		}
	}

	
}
