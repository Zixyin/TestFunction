package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestCountDownLatch {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(10);
		for(int i = 0;i < 3;++ i) {
			exec.execute(new Work(latch));
		}
		for(int i = 0;i < 10;++ i) {
			exec.execute(new Portion(latch));
		}
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exec.shutdownNow();
		System.out.println("all work is done");
	}
}

class Portion implements Runnable {
	private static int count = 0;
	private final int id = count ++;
	private final CountDownLatch latch;
	public Portion(CountDownLatch latch) {
		this.latch = latch;
	}
	public void doWork() {
		System.out.println("portion: " + id + "is done");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		doWork();
		latch.countDown();
	}
}
class Work implements Runnable {
	private static int count = 0;
	private final int id = count ++;
	private final CountDownLatch latch;
	public Work(CountDownLatch latch) {
		this.latch = latch;
	}
	public void doWork() {
		System.out.println("work: " + id + "is done");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			latch.await();
			doWork();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println("is interrupted");
		}
	}
}