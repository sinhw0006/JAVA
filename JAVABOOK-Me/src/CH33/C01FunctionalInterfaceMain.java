package CH33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@FunctionalInterface
interface Func1{
	void say(String message);
}

@FunctionalInterface
interface Func2{
	int sum(int ...args);
}

@FunctionalInterface
interface Func3{
	List<Integer> createListDesc(int ...args);
}

public class C01FunctionalInterfaceMain {
	public static void main(String[] args) {
		Func1 func1 = (message)->{System.out.println(message);};
		func1.say("Hello World!");
		Func1 func1_1 = System.out::println;
		func1_1.say("Hello World!");
		System.out.println("==================================");
		Func2 func2 = (item)->{
			int sum = 0;
			for(int i=0; i<item.length;i++) {
				sum += item[i];
			}
			return sum;
		};
		System.out.println(func2.sum(10,20,30,40,556,6,7,8,9));
		System.out.println("==================================");
		Func2 func2_2 = (item)->{
			return Arrays.stream(item).reduce(0,(sum,items)->sum+items);
		};
		System.out.println(func2_2.sum(10,20,30,40,556,6,7,8,9));
		System.out.println("==================================");
		Func3 func3 = (item)->{
			return Arrays.stream(item).boxed().sorted((a,b)->b-a).collect(Collectors.toList());
		};
		List<Integer> li = func3.createListDesc(10,20,30,40,556,6,7,41,513,6);
		System.out.println(li);
	}
}
