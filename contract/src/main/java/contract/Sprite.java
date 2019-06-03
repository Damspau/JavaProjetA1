package contract;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * <h1>The Sprite Class.</h1>
 *
 * @author Benoît D, Maxime G and Damiens
 * @version 0.1
 */

public class Sprite {
	private Image image;
	private String imageName;

	public Sprite(char character, String imageName) {
		try {
			this.setImageName(imageName);
			this.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public final void loadImage() throws IOException {
		System.out.println();
		String spriteName = "sprites/" + this.getImageName();

		this.setImage(ImageIO.read(new File(spriteName)));
	}
}
