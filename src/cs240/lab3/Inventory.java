package cs240.lab3;

import java.util.Random;

public class Inventory {
	static int bunsAmount, pattyAmount, lettuceAmount, tomatoAmount, onionAmount, cheeseAmount;
	static int bunsWasted, pattyWasted, lettuceWasted, tomatoWasted, onionWasted, cheeseWasted;
	static int countItemOne, countItemTwo, countItemThree, countItemFour, countItemFive, countItemSix;
	static int servedCustomersDay, lostCustomersDay;
	static final int lineMax = 50;

	BurgerList<String> burgList = new BurgerList<String>();
	BurgerList<String> cheeseList = new BurgerList<String>();
	BurgerList<String> veganList = new BurgerList<String>();
	BurgerList<String> burnoTomoatoList = new BurgerList<String>();
	BurgerList<String> cheeseNoOnionList = new BurgerList<String>();
	BurgerList<String> burgNoTomList = new BurgerList<String>();

	public void makeList() {
		burgList.add("buns");
		burgList.add("patty");
		burgList.add("lettuce");
		burgList.add("tomato");
		burgList.add("onion");
		cheeseList.add("buns");
		cheeseList.add("patty");
		cheeseList.add("lettuce");
		cheeseList.add("tomato");
		cheeseList.add("onion");
		cheeseList.add("cheese");
		veganList.add("lettuce");
		veganList.add("tomato");
		veganList.add("onion");
		burnoTomoatoList.add("buns");
		burnoTomoatoList.add("patty");
		burnoTomoatoList.add("lettuce");
		burnoTomoatoList.add("onion");
		cheeseNoOnionList.add("buns");
		cheeseNoOnionList.add("patty");
		cheeseNoOnionList.add("lettuce");
		cheeseNoOnionList.add("tomato");
		cheeseNoOnionList.add("cheese");
		burgNoTomList.add("buns");
		burgNoTomList.add("patty");
		burgNoTomList.add("lettuce");
		burgNoTomList.add("onion");
	}

	public static int random(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;

	}

	int amountofPeople;
	LineQueue<Integer> line = new LineQueue<Integer>();

	public void peopleinLine() {
		amountofPeople = random(1, 100);

		if (amountofPeople > lineMax) {
			lostCustomersDay = amountofPeople - lineMax;
			amountofPeople = lineMax;
		}
		// System.out.println("amount of people = " + amountofPeople);

		for (int i = 0; i < amountofPeople; i++) {
			int menuChoice = random(1, 6);
			line.enqueue(menuChoice);
		}
	}

	BurgerList<Integer> burger = new BurgerList<Integer>();

	public void serveCoustomers() {

		for (int i = 0; i < amountofPeople; i++) {
			switch (line.dequeue()) {
			case 1:
				if (ensureAmount(1)) {
					burger.add(1);
					countItemOne++;
					bunsAmount--;
					pattyAmount--;
					lettuceAmount--;
					tomatoAmount--;
					onionAmount--;

				}
				break;
			case 2:
				if (ensureAmount(2)) {
					burger.add(3);
					countItemTwo++;
					cheeseAmount--;
					bunsAmount--;
					pattyAmount--;
					lettuceAmount--;
					tomatoAmount--;
					onionAmount--;
				}
				break;
			case 3:
				if (ensureAmount(3)) {
					countItemThree++;
					lettuceAmount--;
					lettuceAmount--;
					tomatoAmount--;
					onionAmount--;

				}
				break;
			case 4:
				if (ensureAmount(4)) {
					bunsAmount--;
					pattyAmount--;
					lettuceAmount--;
					tomatoAmount--;

					countItemFour++;
				}
				break;
			case 5:
				if (ensureAmount(5)) {
					bunsAmount--;
					pattyAmount--;
					lettuceAmount--;
					tomatoAmount--;
					cheeseAmount--;

					countItemFive++;
				}
				break;
			case 6:
				if (ensureAmount(6)) {
					bunsAmount--;
					pattyAmount--;
					lettuceAmount--;
					onionAmount--;
					countItemSix++;
				}
				break;
			}
		}
	}

	public boolean ensureAmount(int caseNum) {
		boolean status = false;
		switch (caseNum) {
		case 1:
			if (bunsAmount != 0 && pattyAmount != 0 && lettuceAmount != 0 && tomatoAmount != 0 && onionAmount != 0)
				status = true;
			break;
		case 2:
			if (bunsAmount != 0 && pattyAmount != 0 && lettuceAmount != 0 && tomatoAmount != 0 && onionAmount != 0
					&& cheeseAmount != 0)
				status = true;
			break;
		case 3:
			if (lettuceAmount >= 2 && tomatoAmount != 0 && onionAmount != 0)
				status = true;
			break;
		case 4:
			if (bunsAmount != 0 && pattyAmount != 0 && lettuceAmount != 0 && tomatoAmount != 0)
				status = true;
			break;
		case 5:
			if (bunsAmount != 0 && pattyAmount != 0 && lettuceAmount != 0 && tomatoAmount != 0 && cheeseAmount != 0)
				status = true;
			break;
		case 6:
			if (bunsAmount != 0 && pattyAmount != 0 && lettuceAmount != 0 && onionAmount != 0)
				status = true;
			break;

		}
		if (status == false) {
			lostCustomersDay++;
		}
		return status;
	}

