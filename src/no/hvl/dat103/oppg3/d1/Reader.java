package no.hvl.dat103.oppg3.d1;
import no.hvl.dat103.semaphore.Semaphore;

import java.util.Random;

import no.hvl.dat103.semaphore.Number;

public class Reader extends Thread{
	public Number counter;
	private Semaphore mutex; // Controls access to critical section
	private Semaphore rw_mutex; // All slots are empty initially
	Random rand = new Random();
	public Reader(Semaphore mutex, Semaphore rw_mutex, Number counter) {
		this.mutex = mutex;
		this.rw_mutex = rw_mutex;
		this.counter = counter;
		
	}

	@Override
	public void run() {
		
		while(true) {
			try {
				sleep(rand.nextInt(200));
				mutex.vent();
				counter.increase();
				if(counter.getNumber()== 1) {
					rw_mutex.vent();
				}

				System.out.println(currentThread().getName() + " is reading as reader: " + counter.getNumber());
				mutex.signal();
				sleep(100);

				System.out.println(currentThread().getName() + " has finished reading");

				mutex.vent();
				counter.decrease();
				if(counter.getNumber() == 0) {
					rw_mutex.signal();
				}
				mutex.signal();
				sleep(75);
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
