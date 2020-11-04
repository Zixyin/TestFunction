package Multi_thread;

/**
 * @author YZX
 * @date 2020年2月11日
 * @time 上午10:32:28
 */

public class test {
	public static void main(String[] args) {
		Thread t = new Thread(new MyThread(),"myThread");
		t.start();
	}
}

class MyThread extends Thread{
	public MyThread() {          
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(currentThread().getName());
		System.out.println(this.getName());
		StackTraceElement[] a = Thread.currentThread().getStackTrace();
		for(StackTraceElement s:a) {
			System.out.println(s.getClassName() + "\t" + s.getMethodName() + "\t" + s.getFileName());
		}
	}
}