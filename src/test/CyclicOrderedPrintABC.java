package test;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CyclicOrderedPrintABC {
	static Semaphore sa = new Semaphore(1);
	static Semaphore sb = new Semaphore(0);
	static Semaphore sc = new Semaphore(0);
	public static void main(String[] args) {
		Thread a = new Thread(() -> {
			for(int i = 0;i < 10;i ++) {
				try {
					sa.acquire();
					System.out.println("A");
					sb.release();
					Thread.sleep(new Random(47).nextInt(50));
				} catch (InterruptedException e) {
				}
			}
		});
		Thread b = new Thread(() -> {
			for(int i = 0;i < 10;i ++) {
				try {
					sb.acquire();
					System.out.println("B");
					sc.release();
					Thread.sleep(new Random(47).nextInt(50));
				} catch (InterruptedException e) {
				}
			}
		});
		Thread c = new Thread(() -> {
			for(int i = 0;i < 10;i ++) {
				try {
					sc.acquire();
					System.out.println("C");
					sa.release();
					Thread.sleep(new Random(47).nextInt(50));
				} catch (InterruptedException e) {
				}
			}
		});
		a.start();b.start();c.start();
	}
}
