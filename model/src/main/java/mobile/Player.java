package mobile;

import contract.Permeability;
import contract.Sprite;

public class Player extends CommonMobile {

	/** The Constant SPRITE. */
	private final Sprite sprite = new Sprite('H', "MyPlayer.png");

	/** The Constant spriteTurnLeft. */
	private final Sprite spriteMoveLeft = new Sprite('H', "MyPlayer.png");

	/** The Constant spriteTurnRight. */
	private final Sprite spriteMoveRight = new Sprite('H', "MyPlayerRight.png");
	
	/** The Constant spriteTurnDown. */
	private final Sprite spriteMoveDown = new Sprite('H', "MyPlayerDown.png");
	
	/** The Constant spriteTurnUp. */
	private final Sprite spriteMoveUp = new Sprite('H', "MyPlayerUp.png");

	/** The Constant spriteExplode. */
	private final Sprite spriteExplode = new Sprite('H', "MyPlayerExplode.png");

	public Player(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}
	
//    @Override
//    public final void moveLeft() {
//        super.moveLeft();
//        this.setSprite(spriteMoveLeft);
//    }

}
