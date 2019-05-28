package org.motionless;
import fr.exia.showboard.IBoard;

import java.awt.Point;

import org.elements.Elements;
import org.elements.Permeability;
import org.elements.Sprite;

import contract.IMap;

public class CommonMotionless extends Elements {
	private Point position;
	private IBoard board;

	public CommonMotionless(Sprite sprite, Permeability permeability, IMap map) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}
	//Override
	public CommonMotionless(Sprite sprite, Permeability permeability, IMap map, int x, int y) {
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
