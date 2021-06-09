package test;

public class InterruptTest {
	public static void main(String[] args) {
		Thread thread = new Thread() {
			public void run() { 
					for(int i = 0;i < Integer.MAX_VALUE/2;++ i) {
						while(!isInterrupted())
							System.out.println(i);
						//清除标志位
						while(!interrupted())
							System.out.println(i);
					}
				System.out.println("end");
			} 
		};
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("thread interrupted");
		}
		thread.interrupt();
	}
}
