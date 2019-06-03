package motionless;
import org.showboard.*;

import java.awt.Point;

import elements.*;
import contract.*;

import contract.IMap;
/**
 * <h1>the class CommonMotionless</h1>
 * @author  Damien B, Maxime G and Benoît D
 * @version 1.0
 */
public class CommonMotionless extends Elements {
	private Point position;
	private IBoard board;
	private IMap map;

	public IMap getMap() {
		return map;
	}
	public void setMap(IMap map) {
		this.map = map;
	}
	
	
	public CommonMotionless(Sprite sprite) {
		super(sprite);
		this.setMap(map);
		// TODO Auto-generated constructor stub
	}
	//Override
	protected CommonMotionless(Sprite sprite, int x, int y) {
		super(sprite);
		
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


}
