package CH12;

class Point2D {
	int x;
	int y;

	Point2D() {
		System.out.println("Point2D 디폴트 생성자 호출!");
	}

	Point2D(int x) {
		this.x = x;
		System.out.println("Point2D(int x) 생성자 호출!");
	}

	Point2D(int x,int y) {
		this.x = x;
		this.y = y;
		System.out.println("Point2D(int x, int y) 생성자 호출!");
	}
}

class Point3D extends Point2D {
	int z;

	Point3D() {
		super(); // 상위 클래스 Point2D() 생성자 호출
		System.out.println("Point3D 디폴트 생성자 호출!");
	}
	Point3D(int x) {
		super(x);
		System.out.println("Point3D(int x) 생성자 호출!");
	}
	Point3D(int x,int y) {
		super(x,y);
		System.out.println("Point3D(int x, int y) 생성자 호출!");
	}
	Point3D(int x,int y, int z) {
		super(x,y);
		this.z = z;
		System.out.println("Point3D(int x, int y, int z) 생성자 호출!");
	}

	@Override
	public String toString() {
		return "Point3d [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}

public class C02InheritanceMain {
	public static void main(String[] args) {
		Point3D ob1 = new Point3D();
		System.out.println(ob1);
	}
}
