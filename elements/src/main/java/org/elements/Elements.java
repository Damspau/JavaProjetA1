package org.elements;

import java.awt.Image;
import contract.*;
public abstract class Elements implements IElements{
	protected int y;
	protected int x;
	
	
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
		
	}
	

	
	protected void setSprite(Sprite sprite) {
		
	}
	
	private void setPermeability(Permeability permeability) {
		
	}
	
	public Sprite getSprite  () {
		return null;
	}
	
	public Permeability getPermeability (){
		return null;
	}
	
	public Image getImage () {
		return null;
		
	}
}


