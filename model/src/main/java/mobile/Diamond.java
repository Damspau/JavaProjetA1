package mobile;

import contract.IMap;
import contract.Sprite;
/**
 * <h1>the class Diamon</h1>
 * @author  Damien B, Maxime G and Benoît D
 * @version 1.0
 */
public class Diamond extends CommonMobile {



	/** The Constant SPRITE. */
	private final static Sprite sprite = new Sprite('D', "D.jpg");

	 public Diamond(int x,int y, IMap map) {
	 	super(sprite, x, y, map);
	 }
	


	protected Diamond(Sprite sprite, int x, int y, IMap map) {
		super(sprite, x, y, map);
		// TODO Auto-generated constructor stub
	}



}
