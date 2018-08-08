package com.thread;

public class WaitNotifyTest extends Thread{
	
    private Data data;
	
    WaitNotifyTest(Data data)
	{
		this.data = data;
	}
	
	public static void main(String args[]) throws InterruptedException {
		// TODO Auto-generated method stub
		
		  Data data = new Data(10, 20);
		  WaitNotifyTest wnt = new WaitNotifyTest(data);
		  wnt.setName("Sender");
		  wnt.start();
		  Thread t1 = Thread.currentThread();
		  t1.setName("Receiver");
		  while(true)
		  {
			  try {
					while(true)
					{
					    Thread.sleep(2000);
						data.getSum(t1.getName());
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
		  }
	}
   
   @Override
	public void run()
	{
		try {
			while(true)
			{
			    Thread.sleep(1000);
				data.sum(Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Data
{
	private int num1;
	private int num2;
	private int total;
	private boolean flag;
	
	public Data(int num1, int num2)
	{
		this.num1 = num1;
		this.num2 = num2;
	}
	public synchronized void getSum(String name) throws InterruptedException {
		if(!flag)
		{
    		wait();
		}
    	System.out.println(name+" Sum is: "+total);
		flag = false;
		notify();
	}
	
	public synchronized void sum(String name) throws InterruptedException {
		if(flag)
		{
			wait();
		}
		System.out.println(name+" data is: num1: "+num1+" num2: "+num2);
		total = num1 + num2;
		flag = true;
		notify();
	}
	
}