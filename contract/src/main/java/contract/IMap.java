package contract;

import java.util.Observable;

import org.showboard.ISquare;

/**
 * <h1>The IMap Interface.</h1>
 *
 * @author Benoît D, Maxime G and Damiens
 * @version 0.1
 */

public interface IMap {

	// get the width of the map
	int getWidth();

	// get the height of the map
	int getHeight();

	// go on the map
	ISquare getOnTheMap(int x, int y);

	// notify the observer
	void setMobileHasChanged();

	// become an observable
	Observable getObservable();

	int getActualXPlayer();

	int getActualYPlayer();

}
