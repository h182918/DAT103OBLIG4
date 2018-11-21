package no.hvl.dat103.oppg2.d2;

import java.util.concurrent.Semaphore;

public class Consumer extends Thread{
	private Semaphore mutex;
	private Semaphore full;
	private Semaphore tom;
	private int index;
	private final int BUFFER_SIZE;
	Integer[] buffer;
	
	public Consumer(Semaphore mutex, Semaphore full, Semaphore tom, Integer[] buffer) {
		this.mutex = mutex;
		this.full = full;
		this.tom = tom;
		this.buffer = buffer;
		this.BUFFER_SIZE = buffer.length;
		index = 0;
	}
	
	public void run() {
		while(true) {
			full.tryAcquire();
			mutex.tryAcquire();
			if(!((buffer[index]) == (null))) {
				Integer consumed = buffer[index];
				index = (index + 1) % BUFFER_SIZE;
				System.out.println("Konsumerte: " + consumed);
			}
			mutex.release();
			tom.release();
			try {
				sleep(200);
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
	

}
