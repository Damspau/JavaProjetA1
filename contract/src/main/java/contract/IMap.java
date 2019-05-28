package contract;

import java.util.Observable;

import fr.exia.showboard.*;

public interface IMap {
	//get the width of the map
	public int getWidth();
	
	//get the height of the map
	public int getHeight();
	
	//go on the map
	public ISquare getOnTheMap (int x, int y);
	
	//notify the observer
	public void setMobileHasChanged ();
	
	//become an observable
	public Observable getObservable ();
	
	public void setMap (IMap map);
	
}
