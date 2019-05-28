package contract;

import java.io.IOException;

/**
 * <h1>The Interface IOrderPerformed.</h1>
 * 
 * @author Maxime G, Damiens and Benoît D
 * @version 0.1
 */
public interface IOrderPerformer {

	/**
	 * Order perform.
	 *
	 * @param userOrder the user order
	 * @throws IOException Signals that an I/O exception has occurred.
	 */

	public void orderPerform(UserOrder userOrder) throws IOException;

}
