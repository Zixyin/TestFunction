package test;

public class RuntimeExceptionTest {
	public static void main(String[] args) {
		runtime();
		checked();
		runtimeUpCast();
	
	}
	static void runtime() {
		try {
			throw new RuntimeException();
		} catch (RuntimeException e) {
			System.out.println("catch RuntimeException");
		}
		System.out.println("after catch RuntimeException");
	}
	static void checked() {
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("catchException");
		}
		System.out.println("after catch Exception");
	}
	static void runtimeUpCast() {
		try {
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("catch RuntimeExceptionUpCast");
		}
		System.out.println("after catch RuntimeExceptionUpCast");
	}
}

