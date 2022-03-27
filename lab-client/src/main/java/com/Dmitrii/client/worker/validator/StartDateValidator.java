package com.Dmitrii.client.worker.validator;

import java.time.LocalDateTime;

public class StartDateValidator {

	public static LocalDateTime validateStartDate(String s) {
		try {
			LocalDateTime result = LocalDateTime.parse(s);
			return result;
		} catch (Exception e) {
			throw new IllegalArgumentException("Неправильная дата");
		}
	}
}
