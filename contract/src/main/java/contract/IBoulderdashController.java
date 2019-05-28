package contract;

import java.io.IOException;

import view.IOrderPerformer;
import view.UserOrder;

/**
 * The Interface IBoulderdashController.
 *
 * @author Benoît D, Damiens et Maxime G
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


	public void play() throws InterruptedException;

	public IOrderPerformer getOrderPerformer();

}
