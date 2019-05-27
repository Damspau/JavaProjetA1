package controller;

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
	 */
	public void orderPerform(UserOrder controllerOrder);

	public void play() throws InterruptedException;

	public IOrderPerformer getOrderPerformer();

}
