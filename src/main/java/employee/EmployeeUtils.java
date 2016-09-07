package main.java.employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class EmployeeUtils {

	// Java subList

	public static Collection<Employee> getFromBeginning(List<Employee> list,
			int quantity) {
		Collection<Employee> employee = list.subList(0, quantity);
		return employee;
	}

	public static Collection<Employee> getFromEnd(List<Employee> list,
			int quantity) {
		Collection<Employee> employee = list.subList(list.size() - quantity,
				list.size());
		return employee;
	}

	// Java ITERATOR

	public static Collection<Employee> getFromBeginningWhile(
			List<Employee> list, int quantity) {
		ListIterator<Employee> listIterator = list.listIterator();
		Collection<Employee> result = new ArrayList<Employee>();
		int i = 1;
		while (listIterator.hasNext() & i <= quantity) {
			i++;
			result.add(listIterator.next());
		}
		isEmpty(result);
		return result;
	}

	public static Collection<Employee> getFromEndWhile(List<Employee> list,
			int quantity) {
		ListIterator<Employee> listIterator = list.listIterator(list.size()-1);
		Collection<Employee> result = new ArrayList<Employee>();
		int i = 1;
		while (listIterator.hasPrevious() & i <= quantity) {
			i++;
			result.add(listIterator.previous());
		}
		isEmpty(result);
		return result;
	}

	public Collection<Employee> filter(List<Employee> list, String name) {

		List<Employee> result = list
				.stream()
				.filter(p -> p.getName().toLowerCase()
						.contains(name.toLowerCase()))
				.collect(Collectors.toList());
		return result;
	}

	public Employee filter(List<Employee> list, int id) {

		Employee result = list.stream().filter(p -> p.getId() == (id))
				.findFirst().get();
		return result;
	}

	public static boolean isEmpty(Collection<Employee> list) {
		if (list.isEmpty()) {
			throw new NullPointerException("list is empty" + EmployeeUtils.class);
		}
		return false;
	}
}
