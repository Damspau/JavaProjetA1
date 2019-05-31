package contract;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
private Image image;
private String imageName;

private char bddImage;
//private boolean imageLoaded;



public Sprite (char character, String imageName) {
	try {
		this.setImageName(imageName);
		this.loadImage();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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


public final void loadImage() throws IOException {
	System.out.println();
	String spriteName = "sprites/"+ this.getImageName();
	
	this.setImage(ImageIO.read(new File(spriteName)));
}
}
