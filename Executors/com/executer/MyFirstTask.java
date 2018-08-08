import java.util.concurrent.TimeUnit;

public class MyFirstTask implements Runnable{

	private static int count = 0;
	private int id;
	public MyFirstTask()
	{
		this.id = ++count;
	}
	@Override
	public void run() {
		System.out.println("******Starting Task: "+id+" ******");
		for(int i=0; i<4; i++)
		{
			System.out.println("******"+Thread.currentThread().getName()+" Executing Task: "+id+" Job"+i+" ******");
			try {
				TimeUnit.MICROSECONDS.sleep((long)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("******Ending Task: "+id+" ******");

	}

}
