package CH08;

import java.util.Scanner;

class Grade{
	private int math;
	private int science;
	private int english;
	public Grade(int math, int science, int english) {
		super();
		this.math = math;
		this.science = science;
		this.english = english;
	}
	public int average() {
		return (this.math+this.science+this.english)/3;
	}
}

public class C09Class2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		   
		   System.out.print("수학, 과학, 영어 순으로 3개의 정수 입력 >> ");
		   int math = sc.nextInt();
		   int science = sc.nextInt();
		   int english = sc.nextInt();
		   Grade me = new Grade(math, science, english);
		   System.out.println("평균은 "+me.average()); // average()는 평균을 계산하여 리턴
		   
		   sc.close();
		}
	}
