package com.Dmitrii.client.worker.validator;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class StartDateValidator {

	public static LocalDateTime validateStartDate(String s) throws IllegalArgumentException {
		try {
			LocalDateTime result = LocalDateTime.parse(s);
			return result;
		} catch (DateTimeParseException e) {
			throw new IllegalArgumentException("Неправильная дата");
		}
	}
}
