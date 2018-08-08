import java.lang.*;
 
public class JoinDemo implements Runnable
{
    public void run()
    {
        Thread t = Thread.currentThread();
        System.out.println("Current thread: "
                               + t.getName());
        for(int i=0;i<5;i++)
        {
        	try {
        		System.out.println("In loop=="+i);
        		Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        // checks if current thread is alive
        System.out.println(t.getName()+" Is Alive? "
                               + t.isAlive());
    }
 
    public static void main(String args[]) throws Exception
    {
    	JoinDemo j =new JoinDemo();
    	Thread t = new Thread(j);
    	t.setName("Thread 1");
    	Thread t1 = new Thread(j);
    	t1.setName("Thread 2");
        t.start();
        t.join(6000);
        t1.start();
        // Waits for 1000ms this thread to die.
       /* t1.join(4000);
 
        System.out.println("\nJoining after 4000"+
                             " mili seconds: \n");
        System.out.println("Main Current thread: " +
                                    t.getName());
        System.out.println("Main Current thread: " +
                t1.getName());*/
 
 
        // Checks if this thread is alive
       // System.out.println("Main "+t.getName()+" Is alive? " + t.isAlive());
        //System.out.println("Main "+t1.getName()+" Is alive? " + t1.isAlive());
       
    }
}
