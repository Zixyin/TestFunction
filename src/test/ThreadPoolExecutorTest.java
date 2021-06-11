package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		ExecutorService executor = createExecutorService();
		executor.execute(() -> {
			System.out.println(Thread.currentThread().getName());
			throw new RuntimeException();
		});
	}
	
	public static ExecutorService createExecutorService() {
		
		/**
		 * 核心线程数大小：工作队列未满时线程最大并行数
		 */
		int corePoolSize = 1;
		
		/**
		 * 最大线程数大小：工作队列满且继续添加任务时，列头任务将取出，并创建线程执行该任务，该变量为工作队列已满时线程最大的并行数
		 */
		int maximumPoolSize = 1;
		
		/**
		 * 因工作队列满创建的线程数超过核心线程数，且创建的线程处于空闲的最大存活时间，超时则销毁
		 */
		long keepAliveTime = 60;
		
		/**
		 * 时间枚举类，提供了纳秒-天范围的枚举值以及不同计量单位之间的转换方法
		 */
		TimeUnit timeUnit = TimeUnit.SECONDS;
		
		/**
		 * 核心线程数<当前线程数<最大线程数时，新增的任务会进入该队列，队列容量满时会取出列头任务并创建线程执行任务
		 * 四种BlockingQueue及其内部数据结构：
		 *     ArrayBlockingQueue：数组，实例化时需要给定capacity，有界队列，界为capacity
		 *     LinkedBlockingQueue：链表，实例化时可选择是否指定capacity，未指定默认Integer.MAX_VALUE，无界队列
		 *     PriorityBlockingQueue：数组结构的小顶堆
		 *     DelayQueue：优先队列，根据delay时间升序排序
		 */
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
		
		ThreadFactory factory = r -> {
		    Thread thread = new Thread(r);
		    thread.setUncaughtExceptionHandler((t, e) -> System.out.println(t.getName() + e.getMessage()));
		    return thread;
		};
		
		RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, timeUnit, workQueue, factory, handler);
		return executor;
	}
}
