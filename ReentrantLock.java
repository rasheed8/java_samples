package com.springboot.firstapp.firstapp;

public class ReentrantLock {

	
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

	
}
