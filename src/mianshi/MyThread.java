package mianshi;

/**
 * @author YZX
 * @date 2019年10月18日
 * @time 上午9:32:18
 */

public class MyThread implements Runnable{
	public void run() {
		System.out.println("IM RUNNING~~");
	}
	public static void main(String[] args) {
		new Thread(new MyThread()).start();
		new MyThread2().start();
	}
}

class MyThread2 extends Thread{
	public void run() {
		System.out.println("ME TOO");
	}
}
/*
 * java.util.current包中提供了对线程优化、管理的各项操作，
 * 该包提供了线程的运行，线程池的创建，线程生命周期的控制.
 * Executors提供四个静态方法创建四种线程池
 * newCachedThreadPool 		可缓存：如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * newFixedThreadPool 		定长：控制线程最大并发数，超出的线程会在队列中等待。
 * newScheduledThreadPool	定长，支持定长和周期性任务执行
 * newSingleThreadExecutor	单线程，所有任务按指定优先级执行
 * 作用：
 * 1、限定线程的个数，不会导致由于线程过多导致系统运行缓慢或崩溃
 * 2、线程池不需要每次都去创建或销毁，节约了资源、
 * 3、线程池不需要每次都去创建，响应时间更快。
 */