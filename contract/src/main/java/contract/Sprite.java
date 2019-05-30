package contract;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
private Image image;
//private String imageName;
private char bddImage;
//private boolean imageLoaded;



public Sprite (char character, String imageName) {
	try {
		loadImage(imageName);
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

//public String getImageName() {
//	return imageName;
//}

//public void setImageName(String imageName) {
//	this.imageName = imageName;
//}



public char getBddImage() {
	return bddImage;
}



public void setBddImage(char bddImage) {
	this.bddImage = bddImage;
}


<<<<<<< HEAD
//checking if the sprite is loaded
//public boolean isImageLoaded () {
//	return this.imageLoaded;
//}



=======
>>>>>>> branch 'BenoitSBranchMaven' of https://github.com/Damspau/JavaProjetA1.git
public final void loadImage(String imageName) throws IOException {
	String spriteName = "sprites/"+ imageName;
	System.out.println(spriteName);
	this.setImage(ImageIO.read(new File(spriteName)));
}
}
