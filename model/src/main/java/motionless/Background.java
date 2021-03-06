package motionless;

import java.io.IOException;

import contract.Sprite;
/**
 * <h1>the class Background</h1>
 * @author  Damien B, Maxime G and Benoît D
 * @version 1.0
 */



public class Background extends CommonMotionless{
	private final static Sprite sprite = new Sprite('*', "background.jpg");
	
	public Background() {

		super(sprite);
		
	}
	
	public Background(int x,int y) throws IOException {
		
		super(sprite, x,y);
		
	}

	public Sprite getSprite() {
		return sprite;
	}

}

