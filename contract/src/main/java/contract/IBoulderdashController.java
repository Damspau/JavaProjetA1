package contract;

import controller.ControllerOrder;
import controller.IOrderPerformer;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IBoulderdashController {

	/**
	 * Control.
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */


	public void play() throws InterruptedException;

	public IOrderPerformer getOrderPerformer();

	public void controller();

	public void orderPerform(ControllerOrder controllerOrder);



}



