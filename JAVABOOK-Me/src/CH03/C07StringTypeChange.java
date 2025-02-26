package CH03;

import java.util.ArrayList;

public class C07StringTypeChange {
	public static void main(String[] args) {
		System.out.println("문자열1"+"문자열2");
		System.out.println("문자열1"+","+"문자열2");
		System.out.println("문자열1"+ 2);
		System.out.println("문자열1"+','+'!');
		System.out.println(','+'!'+"문자열1");
		
		System.out.println("10"+"20");
		int n1 = Integer.parseInt("10");
		int n2 = Integer.parseInt("20");
		System.out.println(n1+n2);
		
		double n3 = Double.parseDouble("10.5");
		double n4 = Double.parseDouble("20.4");
		System.out.println(n3+n4);
		
		short n5 = Short.parseShort("5");
		short n6 = Short.parseShort("6");
		System.out.println(n5+n6);
		String rny_string = "mom";
		String answer = "";
		for(int i = 0; i<rny_string.length(); i++) {
			if(rny_string.charAt(i) == 'm') {
				answer += "rm";
			} else {
				answer += rny_string.charAt(i);
			}
		}
	}
}
