package com.java;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Coding {

	public static void main(String[] args) {
		List<Employee> elist = EmployeeData.getEmployees();

		//p(elist.stream().collect(Collectors.groupingBy(e -> e.getGender(), Collectors.counting())));

		//p(elist.stream().map(e->e.getDepartment()).collect(Collectors.toSet()));

		//p(elist.stream().collect(Collectors.groupingBy(e -> e.getGender(), Collectors.averagingInt(e -> e.getAge()))));

		//Map<String, Set<Employee>> val = elist.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Function.identity(), Collectors.toSet())));
		//System.out.println(val);

		//getFundCodeMapping();

		//extractCommaSeperateNamesOfEmployees(elist);

		//extractZerosAndOnesFromIntegerArray();

		findMaxSalaryEmployeeFromEachDepartment();
		//sortByLambdaExpression();
	}

	private static void extractCommaSeperateNamesOfEmployees(List<Employee> elist) {
		Map<Integer, String> map = elist.stream().filter(e -> e.getGender().equalsIgnoreCase("male"))
		.collect(Collectors.groupingBy(Employee::getId, Collectors.mapping(Employee::getName, Collectors.joining(","))));

		System.out.println(map);

		Map<Integer, List<String>> map2 = elist.stream().filter(e -> e.getGender().equalsIgnoreCase("male"))
				.collect(Collectors.groupingBy(Employee::getId, Collectors.mapping(Employee::getName, Collectors.toList())));

		System.out.println(map2);

		// Sort in order by age
		Map<Integer, List<String>> map3 = elist.stream().filter(e -> e.getGender().equalsIgnoreCase("male"))
				.collect(Collectors.groupingBy(Employee::getId, TreeMap::new, Collectors.mapping(Employee::getName, Collectors.toList())));

		System.out.println(map3);
	}

	private static void extractZerosAndOnesFromIntegerArray() {
		final int[] integers = {0,1,1,0,1,1,1,0,0,1};
		//Stream<int[]> intStream = Stream.of(integers);
		//IntStream arraysStream = intStream.flatMapToInt(Arrays::stream);
		IntStream arraysStream = Arrays.stream(integers);
		final String zeros = arraysStream.filter(number -> number == 0).mapToObj(String::valueOf).collect(Collectors.joining(""));
		System.out.print(zeros);
	}

	public static void getFundCodeMapping(){

			List<UeFundCodeMapping> ueFundCodeList = new ArrayList<>();

			ueFundCodeList.add(new UeFundCodeMapping(1l, "FC1"));
			ueFundCodeList.add(new UeFundCodeMapping(2l, "FC2"));
			ueFundCodeList.add(new UeFundCodeMapping(3l, "FC3"));
			ueFundCodeList.add(new UeFundCodeMapping(1L, "FC11"));
			System.out.println(ueFundCodeList);

			// If there is duplicate key in that case it will through error
			//ueFundCodeList.stream().collect(Collectors.toMap(UeFundCodeMapping::getId, UeFundCodeMapping::getFundCode));

			// So try this it will give same behaviour as Map is having to replace value.
			System.out.println(ueFundCodeList.stream()
			.collect(Collectors.toMap(UeFundCodeMapping::getId, UeFundCodeMapping::getFundCode, (o,n)->n)));

			// If we don't wants to replace value keep like
			System.out.println(ueFundCodeList.stream()
					.collect(Collectors.toMap(UeFundCodeMapping::getId, UeFundCodeMapping::getFundCode, (o,n)->o)));
	}

	public static void findMaxSalaryEmployeeFromEachDepartment(){
		List<Employee> emps = EmployeeData.getEmployees();
		Map<String, Employee> result = emps.stream().collect(
				Collectors.groupingBy(Employee::getDepartment,
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(e -> e.getSalary())), Optional::get)
				)
		);


		System.out.println(result);

		emps.stream().collect(Collectors.maxBy(Comparator.comparingDouble(e -> e.getSalary()))).get();
		// Max Salary
		System.out.println("Max Salary : "+emps.stream().max(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println("Avg salary : "+emps.stream().collect(Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Department Wise Average Salary : "+ emps.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary))));
		System.out.println("All Emp Ages : "+ emps.stream().map(Employee::getAge).collect(Collectors.toList()));
		System.out.println("Youngest Employee : "+ emps.stream().sorted(Comparator.comparing(Employee::getYearOfJoining).reversed()).findFirst().get());
		System.out.println("Youngest Employee : "+ emps.stream().sorted((e1,e2)-> e2.getYearOfJoining() - e1.getYearOfJoining()).findFirst().get());

	}

	public static void sortByLambdaExpression(){
		List<Employee> employees = EmployeeData.getEmployees();

		employees.sort((e1,e2)-> e1.getAge() > e2.getAge() ? 1 : -1);
		//OR
		Collections.sort(employees, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		});
		//OR by below lambda expression
		Collections.sort(employees, (e1,e2)->e1.getName().compareTo(e2.getName()));
		System.out.println(employees.subList(0,4));


		System.out.println(employees.stream()
				.sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList()));

		// OR
		System.out.println(employees.stream()
				.sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getSalary)).collect(Collectors.toList()));

		// OR
		employees.stream().map(Employee::getSalary).forEach(System.out::println);
		System.out.println(employees.stream()
				.sorted((e1,e2)-> e1.getSalary() > e2.getSalary() ? 1 : -1).skip(2).findFirst().get());


	}
}