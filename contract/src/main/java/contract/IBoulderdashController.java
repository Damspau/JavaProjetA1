package contract;

import java.io.IOException;

/**
 * The Interface IBoulderdashController.
 *
 * @author Benoît D, Damiens and Maxime G
 */

public interface IBoulderdashController {

	void orderPerform(UserOrder controllerOrder) throws IOException;

	void play() throws InterruptedException, IOException;

	IOrderPerformer getOrderPerformer();

}
