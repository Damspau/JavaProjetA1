package controller;

public interface IBoulderDashController {

	/**
	 * Play.
	 *
	 * @throws InterruptedException the interrupted exception
	 */

	public void play() throws InterruptedException;

	public IOrderPerformer getOrderPerformer();

	public void controller();

	public void orderPerform(ControllerOrder controllerOrder);

}
