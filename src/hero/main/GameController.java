package hero.main;

import hero.creatures.Grue;
import hero.items.Broadsword;
import hero.items.Item;
import hero.items.Shortsword;
import hero.magic.Heal;
import hero.rooms.Room;
import hero.rooms.RoomChanger;

public class GameController<gridPosition> {

	Player player = new Player();
	Battle battle = new Battle();
	Grue grue = new Grue();
	
	public Item item, item2;

	Shortsword shortsword;
	public GameObjects go;

	public GameController(Player player) {

	}

	// game loop method
	public void game(GameObjects go, Room[][] gridArray) {
		RoomChanger rc = new RoomChanger(gridArray);
		player.room = gridArray[0][0];

		

		Shortsword shortsword = new Shortsword();
		Broadsword broadsword = new Broadsword();

		item = shortsword;
		item2 = broadsword;

		boolean gameRunner = true;

		String selection = null;

		// game loop

		gameRunner = true;
		System.out.println("THIS IS JUST A BETA TO SEE FUNCTIONALITY!!");
		while (gameRunner) {
			System.out.println();
			rc.playerRoom(player, gridArray);
			selection = PlayerInput.gameInput();
			if (selection.equals("e") || selection.equals("east")
					|| selection.equals("n") || selection.equals("north")
					|| selection.equals("s") || selection.equals("south")
					|| selection.equals("w") || selection.equals("west")){
				player.room = rc.playerMovement(player, selection, gridArray);
			}

				if (selection.equals("i") || selection.equals("inventory")) {// access
																				// player
																				// inventory
					// ----------------------------------------------------------
					playerInventory();

				}
			if (selection.equals("p") || selection.equals("pickup")) {// tests
																		// the
																		// item
																		// pickup
																		// method
				// -------------------------------------------------------------
				player.setPlayerInventory(broadsword);
				player.setPlayerInventory(shortsword);
				System.out.println("The hero has picked up: " + broadsword.name
						+ ", " + shortsword.name + "!");
			}
			if (selection.equals("c") || selection.equals("character")) {// view
																			// player
																			// stats
				// ----------------------------------------------------------
				player.getPlayerStats();
			}

			if (selection.equals("b") || selection.equals("battle")) {// run a
																		// test
																		// battle
																		// --------------------------------------------
				battle.battleRunner(player, grue);// grue is a
													// placeholder-------------------------------------------
				grue.hp = grue.getMaxHp();
			}
			if (selection.equals("magic") || selection.equals("m")) {// BRAND
																		// NEW
																		// MAGIC
																		// TEST!!!!!----------------------
				Heal heal = new Heal();
				heal.healPlayer(player);
			}

			if (selection.equals("quit") || selection.equals("q")) {// quit game
				// --------------------------------------------------------------------Verify
				// quit
				System.out.println("Are you sure you wish to quit?");
				String quit = PlayerInput.gameMenuInput();
				// verify quit ---------------------------------------------

				if (quit.equals("y") || quit.equals("yes")) {
					gameEnd();
				} else {
					break;
				}

			} else {
				gameRunner = true;
			}
		}
	}// end game loop

	// access player inventory
	// -----------------------------------------------------------------------
	private void playerInventory() {
		String list = player.getPlayerInventory();
		System.out.println(list);
		System.out
				.println("Type [0] to leave inventory without a selection. Or choose which to equip by number: ");
		int itemSelection = PlayerInput.gameSelection();
		if (itemSelection == 0) {
			return;
		} else {
			player.setEquipItem(itemSelection);
		}
	}

	public void gameEnd() {// game ending method
							// ----------------------------------------------------------
		System.exit(0);
	}
}
