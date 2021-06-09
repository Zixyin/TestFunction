package test;

public class SuperTest {
	void f() {
		System.out.println("TestSuper");
	}
	class B extends A{
		public B() {
			f();
			super.f();
			SuperTest.this.f();
		}
		void f() {
			System.out.println("BBB");
		}
	}
	public static void main(String[] args) {
		SuperTest.B b = new SuperTest().new B();
	}
}

class A{
	void f() {
		System.out.println("AAA");
	}
}
class C extends A{
	
}