package CH12;

class Parent2 {
    int x = 100;
    Parent2() {
        this(500);
    }
 
    Parent2(int x) {
        this.x = x;
    }
 
    int getX() {
        return x;
    }
}
 
class Child extends Parent2 {
    int x = 4000;
    Child() {
        this(5000);
    }
 
    Child(int x) {
        this.x = x;
    }
}
 
public class C05Ex2125125 {
    public static void main(String[] args) {
        Child obj = new Child();
        System.out.println(obj.getX());
    }
}