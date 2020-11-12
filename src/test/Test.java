package test;

public class Test {
	public static void main(String[] args) {
		System.out.println(f());
	}
	public static int f() {
		int a = 0;
		try {
			int i = 5/0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR");
			return a++;
		} finally {
			a++;
			return a++;
		}
	}
}
