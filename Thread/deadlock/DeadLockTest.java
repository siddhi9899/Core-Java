package com.thread.deadlock;

public class DeadLockTest {
	
	public static void main(String args[]) throws InterruptedException
	{
		MyThread.mainThread = Thread.currentThread();
		
		MyThread myThread = new MyThread();
		
		myThread.start();
		
		myThread.join();
		
		for(int i = 0; i<5; i++)
		{
			System.out.println("In Main Thread loop: "+i);
		}
	}

}

class MyThread extends Thread
{
	static Thread mainThread;
	
	@Override
	public void run(){
		
		try {
			mainThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i<5; i++)
		{
			System.out.println("In Child Thread loop: "+i);
		}
	}
}
