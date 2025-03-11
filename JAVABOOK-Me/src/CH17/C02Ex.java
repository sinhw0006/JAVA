package CH17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C02Ex {
	public static void func1(List<String> list) {
		// ArrayList에 있는 정수값을 입력받는데 전달되는 수중에
		// 짝수의 값만 입력받는 코드를 작성하세요.
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).matches("\\d+")) {
				if (Integer.parseInt(list.get(i)) % 2 == 0) {
					newList.add(list.get(i));
				}
			}
		}
		for (String string : newList) {
			System.out.printf("%s ", string);
		}
		System.out.println();
	}

	public static List<String> func2(List<String> list) {
		// ArrayList에 있는 문자열 중에서 길이가 5보다 큰 문자열만 필터링해서 리턴하는 함수를 만드세요
		List<String> newList = new ArrayList<String>();
		for (String string : list) {
			if (string.length() > 5)
				newList.add(string);
		}
		return newList;
	}

	public static int func3(List<String> list) {
		// ArrayList에 있는 문자열 중에서 숫자형 데이터만 추출해서 합을 구해보세요
		int sum = 0;
		for (String string : list) {
			if (string.matches("\\d+"))
				sum += Integer.parseInt(string);
		}

		return sum; // 바꿔주세요 작업시
	}

	public static void main(String[] args) {
		List<String> li = new ArrayList();
		for (int i = 0; i < 10; i++) {
			li.add(String.valueOf((int)(Math.random()*1000000+1)));
			li.add("TEST"+(int)(Math.random()*100+1));
		}
		
		func1(li);
		List<String> returndList = func2(li);
		System.out.println("=============");
		System.out.println(returndList);
		System.out.println("=============");
		int sum = func3(returndList);
		System.out.println(sum);
	}

}
