package hero.rooms;

import hero.main.Player;


public class RoomChanger {
	public Room[][] grid;
	private int boundaryMaxX;
	private int boundaryMinX;
	private int boundaryMaxY;
	private int boundaryMinY;
	public int posX = 0;
	public int posY = 0;
	public RoomChanger(Room[][] grid) {
		boundaryMinX = 0;
		boundaryMinY = 0;
		boundaryMaxX = grid.length - 1;
		boundaryMaxY = grid[0].length - 1;
	}
	//locates the player on the grid
	public void playerRoom(Player player, Room[][] grid) {
		int x = 0;
		int y = 0;
		outerLoop: for (x = 0; x < grid.length; x++) {
			Room[] column = grid[x];
			for (y = 0; y < column.length; y++) {
				if (grid[x][y] == null) {
					continue;
				}
				if (player.room.roomID == grid[x][y].roomID) {
					break outerLoop;
				}

			}
		}
		//will print out all exits as each room is entered
		if (x - 1 < boundaryMinX || grid[x - 1][y] == null) {
			System.out.println("There is no door west.");
		} else {
			System.out.println("There's a door west.");
		}
		if (x + 1 > boundaryMaxX || grid[x + 1][y] == null) {
			System.out.println("There is no door east.");
		} else {
			System.out.println("There is a door east");
		}
		if (y - 1 < boundaryMinY || grid[x][y - 1] == null) {
			System.out.println("There is no door to the north.");
		} else {
			System.out.println("There is a door to the north");
		}
		if (y + 1 > boundaryMaxY || grid[x][y + 1] == null) {
			System.out.println("There is no door to the south");
		} else {
			System.out.println("There is a door to the south");
		}

		System.out.println(grid[x][y].description);
	}
	//player movement method
	public Room playerMovement(Player player, String input, Room[][] grid) {
		this.grid = grid;
		//north
		if (input.equals("n") || input.equals("north")) {
			if (posY - 1 < boundaryMinY || grid[posX][posY - 1] == null){
				System.out.println("There is no door north.");
			}
			else {
				System.out.println("You go north.");
				posY = posY - 1;
				player.room = grid[posX][posY];
			}
		} 
		
		//east
		if (input.equals("e") || input.equals("east")) {
			if(posX + 1 > boundaryMaxX || grid[posX + 1][posY] == null){
				System.out.println("There is no door east.");
			}
			else {
				System.out.println("You go east.");
				posX = posX + 1;
				player.room = grid[posX][posY];
			}
		} 
		//south
		if (input.equals("s") || input.equals("south")) {
			if(posY + 1 > boundaryMaxY || grid[posX][posY + 1] == null){
				System.out.println("There is no door south");
			}
			else {
				System.out.println("You go south.");
				posY = posY + 1;
				player.room = grid[posX][posY];
			}
		} 
		//west
		if (input.equals("w") || input.equals("west")) {
			if(posX - 1 < boundaryMinX || grid[posX - 1][posY]== null){
				System.out.println("There is no door west");
			}
			else {
				System.out.println("You go west");
				posX = posX - 1;
				player.room = grid[posX][posY];
			}
		} 
	return grid[posX][posY];
	}
}
