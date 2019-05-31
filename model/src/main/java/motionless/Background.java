package motionless;

import java.io.IOException;

import contract.Permeability;
import contract.Sprite;




public class Background extends CommonMotionless{
	private final static Sprite sprite = new Sprite('b', "b.jpg");
	
	public Background() {

		super(sprite, Permeability.UNBREAKABLE);
		
	}
	
	public Background(int x,int y) throws IOException {
		
		super(sprite, Permeability.UNBREAKABLE, x,y);
		
	}

	public Sprite getSprite() {
		return sprite;
	}
	

}

