package mobile;

import elements.*;

import java.awt.Point;

import contract.*;
import fr.exia.showboard.*;

public abstract class CommonMobile  extends Elements {

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
		// TODO Auto-generated constructor stub
	}


	//Override
	public CommonMobile(Sprite sprite, Permeability permeability, IMap map, int x, int y) {
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
