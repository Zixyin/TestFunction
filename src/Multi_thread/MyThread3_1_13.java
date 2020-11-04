package Multi_thread;

/**
 * notify线程顺序
 * 
 * @author YZX
 * @date 2020年2月16日
 * @time 上午10:00:51
 */

public class MyThread3_1_13 {
	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();
		for(int i = 0;i < 10;++ i) {
			ThreadA ta = new ThreadA(service);
			ta.start();
		}
		Thread.sleep(1000);
		ThreadB tb1 = new ThreadB(service);
		tb1.start();
		Thread.sleep(50);
		ThreadB tb2 = new ThreadB(service);
		tb2.start();
		Thread.sleep(50);
		ThreadB tb3 = new ThreadB(service);
		tb3.start();
		Thread.sleep(50);
		ThreadB tb4 = new ThreadB(service);
		tb4.start();
		Thread.sleep(50);
		ThreadB tb5 = new ThreadB(service);
		tb5.start();
	}
}

class MyService{
	private Object lock = new Object();
	public void waitMethod() {
		try {
			synchronized(lock) {
				System.out.println("begin wait:" + Thread.currentThread().getName());
					lock.wait();
				System.out.println("end wait:" + Thread.currentThread().getName());
				} 
			}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void notifyMethod() {
		synchronized(lock) {
			System.out.println("begin notify:" + Thread.currentThread().getName());
			lock.notify();
			System.out.println("end notify:" + Thread.currentThread().getName());
		}
	}
}

class ThreadA extends Thread{
	private MyService service;
	public ThreadA(MyService service) {
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.waitMethod();
	}
}

class ThreadB extends Thread{
	private MyService service;
	public ThreadB(MyService service) {
		this.service = service;
	}
	public void run() {
		service.notifyMethod();
	}
}



