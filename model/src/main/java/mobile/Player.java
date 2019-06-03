package mobile;

import contract.IMap;
import contract.Sprite;
/**
 * <h1>the class Player</h1>
 * @author  Damien B, Maxime G and Benoît D
 * @version 1.0
 */
public class Player extends CommonMobile {


	private boolean alive = true;

	public Player(int x, int y, IMap map) {

		super(sprite, x, y, map);
	}



	/** The Constant SPRITE. */
	private final static Sprite sprite = new Sprite('P', "pF.gif");

	/** The Constant spriteTurnLeft. */
	private final Sprite spriteMoveLeft = new Sprite('p', "pL.gif");

	/** The Constant spriteTurnRight. */
	private final Sprite spriteMoveRight = new Sprite('p', "pR.gif");

	/** The Constant spriteTurnDown. */
	private final Sprite spriteMoveDown = new Sprite('p', "pD.gif");

	/** The Constant spriteTurnUp. */
	private final Sprite spriteMoveUp = new Sprite('p', "pU.gif");

	/** The Constant spriteExplode. */
	


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

	@Override
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
