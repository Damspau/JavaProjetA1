package elements;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

import org.showboard.ISquare;

import contract.IElements;
import contract.IMap;
import entity.DB;
import mobile.CommonMobile;
import mobile.MobileElementsFactory;
import motionless.CommonMotionless;
import motionless.MotionlessElementsFactory;

public class Map extends Observable implements IMap {

	private int width;
	private int height;

	private IElements[][] onTheMap;
	private int actualXPlayer;
	private int actualYPlayer;
	MotionlessElementsFactory factoryMotionless = new MotionlessElementsFactory();
	MobileElementsFactory factoryMobile = new MobileElementsFactory();
	CommonMotionless motionLessElement;
	CommonMobile mobileElement;



	public Map(final String fileName) throws IOException {
		super();
		DB.lireEnBase();
		this.loadFile(fileName);
	}

	private void loadFile(final String fileName) throws IOException {

		final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String line = buffer.readLine();
		int y = 0;
		this.setWidth(compterOccurrencesLargeur(line));
		this.setHeight(compterOccurencesHauteur(fileName));

		this.onTheMap = new IElements[this.getWidth()][this.getHeight()];

		MotionlessElementsFactory factoryMotionless = new MotionlessElementsFactory();
		MobileElementsFactory factoryMobile = new MobileElementsFactory();

		// Elements display:

		while (line != null) {

			for (int x = 0; x < line.toCharArray().length; x++) {
				char c = line.toCharArray()[x];
				CommonMotionless motionLessElement = factoryMotionless.getFromFileSymbol(line.toCharArray()[x]);
				if (motionLessElement == null) {
					if (c == 'P') {
						setActualXPlayer(x);
						setActualYPlayer(y);
						motionLessElement = factoryMotionless.getFromFileSymbol('*');
						motionLessElement.setX(x);
						motionLessElement.setY(y);
						this.setOnTheMap(motionLessElement, x, y);
					} else {
						CommonMobile mobileElement = factoryMobile.getFromFileSymbol(line.toCharArray()[x], x, y);
						mobileElement.setX(x);
						mobileElement.setY(y);
						this.setOnTheMap(mobileElement, x, y);
					}
				}

				else {
					motionLessElement.setX(x);
					motionLessElement.setY(y);
					this.setOnTheMap(motionLessElement, x, y);
				}

			}
			line = buffer.readLine();
			y++;
		}
		buffer.close();
	}



