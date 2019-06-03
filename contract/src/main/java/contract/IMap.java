package contract;

import java.util.Observable;

import org.showboard.ISquare;;

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

	public int getActualXPlayer();
	public int getActualYPlayer();



	public void setOnTheMap(IElements onTheMap, int i, int j);





}
