package cs240.lab3;

public class LynsiTest {
	static Inventory inventory = new Inventory();
	static int days = 1;
	static int daysinMonthMarch = 31;
	static int hoursOpen = 10;

	public static void main(String args[]) {
		inventory.makeList();
		int openHours = 10;
		for (int i = 0; i < openHours; i++) {

		}
		inventory.foodDelivery(date);
		for (int i = 0; i < daysinMonthMarch; i++) {
			for (int j = 0; j < hoursOpen; j++) {
				inventory.peopleinLine();
				inventory.serveCoustomers();
				if (deliverToday(date))
					inventory.foodDelivery(date);

			}
			inventory.organizeSortandcheckExpiration(date);
			System.out.println();
			System.out.println("Today is day: " + (i + 1));
			inventory.state();
			inventory.resetDay();
			date++;
		}
		System.out.println("End of the month of March. We did it!!");

	}

	static int date = 300;

	public static boolean deliverToday(int dayNum) {
		boolean status = false;
		if (dayNum % 3 == 0)
			status = true;
		return status;
	}

}