package mobile;

import java.io.IOException;

public class MobileElementsFactory {
	private CommonMobile toReturn;

	public CommonMobile getFromFileSymbol(final char fileSymbol) throws IOException {
		switch (fileSymbol) {
		case 'p':
			Player player = new Player();
			toReturn = player;

			break;

		default:
			toReturn = null;
			break;
		}

		return toReturn;
	}

}
