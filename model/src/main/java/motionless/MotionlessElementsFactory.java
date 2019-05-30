package motionless;

import java.io.IOException;

public class MotionlessElementsFactory {

	private CommonMotionless toReturn;

public CommonMotionless getFromFileSymbol(final char fileSymbol) throws IOException {

	switch (fileSymbol) {
	case 'b':
		Background background = new Background();
		toReturn = background;
		break;

	case 't':
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
