package motionless;

import contract.Permeability;
import contract.Sprite;

public class Dirt extends CommonMotionless{
	private static final Sprite SPRITE = new Sprite('d', "background.jpg");
	public Dirt(Sprite sprite, Permeability permeability, int x,int y) {
		super(SPRITE, Permeability.UNBREAKABLE, x,y);
		
		// TODO Auto-generated constructor stub
	}

}
