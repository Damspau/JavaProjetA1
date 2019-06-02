package mobile;

import contract.*;

public class Rock extends CommonMobile {
	private boolean validMove;


	/** The Constant SPRITE. */
	private final static Sprite sprite = new Sprite('R', "R.jpg");


	 public Rock(int x,int y, IMap map) {
	 	super(sprite, Permeability.BREAKABLE, x, y, map);
	 }
	
//	 public Rock(IMap map) {
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
//	}

	protected Rock(Sprite sprite, Permeability permeability, int x, int y, IMap map) {
		super(sprite, permeability, x, y, map);
		// TODO Auto-generated constructor stub
	}



//	public Rock(Sprite sprite, Permeability permeability) {
////		super(sprite, permeability, null);
////		// TODO Auto-generated constructor stub
	//}
	
	
	


}
