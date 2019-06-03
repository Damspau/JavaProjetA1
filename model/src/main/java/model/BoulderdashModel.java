package model;

import java.io.IOException;

import contract.IMap;
import elements.Map;
import mobile.CommonMobile;
import mobile.Player;
import motionless.Background;
import motionless.CommonMotionless;

public class BoulderdashModel implements IBoulderdashModel {

	private IMap map;

	private CommonMobile myPlayer;

	public BoulderdashModel(final String fileName) throws IOException {
		// TODO Auto-generated constructor stub
		this.setMap(new Map(fileName));
		this.setMyPlayer(new Player(this.getMap().getActualXPlayer(), this.getMap().getActualYPlayer(), getMap()));
		this.getMyPlayer().setX(getMap().getActualXPlayer());
		this.getMyPlayer().setY(getMap().getActualYPlayer());
		System.out.println(getMap().getActualXPlayer());
		

	}

	@Override
	public CommonMobile getMyPlayer() {
		return this.myPlayer;
		// TODO Auto-generated method stub

	}

	public void setMyPlayer(CommonMobile myPlayer) {
		this.myPlayer = myPlayer;

	}

	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;

	}
	
	//i know i should create a function to get the factory but I don't have anymore time so I'm instatiating a new background directly
	public CommonMotionless backgroundFastCreator() {
		return new Background();
	}

}
