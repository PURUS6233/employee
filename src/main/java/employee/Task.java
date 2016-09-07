package main.java.employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * java -jar employee_task.jar C:\OUTPUT.TXT
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

		Collection<Employee> fromBeginningEmployee = EmployeeUtils.getFromBeginning(employees, 3);
		for (Employee employee : fromBeginningEmployee) {
			System.out.println(employee);
		}
		System.out.println();
		Collection<Employee> fromEndEmployee = EmployeeUtils.getFromEnd(employees, 2);
		for (Employee employee : fromEndEmployee) {
			System.out.println(employee);
		}
		System.out.println("While");
		Collection<Employee> fromBeginning = EmployeeUtils.getFromBeginningWhile(employees, 3);
		for (Employee employee : fromBeginning) {
			System.out.println(employee);
		}
		System.out.println();
		Collection<Employee> fromEnd = EmployeeUtils.getFromEndWhile(employees, 2);
		for (Employee employee : fromEnd) {
			System.out.println(employee);
		}
		EmployeeUtils utils = new EmployeeUtils();
		
		Collection<Employee> filterEmployeeName = utils.filter(employees, "pA");
		for (Employee employee : filterEmployeeName) {
			System.out.println(employee);
		}
		
		Employee filterEmployeeId = utils.filter(employees, 4);
		System.out.println(filterEmployeeId);
		
		FileHelper.writeResultToFile(pathToFile, employees);
		
		System.out.println(FileHelper.readEmployeesFromFile(pathToFile).toString() + "\n");
		
		System.out.println("Evaluation ends in:" + new Date());
		
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
