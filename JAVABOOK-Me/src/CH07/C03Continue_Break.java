package CH07;

public class C03Continue_Break {
	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		while(i<=10) {
			if(i%3==0) {
				System.out.println("i : "+i);
				sum+=i;
			}
			i++;
		}
		System.out.println("Sum : "+sum);
	}
}
