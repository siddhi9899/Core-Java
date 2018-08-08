// A Java program to demonstrate working of
// synchronized.
import java.io.*;
import java.util.*;

// A Class used to send a message
class Sender
{
   public  void send(String msg, String threadName)
	    {
	        System.out.println(threadName+" Method Send Sending\t"  + msg);
	        try
	        {
	            //Thread.sleep(5000);
	            Thread.yield();
			   
	        }
	        catch (Exception e)
	        {
	            System.out.println("Thread  interrupted.");
	        }
	        System.out.println("\n"+threadName+" Method Send " + msg + "Sent");
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
    }

}

// Driver class
public class SyncDemo
{
   public static void main(String args[])
    {
        Sender snd = new Sender();
        ThreadedSend S1 =
            new ThreadedSend( " Hi " , snd );
        
        ThreadedSend S2 =
                new ThreadedSend( " Bye " , snd );
            S1.setName("Thread 1");
            S2.setName("Thread 2");
		// Start two threads of ThreadedSend type
        S1.start();
        S2.start();
       /* try
        {
            for(int i = 0;i<5;i++)
            {
            	System.out.println("in main thread="+i);
            	Thread.sleep(3000);
            }
        }
        catch(Exception e)
        {
            System.out.println("Interrupted");
        }*/
    }
}
