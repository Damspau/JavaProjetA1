package model;

import java.io.IOException;

import contract.IMap;
import elements.Map;
import mobile.CommonMobile;

public class BoulderdashModel implements IBoulderdashModel {
	
	
	private IMap map;

	
	

	private CommonMobile myPlayer;
	
	
	public BoulderdashModel(final String fileName, int myPlayerStartX, int myPlayerStartY) throws IOException {
		// TODO Auto-generated constructor stub
		this.setMap(new Map(fileName));
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
