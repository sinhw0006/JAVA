package CH00;

import java.util.UUID;
public class test {

	public static void main(String[] args) {
		String[] a = UUID.randomUUID().toString().split("-");
		System.out.println(a[0]);
	}
}
