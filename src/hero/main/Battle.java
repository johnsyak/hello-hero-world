package hero.main;

import hero.creatures.Creature;
import hero.creatures.Monster;

public class Battle {

	Creature creature = new Creature();

	public int damageTaken;
	private boolean playerHasAttacked;
	private boolean monsterHasAttacked;

	double playerSpeed;
	double monsterSpeed;

	@SuppressWarnings("unused")
	private Creature player;
	@SuppressWarnings("unused")
	private Creature attacker;
	@SuppressWarnings("unused")
	private Creature defender;

	public Battle() {

	}

	public void battleRunner(Player player, Monster monster) {// passes monster
																// into battle
																// from
																// controller
		this.player = player;
		System.out.println("Battle begins!! " + monster.name
				+ " is attacking!!");

		// Battle runner loop

		while (player.hp >= 0 || monster.hp >= 0) {
			initiative(player, monster);// initiative loop
										// -----------------------------------
			if (player.hp <= 0) {
				System.out.println(" EPIC FAILURE! The Grue has won. You were likely eaten by it.");
				break;
			}
			if (monster.hp <= 0) {
				System.out.println();
				System.out.println(" The hero won.");
				player.setPlayerExp(monster.exp);
				break;
			}

			// End battle runner loop-------------------------------------
		}
		System.out.println("Battle has ended.");

		player.speed = player.getMaxSpeed();
	}

	/*
	 * test for initiative--------------------------------------------
	 */
	private void initiative(Player player, Monster monster) {
		
		playerSpeed = Math.random() + player.speed;
		monsterSpeed = Math.random() + monster.speed;
		if (playerSpeed >= monsterSpeed && !playerHasAttacked && player.hp > 0) {
			attackSpeed(player, monster);
			playerHasAttacked = true;
			monsterHasAttacked = false;
		}
		if (!monsterHasAttacked && !monsterHasAttacked && monster.hp > 0) {
			attackSpeed(monster, player);
			playerHasAttacked = false;
			monsterHasAttacked = true;
		}
	}// End test for initiative--------------------------------------

	private void attackSpeed(Creature attacker, Creature defender) {// will pass
																	// in either
																	// player or
																	// monster
		// in the order that they will be
		// rolled-----------------------------------
		this.attacker = attacker;
		this.defender = defender;
		double speedDecrement = 0.5;
		double speed = 0;
		defender.hp = damageDealt(attacker, defender);
		for (speed = attacker.speed; speed > defender.speed; speed -= speedDecrement) {
			if(defender.hp <= 0){
				defender.hp = 0;
				break;
			}
			defender.hp = damageDealt(attacker, defender);
			
			if (defender.hp <= 0) {
				defender.hp = 0;
				break;
			}
		}
		System.out.println("------------------Next Attacker--------------------");
	}

	// Damage dealer method---------------------------------------------
	
	private int damageDealt(Creature attacker, Creature defender) {
		this.attacker = attacker;
		this.defender = defender;
		int critChance = (int)(Math.round(Math.random() * 100));
		critChance = critChance + attacker.critRoll;
		int damageRoll = (int)(Math.round(Math.random() * attacker.damageRoll + 1));
		if(critChance > 100){
			damageTaken = defender.hp - (attacker.damage * 2);
			System.out.println("A crit has been scored!!");
			System.out.println(""+attacker.name+ " scores a mighty blow! "+damageTaken+" Has been dealt.");
			System.out.println(""+defender.name+" has "+damageTaken+" left!");
		}
		else{
		int attackerDamage = attacker.damage + damageRoll;
		damageTaken = defender.hp - (attacker.damage + damageRoll);
		if(damageTaken < 0){
			damageTaken = 0;
		}
		System.out.println("" + attacker.name + " swings! Damage dealt is "
				+ attackerDamage);
		System.out.println(""+defender.name+" has "+damageTaken+" left!");
		}
		return damageTaken;
	}

}// End damage dealer method