	public String updateRockMap (int playerActualXPosition, int playerActualYPosition, UserOrder userOrder ) throws IOException {
		String retour;
		if ((((IElements) getOnTheMap(playerActualXPosition, playerActualYPosition)).getSprite().getImageName() == "R.jpg") && (userOrder==UserOrder.RIGHT)) {

				if (((IElements) getOnTheMap(playerActualXPosition+1, playerActualYPosition)).getSprite().getImageName() == "background.jpg" )
		            {
		                motionLessElement = factoryMotionless.getFromFileSymbol('*');
		                motionLessElement.setX(playerActualXPosition);
		                motionLessElement.setY(playerActualYPosition);


		                mobileElement = factoryMobile.getFromFileSymbol('R', playerActualXPosition+1, playerActualYPosition);
		                mobileElement.setX(playerActualXPosition+1);
		                mobileElement.setY(playerActualYPosition);
		                setOnTheMap(motionLessElement, playerActualXPosition, playerActualYPosition);
		                setOnTheMap(mobileElement, playerActualXPosition+1, playerActualYPosition);
		                retour = "rockPushRight";
		            }

	            else {
	            	retour = "playerGoBackLeft";

	            	}

            return retour;
            }
		else if ((((IElements) getOnTheMap(playerActualXPosition, playerActualYPosition)).getSprite().getImageName() == "R.jpg") && (userOrder==UserOrder.LEFT)) {

			if (((IElements) getOnTheMap(playerActualXPosition-1, playerActualYPosition)).getSprite().getImageName() == "background.jpg" )
	            {
	                motionLessElement = factoryMotionless.getFromFileSymbol('*');
	                motionLessElement.setX(playerActualXPosition);
	                motionLessElement.setY(playerActualYPosition);


	                mobileElement = factoryMobile.getFromFileSymbol('R', playerActualXPosition-1, playerActualYPosition);
	                mobileElement.setX(playerActualXPosition-1);
	                mobileElement.setY(playerActualYPosition);
	                setOnTheMap(motionLessElement, playerActualXPosition, playerActualYPosition);
	                setOnTheMap(mobileElement, playerActualXPosition-1, playerActualYPosition);
	                retour = "rockPushLeft";
	            }

            else {
            	retour = "playerGoBackRight";

            }
			return retour;

	public Boolean updateMapDirt(int playerActualXPosition, int playerActualYPosition) throws IOException {

		MotionlessElementsFactory factoryMotionless = new MotionlessElementsFactory();

		CommonMotionless motionLessElement;

		if (((IElements) getOnTheMap(playerActualXPosition, playerActualYPosition)).getSprite()
				.getImageName() == "-.jpg") {

			motionLessElement = factoryMotionless.getFromFileSymbol('*');
			motionLessElement.setX(playerActualXPosition);
			motionLessElement.setY(playerActualYPosition);
			setOnTheMap(motionLessElement, playerActualXPosition, playerActualYPosition);

			return (true);
		} else {
			return (false);
		}
	}

	public Boolean updateMapDiams(int playerActualXPosition, int playerActualYPosition) throws IOException {

		MotionlessElementsFactory factoryMotionless = new MotionlessElementsFactory();

		CommonMotionless motionLessElement;

		if (((IElements) getOnTheMap(playerActualXPosition, playerActualYPosition)).getSprite()
				.getImageName() == "D.jpg") {

			motionLessElement = factoryMotionless.getFromFileSymbol('*');
			motionLessElement.setX(playerActualXPosition);
			motionLessElement.setY(playerActualYPosition);
			setOnTheMap(motionLessElement, playerActualXPosition, playerActualYPosition);
			return (true);
		} else {
			return (false);
		}
	}

	public Boolean ifiamonExitDoor(int playerActualXPosition, int playerActualYPosition) throws IOException {

		if (((IElements) getOnTheMap(playerActualXPosition, playerActualYPosition)).getSprite()
				.getImageName() == "E.jpg") {
			return (true);
		} else {
			return (false);
		}
	}

	public Boolean ifiamonBorder(int playerActualXPosition, int playerActualYPosition) throws IOException {

		if (((IElements) getOnTheMap(playerActualXPosition, playerActualYPosition)).getSprite()
				.getImageName() == "B.jpg") {
			return (true);
		} else {
			return (false);

		}
			else if ((((IElements) getOnTheMap(playerActualXPosition, playerActualYPosition)).getSprite().getImageName() == "R.jpg") && (userOrder==UserOrder.DOWN)) {





				retour = "playerGoBackUp";
				return retour;
			}



		else {
			return("z");
		}

	}

	public void setOnTheMap(IElements mobileElement, int x, int y) {
		this.onTheMap[x][y] = mobileElement;

	}

	@Override
	public ISquare getOnTheMap(int x, int y) {
		 return (ISquare) this.onTheMap[x][y];

	}

	public void setWidth(int width) {
		this.width = width;

	}

	public void setHeight(int height) {
		this.height = height;

	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

	@Override
	public void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();

	}

	@Override
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return this;
	}

	public static int compterOccurrencesLargeur(String line) {
		int nb = 0;
		for (int i = 0; i < line.length(); i++) {
			nb++;
		}
		return nb;
	}

	public static int compterOccurencesHauteur(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		int lines = 0;
		while (reader.readLine() != null)
			lines++;
		reader.close();
		return lines;
	}

	public int getActualXPlayer() {
		return actualXPlayer;
	}

	public void setActualXPlayer(int actualXPlayer) {
		this.actualXPlayer = actualXPlayer;
	}

	public int getActualYPlayer() {
		return actualYPlayer;
	}

	public void setActualYPlayer(int actualYPlayer) {
		this.actualYPlayer = actualYPlayer;
	}

	public MotionlessElementsFactory getFactoryMotionless() {
		return factoryMotionless;
	}

	public void setFactoryMotionless(MotionlessElementsFactory factoryMotionless) {
		this.factoryMotionless = factoryMotionless;
	}

	public MobileElementsFactory getFactoryMobile() {
		return factoryMobile;
	}

	public void setFactoryMobile(MobileElementsFactory factoryMobile) {
		this.factoryMobile = factoryMobile;
	}

	public CommonMotionless getMotionLessElement() {
		return motionLessElement;
	}

	public void setMotionLessElement(CommonMotionless motionLessElement) {
		this.motionLessElement = motionLessElement;
	}

	public CommonMobile getMobileElement() {
		return mobileElement;
	}

	public void setMobileElement(CommonMobile mobileElement) {
		this.mobileElement = mobileElement;
	}






}
