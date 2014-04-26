package hero.creatures;

public class Grue extends Monster {

	public Grue() {
		super("Grue", 2, 2, 10, 0.3, 10, 100);
	}
	public Grue(Grue grue){
		super(grue);
	}
	public int getMaxHp(){
		int maxHp = 10;
		return maxHp;
	}

}
