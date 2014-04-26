/*
 * Hello, Hero World!!
 * Author John Yakscoe
 */

package hero.main;

import hero.rooms.Room;
import hero.rooms.RoomSetup;

import java.io.IOException;

public class Main {
	
	
	public Main() {

	}

	public static void main(String[] args) {
		
		System.out.println("Welcome to Hero World!!");
		System.out
				.println("Type 'exit' or 'e' during movement phase to quit at anytime!");
		RoomSetup rs = new RoomSetup();
		GameController<?> control = new GameController<Object>(null);
		
		try {
			rs.setUp();
		} catch (IOException e) { // e.printStackTrace();

		}
		Room[][] grid;
		grid = rs.getRoomGrid();
		
		control.game(null, grid);
		
		System.out.println();
		control.gameEnd();

	}
}
