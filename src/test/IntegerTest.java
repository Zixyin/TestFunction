package test;

/**
 * @author YZX
 * @date 2019年10月17日
 * @time 下午4:57:37
 */

public class IntegerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int i1 = 11;
			Integer i2 = 11;
			Integer i3 = 11;
			Integer i4 = new Integer(11);
			Integer i5 = new Integer(11);
			Integer i6 = 128;
			Integer i7 = 128;
			System.out.println(i1 == i2); //	T
			System.out.println(i2 == i3); //	T
			System.out.println(i1 == i4); //	T
			System.out.println(i3 == i4); //	F
			System.out.println(i4 == i5); //	F
			//包装类的"=="运算在遇到算数运算的情况下会自动拆箱
			System.out.println(i4 == (i5 + 0)); //	T
			System.out.println(i5 == i6); //	F
			System.out.println(i6 == i7); //	F
			System.out.println(i3.equals(i4));//T
			System.out.println(i4.equals(i5));//T
			System.out.println(i6.equals(i7));//T
			System.out.println("********************");
			String s = "aaa";
			String s1 = "aaa";
			String s2 = new String("aaa");
			String s3 = new String("aaa");
			System.out.println(s == s1);		//T
			System.out.println(s.equals(s1));	//T
			System.out.println(s == s2);		//F
			System.out.println(s.equals(s2));	//T
			System.out.println(s2 == s3);		//F
			System.out.println(s2.equals(s3));	//T
			int  i = 3;
			switch(i) {
			case 1:System.out.println("1");
			case 2:System.out.println("2");break;
			case 3:System.out.println(("3"));
			case 4:System.out.println("4");break;
			}
			/**
			 * out:
			 * 		3
			 * 		4
			 */
	}

}
