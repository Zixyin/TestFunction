package test;

public class SplitTest {
	public static void main(String[] args) {
		for(String s : "asd".split(","))
			System.out.println(s);
		System.out.println("".split("-")[0]);
		System.out.println("".split("-")[1]);
	}
}
