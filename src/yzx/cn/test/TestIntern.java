package yzx.cn.test;

/**
 * @author YZX
 * @date 2020年10月8日
 * @time 下午8:10:54
 */

public class TestIntern {
	public static void main(String[] args) {
		String s1 = new String("java");
		String s2 = new String("计算机网络");
		String s3 = "java";
		String s4 = "计算机网络";
		System.out.println(s1.intern() == s1);
		System.out.println(s2.intern() == s2);
		System.out.println(s1.intern() == s3);
		System.out.println(s2.intern() == s4);
	}
}
