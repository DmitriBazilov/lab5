package com.Dmitrii.client.commandhub;

import com.Dmitrii.client.worker.*;
import com.Dmitrii.client.worker.validator.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;

/**
 *
 * Команда ExecuteScript.
 */
@CommandAnnotation(description = "Испольнение скрипта", needWorker = false, needId = false, needPath = true)
public class ExecuteScript {

	private String path;
	
	public ExecuteScript() {
	}
	
	public ExecuteScript(String path) {
		this.path = path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public boolean execute() {
		File file = new File(path);
		FileReader fr;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException ex) {
			System.out.println("Файл не найден");
			return false;
		}
		BufferedReader reader = new BufferedReader(fr);
		
		CommandFetcher fetcher = new CommandFetcher();
		try {
			while (reader.ready()) {
				String line = reader.readLine();
				Class command = fetcher.fetchCommand(line);
			
				fetcher.checkAnnotation(command);
				
				Integer id = null;
				if (fetcher.getNeedId()) {
					String idLine = reader.readLine().trim();
					id = Integer.parseInt(idLine);
				}
				Worker worker = null;
				if (fetcher.getNeedWorker()) {
					String name = reader.readLine().trim();
					NameValidator.validateName(name);
					String coordLine = reader.readLine().trim();
					String[] spl = coordLine.split("\\s+");
					if (spl.length != 2)
						throw new IllegalArgumentException();
					double x = CoordinatesValidator.validateX(spl[0]);
					long y = CoordinatesValidator.validateY(spl[1]);
					Coordinates coordinates = new Coordinates(x, y);
					Long salary = SalaryValidator.validateSalary(reader.readLine().trim());
					LocalDateTime startDate = StartDateValidator.validateStartDate(reader.readLine().trim());
					Position position = PositionValidator.validatePosition(reader.readLine().trim());
					Status status = StatusValidator.validateStatus(reader.readLine().trim());
					Integer weight = WeightValidator.validateWeight(reader.readLine().trim());
					Color eyeColor = EyeColorValidator.validateEyeColor(reader.readLine().trim());
					Color hairColor = HairColorValidator.validateHairColor(reader.readLine().trim());
					Location location = PersonValidator.validateLocation(reader.readLine().trim());
					Person person = new Person(weight, eyeColor, hairColor, location);
					worker = new Worker(name, coordinates, salary, startDate, position, status, person);
				}
				if (fetcher.getNeedPath()) {
					String nPath = reader.readLine();
					if (nPath.equals(path)) {
						System.out.println("Скрипт вызывает сам себя");
						return false;
					}
					ExecuteScript newScript = new ExecuteScript(nPath);
					newScript.execute();
					continue;
				}
				if (id == null && worker == null)
					fetcher.startCommand(command);
				else if (id != null && worker == null)
					fetcher.startCommand(command, id);
				else if (id == null && worker != null)
					fetcher.startCommand(command, worker);
				else
					fetcher.startCommand(command, id, worker);
				System.out.println("ГОТОВО");
			}
		} catch (Exception e) {
			System.out.println("Неправильный скрипт");
			return false;
		}
		return true;
	}
}
