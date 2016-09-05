package main.java.employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Alex
 * java -jar employee_task.jar C:\OUTPUT.TXT
 * 
 */

public class Task {

	public static void main(String[] args) throws IOException, IncorrectFileFormatException {
		
		if (!readAndValidateParams(args)) {
			System.exit(1);
		}
		final String pathToFile = args[0];
		System.out.println("Evaluation started:" + new Date() + "\n");

		List<Employee> employees = new ArrayList<Employee>();

		employees.add(new EmployeeFixedRate("Pavel", 1500));
		employees.add(new EmployeeHourlyWage("Alex", 24));
		employees.add(new EmployeeFixedRate("Yura", 3000));
		employees.add(new EmployeeHourlyWage("Artem", 30));
		employees.add(new EmployeeFixedRate("Vova", 8000));
		employees.add(new EmployeeFixedRate("Andrey", 8000));
		Collections.sort(employees, new EmployeeComparator());

		Task task = new Task();

		task.printFirstFiveEmployee(employees);
		System.out.println();
		task.printLastFiveEmployee(employees);
		System.out.println();
		
		FileHelper.writeResultToFile(pathToFile, employees);
		
		System.out.println(FileHelper.readEmployeesFromFile(pathToFile).toString() + "\n");
		
		System.out.println("Evaluation ends in:" + new Date());
		
	}

	public void printFirstFiveEmployee(List<Employee> workers) {
		for (int i = 0; i < 5; i++) {
			System.out.println(workers.get(i).toString());
		}
	}

	public void printLastFiveEmployee(List<Employee> workers) {
		for (int i = workers.size() - 1; i > workers.size() - 1 - 3; i--) {
			System.out.println(workers.get(i).toString());
		}
	}	
	
	private static boolean readAndValidateParams(String[] args) {
		// length check
		if (args.length < 1) {
			System.err.println();
			System.err.println("Wrong number of arguments");
			System.err.println();
			System.err
					.println("Usage: java -jar employee_task.jar <pathToFile>");
			System.err.println();
			return false;
		}

		return true;
	}

}
