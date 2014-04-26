package hero.main;

import hero.creatures.Creature;
import hero.items.Item;
import hero.rooms.Room;

import java.util.ArrayList;

public class Player extends Creature {
	public Room room;
	public String playerInventoryList;
	public ArrayList<Item> inventory = new ArrayList<Item>();
	public Item item;
	public int maxHp = 10;
	public double maxSpeed = 0.2;
	public int lvl = 1;
	public int exp = 0;
	public int nextLvlReq = 100;
	public int monsterExp;
	
	Item equipItem;

	public Player() {
		super("Bobmyman", 2, 0, 0, 0.1, 10);
		
	}

	public void setPlayerExp(int monsterExp) {// method called for adding in
												// player experience
		this.monsterExp = monsterExp;
		exp = exp + monsterExp;
		System.out.println("Your current exp is: " + exp);
		while (exp >= nextLvlReq) {// will continually call next level as long
									// as the player has more exp than required

			setNextLevel();
		}

	}

	public void setNextLevel() {// method that adjusts stats at
								// level----------------
		lvl++;
		damage++;
		maxSpeed = Math.round(speed * 100.0) / 100 + 0.2;
		hp = hp + 5;
		maxHp = maxHp + 5;

		nextLvlReq = (nextLvlReq + 5) * 2;
		System.out.println("Your level becomes: " + lvl + "!");
		System.out.println("Your damage is now: " + damage + "!");
		System.out.println("Your speed is now: " + speed + "!");
		System.out.println("Your hitpoints are now: " + hp + "!");
		System.out.println("Your next level is now at: " + nextLvlReq + "!");
	}

	public void getPlayerStats() {//called by character stats
		System.out.println("Your level is: " + lvl + "!");
		System.out.println("Your damage is: " + damage + "!");
		System.out.println("Your speed is: " + speed + "!");
		System.out.println("Your hitpoints are currently: " + hp + "!");
		System.out.println("Your next level is at: " + nextLvlReq + "!");
	}

	public void setPlayerInventory(Item item) {//will add an item directly to player inventory
		inventory.add(item);
		String inventoryList = "";
		int itemId = 1;
		for (Item i : inventory) {
			inventoryList += i.name + " (" + (itemId++) + "), ";
		}

		inventoryList = inventoryList.substring(0, inventoryList.length() - 2);//makes inventory list into string and cuts off last comma
		playerInventoryList = "You are currently carrying: " + inventoryList;
	}

	public String getPlayerInventory() {//calls inventory list
		if (playerInventoryList == null) {
			return "You currently have nothing!";
		} else {
			return playerInventoryList;
		}
	}

	public void setEquipItem(int ID) {//passes in ID for the player choice

		if (ID > inventory.size() || equipItem != null) {
			System.out.println("The choice is invalid!");
		}

		else {//equips item and adjusts stats
			equipItem = inventory.get(ID - 1);
			damage = damage + equipItem.damage;
			speed = speed + equipItem.speed;
			maxSpeed = maxSpeed + equipItem.speed;
			critRoll = critRoll + equipItem.critRoll;
			damageRoll = damageRoll + equipItem.damageRoll;
			inventory.remove(equipItem);
			System.out.println("Hero is now equipped with: " + equipItem.name
					+ ".");
			inventory.remove(equipItem);
		}

	}

	public int getMaxHp() {//needed to return hero to full hp
		return maxHp;
	}

	public double getMaxSpeed() {//needed to return hero to full speed
		return maxSpeed;
	}
}
