package CH32;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.checkerframework.common.reflection.qual.NewInstance;

class Person {
	private String name;
	private int age;

	public Person() {
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

class Employee extends Person{
	String company;
	String department;
	String role;

	public Employee() {
	}
	
	public Employee(Person person) {
		super(person.getName(),person.getAge());
	}
	
	public Employee(String name, int age) {
		super(name,age);
	}

	public Employee(String company, String department, String role) {
		super();
		this.company = company;
		this.department = department;
		this.role = role;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [company=" + company + ", department=" + department + ", role=" + role + ", getName()="
				+ getName() + ", getAge()=" + getAge() + "]";
	}

	
}

public class C01StreamMain {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(list);

		// filter
		List<Integer> list2 = list.stream().filter((item) -> item % 2 == 0).collect(Collectors.toList());
		System.out.println("짝수 필터링 : " + list2);

		List<Integer> list3 = list.stream().filter((item) -> item % 2 == 0).map((item) -> {
			return item * item;
		}).collect(Collectors.toList());
		System.out.println("MAP : " + list3);

		List<Person> list4 = Arrays.asList(new Person("홍길1동", 35), new Person("남길12동", 45), new Person("서길123동", 25),
				new Person("동길1234동", 55));
		List<Integer> list5 = list4.stream().map(Person::getAge).sorted((a, b) -> b - a).collect(Collectors.toList());
		System.out.println(list5);

		List<Integer> list6 = list4.stream().map(Person::getName).map(String::length).sorted((a, b) -> b - a)
				.collect(Collectors.toList());
		System.out.println(list6);
		
		List<Employee> list7 =
		list4.stream()
//			.map(person -> new Employee(person.getName(),person.getAge()))
			.map(Employee::new)
			.collect(Collectors.toList());
		list7.forEach(System.out::println);
		
		
	}
}
