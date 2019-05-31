package mobile;

import javax.swing.ImageIcon;

import contract.Permeability;

public class Player extends CommonMobile {
	
	private static final ImageIcon imageIcon = new ImageIcon("pF.gif");
	private boolean validMove;
	private boolean alive=true;



	public Player() {
		super(imageIcon, Permeability.BREAKABLE);
		// TODO Auto-generated constructor stub
	}
	
	

	/** The Constant SPRITE. */
	private final ImageIcon face = new ImageIcon("pF.gif");

	/** The Constant spriteTurnLeft. */
	private final ImageIcon left = new ImageIcon("pL.gif");

	/** The Constant spriteTurnRight. */
	private final ImageIcon right = new ImageIcon("pR.gif");
	
	/** The Constant spriteTurnDown. */
	private final ImageIcon down = new ImageIcon("pD.gif");
	
	/** The Constant spriteTurnUp. */
	private final ImageIcon up = new ImageIcon("pU.gif");

	/** The Constant spriteExplode. */
	private final ImageIcon explode = new ImageIcon("pU.gif");

	
	public boolean isValidMove() {
		return validMove;
	}







	public void setValidMove(boolean validMove) {
		this.validMove = validMove;
	}
	
		
	
	
	@Override
   public final void moveLeft() {
       super.moveLeft();
       this.setImageIcon(left);
    }
	
	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		super.moveRight();
		this.setImageIcon(right);
	
	}
	
	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		super.moveDown();
		this.setImageIcon(down);
	}
	
	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		super.moveUp();
		this.setImageIcon(up);
	}
	
	public void doNothing()	{
		super.doNothing();
		this.setImageIcon(face);
	}
	
	@Override
	public boolean isAlive() {
		return alive;
	}


	public void setAlive(boolean alive) {
		this.alive = alive;
	}



	public ImageIcon setImageIcon(ImageIcon imageIcon) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public contract.ImageIcon setImageIcon(contract.ImageIcon imageIcon) {
		// TODO Auto-generated method stub
		return null;
	}




	
	
}
