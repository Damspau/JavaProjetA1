package mobile;

import java.io.IOException;
/**
 * <h1>the class MobileElementsFactory</h1>
 * @author  Damien B, Maxime G and Benoît D
 * @version 1.0
 */
public class MobileElementsFactory {
	private CommonMobile toReturn;
	/**
	 * Identify with the symbol the object to create
	 */
	public CommonMobile getFromFileSymbol(final char fileSymbol, int x, int y) throws IOException {
		switch (fileSymbol) {
		case 'P':
			Player player = new Player(x, y,null);
			toReturn = player;

			break;
		case 'R':
			Rock rock = new Rock(x, y, null);
			toReturn = rock;

			break;
		case 'D':
			Diamond diamond = new Diamond(x, y, null);
			toReturn = diamond;

			break;
		default:
			toReturn = null;
			break;
		}

		return toReturn;
	}

}
