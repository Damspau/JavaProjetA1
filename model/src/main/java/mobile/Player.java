package mobile;

import contract.Permeability;
import contract.Sprite;

public class Player extends CommonMobile {
	
	private boolean validMove;



	public Player() {
		super(sprite, Permeability.BREAKABLE);
		// TODO Auto-generated constructor stub
	}
	
	

	/** The Constant SPRITE. */
	private final static Sprite sprite = new Sprite('H', "MyPlayer.png");

	/** The Constant spriteTurnLeft. */
	private final Sprite spriteMoveLeft = new Sprite('H', "MyPlayerLeft.png");

	/** The Constant spriteTurnRight. */
	private final Sprite spriteMoveRight = new Sprite('H', "MyPlayerRight.png");
	
	/** The Constant spriteTurnDown. */
	private final Sprite spriteMoveDown = new Sprite('H', "MyPlayerDown.png");
	
	/** The Constant spriteTurnUp. */
	private final Sprite spriteMoveUp = new Sprite('H', "MyPlayerUp.png");

	/** The Constant spriteExplode. */
	private final Sprite spriteExplode = new Sprite('H', "MyPlayerExplode.png");

	
	public boolean isValidMove() {
		return validMove;
	}







	public void setValidMove(boolean validMove) {
		this.validMove = validMove;
	}
	
		
	
	
	@Override
   public final void moveLeft() {
       super.moveLeft();
       this.setSprite(spriteMoveLeft);
    }
	
	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		super.moveRight();
		this.setSprite(spriteMoveRight);
	
	}
	
	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		super.moveDown();
		this.setSprite(spriteMoveDown);
	}
	
	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		super.moveUp();
		this.setSprite(spriteMoveUp);
	}
}
