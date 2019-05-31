package motionless;

import java.io.IOException;

import contract.Permeability;
import contract.Sprite;

public class ExitDoor extends CommonMotionless {
	private static final Sprite sprite = new Sprite('E', "background.jpg");
	
	public ExitDoor() {

		super(sprite, Permeability.UNBREAKABLE);
		
	}
	
	public ExitDoor(int x,int y) throws IOException {
		
		super(sprite, Permeability.UNBREAKABLE, x,y);
		
	}

	public Sprite getSprite() {
		return sprite;
	}


}
