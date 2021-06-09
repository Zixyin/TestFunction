package test;

import java.lang.reflect.InvocationTargetException;

public class ClassforNameTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> class1 = Class.forName("test.Fun");
		System.out.println("*****************");
		class1.newInstance();
		System.out.println("*****************");
		class1.getConstructor(String.class).newInstance("123");
		System.out.println("*****************");
		class1.getConstructor().newInstance();
		System.out.println("*****************");
		new Fun();
	}
}

class Fun {
	static {
		System.out.println("load static block");
	}
	{
		System.out.println("load block");
	}
	public Fun() {
		System.out.println("come into construction");
	}
	public Fun(String s) {
		System.out.println("come into construction" + s);
	}
}