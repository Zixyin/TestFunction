package Multi_thread;

/**
 * @author YZX
 * @date 2019年11月13日
 * @time 上午10:06:31
 */

public class MyThread1_3 extends Thread{
	public MyThread1_3(){
		System.out.println("Thread.currentThread().getName()" + Thread.currentThread().getName());
		System.out.println("this.getName()" + this.getName());
	}
	public void run(){
		System.out.println("Thread.currentThread().getName()" + Thread.currentThread().getName());
		System.out.println("this.getName()" + this.getName());
	}
	public static void main(String[] args) {
		MyThread1_3 thread = new MyThread1_3();
		thread.setName("A");
		thread.start();
		MyThread1_3 thread2 = new MyThread1_3();
		Thread t = new Thread(thread2,"B");
		t.start();
	}
}
