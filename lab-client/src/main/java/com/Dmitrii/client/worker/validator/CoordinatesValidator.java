package com.Dmitrii.client.worker.validator;

import com.Dmitrii.client.worker.Coordinates;

public class CoordinatesValidator {

	public static double validateX(String s) throws IllegalArgumentException, NumberFormatException {
		try {
			Double result = Double.parseDouble(s);
			return result;
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Неправильный X БЛЯТЬ");
		}
	}

	public static long validateY(String s) throws IllegalArgumentException, NumberFormatException {
		try {
			Long result = Long.parseLong(s);
			return result;
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Неправильный Y");
		}
	}
}
