package motionless;

import java.io.IOException;
import contract.*;

import contract.IMap;



public class Background extends CommonMotionless{
	private static final Sprite SPRITE = new Sprite('b', "b.jpg");
	
	public Background() {

		super(SPRITE, Permeability.UNBREAKABLE);
		
	}
	
	public Background(int x,int y) throws IOException {
		
		super(SPRITE, Permeability.UNBREAKABLE, x,y);
		
	}

	public Sprite getSprite() {
		return SPRITE;
	}

}

