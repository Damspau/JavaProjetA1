package contract;

import java.io.IOException;

/**
 * The Interface IBoulderdashController.
 *
 * @author Benoît D, Damiens and Maxime G
 */
public interface IBoulderdashController {

	/**
	 * Order perform.
	 *
	 * @param controllerOrder the controller order
	 * @throws IOException
	 */

	public void orderPerform(UserOrder controllerOrder);

	/**
	 * Play.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	void play() throws InterruptedException;

	/**
	 * Gets the order peformer.
	 *
	 * @return the order peformer
	 */
	IOrderPerformer getOrderPerformer();

}
