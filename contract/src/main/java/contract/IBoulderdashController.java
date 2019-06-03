package contract;

import java.io.IOException;

/**
 * The Interface IBoulderdashController.
 *
 * @author Benoît D, Damien and Maxime G
 */
public interface IBoulderdashController {



	public void orderPerform(UserOrder controllerOrder) throws IOException;


	void play() throws InterruptedException;

	
	IOrderPerformer getOrderPerformer();

}
