package it.univr.autosentences;

import java.util.Iterator;

public class AutoSentencesThread {

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();

		Iterator<int[]> it = new Sequences(5, Constants.REPLACEMENTS.length).iterator();

		class Worker extends Thread {
		
			public void run() {
				while (true) {
					int[] idx;
					
					// sezione critica in mutua esclusione, che si sincronizza su it
					// per evitare accessi concorrenti ad it
					synchronized (it) {
						if (!it.hasNext())
							break;

						idx = it.next();
					}
					
					Sentence sentence = new Sentence(idx);
					if (sentence.isAutoSentence())
						System.out.println(sentence);
				}
			}
		}

		// creo una batteria di Worker's
		Worker[] workers = new Worker[Runtime.getRuntime().availableProcessors()];
		for (int pos = 0; pos < workers.length; pos++)
			workers[pos] = new Worker();

		// li faccio partire tutti
		for (int pos = 0; pos < workers.length; pos++)
			workers[pos].start();

		// aspetto che tutti abbiamo finito
		for (int pos = 0; pos < workers.length; pos++)
			workers[pos].join();

		long end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
	}
}
