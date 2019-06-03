package motionless;

import java.io.IOException;

import contract.Sprite;

public class Dirt extends CommonMotionless{
	private final static Sprite sprite = new Sprite('-', "-.jpg");
	
	public Dirt() {
		// TODO Auto-generated constructor stub
		super(sprite);
	}
	
	public Dirt(int x,int y) throws IOException {
		
		super(sprite, x,y);
		
	}

	public Sprite getSprite() {
		return sprite;
	}

}
