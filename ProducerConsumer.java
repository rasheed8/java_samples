package com.springboot.firstapp.firstapp;

public class ProducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final pc pc1= new pc();
		
		Thread t1=new Thread(()-> 
		{
			try {
				pc1.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Thread t2=new Thread(()-> {
			try {
				pc1.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();

	}

	
}
