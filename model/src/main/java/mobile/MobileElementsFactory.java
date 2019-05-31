package mobile;

import java.io.IOException;


public class MobileElementsFactory {
	private CommonMobile toReturn;
 
	
	
	public CommonMobile getFromFileSymbol (final char fileSymbol,int x, int y) throws IOException {
		switch (fileSymbol) {
		case 'p':
			Player player = new Player (x, y, null);
			toReturn = player;
			
			break;

		default:
			toReturn=null;
			break;
		}
		
		
		return toReturn;
	}
	

}
