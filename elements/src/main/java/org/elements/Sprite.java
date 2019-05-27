package org.elements;

import java.awt.Image;

public class Sprite {
private Image image;
private String imageName;
private char bddImage;
private boolean imageLoaded;


public Sprite (char character, String imageName) {
	
}

//Overwrite

public Sprite (char character) {
	
}

public Image getImage() {
	return image;
}

public void setImage(Image image) {
	this.image = image;
}

public String getImageName() {
	return imageName;
}

public void setImageName(String imageName) {
	this.imageName = imageName;
}

public char getBddImage() {
	return bddImage;
}

public void setBddImage(char bddImage) {
	this.bddImage = bddImage;
}

public void setImageLoaded(boolean imageLoaded) {
	this.imageLoaded = imageLoaded;
}

//checking if the sprite is loaded
public boolean isImageLoaded () {
	return this.imageLoaded;
}

}
