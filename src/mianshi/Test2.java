package mianshi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Pattern p = Pattern.compile("-[0-9]+");
		Matcher m = p.matcher(s);
		int result = 0;
		while(m.find()) {
			int val = Integer.parseInt(m.group());
			result += val;
			s = s.replaceFirst(m.group(), "");
		}
		for(char c : s.toCharArray()) {
			if(Character.isDigit(c))
				result += c - '0';
		}
		System.out.println(result);
	}
}
