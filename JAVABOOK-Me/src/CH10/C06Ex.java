package CH10;

import java.util.Iterator;
import java.util.Scanner;

import javax.imageio.ImageTranscoder;

public class C06Ex {
	//5개의 정수값을 입력받아 int형 배열에 저장하고
	//최대값,최소값,전체합을 출력합니다.
	
	//5 명의 학생에 국영수점수를 입력받아 2차원배열 저장
	//각 학생의 국영수 점수의 합/평균 구하고
	//각 과목당 합 / 평균 구해보시오
	public static void main(String[] args) {
		int[] values = new int[5];
		Scanner scanner = new Scanner(System.in);
		for (int i =0; i<values.length;i++) {
			System.err.print("값을 입력하세요 : ");
			values[i] = scanner.nextInt();
		}
		int max = -2100000000, min = 2100000000, sum=0;
		for (int i : values) {
			if (max<i) {
				max = i;
			}
			if (min>i) {
				min = i;
			}
			sum +=i;
		}
		System.out.println("최대값 : "+max+" / 최소값 : "+min+" / 전체합 : "+sum);
		String[] subject = {"국어", "영어", "수학"};
		int subjectCount = subject.length;
		int sutdentCount = 5;
		int[][] studentScore = new int[sutdentCount][subjectCount];
		for(int i =0; i<sutdentCount;i++) {
			System.out.print((i+1)+"번째 학생의 국,영,수 점수를 입력하세요 : ");
			for(int j = 0; j<subjectCount;j++) {
				studentScore[i][j] = scanner.nextInt();
			}
		}
		int avg = 0;
		int b = 0;
		for (int[] is : studentScore) {
			sum = is[0]+is[1]+is[2];
			avg = sum/subjectCount;
			b++;
			System.out.println(b+"번 학생 점수 합 : "+sum+" / 평균 : "+avg);
		}
		for(int i =0; i<subjectCount; i++) {
			sum = 0;
			for(int j =0; j<sutdentCount; j++) {
				sum += studentScore[j][i];
			}
			avg = sum / sutdentCount;
			System.out.println(subject[i]+"점수 합 : "+sum+" / 평균 : "+avg);
		}
	}
}
