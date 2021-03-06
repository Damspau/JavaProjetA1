package contract;

import java.io.IOException;

/**
 * <h1>The Interface IBoulderdashController.</h1>
 *
 * @author  Damien B, Maxime G, Benoît D,
 */

public interface IBoulderdashController {
	/**
	 * realize the order send
	 
	 * 
	 */
	void orderPerform(UserOrder controllerOrder) throws IOException;
	/**
	 * This method is running while the game is on, it's calling all the physical testing function
	 
	 *
	 */
	void play() throws InterruptedException, IOException;
	
	/**
	 * return the controller
	
	 */
	IOrderPerformer getOrderPerformer();

}
