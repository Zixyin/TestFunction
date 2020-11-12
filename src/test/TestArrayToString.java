package test;

import java.util.Arrays;

public class TestArrayToString {
	public static void main(String[] args) {
		String s = Arrays.toString("ABC DEF".split(" ")).replace(" ", "");
		System.out.println(s.substring(1, s.length() - 1));
	}
}