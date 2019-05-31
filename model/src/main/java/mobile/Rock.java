package mobile;

import contract.*;

public class Rock extends CommonMobile {
	private boolean validMove;
	
	/** The Constant SPRITE. */
	private final static Sprite sprite = new Sprite('R', "R.jpg");

	public Rock(int x,int y) {
		super(sprite, Permeability.BREAKABLE, x, y);
	}

	public Rock(IMap map) {
		super(sprite, Permeability.BREAKABLE, map);
	}

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
//	}

}
