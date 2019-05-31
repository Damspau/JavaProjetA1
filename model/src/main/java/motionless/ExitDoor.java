package motionless;

import java.io.IOException;

import contract.Permeability;
import contract.Sprite;

public class ExitDoor extends CommonMotionless {
	private static final Sprite sprite = new Sprite('E', "E.jpg");

	public ExitDoor(Sprite sprite, Permeability permeability, int x, int y) {
		super(sprite, permeability, x, y);
		// TODO Auto-generated constructor stub
	}

	public ExitDoor() {

		super(sprite, Permeability.UNBREAKABLE);

	}

	public ExitDoor(int x, int y) throws IOException {

		super(sprite, Permeability.UNBREAKABLE, x, y);

	}

	public Sprite getSprite() {
		return sprite;
	}

}
