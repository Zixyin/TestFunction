package Multi_thread;

/**
 * notifyAll线程顺序
 * 
 * @author YZX
 * @date 2020年2月16日
 * @time 上午10:00:51
 */

public class MyThread3_1_14 {
	public static void main(String[] args) throws InterruptedException {
		MyService3_1_14 service = new MyService3_1_14();
		for(int i = 0;i < 10;++ i) {
			ThreadA3_1_14 ta = new ThreadA3_1_14(service);
			ta.start();
		}
		Thread.sleep(1000);
		ThreadB3_1_14 tb1 = new ThreadB3_1_14(service);
		tb1.start();
	}
}

class MyService3_1_14{
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
			lock.notifyAll();
			System.out.println("end notify:" + Thread.currentThread().getName());
		}
	}
}

class ThreadA3_1_14 extends Thread{
	private MyService3_1_14 service;
	public ThreadA3_1_14(MyService3_1_14 service) {
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.waitMethod();
	}
}

class ThreadB3_1_14 extends Thread{
	private MyService3_1_14 service;
	public ThreadB3_1_14(MyService3_1_14 service) {
		this.service = service;
	}
	public void run() {
		service.notifyMethod();
	}
}



