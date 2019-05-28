package model;



import java.util.Observable;

import mobile.CommonMobile;

/**
 * The Interface IBoulderdashModel.
 *
 * @author Benoît D, Damiens et Maxime G
 */

public interface IBoulderdashModel {

	public String getMessage();

	public void loadMessage(String key);

	public Observable getObservable();
	
	public CommonMobile getMyPlayer ();

}
