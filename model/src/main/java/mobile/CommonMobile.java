package mobile;

import java.awt.Point;

import contract.*;
import element.*;

import org.showboard.*;

public abstract class CommonMobile  extends Element {

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


	//Override
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
	

}
