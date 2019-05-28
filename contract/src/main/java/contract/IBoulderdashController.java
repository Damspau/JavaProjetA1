package contract;

import java.io.IOException;

import view.IOrderPerformer;
import view.UserOrder;

/**
 * The Interface IBoulderdashController.
 *
 * @author Benoît D, Damiens and Maxime G
 */
public interface IBoulderdashController {

	/**
	 * Controller.
	 */
	public void controller();

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
