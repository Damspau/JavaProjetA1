package motionless;
import org.showboard.*;

import java.awt.Point;

import contract.*;

import contract.IMap;
import element.*;

public class CommonMotionless extends Element {
	private Point position;
	private IBoard board;
	private IMap map;

	public IMap getMap() {
		return map;
	}
	public void setMap(IMap map) {
		this.map = map;
	}
	
	
	public CommonMotionless(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		this.setMap(map);
		// TODO Auto-generated constructor stub
	}
	//Override
	protected CommonMotionless(Sprite sprite, Permeability permeability, int x, int y) {
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


}
