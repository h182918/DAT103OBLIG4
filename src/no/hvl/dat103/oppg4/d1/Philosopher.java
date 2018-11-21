package no.hvl.dat103.oppg4.d1;

import java.util.Random;

public class Philosopher implements Runnable {
	Random rand = new Random();
	Fork leftFork;
	Fork rightFork;
	
	public Philosopher(Fork lf, Fork rf) {
		leftFork = lf;
		rightFork = rf;
	}

	@Override
	public void run() {
		while(true) {
			try {
				think();
				leftFork.vent();
				System.out.println(Thread.currentThread().getName() + " picked up left fork.");
				rightFork.vent();
				System.out.println(Thread.currentThread().getName() + " picked up right fork, and is now eating.");
				eat();
				leftFork.signal();
				rightFork.signal();
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
