

ava_samples

Difference between countdown Latch and cyclic barrier.
=========================================================
ans: multiple child threads join to give combined result to parent thread::: this cyclic barrier.
     each thread will call decrement the latch, main thead will be awaiting.
     cyclic barrier can be reset.
========================================================     
 why cant we invoke run() method instead of invoking start() on threads? 
 ==
 public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1= new Thread(()->{
			
			{
				System.out.println(Thread.currentThread().getName()+"INSIDE");
				System.out.println("hello");
				
			}
			
		});

		System.out.println(Thread.currentThread().getName());
		t1.run();
		
	//	t1.start();
		
		
	}

if we directly call run() method, it wont span a new thread, it will get executed in same thread. In the above code, it will only main thread.

================================================================================================================================================

Use case of Countdown Latch:
==
Lets say we have invoked two async web services, when each gets response.. it will decrement countdown latch. when both get responses. the main invoker (which has invoked these threads) will resume.
