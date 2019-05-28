package motionless;

import java.io.IOException;
import contract.*;

import contract.IMap;



public class Background extends CommonMotionless{
	private static final Sprite SPRITE = new Sprite('b', "background.jpg");
	public Background(Sprite sprite, Permeability permeability,IMap map, int x,int y) throws IOException {
		
		super(sprite, Permeability.UNBREAKABLE, map, x,y);
		SPRITE.loadImage();
		// TODO Auto-generated constructor stub
	}

}

