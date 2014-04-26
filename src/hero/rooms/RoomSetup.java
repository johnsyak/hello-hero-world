package hero.rooms;

import hero.creatures.Creature;
import hero.creatures.Grue;
import hero.items.Broadsword;
import hero.items.Item;
import hero.items.Shortsword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RoomSetup {
	private Item[] itemIndex;
	private Creature[] creatureIndex;
	private Room[][] roomGrid;
	private String[] descriptionIndex;
	public RoomSetup() {
		itemIndex = new Item[] { null, new Shortsword(), new Broadsword() };
		creatureIndex = new Creature[] { null, new Grue() };
		roomGrid = new Room[2][3];//presets size of grid
		descriptionIndex = new String[]{null, 
		//room 1
		"This is the first room. It is empty except for a single weapon on the floor.",
		//room 2
		"There is a monster here. He doesn't look happy. There's a shield behind him.",
		//room 3
		"Another monster, and a new weapon. Get to killin!!",
		//room 4
		"The lord of all evil; King Emperor Fuzzy Bottom guards the exit." +
		" He gnashes his comfy teeth, and snarls in a hum, purr-like."+
		" 'Welcome to the final challenge, hero. May my vile cuteness be the last thing you see!!"
		};
	}

	public void setUp() throws IOException {
		File roomFile = new File("C:\\goddamnwindows\\roomLayout.txt");
		BufferedReader br = new BufferedReader(new FileReader(roomFile));
		String line;

		int x = 0;
		int y = 0;
		int idCounter = 1;
		while ((line = br.readLine()) != null) {
			// process the line.
			
			String[] roomsOnRow = line.split(",");
			x = 0;
			for (String s : roomsOnRow) {// for loop for string
											// parsing------------------
				String creatureString = s.substring(1, 3);
				String itemString = s.substring(4, 6);
				
				int creatureCode = Integer.parseInt(creatureString);
				int itemCode = Integer.parseInt(itemString);
				Item item;
				if (itemCode == 0) {
					item = null;
				} else {
					item = new Item(itemIndex[itemCode]);
				}
				Creature creature;
				if (creatureCode == 0) {
					creature = null;
				} else {
					creature = new Creature(creatureIndex[creatureCode]);
				}
				String description = descriptionIndex[idCounter];
				Room room = new Room(creature, item, idCounter++, description);
				roomGrid[x][y] = room;
				x++;
			}// End of for loop ------------------------------------
			y++;
		}// end of while loop --------------------------------------
		br.close();

	}

	public Room[][] getRoomGrid() {
		return roomGrid;
	}
}
