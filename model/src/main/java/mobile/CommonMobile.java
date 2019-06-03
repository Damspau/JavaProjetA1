package mobile;

import java.awt.Point;

import org.showboard.IBoard;

import contract.IMap;
import contract.Sprite;
import elements.Elements;
/**
 * <h1>the class CommonMobile</h1>
 * @author  Damien B, Maxime G and Benoît D
 * @version 1.0
 */
public class CommonMobile extends Elements {
	/**
	 * the position of the element
	 */
	private Point position;
	private IBoard board;
	private IMap map;
	private int velocity;

	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

	// Override
	protected CommonMobile(Sprite sprite, int x, int y, IMap map) {

		super(sprite);
		this.setMap(map);

	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public IBoard getBoard() {
		return board;
	}
	
	public void moveLeft() {

		this.setX(this.getX() - 1);
		this.setHasMoved();

	}

	public void moveRight() {

		this.setX(this.getX() + 1);
		this.setHasMoved();

	}

	public void moveUp() {
		this.setY(this.getY() - 1);
		this.setHasMoved();

	}

	public void moveDown() {
		this.setY(this.getY() + 1);
		this.setHasMoved();

	}

	public void doNothing() {
		// TODO Auto-generated method stub

	}
	/**
	 * notify observer
	 */
	private void setHasMoved() {
		this.getMap().setMobileHasChanged();
	}
	
	/**
	 * is override in player
	 */
	public boolean isAlive() {

		return true;
	}
	/**
	 * is override in player
	 */
	public void setAlive(boolean b) {

	}
	/**
	 * Is use for the rock if they can kill or no
	 */
	public int getVelocity() {
		return velocity;
	}
	/**
	 * Is use for the rock if they can kill or no
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

}
