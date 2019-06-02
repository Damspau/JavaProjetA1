package motionless;

import java.io.IOException;

import contract.Permeability;
import contract.Sprite;

public class Dirt extends CommonMotionless{
	private final static Sprite sprite = new Sprite('-', "-.jpg");
	
	public Dirt() {
		// TODO Auto-generated constructor stub
		super(sprite, Permeability.UNBREAKABLE);
	}
	
	public Dirt(int x,int y) throws IOException {
		
		super(sprite, Permeability.BREAKABLE, x,y);
		
	}

	public Sprite getSprite() {
		return sprite;
	}

}
