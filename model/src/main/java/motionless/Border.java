package motionless;

import java.io.IOException;

import contract.Permeability;
import contract.Sprite;

public class Border extends CommonMotionless {
	private static final Sprite sprite = new Sprite('B', "B.jpg");

	public Border(Sprite sprite, Permeability permeability, int x, int y) {
		super(sprite, permeability, x, y);
		// TODO Auto-generated constructor stub
	}
	
	public Border() {

		super(sprite, Permeability.UNBREAKABLE);

	}

	public Border(int x,int y) throws IOException {

		super(sprite, Permeability.UNBREAKABLE, x,y);

	}

	public Sprite getSprite() {
		return sprite;
	}

}
