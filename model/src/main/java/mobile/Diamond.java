package mobile;

import contract.Permeability;
import contract.Sprite;

public class Diamond extends Rock {

	public Diamond(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}

	private boolean validMove;

	public Diamond() {
		super(sprite, Permeability.BREAKABLE);
		// TODO Auto-generated constructor stub
	}

	/** The Constant SPRITE. */
	private final static Sprite sprite = new Sprite('D', "D.jpg");

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
