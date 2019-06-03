package model;





import contract.IElements;
import contract.IMap;
import mobile.CommonMobile;

/**
 * The Interface IBoulderdashModel.
 *
 * @author Benoît D, Damiens et Maxime G
 */

public interface IBoulderdashModel {



	public CommonMobile getMyPlayer ();
	IMap getMap();
	public IElements backgroundFastCreator();

}
