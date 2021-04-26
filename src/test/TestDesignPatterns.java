package test;

/**
 * @author YZX
 * @date 2019年9月9日
 * @time 下午8:22:59
 */

public class TestDesignPatterns {

	public TestDesignPatterns() {
		
	}
	
}
//单例设计模式
//public class Singleton {
//	private Singleton singleton;
//	private Singleton() {}
//	public Singleton getinstance() {
//		if(singleton == null) {
//			singleton = new Singleton();
//		}
//		return singleton;
//	}
//}

//懒汉式写法（线程安全）
//public class Singleton({
//	private static Singleton singleton;
//	private Singleton () {}
//	puiblic static synchronized Singleton getInstance() {
//		if(singleton == null) {
//			singleton = new Singleton();
//		}
//		return singleton;
//	}
//}

//饿汉式写法
//public class Singleton {
//	private static Singleton singleton = new Singleton();
//	private Singleton() {}
//	public static Singleton getInstance() {
//		return singleton;
//	}

//静态内部类
//public class Singleton{
//	public class SingletonHolder{
//		private static final Singleton INSTANCE = new Singleton();
//		}
//		private Singleton() {};
//		private static final Singleton getInstance() {
//			return SingletonHolder.INSTANCE;
//		}
//}

//枚举方法
//enum Singleton{
//	INSTANCE;
//	public void otherMethods() {
//		System.out.println("Something");
//	}
//}
//public class Hello{
//	public static void main(String[] args) {
//		Singleton.INSTANCE.otherMethods();
//	}
//}

//双重校验锁法
//public class Singleton{
//	private volatile static Singleton instance;
//	private Singleton() {}
//	private static Singleton getInstance() {
//		if(instance == null) {
//			synchronized (Singleton.class){
//			if(instance == null) {
//				instance = new Singleton();
//				}
//			}
//		}
//		return instance;
//	}
//}

//观察者模式 小王小李小美的故事。观察者实现接口，被观察者调用接口

//装饰者模式 三明治的做法 用户使用的时候任意组装
//public class Food {
//
//	   private String food_name;
//
//	   public Food() {
//	   }
//
//	   public Food(String food_name) {
//	       this.food_name = food_name;
//	   }
//
//	   public String make() {
//	       return food_name;
//	   };
//	}

//适配器模式 变压器220V->5V给手机充电
//public class Test {
//	   public static void main(String[] args) {
//	       Phone phone = new Phone();
//	       VoltageAdapter adapter = new VoltageAdapter();
//	       phone.setAdapter(adapter);
//	       phone.charge();
//	   }
//	}
//
//	// 手机类
//	class Phone {
//
//	   public static final int V = 220;// 正常电压220v，是一个常量
//
//	   private VoltageAdapter adapter;
//
//	   // 充电
//	   public void charge() {
//	       adapter.changeVoltage();
//	   }
//
//	   public void setAdapter(VoltageAdapter adapter) {
//	       this.adapter = adapter;
//	   }
//	}
//
//	// 变压器
//	class VoltageAdapter {
//	   // 改变电压的功能
//	   public void changeVoltage() {
//	       System.out.println("正在充电...");
//	       System.out.println("原始电压：" + Phone.V + "V");
//	       System.out.println("经过变压器转换之后的电压:" + (Phone.V - 200) + "V");
//	   }
//	}

//工厂模式
	//简单工厂模式：一个抽象的接口，多个抽象接口的实现类，一个工厂类，用来实例化抽象的接口
////抽象产品类
//abstract class Car{
//	public void run() ;
//	public void stop() ;
//}
////具体实现类
//class Benz implements Car {
//	public void run() {
//		System.out.println("Benz555");
//	}
//	public void stop() {
//		System.out.println("Benzyuuuu");
//	}
//}
//class Ford implements Car {
//	public void run() {
//		System.out.println("Ford555");
//	}
//	public void stop() {
//		System.out.println("Fordyuuuu");
//	}
//}
////工厂类
//class Factory{
//	public static Car getCarInstance(String type) {
//		Car c = null;
//		if("Benz".equals(type)) {
//			c = new Benz();
//		}
//		if ("Ford".equals(type)) {
//			c = new Ford();
//		}
//		return c;
//	}
//}
//public class Test{
//	public static void main(String []args) {
//		Car c = Factory.getCarInstance("Benz");
//		if(c != null) {
//			c.run();
//			c.stop();
//		} else {
//			System.out.println("cannot");
//		}
//	}
//}
	//工厂方法模式：有四个角色，抽象工厂模式，具体工厂模式，抽象产品模式，具体产品模式。
		//不再是由一个工厂类去实例化具体的产品，而是由抽象工厂的子类去实例化产品
//抽象产品角色
//public interface Moveable {
//void run();
//}
//
////具体产品角色
//public class Plane implements Moveable {
//@Override
//public void run() {
//    System.out.println("plane....");
//}
//}
//
//public class Broom implements Moveable {
//@Override
//public void run() {
//    System.out.println("broom.....");
//}
//}
//
////抽象工厂
//public abstract class VehicleFactory {
//abstract Moveable create();
//}
//
////具体工厂
//public class PlaneFactory extends VehicleFactory {
//public Moveable create() {
//    return new Plane();
//}
//}
//
//public class BroomFactory extends VehicleFactory {
//public Moveable create() {
//    return new Broom();
//}
//}
//
////测试类
//public class Test {
//public static void main(String[] args) {
//    VehicleFactory factory = new BroomFactory();
//    Moveable m = factory.create();
//    m.run();
//}
//}
	//抽象工厂模式 与工厂方法模式不同的是，工厂方法模式中的工厂只生产单一的产品，
		//而抽象工厂模式中的工厂生产多个产品
//抽象工厂类
//public abstract class AbstractFactory{
//	public abstract Vehicle createVehicle();
//	public abstract Weapon createWeapon();
//	public abstract Food craeteFood();
//}
////具体工厂类
//public class DefaultFactory extends AbstractFactory{
//	public Food createFood() {
//		return new Apple();
//	}
//	public Weapon createWeapon() {
//		return new AK47();
//	}
//	public Vehicle createVehicle() {
//		return new Car(); 
//	}
//}
//public class Test{
//	public static void main(String[ args) {
//		AbstractFactory f = new DefaultFactory();
//		Vehicle v = f.createVehicle();
//		v.run();
//		Weapon w = f.createWeapon();
//		w.shoot();
//		Food a = f.craeteFood();
//		a.printName();
//	}
//}

//代理模式
//public interface ProxyInterface{
//	void marry();
//}
//public class WeddingCompany implements proxyInterface{
//	private ProxyInterface proxyInterface;
//	public WeddingCompany(ProxyInterface proxyInterface) {
//		this.proxyInterface = proxyInterface;
//	}
//	public void marry() {
//		System.out.println("company working...");
//		System.out.println("company working...");
//		System.out.println("company working...");
//		proxyInterface.marry();
//		System.out.println("company working...");
//		System.out.println("company working...");
//	}
//}
//public class NormalHome implements ProxyInterface{
//	public void marry() {
//		System.out.println("we marry!");
//	}
//}
//public class Test{
//	public static void main(String[] args) {
//		ProxyInterface proxyInterface  = new WeddingCompany(new NormalHome());
//		proxyInterface.marry();
//	}
//}