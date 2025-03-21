package CH33;

import java.util.Arrays;

@FunctionalInterface
interface Functional {
	Integer execute(int... args);
}

class Calc {
	Functional sum;
	Functional sub;
	Functional mul;
	Functional div;

	Calc() {
//		Functional sum 에 대한 람다식
		sum = (items) -> {
			return Arrays.stream(items).reduce(0, (sum, item) -> sum + item);
		};
//		Functional sub 에 대한 람다식
		sub = (items) -> {
			return Arrays.stream(items).boxed().sorted((a,b)->b-a).reduce((sub,item)->sub-item).orElse(0);
		};
//		Functional mul 에 대한 람다식
		mul = (items) -> {
			return Arrays.stream(items).reduce(1, (sum, item) -> sum * item);
		};
//		Functional div 에 대한 람다식
		div = (items) -> {
			return Arrays.stream(items).boxed().sorted((a,b)->b-a).reduce((sub,item)->sub/item).orElse(0);
		};
		// 뺄셈,나눗셈은 큰수에서 작은수로 정렬후 감산 처리
	}
}

public class C02Ex {
	public static void main(String[] args) {
		Calc calc = new Calc();
		System.out.println("합 : " + calc.sum.execute(10, 20, 30, 40, 50, 60));
		System.out.println("차 : " + calc.sub.execute(1, 4, 2, 9));
		System.out.println("곱 : " + calc.mul.execute(10, 20, 30, 40, 50, 60));
		System.out.println("나눗셈 : " + calc.div.execute(4,2,5, 600));
	}
}
