package CH17;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 1~45 까지 숫자를 6개 랜덤으로 받아 set에 저장 / 출력
// 저장된 set의 오름차순정렬

public class C04Ex {

	public static void main(String[] args) {
		Set<Integer> lotto = new HashSet<>();
		while(lotto.size()<6) {
			lotto.add((int)(Math.random()*45+1));
		}
		List<Integer> lotto2 = new ArrayList<Integer>(lotto);
		lotto2.sort(null);
		System.out.println("랜덤 값 : "+lotto);
		System.out.println("정렬 값 : "+lotto2);
	}
}
