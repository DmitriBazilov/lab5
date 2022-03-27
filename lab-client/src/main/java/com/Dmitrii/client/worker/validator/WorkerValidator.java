package com.Dmitrii.client.worker.validator;

import com.Dmitrii.client.worker.*;
import java.time.ZonedDateTime;
import java.time.LocalDateTime;

public class WorkerValidator {
	
	public static Integer validateId(Integer id) throws IllegalArgumentException {
		if (id == null || id <= 0)
			throw new IllegalArgumentException("Неправильный ID. Не должен быть null и должен быть больше нуля");
		return id;
	}

	public static String validateName(String name) throws IllegalArgumentException {
		try {
			String result = NameValidator.validateName(name);
			return result;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public static Coordinates validateCoordinates(Coordinates c) throws IllegalArgumentException, NumberFormatException {
		if (c == null) 
			throw new IllegalArgumentException("Координаты не могут быть null");
		try {
			String[] coords = c.toString().split("\\s+");
			double x = c.getX();
			long y = c.getY();
			double resultX = CoordinatesValidator.validateX(Double.toString(x));
			long resultY = CoordinatesValidator.validateY(Long.toString(y));
			return c;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	} 

	public static ZonedDateTime validateCreationDate(ZonedDateTime time) throws IllegalArgumentException {
		if (time == null) 
			throw new IllegalArgumentException("Время не может быть null");
		//Дописать для него валидатор
		return time;
	}

	public static Long validateSalary(Long salary) throws IllegalArgumentException, NumberFormatException {
		if (salary == null) 
			throw new IllegalArgumentException("Зарплата не может быть null");
		try {
			Long result = SalaryValidator.validateSalary(salary.toString());
			return result;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public static LocalDateTime validateStartDate(LocalDateTime time) throws Exception {
		if (time == null)
			throw new IllegalArgumentException("Время не может быть null");
		try {
			LocalDateTime result = StartDateValidator.validateStartDate(time.toString());
			return result;
		} catch (Exception e) {
			throw e;
		}
	}

	public static Position validatePosition(Position pos) throws IllegalArgumentException {
		if (pos == null) 
			return null;
		try {
			Position result = PositionValidator.validatePosition(pos.toString());
			return result;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public static Status validateStatus(Status s) throws IllegalArgumentException {
		if (s == null)
			return null;
		try {
			Status result = StatusValidator.validateStatus(s.toString());
			return result;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public static Person validatePerson(Person p) {
		if (p == null)
			return null;
		try {
			Integer resultWeight = PersonValidator.validateWeight(p.getWeight().toString().split(" "));
			Color resultEyeColor = PersonValidator.validateEyeColor(p.getEyeColor().toString().split(" "));
			Color resultHairColor = PersonValidator.validateHairColor(p.getHairColor().toString().split(" "));
			Location resultLocation = PersonValidator.validateLocation(p.getLocation().toStringArray());
			return p;
		} catch (IllegalArgumentException | NullPointerException e) {
			throw e;
		}
	}
}