	public void foodDelivery(int dayNum) {
		int amount = random(700, 1000);
		for (int i = 0; i < amount; i++) {
			bunsStack.push(expirationDateGenerator(dayNum, 1));
			bunsAmount++;

		}
		int amountTwo = random(700, 1000);
		for (int i = 0; i < amountTwo; i++) {
			pattyStack.push(expirationDateGenerator(dayNum, 2));
			pattyAmount++;
		}
		int amountThree = random(700, 1000);
		for (int i = 0; i < amountThree; i++) {
			lettuceStack.push(expirationDateGenerator(dayNum, 3));
			lettuceAmount++;

		}
		int amountFour = random(700, 1000);
		for (int i = 0; i < amountFour; i++) {
			tomatoStack.push(expirationDateGenerator(dayNum, 4));
			tomatoAmount++;

		}
		int amountFive = random(700, 1000);
		for (int i = 0; i < amountFive; i++) {
			onionStack.push(expirationDateGenerator(dayNum, 5));
			onionAmount++;
		}
		int amountSix = random(700, 1000);
		for (int i = 0; i < amountSix; i++) {
			cheeseStack.push(expirationDateGenerator(dayNum, 6));
			cheeseAmount++;
		}

	}

	public int expirationDateGenerator(int dayNum, int food) {
		int expires = 0;
		if (food == 1) {// buns
			expires = dayNum + 5;
		}
		if (food == 2) {// patty
			expires = dayNum + 4;
		}
		if (food == 3) {// lettuce
			expires = dayNum + 3;
		}
		if (food == 4) {// tomato
			expires = dayNum + 3;
		}
		if (food == 5) {// onion
			expires = dayNum + 5;
		}
		if (food == 6) {// cheese
			expires = dayNum + 2;
		}
		return expires;
	}

	FoodStack<Integer> bunsStack = new FoodStack<Integer>();
	FoodStack<Integer> pattyStack = new FoodStack<Integer>();
	FoodStack<Integer> lettuceStack = new FoodStack<Integer>();
	FoodStack<Integer> tomatoStack = new FoodStack<Integer>();
	FoodStack<Integer> onionStack = new FoodStack<Integer>();
	FoodStack<Integer> cheeseStack = new FoodStack<Integer>();

	// this method must check and organize,put it an array
	public boolean checkexpirationDate(int dayNum, int food) {
		boolean status = false;
		while (!bunsStack.isEmpty() || !pattyStack.isEmpty() || !lettuceStack.isEmpty() || !tomatoStack.isEmpty()
				|| !onionStack.isEmpty() || !cheeseStack.isEmpty()) {
			if (bunsStack.peek() == dayNum) {
				bunsStack.pop();
				bunsWasted++;
				bunsAmount--;
				status = true;
			}
			if (pattyStack.peek() == dayNum) {
				pattyStack.pop();
				pattyWasted++;
				pattyAmount--;
				status = true;

			}
			if (lettuceStack.peek() == dayNum) {
				lettuceStack.pop();
				lettuceWasted++;
				lettuceAmount--;
				status = true;

			}
			if (tomatoStack.peek() == dayNum) {
				tomatoStack.pop();
				tomatoWasted++;
				tomatoAmount--;
				status = true;

			}
			if (onionStack.peek() == dayNum) {
				onionStack.pop();
				onionWasted++;
				onionAmount--;
				status = true;

			}
			if (cheeseStack.peek() == dayNum) {
				cheeseStack.pop();
				cheeseWasted++;
				cheeseAmount--;
				status = true;

			}
		}
		return status;
	}

	int[] buns;
	int[] patty;
	int[] lettuce;
	int[] tomato;
	int[] onion;
	int[] cheese;

	public void organize(int dateNum) {
		for (int i = 0; i < cheeseAmount; i++) {
			if (!checkexpirationDate(dateNum, 1))
				cheese[i] = cheeseStack.pop();
		}
	}

