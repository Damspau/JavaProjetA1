package mobile;

import java.io.IOException;

import contract.IMap;
import contract.Permeability;
import contract.Sprite;

public class Player extends CommonMobile {
	
	private boolean validMove;
	private boolean alive=true;



	public Player(int x, int y, IMap map) throws IOException {
		super(sprite, Permeability.BREAKABLE, x, y);
		// TODO Auto-generated constructor stub
	}
   
	
	
	
	

	/** The Constant SPRITE. */
	private final static Sprite sprite = new Sprite('p', "pF.gif");

	/** The Constant spriteTurnLeft. */
	private final Sprite spriteMoveLeft = new Sprite('p', "pL.gif");

	/** The Constant spriteTurnRight. */
	private final Sprite spriteMoveRight = new Sprite('p', "pR.gif");
	
	/** The Constant spriteTurnDown. */
	private final Sprite spriteMoveDown = new Sprite('p', "pD.gif");
	
	/** The Constant spriteTurnUp. */
	private final Sprite spriteMoveUp = new Sprite('p', "pU.gif");

	/** The Constant spriteExplode. */
	private final Sprite spriteExplode = new Sprite('p', "pU.gif");

	
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
	
	public void doNothing()	{
		super.doNothing();
		this.setSprite(sprite);
	}
	
	@Override
	public boolean isAlive() {
		return alive;
	}






	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	
}
