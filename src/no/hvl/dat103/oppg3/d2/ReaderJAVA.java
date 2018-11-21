package no.hvl.dat103.oppg3.d2;

import java.util.concurrent.Semaphore;

public class ReaderJAVA extends Thread{
	public Integer counter;
	private Semaphore mutex; // Controls access to critical section
	private Semaphore rw_mutex; // All slots are empty initially

	public ReaderJAVA(Semaphore mutex, Semaphore rw_mutex, Integer counter) {
		this.mutex = mutex;
		this.rw_mutex = rw_mutex;
		this.counter = counter;
	}

	@Override
	public void run() {
		while(true) {
			try {
				mutex.acquire();
				counter++;
				if(counter == 1) {
					rw_mutex.acquire();
				}
				System.out.println(currentThread().getName() + " is reading as reader: " + counter);
				mutex.release();
				sleep(100);
				
				System.out.println(currentThread().getName() + " has finished reading");
				
				mutex.acquire();
				counter--;
				if(counter == 0) {
					rw_mutex.release();
				}
				mutex.release();
				sleep(75);
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
