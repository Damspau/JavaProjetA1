package model;

import java.io.IOException;

import contract.IMap;
import elements.Map;
import mobile.CommonMobile;
import mobile.Player;

public class BoulderdashModel implements IBoulderdashModel {
	
	
	private IMap map;

	
	

	private CommonMobile myPlayer;
	
	
	public BoulderdashModel(final String fileName) throws IOException {
		// TODO Auto-generated constructor stub
		this.setMap(new Map(fileName));
		this.setMyPlayer(new Player(this.getMap().getActualXPlayer(), this.getMap().getActualYPlayer(),getMap()));
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

}
