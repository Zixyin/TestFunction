package yzx.cn.test;

/**
 * @author YZX
 * @date 2019年9月19日
 * @time 上午7:59:37
 */

public class TestPolym {
	public static void main(String[] args) {
		Animal animal = new Dog(); // 向上可以自动转型
		System.out.println(animal.age); // 属性调用时，仍然是基类的属 性。属性没有多态！
// animal.shout();
		animalCry(new Dog());
//传的具体是哪一个类就调用哪一个类的方法。大大提高了程序的可扩展性。 //如果没有多态，我们这里需要写很多重载的方法。如果增加一种动物，就需要重载一种动物的喊叫方法。非常麻烦。 
		// 有了多态，只需要增加这个类继承Animal基类就可以了。
		animalCry(new Cat());
		Dog dog = (Dog) animal;
//编写程序时，如果想调用运行时类型的方法，只能进行类型转换。不然通不过编译器的检查。 dog.gnawBone();
		System.out.println(dog instanceof Animal);
		System.out.println(animal instanceof Cat);
		System.out.println(animal instanceof Dog);
	}

	static void animalCry(Animal a) {
		a.shout();
	}
}

class Animal {
	int age = 10;

	public void shout() {
		System.out.println("叫了一声！");
	}
}

class Dog extends Animal {
	int age = 28;

	public void shout() {
		System.out.println("旺旺旺！");
	}

public void gnawBone(){ 
 System.out.println("我在啃骨头");
}
}

class Cat extends Animal {
	int age = 18;

	public void shout() {
		System.out.println("喵喵喵喵！");
	}
}