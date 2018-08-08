// A Java program to demonstrate working of
// synchronized.
import java.io.*;
import java.util.*;

// A Class used to send a message
class Sender
{
   /* Object Level Locking */
   /* public synchronized void send(String msg, String threadName)
    {
        System.out.println(threadName+" Method Send Sending\t"  + msg );
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Thread  interrupted.");
        }
        System.out.println("\n"+threadName+" Method Send " + msg + "Sent");
    }
    */
    /* Class Level Locking */
     static int x=5;
    public   void send(String msg, String threadName)
	    {
	        System.out.println(threadName+" Method Send Sending\t"  + msg +" x is "+x);
	        try
	        {
	            if(x==5)
	            {
	            System.out.println("In if=="+x);
	            x=x*5;
	            Thread.sleep(5000);
	            //Thread.yield();
			    }
	        }
	        catch (Exception e)
	        {
	            System.out.println("Thread  interrupted.");
	        }
	        System.out.println("\n"+threadName+" Method Send " + msg + "Sent"+" x is "+x);
    }
    public void send1(String msg, String threadName)
	    {
	        System.out.println(threadName+" Method Send1 Sending\t"  + msg +" x is "+x);
	        try
	        {
	            Thread.sleep(1000);
	        }
	        catch (Exception e)
	        {
	            System.out.println("Thread  interrupted.");
	        }
	        System.out.println("\n"+threadName+" Method Send1 " + msg + "Sent"+" x is "+x);
    }
}

// Class for send a message using Threads
class ThreadedSend extends Thread
{
    private String msg;
    private Thread t;
    Sender  sender;

    // Recieves a message object and a string
    // message to be sent
    ThreadedSend()
    {
		 System.out.println("default constructor");
	}
    ThreadedSend(String m,  Sender obj)
    {
        msg = m;
        sender = obj;
    }

    public void run()
    {
        sender.send(msg,this.getName());
        //sender.send1(msg,this.getName());

    }

}

// Driver class
public class SyncDemo
{
   public static void main(String args[])
    {
        Sender snd = new Sender();
        Sender snd2 = new Sender();
        ThreadedSend S1 =
            new ThreadedSend( " Hi " , snd );
        ThreadedSend S2 =
            new ThreadedSend( " Bye " , snd);
		S1.setName("Thread 1");
		S2.setName("Thread 2");
        // Start two threads of ThreadedSend type
       S1.start();
       S2.start();
		// wait for threads to end
        /*try
        {
            S1.join();
            S2.join();
        }
        catch(Exception e)
        {
            System.out.println("Interrupted");
        }*/
    }
}
