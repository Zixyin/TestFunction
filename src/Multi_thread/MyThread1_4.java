package Multi_thread;

/**
 * @author YZX
 * @date 2020年4月25日
 * @time 下午7:47:10
 */

public class MyThread1_4 extends Thread{
	public void run() {
		for(int i = 0;i < 100;i ++)
		System.out.println("myyy" + i);
	}
}

class Run {
	public static void main(String[] args) throws InterruptedException {
		MyThread1_4 mythread = new MyThread1_4();
		//System.out.println(Thread.currentThread().getName() + Thread.currentThread().isAlive());
		//mythread.setName("aaaaaaa");
		for(int i = 0;i < 100;i ++)
			System.out.println("main" + i);
		mythread.start(); 
		mythread.join();
		mythread.isInterrupted();
		//System.out.println(Thread.currentThread().getName() + Thread.currentThread().isAlive());
		}
}