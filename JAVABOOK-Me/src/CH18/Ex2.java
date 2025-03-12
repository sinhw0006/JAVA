package CH18;

import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean stop = false;
		while (!stop) {
			System.out.print("피라미드 1 // 다이아몬드 2 // 종료 3: ");
			int key = sc.nextInt();
			switch (key) {
			case 1: {
				System.out.print("높이를 입력하세요 : ");
				int height = sc.nextInt();
				for (int i = 0; i < height; i++) {
					for (int j = height; j > i + 1; j--) {
						System.out.print(" ");
					}
					for (int j = 0; j < 1 + (i * 2); j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			}
			case 2: {
				// 사용자에게 높이를 입력요청 텍스트 출력
				System.out.print("높이를 입력하세요(홀수) : ");
				// 스캐너 객체를 사용해 입력한 값을 정수로 받아 height 변수에 저장
				int height = sc.nextInt();
				// 만약 사용자가 입력한 값이 홀수면
				if (height % 2 == 0)
					height++;
				int middle = height / 2 + 1;
				System.out.println(middle);
				for (int i = 0; i < height; i++) {
					for (int j = 0; j < Math.abs((middle - 1) - i); j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < (i * 2) - Math.max(0, 4 * (i - middle + 1)) + 1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
			case 3: {
				stop = true;
				break;
			}
			default: {
				System.err.println("유효하지 않은 입력값 입니다.");
				continue;
			}
			}
		}
	}
}
