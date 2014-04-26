package hero.creatures;

public class Monster extends Creature {

	public int exp;
	public Monster(String name, int damage, int damageRoll, int critRoll, double speed, int hp, int exp) {
		//name, damage, damageRoll, critRoll, speed, hp, exp
		super(name, damage, damageRoll, critRoll, speed, hp);
		this.exp = exp;
		this.speed = speed;
		this.damage = damage;
		this.critRoll = critRoll;
	}
	public Monster(Monster monster){
		super(monster);
	}
}
