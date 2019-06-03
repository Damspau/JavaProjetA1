package motionless;

import java.io.IOException;

import contract.Sprite;
/**
 * <h1>the class Border</h1>
 * @author  Damien B, Maxime G and Benoît D
 * @version 1.0
 */
public class Border extends CommonMotionless {
	
	private static final Sprite sprite = new Sprite('B', "B.jpg");
	
	public Border() {

		super(sprite);
		
	}
	
	public Border(int x,int y) throws IOException {
		
		super(sprite, x,y);
		
	}

	public Sprite getSprite() {
		return sprite;
	}

}
