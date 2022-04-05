package com.Dmitrii.client.reader;

import java.io.InputStream;
import com.Dmitrii.client.worker.*;
import com.Dmitrii.client.worker.validator.*;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;

/**
 *
 * @author dmitrii
 */
public class ArgumentsReader extends LineReader {
	
	private	boolean isFileStream;
	
	public ArgumentsReader(InputStream stream) {
		super(stream);
		isFileStream = stream instanceof FileInputStream;
	}
	
	public Integer readId() throws IllegalArgumentException {
		Integer result;
		try {
			String line = this.readLine().trim();
			if (line.length() == 0)
				return IdValidator.validateId(null);
			result = IdValidator.validateId(line);
			return result;
		} catch (IllegalArgumentException e) {
			if (isFileStream)
				throw e;
			System.out.println(e.getMessage());
			result = readId();
		}
		return result;
	}
		
	public Worker readWorker() throws IllegalArgumentException, NullPointerException{
		String name = this.readName();
		Coordinates coordinates = this.readCoordinates();
		Long salary = this.readSalary();
		LocalDateTime startDate = this.readStartDate();
		Position position = this.readPosition();
		Status status = this.readStatus();
		Person person = this.readPerson();
		Worker result = new Worker(name, coordinates, salary, startDate, position, status, person);
		return result;
	}
	public String readName() throws IllegalArgumentException {
		String result;
		try {
			String line = this.readLine().trim();
			if (line.length() == 0)
				return NameValidator.validateName(null);
			result = NameValidator.validateName(line);
		} catch (IllegalArgumentException e) {
			if (isFileStream)
				throw e;
			System.out.println(e.getMessage());
			result = readName();
		}
		return result;
	}
	public Coordinates readCoordinates() throws IllegalArgumentException {
		Coordinates result;
		try {
			String line = this.readLine().trim();
			String[] spl = line.split("\\s+");
			if ("".equals(spl[0])) {
				return WorkerValidator.validateCoordinates(null);
			} else if (spl.length != 2) {
				throw new IllegalArgumentException("Координаты должно быть 2");
			}
			double x = CoordinatesValidator.validateX(spl[0]);
			long y = CoordinatesValidator.validateY(spl[1]);
			result = new Coordinates(x, y);
			return result;
		} catch (IllegalArgumentException e) {
			if (isFileStream)
				throw e;
			System.out.println(e.getMessage());
			result = readCoordinates();
		}
		return result;
	}
	public Long readSalary() throws IllegalArgumentException {
		Long result;
		try {
			String line = this.readLine().trim();
			if (line.length() == 0)
				result = SalaryValidator.validateSalary(null);
			else
				result = SalaryValidator.validateSalary(line);
			return result;
		} catch (IllegalArgumentException e) {
			if (isFileStream)
				throw e;
			System.out.println(e.getMessage());
			result = readSalary();
		}
		return result;
	}
	public LocalDateTime readStartDate() throws IllegalArgumentException {
		LocalDateTime result;
		try {
			String line = this.readLine().trim();
			if (line.length() == 0)
				return StartDateValidator.validateStartDate(line);
			result = StartDateValidator.validateStartDate(line);
			return result;
		} catch (IllegalArgumentException e) {
			if (isFileStream)
				throw e;
			System.out.println(e.getMessage());
			result = readStartDate();
		}
		return result;
	}
	
	public Position readPosition() throws IllegalArgumentException {
		Position result;
		try {
			String line = this.readLine();
			if (line.length() == 0)
				return null;
			result = PositionValidator.validatePosition(line);
			return result;
		} catch (IllegalArgumentException e) {
			if (isFileStream)
				throw e;
			System.out.println(e.getMessage());
			result = readPosition();
		}
		return result;
	}
	public Status readStatus() throws IllegalArgumentException {
		Status result;
		try {
			String line = this.readLine();
			if (line.length() == 0)
				return null;
			result = StatusValidator.validateStatus(line);
			return result;
		} catch (IllegalArgumentException e) {
			if (isFileStream)
				throw e;
			System.out.println(e.getMessage());
			result = readStatus();
		}
		return result;
	}
	
	public Person readPerson() throws IllegalArgumentException {
		Integer weight = this.readWeight();
		Color eyeColor = this.readEyeColor();
		Color hairColor = this.readHairColor();
		Location location = this.readLocation();
		return new Person(weight, eyeColor, hairColor, location);
	}
	
	public Integer readWeight() throws IllegalArgumentException {
		Integer result;
		try {
			String line = this.readLine();
			if (line.length() == 0)
				return null;
			result = WeightValidator.validateWeight(line);
			return result;
		} catch (IllegalArgumentException e) {
			if (isFileStream)
				throw e;
			System.out.println(e.getMessage());
			result = readWeight();
		}
		return result;
	}
	
	public Color readEyeColor() throws IllegalArgumentException, NullPointerException {
		Color result;
		try {
			String line = this.readLine();
			if (line.length() == 0) {
				return EyeColorValidator.validateEyeColor(null);
			}
			result = EyeColorValidator.validateEyeColor(line);
			return result;
		} catch (IllegalArgumentException e) {
			if (isFileStream)
				throw e;
			System.out.println(e.getMessage());
			result = readEyeColor();
		}
		return result;
	}
	public Color readHairColor() throws IllegalArgumentException, NullPointerException {
		Color result;
		try {
			String line = this.readLine();
			if (line.length() == 0) {
				return HairColorValidator.validateHairColor(null);
			}
			result = HairColorValidator.validateHairColor(line);
			return result;
		} catch (IllegalArgumentException e) {
			if (isFileStream)
				throw e;
			System.out.println(e.getMessage());
			result = readHairColor();
		}
		return result;
	}
	
	public Location readLocation() {
		Location result;
		try {
			String line = this.readLine();
			String[] args = line.split("\\s+");
			if (args.length == 0) 
				return PersonValidator.validateLocation(null);
			else if (args.length != 3)
				throw new IllegalArgumentException("Должно быть три координаты в строке");
			result = PersonValidator.validateLocation(line);
			return result;
		} catch (IllegalArgumentException e) {
			if (isFileStream)
				throw e;
			System.out.println(e.getMessage());
			result = readLocation();
		}
		return result;
	}
}
