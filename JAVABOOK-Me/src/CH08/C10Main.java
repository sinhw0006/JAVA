package CH08;
//홍길동이					-			사과장수에게 사과를 구매한다
//구매자					-			판매자
//보유금액(속성)						보유금액(속성)
//사과개수(속성)						사과개수(속성)
//									개당가격(속성)	

//구매하기(기능)						판매하기(기능)
//1)사과장수에게 돈을 준다(내 금액 차감)		
//									2)
//
//
//
class Buyer{
	private int myMoney;
	private int appleCnt;
	public Buyer(int myMoney, int appleCnt) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
	}
	@Override
	public String toString() {
		return "Buyer [myMoney=" + myMoney + ", appleCnt=" + appleCnt + "]";
	}
	
	public void payment(Seller seller, int money) {
		this.myMoney -= money;
		this.appleCnt = seller.receive(money);
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
	@Override
	public String toString() {
		return "Sellect [myMoney=" + myMoney + ", appleCnt=" + appleCnt + ", price=" + price + "]";
	}
	
	public int receive(int money) {
		//구매자로부터 전달 받은 money를 내 보유금액에 누적
		this.myMoney += money;
		this.appleCnt -= money/price;
		//전달받은금액 / 사과개수를 리턴
		return money/price; 
	}
	
}

public class C10Main {
	public static void main(String[] args) {
		   Seller seller = new Seller(10000, 100, 1000);
		   Buyer 홍길동 = new Buyer(10000, 0);
		   Buyer 노홍철 = new Buyer(5000, 0);
		   
		   홍길동.payment(seller, 5000);
		   노홍철.payment(seller, 2000);
		   
		   System.out.println(홍길동);
		   System.out.println(노홍철);
		   System.out.println(seller);
		}
}
