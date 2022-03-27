package com.Dmitrii.client.worker.validator;

import com.Dmitrii.client.worker.Color;
import com.Dmitrii.client.worker.Location;

public class PersonValidator {

	public static Integer validateWeight(String[] args) throws IllegalArgumentException, NumberFormatException {
		if (args == null)
			return null;
		if (args.length != 1)
			throw new IllegalArgumentException("Вес это одно число");
		try {
			Integer result = WeightValidator.validateWeight(args[0]);
			return result;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public static Color validateEyeColor(String[] args) throws IllegalArgumentException, NumberFormatException {
		if (args.length != 1)
			throw new IllegalArgumentException("Enum должен быть одним словом");
		try {
			Color result = EyeColorValidator.validateEyeColor(args[0]);
			return result;
		} catch (IllegalArgumentException | NullPointerException e) {
			throw e;
		}
	}

	public static Color validateHairColor(String[] args) throws IllegalArgumentException, NumberFormatException {
		if (args.length != 1)
			throw new IllegalArgumentException("Enum должен быть одним словом");
		try {
			Color result = HairColorValidator.validateHairColor(args[0]);
			return result;
		} catch (IllegalArgumentException | NullPointerException e) {
			throw e;
		}
	}

	public static Location validateLocation(String[] args) throws IllegalArgumentException, NumberFormatException {
		if (args == null)
			return null;
		if (args.length != 3)
			throw new IllegalArgumentException("Координаты должно быть 3");
		try {
			Double x = LocationValidator.validateX(args[0]);
			long y = LocationValidator.validateY(args[1]);
			int z = LocationValidator.validateZ(args[2]);
			return new Location(x, y, z);
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}
}
