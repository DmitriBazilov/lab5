package com.Dmitrii.client.worker.validator;

public class NameValidator {

	public static String validateName(String n) {
		if ("".equals(n) || n == null)
			throw new IllegalArgumentException("Неправильное имя");
		return n;
	}
}
