package mobile;

import contract.IMap;
import contract.Sprite;

public class Diamond extends CommonMobile {


	private boolean validMove;

	/** The Constant SPRITE. */
	private final static Sprite sprite = new Sprite('D', "D.jpg");

	 public Diamond(int x,int y, IMap map) {
	 	super(sprite, x, y, map);
	 }
	
//	 public Diamond(IMap map) {
//	 	super(sprite, Permeability.BREAKABLE, map);
//	 }

	public boolean isValidMove() {
		return validMove;
	}

	public void setValidMove(boolean validMove) {
		this.validMove = validMove;
	}

//	@Override
//	public void moveDown() {
//		// TODO Auto-generated method stub
//		super.moveDown();
//		this.setSprite(spriteMoveDown);
//	}

//	public void doNothing() {
//		super.doNothing();
//		this.setSprite(sprite);

	protected Diamond(Sprite sprite, int x, int y, IMap map) {
		super(sprite, x, y, map);
		// TODO Auto-generated constructor stub
	}

//	public Diamond(Sprite sprite, Permeability permeability) {
//		super(sprite, permeability);
//		// TODO Auto-generated constructor stub

//	}

}
