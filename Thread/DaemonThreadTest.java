package com.thread;



public class DaemonThreadTest {

	public static void main(String[] args) {
		
		System.out.println("******Main Thread Start ******");
		MyThread th = new MyThread();
		th.setName("Daemon Thread");
		th.setDaemon(true);
		th.start();
		System.out.println("******Main Thread End ******");

	}

}
