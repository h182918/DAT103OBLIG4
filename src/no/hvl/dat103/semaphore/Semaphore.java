package no.hvl.dat103.semaphore;

public class Semaphore {

	private Integer S; // S = antall ledige plasser
	
	public Semaphore(Integer S) {
		this.S = S;
	}

	public void vent() throws InterruptedException {
		while (S <= 0) {
			Thread.sleep(50);
		} // busy wait
		S--;
	}
	public void signal() {
		S++;
	}
}