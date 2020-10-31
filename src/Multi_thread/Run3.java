package Multi_thread;

/**
 * @author YZX
 * @date 2019年11月12日
 * @time 下午2:53:23
 */

public class Run3 {

	public static void main(String[] args) throws InterruptedException{
		for(int i = 0;i < 5;++ i) {
			new Thread() {
				public void run() {
					try {
						Thread.sleep(500000);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				};
			}.start();
		}
	}

}
