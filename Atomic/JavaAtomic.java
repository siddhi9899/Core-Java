import java.util.concurrent.atomic.AtomicInteger;

public class JavaAtomic {

    public static void main(String[] args) throws InterruptedException {

        ProcessingThread pt = new ProcessingThread();
         ProcessingThread pt1 = new ProcessingThread();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt1, "t2");
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Processing count=" + pt.getCount()+" count1: "+pt.getCount1());
        System.out.println("Processing count=" + pt1.getCount()+" count1: "+pt1.getCount1());
    }
}

class ProcessingThread implements Runnable {
    private AtomicInteger count = new AtomicInteger();
    private static AtomicInteger count1 = new AtomicInteger();
	//private volatile int count;
	//private volatile static int count1;
    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            count.incrementAndGet();
            count1.incrementAndGet();
        }
        /*int i=1;
        while(i<5)
        {
			processSomething(i);
			count1++; count++; i++;
		}*/
    }

    public int getCount() {
        return this.count.get();
        //return this.count;
    }

    public int getCount1() {
	        return this.count1.get();
	        //return this.count1;
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

/*
 In multithreaded environment volatile stil not useful(without using of synchronization on volatile) because it can be changed by thread and another may not get updated value between transaction but AtomicInteger will always give updated value to thread.
*/