package motionless;

import java.io.IOException;

import contract.Sprite;
/**
 * <h1>the class CommonMotionless</h1>
 * @author  Damien B, Maxime G and Benoît D
 * @version 1.0
 */
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
