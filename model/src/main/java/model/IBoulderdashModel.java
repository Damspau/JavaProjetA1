package model;





import contract.IMap;
import mobile.CommonMobile;
import motionless.CommonMotionless;

/**
 * The Interface IBoulderdashModel.
 *
 * @author Benoît D, Damiens et Maxime G
 */

public interface IBoulderdashModel {



	public CommonMobile getMyPlayer ();
	IMap getMap();
	public CommonMotionless backgroundFastCreator();

}
