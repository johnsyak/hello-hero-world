package hero.rooms;

import hero.creatures.Creature;
import hero.items.Item;
import hero.main.GameObjects;

public class Room extends GameObjects {

	public int roomID;
	protected int coordinateX;
	protected int coordinateY;
	public Creature creature;
	public Item item;
	public String description;
	public Room(Creature creature, Item item, int roomID, String description)
	{
		this.roomID = roomID;
		this.item = item;
		this.creature = creature;
		this.description = description;
	}
	protected void init(int coordinateX, int coordinateY)
	{
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		
	}


}
