package no.hvl.dat103.oppg4.d2;

import java.util.concurrent.Semaphore;

public class DiningPhilosophersJAVA {
	final static int ANTALL = 5;
	static PhilosopherJAVA[] philosophers = new PhilosopherJAVA[ANTALL];
	static Semaphore[] forks =  new Semaphore[ANTALL];

	public static void main(String[] args) {
		for(int i = 0; i < ANTALL; i++) {
			forks[i] = new Semaphore(1);
		}
		for(int i = 0; i < ANTALL; i++) {
			philosophers[i] = new PhilosopherJAVA(forks[i % ANTALL], forks[(i + 1) % ANTALL]);
		}
		Thread t1 = new Thread(philosophers[0], "Aristoteles");
		Thread t2 = new Thread(philosophers[1], "Platon");
		Thread t3 = new Thread(philosophers[2], "Sokrates");
		Thread t4 = new Thread(philosophers[3], "Descartes");
		Thread t5 = new Thread(philosophers[4], "Kant");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}

}
