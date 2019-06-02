package contract;

import contract.IMap;
import org.showboard.*;

/**
 * The Interface IBoulderdashView.
 *
 * @author Maxime G, Benoît D et Damiens
 */
public interface IBoulderdashView {

	void followMyPlayer();

	IMap getMap();

	IElements getMyPlayer();

	BoardFrame getBoardFrame();
}
