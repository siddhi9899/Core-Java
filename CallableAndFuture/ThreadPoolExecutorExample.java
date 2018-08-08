package com.executers;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorExample implements Runnable {
	private static AtomicInteger counter = new AtomicInteger();
	private final int taskId;

	public int getTaskId() {
		return taskId;
	}

	public ThreadPoolExecutorExample(int taskId) {
		this.taskId = taskId;
	}

	public static void main(String[] args) {
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(10);
		ThreadFactory threadFactory = new ThreadFactory() {
			public Thread newThread(Runnable r) {
				int currentCount = counter.getAndIncrement();
				System.out.println("Creating new thread: " + currentCount);
				return new Thread(r, "mythread" + currentCount);
			}
		};
		RejectedExecutionHandler rejectedHandler = new RejectedExecutionHandler() {
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				if (r instanceof ThreadPoolExecutorExample) {
					ThreadPoolExecutorExample example = (ThreadPoolExecutorExample) r;
					System.out.println("Rejecting task with id " + example.getTaskId());
				}
			}
		};
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS, queue, threadFactory, rejectedHandler);
		for (int i = 0; i < 2; i++) {
			executor.execute(new ThreadPoolExecutorExample(i));
		}
		executor.shutdownNow();
	}

	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/*
 * corePoolSize: The ThreadPoolExecutor has an attribute corePoolSize that determines how many threads it will start until new threads are only started when the queue is full.
 * 
 * maximumPoolSize: This attribute determines how many threads are started at the maximum. You can set this to Integer.MAX_VALUE in order to have no upper boundary.
 * 
 * keepAliveTime: When the ThreadPoolExecutor has created more than corePoolSize threads, a thread will be removed from the pool when it idles for the given amount of time.
 * 
 * unit: This is just the TimeUnit for the keepAliveTime.
 * workQueue: This queue holds the instances of Runnable given through the execute() method until they are actually started.
 * 
 * threadFactory: An implementation of this interface gives you control over the creation of the threads used by the ThreadPoolExecutor .
 * 
 * handler: When you specify a fixed size for the workQueue and provide a maximumPoolSize then it may happen, that the ThreadPoolExecutor is not able to execute your 
 * Runnable instance due to saturation. In this case the provided handler is called and gives you control over what should happen in this case.
*/
