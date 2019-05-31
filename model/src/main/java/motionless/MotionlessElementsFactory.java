package motionless;

import java.io.IOException;

public class MotionlessElementsFactory {

	private CommonMotionless toReturn;

	public CommonMotionless getFromFileSymbol(final char fileSymbol) throws IOException {

		switch (fileSymbol) {
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

		case '*':
			Background background = new Background();
			toReturn = background;
			break;

		default:
			toReturn = null;
			break;
		}
		return toReturn;

	}
}
