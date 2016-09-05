package main.java.employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
	
	@SuppressWarnings("unchecked")
	public static List<Employee> readEmployeesFromFile(String pathToFile)
			throws IncorrectFileFormatException {
		List<Employee> employees = new ArrayList<>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					pathToFile));
			employees = (List<Employee>) ois.readObject();
			ois.close();
			return employees;
		} catch (FileNotFoundException | ClassNotFoundException e) {
			throw new IncorrectFileFormatException("Incorrect file type: " + pathToFile
					+ ": " + e.getMessage(), e);
		} catch (IOException e) {
			System.out.println("Incorrect file type: " + pathToFile + ": "
					+ e.getMessage());
			throw new IncorrectFileFormatException("Incorrect file type: "
					+ pathToFile + ": " + e.getMessage(), e);
		}
	}

	public static boolean writeResultToFile(String pathToFile,
			List<Employee> employees) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(pathToFile))) {
			oos.writeObject(employees);
			System.out.println("Done");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

}
