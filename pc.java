package com.springboot.firstapp.firstapp;

import java.util.LinkedList;

public class pc {
	LinkedList<Integer> list = new LinkedList<Integer>();

	int value = 0;
	static int capacity = 2;

	public void produce() throws InterruptedException {

		// stem.out.println("list size in between"+list.isEmpty());
		while (true) {
			System.out.println("list size in between" + list.isEmpty());

			if (!list.isEmpty()) {
				System.out.println(list.size()+"list produce");

			}
			synchronized (this) {
				if (list.size() == capacity) {
					System.out.println("waiting");
					wait();
				}

				else {
					list.add(value++);

					System.out.println("producer produced" + value);

				  this.notify();

					Thread.sleep(1000);

				}

			}
		}
	}

	public void consume() throws InterruptedException {

		while (true) {
			System.out.println("list size in between" + list.isEmpty());
			synchronized (this) {
				
				if (!list.isEmpty()) {
					System.out.println("consumer"+list.size());

				}
				if (list.isEmpty()) {
					wait();
				}

				else {
					if(list.size()==2)
					{
						int value = list.removeFirst();

						System.out.println("consumer consumed" + value);

						notify();

						Thread.sleep(1000);

					}
				
				}
			}
		}
	}
}
