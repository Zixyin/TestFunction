package Multi_thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YZX
 * @date 2020年2月16日
 * @time 上午11:19:49
 */

public class MyThread4_1_9 {
	public static void main(String[] args) {
		Service service = new Service();
		ThreadGet[] get = new ThreadGet[10];
		ThreadSet[] set = new ThreadSet[10];
		for(int i = 0;i < 10;++ i) {
			set[i] = new ThreadSet(service);
			get[i] = new ThreadGet(service);
			set[i].start();
			get[i].start();
		}
	}
}

class Service{
	private ReentrantLock lock = new ReentrantLock();
	private Condition conditionGet = lock.newCondition();
	private Condition conditionSet = lock.newCondition();
	private boolean hasValue = true;

	public void set() {
		lock.lock();
		try {
			while(hasValue) {
				System.out.println("set连续");
				conditionSet.await();
			}	
			System.out.println("set one");
			hasValue = true;
			conditionGet.signal();
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void get() {
		lock.lock();
		try {
			while(!hasValue) {
				System.out.println("get连续");
				conditionGet.await();
				}
			System.out.println("get one");
			hasValue = false;
			conditionSet.signalAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
	}
}
class ThreadGet extends Thread{
	Service service = new Service();
	public ThreadGet(Service service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	@Override
	public void run() {
		for(int i = 0;i < Integer.MAX_VALUE;++ i) 
			service.get();

	}
}

class ThreadSet extends Thread{
	Service service = new Service();
	public ThreadSet(Service service) {
		this.service = service;
	}
	public void run() {
		for(int i = 0;i < Integer.MAX_VALUE;++ i) 
			service.set();
	}
}