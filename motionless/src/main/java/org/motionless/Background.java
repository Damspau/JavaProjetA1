package org.motionless;

import org.elements.Permeability;
import org.elements.Sprite;

import fr.exia.insanevehicles.model.element.motionless.MotionlessElement;

public class Background extends CommonMotionless{

	public Background(Sprite sprite, Permeability permeability) {
		private static final Sprite SPRITE = new Sprite(']', "DitchRight.jpg");
		super(sprite, permeability );
		// TODO Auto-generated constructor stub
	}

}

class DitchRightTurnRight extends MotionlessElement {

   /** The Constant SPRITE. */
   private static final Sprite SPRITE = new Sprite(')', "DitchRightTurnRight.jpg");

   /**
    * Instantiates a new ditch.
    */
   DitchRightTurnRight() {
       super(SPRITE, Permeability.BLOCKING);
   }
}