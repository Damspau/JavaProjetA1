package contract;

import java.util.Observable;

public interface IMap {
	//get the width of the map
	public void getWidth();
	
	//get the height of the map
	public void getHeight();
	
	//go on the map
	public IElements getOnTheMap (int x, int y);
	
	//notify the observer
	public void setMobileHasChanged ();
	
	//become an observable
	public Observable getObservable ();
	
}
