package no.hvl.dat103.oppg2.d2;

import java.util.concurrent.Semaphore;

public class Main {
	final static int BUFFER_SIZE = 10;
	static Integer[] buffer = new Integer[BUFFER_SIZE];
	static Semaphore mutex = new Semaphore(1); // Controls access to critical section
	static Semaphore tom = new Semaphore(BUFFER_SIZE); // All slots are empty initially
	static Semaphore full = new Semaphore(0); // Initially, all slots are empty. Thus full slots are 0
	
	public static void main(String[] args) {
		Producer p = new Producer(mutex, full, tom, buffer);
		Consumer c = new Consumer(mutex, full, tom, buffer);
//		Thread t1 = new Thread(p);
//		Thread t2 = new Thread(c);
//		t1.start();
//		t2.start();
		p.start();
		c.start();
	}
}