package CH18;

class Buyer{
	private int myMoney;
	private int appleCnt;
	
	public Buyer(int myMoney, int appleCnt) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
	}

	public void payment(Seller seller, int money) {
		this.myMoney -= money;
		this.appleCnt += seller.receive(money);
	}
	
	@Override
	public String toString() {
		return "Buyer [myMoney=" + myMoney + ", appleCnt=" + appleCnt + "]";
	}
	
}
class Seller{
	private int myMoney;
	private int appleCnt;
	private int price;
	
	public Seller(int myMoney, int appleCnt, int price) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
		this.price = price;
	}

	public int receive(int money) {
		this.myMoney += money;
		int sellAppleCount = money/this.price;
		this.appleCnt -= sellAppleCount;
		return sellAppleCount;
	}

	@Override
	public String toString() {
		return "Seller [myMoney=" + myMoney + ", appleCnt=" + appleCnt + ", price=" + price + "]";
	}
}

public class Ex {
	public static void main(String[] args) {
		Buyer 홍길동 = new Buyer(10000,0);
		Buyer 철수 = new Buyer(20000,0);
		
		Seller 사과장수 = new Seller(100000,100,1000);
		
		홍길동.payment(사과장수, 5000);
		철수.payment(사과장수, 12000);
		
		System.out.println(홍길동);
		System.out.println(철수);
		System.out.println(사과장수);
	}
}
