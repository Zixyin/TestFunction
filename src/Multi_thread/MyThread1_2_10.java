package Multi_thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YZX
 * @date 2019年11月13日
 * @time 上午9:41:03
 */

public class MyThread1_2_10 extends Thread{
	volatile int voint = 1;
	private int i = 5;
	public void run() {
		 //i--;
//		try {
//			sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("i = " + i-- + ";" + Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		MyThread1_2_10 thread = new MyThread1_2_10();
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		Thread t1 = new Thread(thread);
		Thread t2 = new Thread(thread);
		Thread t3 = new Thread(thread);
		Thread t4 = new Thread(thread);
		Thread t5 = new Thread(thread);
		lock.unlock();
		
		t1.start();
		t1.setName("abd");
//		t2.start();		
//		t3.start();
//		t4.start();
//		t5.start();
	}
}