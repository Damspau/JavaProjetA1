package motionless;

import java.io.IOException;

public class MotionlessElementsFactory {

	private CommonMotionless toReturn=null;

public CommonMotionless getFromFileSymbol(final char fileSymbol) throws IOException {

	switch (fileSymbol) {
	case 'b':
		Background background = new Background();
		toReturn = background;
		break;

	default:
		
		break;
	}
	
	
	return toReturn;
	
}
}
