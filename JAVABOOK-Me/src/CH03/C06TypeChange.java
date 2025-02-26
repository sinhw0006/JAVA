package CH03;

import java.util.ArrayList;

public class C06TypeChange {
	public static void main(String[] args) {
		char n1 = 60000;
		short n2 = (short)n1;
		System.out.println(n2);
		
		int n3 = (char)n2;
		System.out.println(n3);
		
		int[] num_list = {12,4,15,46,38,1,14};
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for(int i = 0; i<num_list.length; i++) {
			answer.add(num_list[i]);
		}
		answer.sort(null);
		while(answer.size() != 5) {
			answer.removeLast();
		}
		System.out.println(answer);
	}
}
