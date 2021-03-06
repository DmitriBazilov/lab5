package com.Dmitrii.client.worker.validator;

import com.Dmitrii.client.worker.Color;

/**
 *
 * Валидатор цвета волос.
 */
public class HairColorValidator {

	public static Color validateHairColor(String s) throws IllegalArgumentException, NullPointerException {
		try {
			Color result = Color.valueOf(s.toUpperCase());
			return result;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Неправильный цвет");
		} catch (NullPointerException e) {
			throw new NullPointerException("Цвет не может быть null");
		}
	}
}
