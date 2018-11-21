package no.hvl.dat103.oppg2.d1;

import no.hvl.dat103.semaphore.Number;
import no.hvl.dat103.semaphore.Semaphore;

public class Main {
	static Number counter = new Number();
	final static int BUFFER_SIZE = 10;
	static Integer[] buffer = new Integer[BUFFER_SIZE];
	static Semaphore mutex = new Semaphore(1); // Controls access to critical section
	static Semaphore tom = new Semaphore(BUFFER_SIZE); // All slots are empty initially
	static Semaphore full = new Semaphore(0); // Initially, all slots are empty. Thus full slots are 0
	
	public static void main(String[] args) {
		Producer p = new Producer(mutex, full, tom, buffer, counter);
		Consumer c = new Consumer(mutex, full, tom, buffer, counter);
		p.start();
		c.start();	
	}
}