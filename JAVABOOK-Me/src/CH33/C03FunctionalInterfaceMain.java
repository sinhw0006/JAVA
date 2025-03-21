package CH33;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


//제공되는 함수형 인터페이스들
//Function<T, R>:
//apply 메서드를 가지고 있어서 하나의 인자(T)를 받아서 결과(R)를 반환하는 함수형 인터페이스 입니다.
//Supplier<T>:
//get 메서드를 가지고 있어서 어떠한 인자도 받지 않고 결과만을 제공하는 함수형 인터페이스 입니다.
//
//Consumer<T>:
//accept 메서드를 가지고 있어서 어떠한 인자를 받아서 결과를 반환하지 않는 함수형 인터페이스 입니다.
//
//Predicate<T>:
//test 메서드를 가지고 있어서 어떠한 인자를 받아서 불리언 결과를 반환하는 함수형 인터페이스 입니다.
//
//UnaryOperator<T>:
//apply 메서드를 가지고 있어서 하나의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스 입니다.
//
//BinaryOperator<T>:
//apply 메서드를 가지고 있어서 두 개의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스 입니다.

public class C03FunctionalInterfaceMain {

	public static Function<Integer, Integer> func1 = x -> x * x;

	public static Function<Integer, Integer> func2 = x -> x + x;

	public static Function<List<Integer>, Integer> func3 = (list) -> list.stream().reduce(0, (sum, item) -> sum + item);

	public static Function<List<Object>, Integer> func4 = (li) -> {
		return li.stream().filter(item -> item instanceof Integer).map(item -> (Integer) item).reduce(0,
				(sum, item) -> sum + item);
	};
	public static Function<List<Object>, List<Integer>> func5 = (li) -> {
		return li.stream().filter(item -> item instanceof Integer).map(item -> (Integer) item)
				.collect(Collectors.toList());
	};
	public static Function<Integer, Integer> func6 = func1.andThen(func2);
	public static Function<Integer, Integer> func7 = func2.andThen(func1);

	public static Function<List<Object>, Integer> func8 = func5.andThen(func3);

	public static Function<Integer, Function<Integer, Integer>> func9 = x -> y -> x + y;
	public static Function<Integer, Function<Integer, Function<Integer, Function<Integer, Integer>>>> func11 = x -> y -> z -> a -> x+y+z+a;

	public static void main(String[] args) {
		System.out.println(func1.apply(10));
		System.out.println(func2.apply(10));
		System.out.println(func3.apply(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)));
		System.out.println(func4.apply(Arrays.asList(10, "AWGHOAW", "gkroekf", 50, 60)));
		System.out.println(func5.apply(Arrays.asList(10, "AWGHOAW", "gkroekf", 50, 60)));
		System.out.println(func6.apply(10));
		System.out.println(func7.apply(10));
		System.out.println(func8.apply(Arrays.asList(10, "AWGHOAW", "gkroekf", 50, 60)));
		System.out.println(func9.apply(10).apply(150));
		System.out.println(func11.apply(10).apply(150).apply(152).apply(5));
	}
}
