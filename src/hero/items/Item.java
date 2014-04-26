package hero.items;

import hero.main.GameObjects;

public class Item extends GameObjects{
	
	public int critRoll;
	public int damageRoll;
	
	public Item() {
		
		}
	protected void init(String name){
		this.name = name;
		}
	
	public Item(Item item) {
		this.name = item.name;
		this.damage = item.damage;
	}
}
