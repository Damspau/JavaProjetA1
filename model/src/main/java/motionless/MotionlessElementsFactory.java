package motionless;

import java.io.IOException;

public class MotionlessElementsFactory {

	private CommonMotionless toReturn;

public CommonMotionless getFromFileSymbol(final char fileSymbol) throws IOException {

	switch (fileSymbol) {
	case 'B':
		Background background = new Background();
		toReturn = background;
		break;

	case '-':
		Dirt dirt = new Dirt();
		toReturn = dirt;
		break;
	default:
		toReturn = null;
		break;
	}
	return toReturn;
	
}
}
