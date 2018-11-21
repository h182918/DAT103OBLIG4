package no.hvl.dat103.oppg2.d1;

import java.util.Random;

import no.hvl.dat103.semaphore.Semaphore;
import no.hvl.dat103.semaphore.Number;

public class Producer extends Thread {
	private Semaphore mutex;
	private Semaphore full;
	private Semaphore tom;
	private int index;
	private int BUFFER_SIZE;
	Integer[] buffer;
	private int item;
	Number count;
	
	public Producer(Semaphore mutex, Semaphore full, Semaphore tom, Integer[] buffer, Number counter) {
		this.mutex = mutex;
		this.full = full;
		this.tom = tom;
		this.buffer = buffer;
		this.BUFFER_SIZE = buffer.length;
		index = 0;
		count = counter;
	}

	// metode kalt på av produsent tråden.
	public void run() {
		Random rdm = new Random();
		while (true) {
			try {
				item = rdm.nextInt(300);
				tom.vent();
				buffer[index] = item;
				count.increase();
				index = (index + 1) % BUFFER_SIZE;
				mutex.signal();
				full.signal();
				System.out.println("Produserte: " + item);
				mutex.vent();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}try {
				sleep(100);
			}catch(InterruptedException e1){
				e1.printStackTrace();
			}
		}
	}
}