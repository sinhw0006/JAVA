package CH33;

@FunctionalInterface
interface Func1{
	void say(String message);
}

public class C01FunctionalInterfaceMain {
	public static void main(String[] args) {
		Func1 func1 = (message)->{System.out.println(message);};
		func1.say("Hello World!");
		Func1 func1_1 = System.out::println;
		func1_1.say("Hello World!");
		
	}
}
