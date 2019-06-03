package contract;

import java.io.IOException;

/**
 * <h1>The Interface IOrderPerformed.</h1>
 * 
 * @author Maxime G, Damien B and Benoît D
 * @version 0.1
 */
public interface IOrderPerformer {

	/**
	 * perform an order
	 *
	 */

	void orderPerform(UserOrder userOrder) throws IOException;

}
