package motionless;

import java.io.IOException;
import contract.*;

import contract.IMap;



public class Background extends CommonMotionless{
	private static final Sprite SPRITE = new Sprite('b', "background.jpg");
	
	public Background() {
		super(SPRITE, Permeability.UNBREAKABLE);
		try {
			SPRITE.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Background(int x,int y) throws IOException {
		
		super(SPRITE, Permeability.UNBREAKABLE, x,y);
		SPRITE.loadImage();
		// TODO Auto-generated constructor stub
	}

	public Sprite getSprite() {
		return SPRITE;
	}

}

