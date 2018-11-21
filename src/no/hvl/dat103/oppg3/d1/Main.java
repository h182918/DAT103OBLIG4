package no.hvl.dat103.oppg3.d1;
import no.hvl.dat103.semaphore.Semaphore;
import no.hvl.dat103.semaphore.Number;

public class Main {
	
	public static void main(String[] args) {
		Number counter = new Number();
		Semaphore mutex = new Semaphore(1);
		Semaphore rw_mutex = new Semaphore(1);
		Reader reader = new Reader(rw_mutex, mutex, counter);
		reader.setName("Moses");
		Reader reader2 = new Reader(rw_mutex, mutex, counter);
		reader2.setName("Josef");
		Reader reader3 = new Reader(rw_mutex, mutex, counter);
		reader3.setName("Maria");
		Reader reader4 = new Reader(rw_mutex, mutex, counter);
		reader4.setName("Noah");
		Writer writer = new Writer(rw_mutex, mutex);
		writer.setName("Almighty GOD");
		reader.start();
		reader2.start();
		// read3.start();
		// read4.start();
		writer.start();

	}

}
