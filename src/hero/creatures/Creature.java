package hero.creatures;

public class Creature {

	public double speed;
	public int damage;
	public int hp;
	public int damageRoll;
	public String name;
	public int critRoll;
	
	public Creature() {

	}
	public Creature(String name, int damage, int damageRoll, int critRoll, double speed, int hp) {
		this.name = name;
		this.damage = damage;
		this.damageRoll = damageRoll;
		this.hp = hp;
		this.speed = speed;
		this.critRoll = critRoll;
		
		}
	public Creature(Creature creature){
		this.name = creature.name;
		this.damage = creature.damage;
		this.hp = creature.hp;
		this.speed = creature.speed;
		this.critRoll = creature.critRoll;
		
	}
}
