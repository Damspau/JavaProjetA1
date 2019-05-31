package contract;

import java.util.Observable;

import org.showboard.*;;

public interface IMap {
	//get the width of the map
	public int getWidth();
	
	//get the height of the map
	public int getHeight();
	
	
	
	
	//notify the observer
	public void setMobileHasChanged ();
	
	//become an observable
	public Observable getObservable ();

	public int getActualXPlayer();
	public int getActualYPlayer();
	//go on the map motionless
	

	ISquare getOnTheMap(int x, int y);
	

	
}
