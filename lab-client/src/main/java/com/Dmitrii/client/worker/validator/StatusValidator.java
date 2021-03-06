package com.Dmitrii.client.worker.validator;

import com.Dmitrii.client.worker.Status;

/**
 *
 * Валидатор статуса раба.
 */
public class StatusValidator {

	public static Status validateStatus(String s) throws IllegalArgumentException {
		try {
			Status result =	Status.valueOf(s);
			return result;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Неправильное назавание статуса");
		} catch (NullPointerException e) {
			return null;
		}
	}
}
