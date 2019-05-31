package mobile;

import java.io.IOException;

public class MobileElementsFactory {
	private CommonMobile toReturn;

	public CommonMobile getFromFileSymbol(final char fileSymbol) throws IOException {
		switch (fileSymbol) {
		case 'P':
			Player player = new Player();
			toReturn = player;

			break;

		case 'D':
			Diamond diamond = new Diamond();
			toReturn = diamond;

			break;

		case 'R':
			Rock rock = new Rock();
			toReturn = rock;

			break;
		default:
			toReturn = null;
			break;
		}

		return toReturn;
	}

}
