package elements;

import java.awt.Image;
import contract.*;
import org.showboard.*;
/**
 * <h1>the class Elements</h1>
 * @author Maxime G, Damien B et Benoît D
 * @version 1.0
 */
public abstract class Elements implements IElements, IPawn {
	protected int y;
	protected int x;

	private Sprite sprite;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Elements(Sprite sprite) {
		this.setSprite(sprite);
	}

	public Sprite getSprite() {
		return this.sprite;
	}

	protected void setSprite(Sprite sprite) {
		this.sprite = sprite;

	}

	public final Image getImage() {
		return this.getSprite().getImage();

	}
}
