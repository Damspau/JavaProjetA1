package contract;

import contract.IMap;
import org.showboard.*;

/**
 * <h1>The Interface IBoulderdashView.</h1>
 *
 * @author Maxime G, Benoît D and Damien B
 */
public interface IBoulderdashView {
	
	/**
	 * return the maps
	 
	 */
	IMap getMap();
	
	/**
	 * return the player
	 
	 */
	IElements getMyPlayer();
	/**
	 * return the boardFrame
	 
	 */
	BoardFrame getBoardFrame();


}
