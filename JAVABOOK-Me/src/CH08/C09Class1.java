package CH08;

class TV {
	String comp;
	int year;
	int inc;
	
	TV(String string, int i, int j) {
		this.comp = string;
		this.year = i;
		this.inc = j;
	}

	void show() {
		System.out.println(this.comp+"에서 만든 "+this.year+"년 "+this.inc+"인치");
	}
};

public class C09Class1 {
	public static void main(String[] args) {
		TV myTV = new TV("LG", 2017, 32); //LG에서 만든 2017년 32인치
		   myTV.show();
	}
}
