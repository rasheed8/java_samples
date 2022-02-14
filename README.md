

ava_samples

Difference between countdown Latch and cyclic barrier.
==
ans: multiple child threads join to give combined result to parent thread::: this cyclic barrier.
     each thread will call decrement the latch, main thead will be awaiting.
     cyclic barrier can be reset.
==
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

===

What are Reentrant Locks?
==


The ReentrantLock class implements the Lock interface and provides synchronization to methods while accessing shared resources. The code which manipulates the shared resource is surrounded by calls to lock and unlock method. This gives a lock to the current working thread and blocks all other threads which are trying to take a lock on the shared resource. 

As the name says, ReentrantLock allows threads to enter into the lock on a resource more than once. When the thread first enters into the lock, a hold count is set to one. Before unlocking the thread can re-enter into lock again and every time hold count is incremented by one. For every unlocks request, hold count is decremented by one and when hold count is 0, the resource is unlocked. 

Reentrant Locks also offer a fairness parameter, by which the lock would abide by the order of the lock request i.e. after a thread unlocks the resource, the lock would go to the thread which has been waiting for the longest time. This fairness mode is set up by passing true to the constructor of the lock.

==

public void some_method()
{
        reentrantlock.lock();
        try
        {
            //Do some work
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            reentrantlock.unlock();
        }
         
}
