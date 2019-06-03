package contract;

import java.util.Observable;

import org.showboard.ISquare;

/**
 * <h1>The IMap Interface.</h1>
 *
 * @author Maxime G, Damien B and Benoît D  
 * @version 0.1
 */

public interface IMap {

	
	/**
	 * get the width of the map
	 * 
	 */
	int getWidth();

	
	/**
	 * get the height of the map
	 * 
	 */
	int getHeight();
	/**
	 * get what is on the map
	 * 
	 */
	
	ISquare getOnTheMap(int x, int y);

	
	/**
	 * notify the observer
	 */
	void setMobileHasChanged();

	/**
	 * use for add an observable
	 * 
	 */
	Observable getObservable();
	
	
	int getActualXPlayer();

	int getActualYPlayer();
	
	/**
	 * Setting elements on the map
	 */
	void setOnTheMap(IElements onTheMap, int x, int i);

}
