package Lotto;
public class mainclass {
	//Køretider for lineær process
	//Køretid 1: 123 milisekunder
	//Køretid 2: 125 milisekunder
	//Køretid 3: 117 milisekunder
	//Køretid 4: 116 milisekunder
	//Køretid 5: 122 milisekunder
	//Gennemsnit: 120,6

	//Køretider for thread process
	//Køretid 1: 31 milisekunder
	//Køretid 2: 30 milisekunder
	//Køretid 3: 33 milisekunder
	//Køretid 4: 27 milisekunder
	//Køretid 5: 38 milisekunder
	//Gennemsnit: 31.8

	private static lottoraek[] spillede;
	private static lottoraek rigtig;
	private static int[] antalgev;

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		spillede = new lottoraek[3000000];
		rigtig = new lottoraek();
		for (int j=0; j < spillede.length; j++)
			spillede[j] = new lottoraek();

		loesning1();
		System.out.println();
		loesning2();

	}

	private static void loesning1 () {
		antalgev = new int[8];
		long l1,l2;
		l1 = System.nanoTime();
		for (int j=0; j < spillede.length; j++) {
			antalgev[rigtig.antalrigtige(spillede[j])] ++; //er der egentlig ikke byttet om på de to arrays her? Gør det en forskel?
		}
		l2 = System.nanoTime();
		System.out.println("K�retiden var " +(l2-l1)/1000000 + " millisekunder");
		int total = 0;
		for (int i=1;i<8;i++){
			System.out.println("Der var " + antalgev[i] + " r�kker med " + i + " rigtige" );
			total = total + antalgev[i];
		}
		System.out.println("Der var totalt " + total + " r�kker");
	}

	private static void loesning2 () {
		int numThreads = 4;
		antalgev = new int[8];
		long l1,l2;

		l1 = System.nanoTime();

		numberCorrectThread[] threads = new numberCorrectThread[numThreads];
		int start = 0;
		int stop = spillede.length / numThreads;
		for (int i = 0; i < numThreads; i++) {
			threads[i] = new numberCorrectThread(rigtig, spillede, start, stop);
			threads[i].start();
			start = stop;
			if (i == numThreads-1) {
				stop = spillede.length;
			} else {
				stop =+ spillede.length / numThreads;
			}
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
				int[] delGevinster = threads[i].getAntalGev();
				for (int j = 1; j < antalgev.length; j++) {
					antalgev[j] =+ delGevinster[j];
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		l2 = System.nanoTime();
		System.out.println("K�retiden var " +(l2-l1)/1000000 + " millisekunder");
		int total = 0;
		for (int i=1;i<8;i++){
			System.out.println("Der var " + antalgev[i] + " r�kker med " + i + " rigtige" );
			total = total + antalgev[i];
		}
		System.out.println("Der var totalt " + total + " r�kker");
	}
}	
