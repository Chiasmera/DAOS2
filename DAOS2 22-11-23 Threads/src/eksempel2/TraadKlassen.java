package eksempel2;

public class TraadKlassen extends Thread{
	
	//Att
	int[] array;
	int max;
	
	public TraadKlassen(int[] array) {
		super();
		this.array = array;
		this.max = Integer.MIN_VALUE;

	}
	
	public void run() {
		for (int i = 0; i < array.length; i++ ) {
			if (array[i] > max) {
				max = array[i];
			}
		}
	}
	public int getMax() {
		return max;
	}
}
