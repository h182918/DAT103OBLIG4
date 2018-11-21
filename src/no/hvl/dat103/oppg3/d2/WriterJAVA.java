package no.hvl.dat103.oppg3.d2;

import java.util.concurrent.Semaphore;

public class WriterJAVA extends Thread{
	private Semaphore rw_mutex;
	private Semaphore mutex;

	public WriterJAVA(Semaphore rw_mutex, Semaphore mutex) {
		this.rw_mutex = rw_mutex;
		this.mutex = mutex;
	}

	@Override
	public void run() {
		while(true) {
			try {
				
				rw_mutex.acquire();
				System.out.println(currentThread().getName() + " is writing");
				sleep(100);
				System.out.println(currentThread().getName() + " has finished writing");
				rw_mutex.release();
				
				sleep(75);
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
		
	}

}
