package mobile;

import java.awt.Point;

import org.showboard.IBoard;

import contract.IMap;
import contract.Permeability;
import contract.Sprite;
import element.Element;

public abstract class CommonMobile extends Element {

	private Point position;
	private IBoard board;
	private IMap map;

	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

	public CommonMobile(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		this.setMap(map);
		// TODO Auto-generated constructor stub
	}

	// Override
	protected CommonMobile(Sprite sprite, Permeability permeability, int x, int y) {
		super(sprite, permeability);

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
		this.setX(this.getY() + -1);
		this.setHasMoved();

	}

	public void moveDown() {
		this.setX(this.getY() + +1);
		this.setHasMoved();

	}

	private void setHasMoved() {
		this.getMap().setMobileHasChanged();
	}

	public void doNothing() {
		// TODO Auto-generated method stub

	}

	public boolean isAlive() {
		return true;
	}

}
