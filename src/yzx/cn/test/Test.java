package yzx.cn.test;

/**
 * @author YZX
 * @date 2019年9月19日
 * @time 上午7:54:50
 */

public class Test {
	public static void main(String[] args) {
		Integer integer = new Integer(1);
		System.out.println(integer instanceof  Integer);//true

		Integer i = 128;
		int ii = 128;
		System.out.println(i == ii);
		
		new ChildClass().f();
	}
}

class FatherClass {
	public int value;

	public void f() {
		value = 100;
		System.out.println("FatherClass.value=" + value);
	}

}

class ChildClass extends FatherClass {
	public int value;

	public void f() {
		super.f();
		value = 200;
		System.out.println("ChildClass.value=" + value);
		System.out.println(value);
		System.out.println(super.value);
	}
}