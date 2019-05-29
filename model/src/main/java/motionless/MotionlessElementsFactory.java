package motionless;

import java.io.IOException;

public class MotionlessElementsFactory {
	private static Background background = new Background();
//	private CommonMotionless[] motionlessElements = {
//			background
//	};
//	
//	

//	public static  CommonMotionless createBackground (int x, int y) throws IOException {
//		background = (Background) createBackground(x, y);
//		return background;
//	}

public CommonMotionless getFromFileSymbol(final char fileSymbol) throws IOException {
	
	
	return background;
	
}
}
