package test;


public class SubStringTest {
	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
		for(int i = 0;i < Integer.MAX_VALUE/2;i ++)
			sb1.append("#");
		for(int i = 0;i < 20000;i ++)
			sb2.append("#");
		long s = System.nanoTime();
		sb1.substring(0, 5000);
		long e = System.nanoTime();
		System.out.println(e - s);
		System.out.println("********************");
		s = System.nanoTime();
		sb2.substring(0, 5000);
		e = System.nanoTime();
		System.out.println(e - s);
	}
}
