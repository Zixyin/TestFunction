package Multi_thread.p_r_test;

/**
 * @author YZX
 * @date 2019年11月25日
 * @time 上午9:54:50
 */

public class P {
	private String lock;
	public P(String lock){
		super();
		this.lock = lock;
	}
	public void setValue() {
		try {
			synchronized(lock) {
				if(!ValueObject.value.equals("")) {
					lock.wait();
				}
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
