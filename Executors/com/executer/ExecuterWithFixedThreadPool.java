import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecuterWithFixedThreadPool {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("******Main Thread Start ******");
		/* Before */
		/*Thread t = new Thread(new MyFirstTask());
		Thread t1 = new Thread(new MyFirstTask());
		t.start();t1.start();*/
		/* After */
		ExecutorService ex = Executors.newFixedThreadPool(2);
		ex.execute(new MyFirstTask());
		ex.execute(new MyFirstTask());
		ex.shutdown();

		ExecutorService ex1 = Executors.newFixedThreadPool(2);
		ex1.execute(new MyFirstTask());
		ex1.execute(new MyFirstTask());
		ex1.shutdown();

		System.out.println("******Main Thread End ******");

	}

}
