package no.hvl.dat103.oppg2.d2;

import java.util.Random;
import java.util.concurrent.Semaphore;



public class Producer extends Thread {
	private Semaphore mutex;
	private Semaphore full;
	private Semaphore tom;
	private int index;
	private int BUFFER_SIZE;
	Integer[] buffer;
	private int item;
	
	public Producer(Semaphore mutex, Semaphore full, Semaphore tom, Integer[] buffer) {
		this.mutex = mutex;
		this.full = full;
		this.tom = tom;
		this.buffer = buffer;
		this.BUFFER_SIZE = buffer.length;
		index = 0;
	}

	// metode kalt på av produsent tråden.

	public void run() {
		Random rdm = new Random();
		while (true) {
			item = rdm.nextInt(300);
			tom.tryAcquire();
			mutex.tryAcquire();
			buffer[index] = item;
			index = (index + 1) % BUFFER_SIZE;
			System.out.println("Produserte: " + item);
			mutex.release();
			full.release();
			
			try {
				sleep(100);
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}

	}

}