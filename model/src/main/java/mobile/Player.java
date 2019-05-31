package mobile;

import contract.IMap;
import contract.Permeability;
import contract.Sprite;

public class Player extends CommonMobile {

	private boolean validMove;
	private boolean alive = true;

	public Player() {
		super(Sprite sprite, Permeability permeability, x, y);
		// TODO Auto-generated constructor stub
	}

	public Player(IMap map) {
		super(sprite, Permeability.BREAKABLE, map);
	}



	/** The Constant SPRITE. */
	private final static Sprite sprite = new Sprite('P', "pF.gif");

	/** The Constant spriteTurnLeft. */
	private final Sprite spriteMoveLeft = new Sprite('P', "pL.gif");

	/** The Constant spriteTurnRight. */
	private final Sprite spriteMoveRight = new Sprite('P', "pR.gif");

	/** The Constant spriteTurnDown. */
	private final Sprite spriteMoveDown = new Sprite('P', "pD.gif");

	/** The Constant spriteTurnUp. */
	private final Sprite spriteMoveUp = new Sprite('P', "pU.gif");

	/** The Constant spriteExplode. */
	private final Sprite spriteExplode = new Sprite('P', "pU.gif");

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

	public void doNothing() {
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
