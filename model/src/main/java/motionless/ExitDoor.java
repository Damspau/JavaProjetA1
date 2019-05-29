package motionless;

import contract.Permeability;
import contract.Sprite;

public class ExitDoor extends CommonMotionless {
	private static final Sprite SPRITE = new Sprite('E', "background.jpg");
	public ExitDoor(Sprite sprite, Permeability permeability,int x,int y) {
		super(sprite, permeability, x, y);
		// TODO Auto-generated constructor stub
	}

}
