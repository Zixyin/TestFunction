package Multi_thread;

/**
 * @author YZX
 * @date 2019年11月12日
 * @time 下午4:28:18
 */

public class MyThread1_2_8 extends Thread{
	private int count = 5;
	public MyThread1_2_8(String name){
		super();
		this.setName(name);
	}
	public void run(){
		super.run();
		while(count > 0) {
			count --;
			System.out.println(this.currentThread().getName() + ":count = " + count);
		}
	}
	public static void main(String[] args) {
		MyThread1_2_8 A = new MyThread1_2_8("A");
		MyThread1_2_8 B = new MyThread1_2_8("B");
		MyThread1_2_8 C = new MyThread1_2_8("C");
		A.start();
		B.start();
		C.start();
		MyThread1 thread = new MyThread1();
		Thread t1 = new Thread(thread, "A");
		Thread t2 = new Thread(thread, "B");
		Thread t3 = new Thread(thread, "C");
		Thread t4 = new Thread(thread, "C");
		Thread t5 = new Thread(thread, "C");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}

class MyThread1 extends Thread{
	private int count = 5;
	public MyThread1(){	}
	synchronized public void run() {
		super.run();
		count --;
		System.out.println(this.currentThread().getName() + ":***********count = " + count);
	}
}