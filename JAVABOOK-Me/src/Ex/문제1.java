package Ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//sort : 오름차순/내림차순
//add : 단어추가
//show : 저장된 단어 확인
public class 문제1 {
	private static Scanner sc = new Scanner(System.in);
	private static List<String> wordList = new ArrayList<String>();

	public static void sort(boolean isAsend) {
		Collections.sort(wordList); //오름차순
		if (!isAsend) Collections.reverse(wordList);//내림차순
	}

	public static void add(String word) {
		boolean isWord = false;
		for (String string : wordList) {
			if (string.equals(word)) {
				System.err.println("\""+word +"\"는 이미 추가된 단어입니다.");
				isWord = true;
			}
		}
		if (!isWord) {
			wordList.add(word);
		}
	}

	public static void show() {
		int count = 0;
		for (String string : wordList) {
			System.out.printf("%03d) \t %s\n",++count,string);
		}
	}

	public static boolean isValue() {
		if(wordList.size() !=0) return false;
		System.err.println("입력된 값이 없습니다.");
		return true;
	}

	public static void main(String[] args) {
		int n = 0;
		boolean memuStop = false;
		boolean memuAdd = false;
		while (!memuStop) {
			try {
				System.out.println("=========== M E N U ===========");
				System.out.println("1. 추가");
				System.out.println("2. 정렬");
				System.out.println("3. 확인");
				System.out.println("4. 종료");
				System.out.println("=========== M E N U ===========");
				System.out.print("번호 : ");
				n = sc.nextInt();
				switch (n) {
				case 1:
					while (!memuAdd) {
						System.out.print("단어 입력(입력 중지 -> !) : ");
						String word = sc.next();
						System.out.println(word);
						if (word.equals("!")) {
							memuAdd = !memuAdd;
						} else {
							add(word);
						}
					}
					memuAdd = !memuAdd;
					break;
				case 2:
					if(isValue()) break;
					System.out.print("오름차순 여부(오름차순 -> 1 / 내림차순 -> 2 ) : ");
					int no = sc.nextInt();
					if (no == 1)
						sort(true);
					else
						sort(false);
					break;
				case 3:
					if(isValue()) break;
					show();
					break;
				case 4:
					System.out.println("종료합니다");
					sc.close();
					memuStop = !memuStop;
					break;
				default:
					System.out.println("다시 입력하세요");
				}
			} catch (InputMismatchException e) {
				System.err.println("숫자를 입력해주세요");
				sc.nextLine();
			}
		}
	}
}
