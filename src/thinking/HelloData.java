package thinking;

import java.util.Date;

/**
 * @author YZX
 * @date 2019年10月14日
 * @time 上午10:41:16
 */

public class HelloData {
	public static void main(String[] args) {
		System.out.print("Hello,its:");
		System.out.println(new Date());
		new ShowProperties().show();
	}
}
class ShowProperties{
	void show() {
	int a = 10;
	int b = 01;
	String s = "asd";
	System.out.println(s + a + b);
	System.out.println(s + (a + b));
	}
}