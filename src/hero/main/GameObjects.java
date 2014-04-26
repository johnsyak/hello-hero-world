package hero.main;

import hero.items.Item;
import hero.items.Shortsword;

import java.util.ArrayList;


public class GameObjects extends GameController<Object> {
	private static Player Player;
	
	protected String name;
	protected int damage;
	protected double speed;
	public GameObjects() {
		super(Player);
	}
	
	public void gameItems(){
	ArrayList<Item> gameInventory = new ArrayList<Item>();
	gameInventory.add(new Shortsword());
	
	}
	
	public void remove(Item item){
		
	}
	
}
