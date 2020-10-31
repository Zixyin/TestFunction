package Multi_thread;

/**
 * @author YZX
 * @date 2020年4月26日
 * @time 下午9:52:14
 */

public class MyThread6_6 {
	public static void main(String[] args) {
		System.out.println(My.FACTORY.hashCode());
		MyThread66 thread = new MyThread66();
		thread.start();
	}
}

enum My{
	FACTORY;
	private My() {
		System.out.println("执行My构造");
	}
}
class MyThread66 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("do run**************");
	}
}