package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class User{
	
	private Semaphore semaphore = null;
	private String userName;
	
	User(Semaphore semaphore, String userName){
		this.semaphore = semaphore;
		this.userName = userName;
	}
	
	void login(String threadName)
	{
		System.out.println(threadName+" User "+userName+" try to login "+ semaphore.availablePermits());
		/*try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if(semaphore.tryAcquire()){
			System.out.println(threadName+" User "+userName+" login successfully");
			logout(threadName);
		}
	}
	void logout(String threadName)
	{
		System.out.println(threadName+" User "+userName+" try to logout");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		semaphore.release();
		System.out.println(threadName+" User "+userName+" logout successfully");
	}
}

public class SemaphoreDemo implements Runnable
{
	private User user = null;
	private static AtomicInteger counter = new AtomicInteger();
	
	SemaphoreDemo(User user)
	{
		this.user = user;
	}
	
	@Override
	public void run(){
		user.login(Thread.currentThread().getName());
	}
	
  public static void main(String args[]) throws InterruptedException {
     
	 ThreadFactory th = new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			int currentCount = counter.getAndIncrement();
			System.out.println("Creating new thread: " + currentCount);
			return new Thread(r, "mythread" + currentCount);
		}
	};
	  
	 Semaphore semaphore = new Semaphore(2);
	 //ExecutorService ex = Executors.newFixedThreadPool(4);
	 ExecutorService ex = Executors.newFixedThreadPool(3, th);
	 ex.execute(new SemaphoreDemo(new User(semaphore, "A")));
	 ex.execute(new SemaphoreDemo(new User(semaphore, "B")));
	 ex.execute(new SemaphoreDemo(new User(semaphore, "C")));
	 ex.execute(new SemaphoreDemo(new User(semaphore, "D")));
	 ex.shutdown();
   }
}
