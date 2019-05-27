package contract;

import java.util.Observable;

/**
 * The Interface IBoulderdashModel.
 *
 * @author Benoît D, Damiens et Maxime G
 */

public interface IBoulderdashModel {

	public String getMessage();

	public void loadMessage(String key);

	public Observable getObservable();

}
