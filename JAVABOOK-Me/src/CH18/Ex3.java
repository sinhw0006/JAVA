package CH18;

import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		// 스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
		// while문 탈출을 위한 boolean 변수 stop 선언, 초기값 false
		boolean stop = false;
		// stop이 false면 반복
		while (!stop) {
			// 정수값을 제외한 다른 값이 들어오면 예외처리
			try {
				// 사용자에게 높이를 입력요청 텍스트 출력
				System.out.print("높이를 입력하세요(홀수) : ");
				// 스캐너 객체를 사용해 입력한 값을 정수로 받아 height 변수에 저장
				int height = sc.nextInt();
				// 만약 사용자가 입력한 값이 짝수면
				if (height % 2 == 0) {
					//사용자에게 홀수 값입력 요청을 출력
					System.err.println("홀수 값을 입력해주세요");
					//현 반복작업 종료
					continue;
				}
				// middle 변수를 선언하여 초기값으로 height / 2 + 1 값 지정
				int middle = height / 2 + 1;
				//i는 0부터 1씩 증가하여 height 전 까지 반복
				for (int i = 0; i < height; i++) {
					// j는 0부터 1씩 증가하여 Math.abs((middle - 1) - i) 전 까지 반복
					// abs()함수 절대값을 활용하여 줄어들고 커짐을 표현
					for (int j = 0; j < Math.abs((middle - 1) - i); j++) {
						//공백문자 출력
						System.out.print(" ");
					}
					// j는 0부터 1씩 증가하여 (i * 2) - Math.max(0, 4 * (i - middle + 1)) + 1 전까지 반복
					// Max()함수를 활용하여 중간값 도달 전까지는 마이너스가 되지 않게 설정
					// Max(a,b) => a,b중 큰 값으로 선정
					for (int j = 0; j < (i * 2) - Math.max(0, 4 * (i - middle + 1)) + 1; j++) {
						// * 문자 출력
						System.out.print("*");
					}
					//줄바꿈
					System.out.println();
					//stop을 true로 설정하여 While문 탈출
					stop = !stop;
				}
				// 정수값을 제외한 다른 값이 들어와 오류 발생시
			} catch (Exception e) {
				// 입력한 값이 유효하지 않은 값임을 알리며 반복문 탈출 실패
				System.err.println(sc.nextLine() + " 는 유효하지 않는 입력값입니다.");
			}
//			height = 7 로 가정		middle = height(7) /2 + 1 => 4	
//			식			Math.abs((middle - 1) - i)		(i * 2) - Math.max(0, 4 * (i - middle + 1)) + 1
//			i(행)				j(공백)										j(별)
//			i=0			|(4-1) - 0| => 3				(0 * 2) - max(0, 4 * (0 - 4 + 1)) + 1 => 0 - 0 + 1 => 1
//			i=1			|(4-1) - 1| => 2				(1 * 2) - max(0, 4 * (1 - 4 + 1)) + 1 => 2 - 0 + 1 => 3
//			i=2			|(4-1) - 2| => 1				(2 * 2) - max(0, 4 * (2 - 4 + 1)) + 1 => 4 - 0 + 1 => 5
//			i=3			|(4-1) - 3| => 0				(3 * 2) - max(0, 4 * (3 - 4 + 1)) + 1 => 6 - 0 + 1 => 7 
//			i=4			|(4-1) - 4| => 1				(4 * 2) - max(0, 4 * (4 - 4 + 1)) + 1 => 8 - 4 + 1 => 5
//			i=5			|(4-1) - 5| => 2				(5 * 2) - max(0, 4 * (5 - 4 + 1)) + 1 => 10- 8 + 1 => 3
//			i=6			|(4-1) - 6| => 3				(6 * 2) - max(0, 4 * (6 - 4 + 1)) + 1 => 12- 12+ 1 => 1
		}
	}
}
