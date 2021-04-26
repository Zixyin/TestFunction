package test;

/**
 * @author YZX
 * @date 2019年9月19日
 * @time 上午8:39:44
 */

/**
 * 获取Class对象的三种方式 1 Object ——> getClass(); 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性 3
 * 通过Class类的静态方法：forName（String className）(常用)
 * 
 */
public class TestReflect {
	public static void main(String[] args) {
		// 第一种方式获取Class对象
		Student stu1 = new Student();// 这一new 产生一个Student对象，一个Class对象。
		Class stuClass = stu1.getClass();// 获取Class对象
		System.out.println(stuClass.getName());
		// 第二种方式获取Class对象
		Class stuClass2 = Student.class;
		System.out.println(stuClass == stuClass2);
		// 第三种方式获取Class对象
		try {
			Class stuClass3 = Class.forName("yzx/cn/test.Student");// 注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
			System.out.println(stuClass3 == stuClass2);// 判断三种方式是否获取的是同一个
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
class Student{
	
}
