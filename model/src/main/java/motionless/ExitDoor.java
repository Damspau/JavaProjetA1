package motionless;

import java.io.IOException;

import contract.Sprite;

public class ExitDoor extends CommonMotionless {
	private static final Sprite sprite = new Sprite('E', "E.jpg");
	
	public ExitDoor() {

		super(sprite);
		
	}
	
	public ExitDoor(int x,int y) throws IOException {
		
		super(sprite, x,y);
		
	}

	public Sprite getSprite() {
		return sprite;
	}


}
