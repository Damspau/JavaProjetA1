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
import mobile.CommonMobile;
import mobile.MobileElementsFactory;
import motionless.CommonMotionless;
import motionless.MotionlessElementsFactory;
import model.*;

public class Map extends Observable implements IMap {

	private int width;
	private int height;



	public Map(String fileName) throws IOException {
		super();
		DB.lireEnBase();
		this.loadFile(fileName);

	private IElements [][] onTheMap;
	private int actualXPlayer;
	private int actualYPlayer;
	private CommonMobile playerDetector;


	// public Map(final String fileName) throws IOException {
		

		// this.loadFile(fileName);
	// }

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

				CommonMotionless motionLessElement = factoryMotionless.getFromFileSymbol(line.toCharArray()[x]);
				if (motionLessElement == null) {
					CommonMobile mobileElement = factoryMobile.getFromFileSymbol(line.toCharArray()[x], x, x);
					mobileElement.setX(x);
					mobileElement.setY(y);
					this.setOnTheMap(mobileElement, x, y);
				} else {
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

	private void setOnTheMap(IElements mobileElement, int x, int y) {
		this.onTheMap[x][y] = mobileElement;

	}

	@Override
	public ISquare getOnTheMap(int x, int y) {
		// TODO Auto-generated method stub
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

	@Override
	public int getActualXPlayer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getActualYPlayer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setActualYPlayer() {
		// TODO Auto-generated method stub

	}

}
