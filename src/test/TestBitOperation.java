package test;

import java.util.Scanner;

public class TestBitOperation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while(sc.hasNextInt()) {
			n = sc.nextInt(); 
			System.out.println(n + " & 1 : " + (n & 1));
			System.out.println(n + " | 1 : " + (n | 1));
			System.out.println(n + " ^ 1 : " + (n ^ 1));
		}
	}
}
