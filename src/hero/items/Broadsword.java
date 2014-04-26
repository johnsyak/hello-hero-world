package hero.items;

public class Broadsword extends Weapon{

	public Broadsword() {
		super("Broadsword", 2, 3, 10, 0.2);
	}
	public Broadsword(Broadsword broadsword){
		super(broadsword);
	}
}
