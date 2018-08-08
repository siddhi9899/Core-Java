import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Test extends C
{
	private static native void start0();
 public static void main(String[] args) throws ParseException {
	 
	 BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
	 /*//Callable;Thread;FutureTask;
	 A a = new Test();
	 
	 a.run1();
	 a.run();
	 List<Date> lstDate = new ArrayList<Date>();
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
     Date date1 = sdf.parse("2009-12-31");
     Date date2 = sdf.parse("2010-01-31");
     
     lstDate.add(date1);
     lstDate.add(date2);
     //Thread;
	 
	 System.out.println("lstDate "+Collections.max(lstDate));*/
	 start0();
 }

/*@Override
public void run() {
	System.out.println("Called Run Test");
	
}*/



}


abstract class A
{
	public void run() {
		System.out.println("Called Run A");
		
	}
	public abstract void run1();
}
class B extends A
{
	public void run() {
		System.out.println("Called Run B");
		
	}
	public void run1() {
		System.out.println("Called Run 1 B");
		
	}
}
class C extends B
{
	public void run() {
		System.out.println("Called Run C");
		
	}
}