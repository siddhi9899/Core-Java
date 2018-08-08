package com.executer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableAndFutureTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("******Main Thread Start ******");
		
		ExecutorService ex = Executors.newSingleThreadExecutor();
		
		Callable<Integer> myTask = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("*****Task Executed******");
				return 1*100;
			}
		};
		
		Future<Integer> fut = ex.submit(myTask);
		if(fut.isDone())
			try {
				System.out.println("Return Value: "+fut.get());
				System.out.println("xxxxxxxxxxxxxx");
				
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		ex.shutdown();
		System.out.println("******Main Thread End ******");

	}

}
