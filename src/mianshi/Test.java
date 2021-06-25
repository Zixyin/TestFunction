package mianshi;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		s = s.replace(",", "");
		String[] split = s.split("0");
		int result = 0;
		for(String tmp : split) {
			if(tmp == null || tmp == "") {
				continue;
			} else if(tmp.length() >= 1 && tmp.length() <= 3) {
				result ++;
			} else {
				int len = tmp.length();
				result += len / 3;
				len = len % 3;
				result += len / 2;
				len = len % 2;
				result += len;
			}
		}
		System.out.println(result);
	}
}
