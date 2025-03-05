package CH08;

class C07Simple{
	int sum(Object ...arg) {
		int sum = 0;
//		for(int i = 0; i<arg.length;i++) {
//			sum += arg[i];
//		}
		for(Object item : arg) {
			sum += (int)item;
		}
		return sum;
	}
}

public class C07가변인자 {
	public static void main(String[] args) {
		C07Simple ob = new C07Simple();
		System.out.println(ob.sum(10,20,30,40,50,670,23523,50,62406,2356));
		System.out.println(ob.sum(10,20,50,60,324,46,2436));
	}
}
