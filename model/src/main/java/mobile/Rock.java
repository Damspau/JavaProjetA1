package mobile;

import contract.IMap;
import contract.Sprite;
/**
 * <h1>the class Rock</h1>
 * @author  Damien B, Maxime G and Benoît D
 * @version 1.0
 */
public class Rock extends CommonMobile {
	

	/** The Constant SPRITE. */
	private final static Sprite sprite = new Sprite('R', "R.jpg");


	 public Rock(int x,int y, IMap map) {
	 	super(sprite, x, y, map);
	 }
	



	protected Rock(Sprite sprite, int x, int y, IMap map) {
		super(sprite, x, y, map);
		// TODO Auto-generated constructor stub
	}



}
