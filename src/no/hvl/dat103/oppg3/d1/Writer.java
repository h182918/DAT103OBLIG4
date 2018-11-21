package no.hvl.dat103.oppg3.d1;
import no.hvl.dat103.semaphore.Semaphore;

public class Writer extends Thread{
	private Semaphore rw_mutex;
	private Semaphore mutex;
	public Writer(Semaphore rw_mutex, Semaphore mutex) {
		this.rw_mutex = rw_mutex;
		this.mutex = mutex;
	}

	@Override
	public void run() {
		while(true) {
			try {
				mutex.vent();
				rw_mutex.vent();
				System.out.println(currentThread().getName() + " is writing");
				sleep(100);
				System.out.println(currentThread().getName() + " has finished writing");
				rw_mutex.signal();
				mutex.signal();
				sleep(75);
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
		
	}

}
