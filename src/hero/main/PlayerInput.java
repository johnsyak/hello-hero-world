package hero.main;

import java.util.Scanner;

public class PlayerInput {

	static int gameSelection() {// integer scanner
								// ----------------------------------------

		@SuppressWarnings("resource")
		Scanner selectionScanner = new Scanner(System.in);
		boolean eventCatcher = true;
		String selectionInput = null;
		int selection = 0;

		while (eventCatcher) {
			try {
				System.out.println("Enter your selection by numeral.");
				selectionInput = selectionScanner.next();
				selection = Integer.parseInt(selectionInput);
			}
			catch (NumberFormatException e){
				System.out.println("This is an invalid choice.");
				System.out.println("Please choose again.");
				}
			

			eventCatcher = false;
		}
		
		return selection;
	}

	static String gameInput() {// String scanner ---------------------------

		@SuppressWarnings("resource")
		Scanner movementScanner = new Scanner(System.in);
		String movement = null;
		System.out.println();
		System.out
				.println("[i = i/inventory, c/character = stats, p/pickup = get weapon, m/magic = cast heal, b/battle = test battle] Enter your choice");
		movement = movementScanner.next();
		
		return movement;
	}

	
	static String gameMenuInput() {// menu scanner ---------------------------

		@SuppressWarnings("resource")
		Scanner gameMenu = new Scanner(System.in);
		String menuInput = gameMenu.next();
		
		return menuInput;
		

	}

}
