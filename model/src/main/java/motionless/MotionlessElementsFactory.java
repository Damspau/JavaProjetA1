package motionless;

import java.io.IOException;
/**
 * <h1>the class MotionlessElementsFactory</h1>
 * @author  Damien B, Maxime G and Benoît D
 * @version 1.0
 */
public class MotionlessElementsFactory {

	private CommonMotionless toReturn;
/**
 * return the element according to the character

 */
public CommonMotionless getFromFileSymbol(final char fileSymbol) throws IOException {

	switch (fileSymbol) {
	case '*':
		Background background = new Background();
		toReturn = background;
		break;
		
	case 'B':
		Border border = new Border();
		toReturn = border;
		break;

	case '-':
		Dirt dirt = new Dirt();
		toReturn = dirt;
		break;
	case 'E':
		ExitDoor exitDoor = new ExitDoor();
		toReturn = exitDoor;
		break;
	default:
		toReturn = null;
		break;
	}
	
	
	return toReturn;
	
}
}
