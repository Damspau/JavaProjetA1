package motionless;

import contract.Permeability;
import contract.Sprite;

public class Border extends CommonMotionless {
	private static final Sprite SPRITE = new Sprite('B', "B.jpg");

	public Border(Sprite sprite, Permeability permeability, int x, int y) {
		super(sprite, permeability, x, y);
		// TODO Auto-generated constructor stub
	}

}
