package com.Dmitrii.client.worker.validator;

import com.Dmitrii.client.worker.Position;

public class PositionValidator {

	public static Position validatePosition(String p) throws IllegalArgumentException {
		try {
			Position result = Position.valueOf(p);
			return result;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Неправильное название позиции");
		} catch (NullPointerException e) {
			return null;
		}
	}
}
