package elements;

import java.awt.Image;
import contract.*;
import fr.exia.showboard.*;
public abstract class Elements implements IElements, IPawn{
	protected int y;
	protected int x;
	
	private Sprite sprite;
	private Permeability permeability;
	
	
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

	
	
	public Elements (Sprite sprite, Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}
	

	

	

	
	public final Sprite getSprite  () {
		return this.sprite;
	}
	
	protected void setSprite(Sprite sprite) {
		this.sprite = sprite;
		
	}
	
	public Permeability getPermeability (){
		return this.permeability;
	}
	
	private void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}
	
	public final Image getImage () {
		return this.getSprite().getImage();
		
	}
}


