package CH12.ex;

// Exercise 3: Multi Level
class Shape {
    void draw() {
        System.out.println("도형을 그립니다");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("원을 그립니다");
    }
    
    void calculateArea() {
        System.out.println("원의 넓이를 계산합니다");
    }
}

class ColoredCircle extends Circle {
    void draw() {
        System.out.println("색칠된 원을 그립니다");
    }
    
    void applyColor() {
        System.out.println("원에 색을 칠합니다");
    }
}

public class Ex03MultiLevel {
    public static void main(String[] args) {
        System.out.println("=== 연습문제 3: 다중 레벨 ===");
        // 문제: 다음 단계를 수행하는 코드를 작성하세요
        // 1. ColoredCircle 인스턴스를 생성하고 Shape 타입으로 업캐스팅하세요
        ColoredCircle a = new ColoredCircle();
        Shape b = a;
        // 2. 업캐스팅된 참조로 draw() 메서드를 호출해보세요
        b.draw();
        // 3. Shape -> Circle로 다운캐스팅하고 calculateArea() 메서드를 호출해보세요
        Circle c = (Circle)b;
        c.calculateArea();
        // 4. Circle -> ColoredCircle로 다운캐스팅하고 applyColor() 메서드를 호출해보세요
        ColoredCircle d = (ColoredCircle)c;
        d.applyColor();
        // 5. 각 단계에서 어떤 메서드에 접근 가능한지 확인해보세요
        
        // 답안 예시
        Shape shape1 = new ColoredCircle();  // 업캐스팅
//        shape1.draw();  // ColoredCircle의 draw 메서드 호출
        
        Circle circle1 = (Circle)shape1;  // 다운캐스팅
//        circle1.calculateArea();
        
        ColoredCircle coloredCircle1 = (ColoredCircle)circle1;  // 다운캐스팅
//        coloredCircle1.applyColor();
        
        // 실행 결과 예시:
        // 색칠된 원을 그립니다
        // 원의 넓이를 계산합니다
        // 원에 색을 칠합니다
        
        // 추가 실습: 잘못된 다운캐스팅 시도해보기
        Shape basicShape = new Shape();
        //Circle wrongCast = (Circle)basicShape;  // 실행 시 ClassCastException 발생        
    }
} 