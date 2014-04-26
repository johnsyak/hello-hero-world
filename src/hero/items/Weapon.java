package hero.items;

public class Weapon extends Item {

	protected double critRoll;

	public Weapon(String name, int damage, int damageRoll, int critRoll,
			double speed) {// rollDamage, and critChance are unused atm
							// ------------
		this.speed = speed;
		this.damage = damage;
		this.critRoll = critRoll;
		this.damageRoll = damageRoll;
		super.init(name);

	}

	public Weapon(Weapon weapon) {
		super(weapon);
	}
}