	public void organizeSortandcheckExpiration(int dayNum) {
		buns = new int[bunsAmount];

		for (int i = 0; i < bunsAmount; i++) {
			if (bunsStack.peek() == dayNum) {
				bunsStack.pop();
				bunsAmount--;
				bunsWasted++;
			} else {
				buns[i] = bunsStack.pop();
			}
		}
		sortFoodStacks(buns);
		arraytoStack(buns, 1);
		patty = new int[pattyAmount];
		for (int i = 0; i < pattyAmount; i++) {
			if (pattyStack.peek() == dayNum) {
				pattyStack.pop();
				pattyAmount--;
				pattyWasted++;
			} else {
				patty[i] = pattyStack.pop();
			}
		}
		sortFoodStacks(patty);
		arraytoStack(patty, 2);
		lettuce = new int[lettuceAmount];
		for (int i = 0; i < lettuceAmount; i++) {
			if (lettuceStack.peek() == dayNum) {
				lettuceStack.pop();
				lettuceAmount--;
				lettuceWasted++;
			} else {
				lettuce[i] = lettuceStack.pop();
			}
		}
		sortFoodStacks(lettuce);
		arraytoStack(lettuce, 3);
		tomato = new int[tomatoAmount];
		for (int i = 0; i < tomatoAmount; i++) {
			if (tomatoStack.peek() == dayNum) {
				tomatoStack.pop();
				tomatoAmount--;
				tomatoWasted++;
			} else {
				tomato[i] = tomatoStack.pop();
			}
		}
		sortFoodStacks(tomato);
		arraytoStack(tomato, 4);
		onion = new int[onionAmount];
		for (int i = 0; i < onionAmount; i++) {
			if (onionStack.peek() == dayNum) {
				onionStack.pop();
				onionAmount--;
				onionWasted++;
			} else {
				onion[i] = onionStack.pop();
			}
		}
		sortFoodStacks(onion);
		arraytoStack(onion, 5);
		cheese = new int[cheeseAmount];
		for (int i = 0; i < cheeseAmount; i++) {
			if (cheeseStack.peek() == dayNum) {
				cheeseStack.pop();
				cheeseAmount--;
				cheeseWasted++;
			} else {
				cheese[i] = cheeseStack.pop();
			}
		}
		sortFoodStacks(cheese);
		arraytoStack(cheese, 6);

	}
	/*
	 * public static void isitExpired(int dayNum,){
	 * 
	 * }
	 */

	static int countMove;
	static int countCompare;

	private static void swapNumbers(int[] arr, int i, int index) {
		int biggerNumber = arr[index];
		arr[index] = arr[i];
		arr[i] = biggerNumber;
	}

	public static int[] sortFoodStacks(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index_max = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[index_max]) {
					index_max = j;
				}
				countCompare++;
			}
			swapNumbers(arr, i, index_max);
			countMove++;
		}
		return arr;
	}

	public void arraytoStack(int[] array, int food) {
		if (food == 1)
			for (int i = 0; i < array.length; i++) {
				bunsStack.push(array[i]);
			}
		if (food == 2)
			for (int i = 0; i < array.length; i++) {
				pattyStack.push(array[i]);
			}
		if (food == 3)
			for (int i = 0; i < array.length; i++) {
				lettuceStack.push(array[i]);
			}
		if (food == 4)
			for (int i = 0; i < array.length; i++) {
				tomatoStack.push(array[i]);
			}
		if (food == 5)
			for (int i = 0; i < array.length; i++) {
				onionStack.push(array[i]);
			}
		if (food == 6)
			for (int i = 0; i < array.length; i++) {
				cheeseStack.push(array[i]);
			}
	}

	public void resetDay() {
		lostCustomersDay = 0;
		servedCustomersDay = 0;
		countItemOne = 0;
		countItemTwo = 0;
		countItemThree = 0;
		countItemFour = 0;
		countItemFive = 0;
		countItemSix = 0;
		bunsWasted = 0;
		pattyWasted = 0;
		lettuceWasted = 0;
		tomatoWasted = 0;
		onionWasted = 0;
		cheeseWasted = 0;
	}

	public void state() {
		System.out.println(" lostCostomerDay= " + lostCustomersDay);
		System.out.println(" cheeseWasted= " + cheeseWasted);
		System.out.println(" bunsWasted= " + bunsWasted);
		System.out.println(" pattyWasted= " + pattyWasted);
		System.out.println(" lettuceWasted= " + lettuceWasted);
		System.out.println(" tomatoWasted= " + tomatoWasted);
		System.out.println(" onionWasted=" + onionWasted);
		System.out.println(" countItemOne= " + countItemOne);
		System.out.println(" countItemTwo= " + countItemTwo);
		System.out.println(" countItemThree= " + countItemThree);
		System.out.println(" countItemFour= " + countItemFour);
		System.out.println(" countItemFive= " + countItemFive);
		System.out.println(" countItemSix= " + countItemSix);

	}

}
