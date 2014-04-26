package hero.magic;

import hero.main.Player;

public class Heal extends Spell {
	Player player;
	public Heal() {
		super("Heal", 0);
		
	}
	public void healPlayer(Player player){
		this.player = player;
		player.hp = player.getMaxHp();
		System.out.println("The hero has fully healed!");
	}

}
