package no.hvl.dat103.oppg4.d2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class PhilosopherJAVA implements Runnable {
	Random rand = new Random();
	Semaphore leftFork;
	Semaphore rightFork;
	
	public PhilosopherJAVA(Semaphore lf, Semaphore rf) {
		leftFork = lf;
		rightFork = rf;
	}

	@Override
	public void run() {
		while(true) {
			try {
				think();
				leftFork.acquire();
				System.out.println(Thread.currentThread().getName() + " picked up left fork.");
				rightFork.acquire();
				System.out.println(Thread.currentThread().getName() + " picked up right fork, and is now eating.");
				eat();
				leftFork.release();
				rightFork.release();
				System.out.println(Thread.currentThread().getName() + " put down both forks, and is now thinking.");
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void think() throws InterruptedException {
		Thread.sleep(500 + rand.nextInt(1000));


	}
	
	public void eat() throws InterruptedException {
		Thread.sleep(500 + rand.nextInt(1000));
	}
}
