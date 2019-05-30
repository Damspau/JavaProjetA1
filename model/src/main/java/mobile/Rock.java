package mobile;

import contract.Permeability;
import contract.Sprite;

public class Rock extends CommonMobile {

	private boolean validMove;

	public Rock(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}

	public Rock() {
		super(sprite, Permeability.BREAKABLE);
		// TODO Auto-generated constructor stub
	}

	/** The Constant SPRITE. */
	private final static Sprite sprite = new Sprite('R', "R.jpg");

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

}
