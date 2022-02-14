package com.springboot.firstapp.firstapp;

import java.util.concurrent.CountDownLatch;

public class CountdownLatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CountDownLatch latch = new CountDownLatch(4);
		
		Thread t1= new Thread(()-> {
		    System.out.println("HELLO----one thread");
		    try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			latch.countDown();
		});
		
		Thread t2= new Thread(()-> {
		    System.out.println("HELLO----two thread");
		    try {
				Thread.currentThread();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			latch.countDown();
		});
		
		Thread t3= new Thread(()-> {
		    System.out.println("HELLO ---three thread");
		    try {
				Thread.currentThread();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			latch.countDown();
		});
		
		Thread t4	=new Thread(()-> {
		    System.out.println("HELLO four");
		    try {
				Thread.currentThread();
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			latch.countDown();
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
        // Main thread has started
        System.out.println(Thread.currentThread().getName() +
                           " has finished");
		
		
	}

}
