package motionless;

import java.io.IOException;
import contract.*;




public class Background extends CommonMotionless{
	private final static Sprite sprite = new Sprite('B', "B.jpg");

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
