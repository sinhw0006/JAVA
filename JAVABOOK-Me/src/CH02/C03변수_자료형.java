package CH02;

public class C03변수_자료형 {
	public static void main(String[] args) {
		
		// Data(수,자료) : 선 저장 / 후 처리
		// 변수 : 개발자의 유지보수 측면에서 바뀔 예정이 큰 수
		// 변수명 : 저장되어져 있는 변수 공간에 접근하기 위한 문자 형태의 주소
		// 자료형 : Data(수,자료)를 저장하기 위한 공간을 형성하는 예약어(+제약조건)
		
		
		int num1;								//	4byte 정수 공간 형성 + num1 이름 부여
		num1 = 2147483647;						//	10 리터럴 상수값 상수 Pool에 저장, num1공간에 값 대입
		int num2 = 1;							//	4 리터럴 상수값 상수 Pool에 저장, 4byte 정수 공간 num2에 초기값으로 대입 num2에 4로 초기화
		int num3 = num1+num2;					//	num1안의 값과 num2안의 값의 + 연산결과 값을 4byte 정수 공간 num3에 초기화
		System.out.println(num3+2147483647);	//	num3안의 값을 println
	}
}
