package motionless;



public abstract class MotionlessElementsFactory {
	private static Background background;
	private static CommonMotionless[] motionlessElements = {
			background,
	};

	public  CommonMotionless createBackground () {
		return background;
	}
	
public static CommonMotionless getFromFileSymbol(final char fileSymbol) {
	for (final CommonMotionless motionlessElement : motionlessElements) {
        if (motionlessElement.getSprite().getBddImage() == fileSymbol) {
            return motionlessElement;
        }
	} return background;
	
}
}
