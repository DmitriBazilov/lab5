package com.Dmitrii.client.worker.validator;

import com.Dmitrii.client.worker.Color;

/**
 *
 * Валидатор цвета.
 */
public class ColorValidator {

	public static Color validateColor(String col) {
		Color result;
		try {
			result = Color.valueOf(col.toUpperCase());
			return result;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Неправильный цвет");
		}
	}		
}
