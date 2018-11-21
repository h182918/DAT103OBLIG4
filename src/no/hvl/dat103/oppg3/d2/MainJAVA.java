package no.hvl.dat103.oppg3.d2;

import java.util.concurrent.Semaphore;

public class MainJAVA {
	public static Integer counter = 0;
	static Semaphore mutex = new Semaphore(1); // Controls access to critical section
	static Semaphore rw_mutex = new Semaphore(1); // All slots are empty initially

	public static void main(String[] args) {
		ReaderJAVA reader = new ReaderJAVA(rw_mutex, mutex, counter);
		reader.setName("Moses");
		ReaderJAVA reader2 = new ReaderJAVA(rw_mutex, mutex, counter);
		reader2.setName("Josef");
		ReaderJAVA reader3 = new ReaderJAVA(rw_mutex, mutex, counter);
		reader3.setName("Maria");
		ReaderJAVA reader4 = new ReaderJAVA(rw_mutex, mutex, counter);
		reader4.setName("Noah");
		WriterJAVA writer = new WriterJAVA(rw_mutex, mutex);
		writer.setName("Almighty GOD");
		reader.start();
		reader2.start();
		// read3.start();
		// read4.start();
		writer.start();

	}

}
