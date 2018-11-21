package no.hvl.dat103.oppg4.d1;

public class Fork {
	
	private Integer S; // S = antall ledige plasser
	public Fork(Integer S) {
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
