package com.executer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecuterWithCachedThreadPool {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("******Main Thread Start ******");
		/* Before */
		/*Thread t = new Thread(new MyFirstTask());
		Thread t1 = new Thread(new MyFirstTask());
		t.start();t1.start();*/
		/* After */
		ExecutorService ex = Executors.newCachedThreadPool();
		ex.execute(new MyFirstTask());
		ex.execute(new MyFirstTask());
		ex.execute(new MyFirstTask());
		ex.execute(new MyFirstTask());
		ex.execute(new MyFirstTask());
		ex.shutdown();
		System.out.println("******Main Thread End ******");

	}

}
