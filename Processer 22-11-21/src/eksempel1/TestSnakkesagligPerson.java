package eksempel1;

public class TestSnakkesagligPerson {

	public static void main(String[] arg) {
		SnakkesagligPerson jacob = new SnakkesagligPerson("Jacob", 150); // opret Jacob
		jacob.start();

		SnakkesagligPerson troels = new SnakkesagligPerson("Troels", 400); // opret Troels
		troels.start();

		SnakkesagligPerson henrik = new SnakkesagligPerson("Henrik", 200);
		henrik.start();

		SnakkesagligPerson ulla = new SnakkesagligPerson("Ulla", 100);
		ulla.start();
	}

}
