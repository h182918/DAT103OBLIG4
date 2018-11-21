package no.hvl.dat103.oppg2.d1;

import no.hvl.dat103.semaphore.Semaphore;
import no.hvl.dat103.semaphore.Number;

public class Consumer extends Thread{
	private Semaphore mutex;
	private Semaphore full;
	private Semaphore tom;
	private int index;
	private final int BUFFER_SIZE;
	Integer[] buffer;
	Number count;
	
	public Consumer(Semaphore mutex, Semaphore full, Semaphore tom, Integer[] buffer, Number counter) {
		this.mutex = mutex;
		this.full = full;
		this.tom = tom;
		this.buffer = buffer;
		this.BUFFER_SIZE = buffer.length;
		index = 0;
		count = counter;
	}
	
	public void run() {
		while(true) {
			try {
				if(count.getNumber() >= 1) {
				full.vent();
				mutex.vent();
				Integer consumed = buffer[index % BUFFER_SIZE];
				index++;
				count.decrease();
				mutex.signal();
				tom.signal();
				System.out.println("Konsumerte: " + consumed);
				}
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
