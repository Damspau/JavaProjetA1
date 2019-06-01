package mobile;

import java.io.IOException;

public class MobileElementsFactory {
	private CommonMobile toReturn;

	public CommonMobile getFromFileSymbol(final char fileSymbol, int x, int y) throws IOException {
		switch (fileSymbol) {
		case 'P':
			Player player = new Player(x, y,null);
			toReturn = player;

			break;
		case 'R':
			Rock rock = new Rock(x, y);
			toReturn = rock;

			break;
		case 'D':
			Diamond diamond = new Diamond(x, y);
			toReturn = diamond;

			break;
		default:
			toReturn = null;
			break;
		}

		return toReturn;
	}

}
