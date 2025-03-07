package CH12;

import java.time.temporal.IsoFields;

class A{int a;

@Override
public String toString() {
	return "A [a=" + a + "]";
	
}

public A(int a) {
	super();
	this.a = a;
}}
class B extends A {int b;

public B(int a, int b) {
	super(a);
	this.b = b;
}

@Override
public String toString() {
	return "B [b=" + b + ", a=" + a + "]";
}}
class C extends A {int c;

public C(int a, int c) {
	super(a);
	this.c = c;
}

@Override
public String toString() {
	return "C [c=" + c + ", a=" + a + "]";
}}
class D extends B {int d;

public D(int a, int b, int d) {
	super(a, b);
	this.d = d;
}

@Override
public String toString() {
	return "D [d=" + d + ", b=" + b + ", a=" + a + "]";
}}
class E extends B {int e;

public E(int a, int b, int e) {
	super(a, b);
	this.e = e;
}

@Override
public String toString() {
	return "E [e=" + e + ", b=" + b + ", a=" + a + "]";
}}
class F extends C {int f;

public F(int a, int c, int f) {
	super(a, c);
	this.f = f;
}

@Override
public String toString() {
	return "F [f=" + f + ", c=" + c + ", a=" + a + "]";
}}
class G extends C {int g;

public G(int a, int c, int g) {
	super(a, c);
	this.g = g;
}

@Override
public String toString() {
	return "G [g=" + g + ", c=" + c + ", a=" + a + "]";
}}

public class C07UpDownCastingMain {
	
	public static void UpDownCastTestFunc(A obj, int ...arg) {
		obj.a=arg[0];
		if(obj instanceof B) {
			B down = (B)obj;
			down.b=arg[1];
		}  if(obj instanceof C) {
			C down = (C)obj;
			down.c=arg[1];
		}  if(obj instanceof D) {
			D down = (D)obj;
			down.b=arg[1];
			down.d=arg[2];
		}  if(obj instanceof E) {
			E down = (E)obj;
			down.b=arg[1];
			down.e=arg[2];
		}  if(obj instanceof F) {
			F down = (F)obj;
			down.c=arg[1];
			down.f=arg[2];
		}  if(obj instanceof G) {
			G down = (G)obj;
			down.c=arg[1];
			down.g=arg[2];
		}
		System.out.println(obj);
	}
	public static void main(String[] args) {
		A ob1 = new A(0);
		B ob2 = new B(0,0);
		C ob3 = new C(0,0);
		D ob4 = new D(0,0,0);
		E ob5 = new E(0,0,0);
		F ob6 = new F(0,0,0);
		G ob7 = new G(0,0,0);
		UpDownCastTestFunc(ob1,10);
		UpDownCastTestFunc(ob2,20,30);
		UpDownCastTestFunc(ob3,40,50);
		UpDownCastTestFunc(ob4,60,70,80);
		UpDownCastTestFunc(ob5,90,100,110);
		UpDownCastTestFunc(ob6,120,130,140);
		UpDownCastTestFunc(ob7,150,160,170);
		
	}
}