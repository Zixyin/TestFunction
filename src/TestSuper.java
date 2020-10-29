
public class TestSuper {
	void f() {
		System.out.println("TestSuper");
	}
	class B extends A{
		public B() {
			f();
			super.f();
			TestSuper.this.f();
		}
		void f() {
			System.out.println("BBB");
		}
	}
	public static void main(String[] args) {
		TestSuper.B b = new TestSuper().new B();
	}
}

class A{
	void f() {
		System.out.println("AAA");
	}
}
class C extends A{
	
}