package contract;

import java.io.IOException;

public interface IOrderPerformer {

	/**
	 * Order perform.
	 *
	 * @param userOrder the user order
	 * @throws IOException Signals that an I/O exception has occurred.
	 */

	public void orderPerform(UserOrder userOrder) throws IOException;

}
