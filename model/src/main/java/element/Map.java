package element;

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
import motionless.CommonMotionless;
import motionless.MotionlessElementsFactory;

public class Map extends Observable implements IMap {

	private int width;
	private int height;
	private IElements[][] onTheMap;

	public Map() throws IOException {
		super();
		DB.lireEnBase();
		this.loadFile();
	}

	public static int countWidth(String line, char recherche) {
		int nb = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == recherche)
				nb++;
		}
		return nb;
	}

	public static int countHeight() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src\\main\\map.txt"));
		int lines = 0;
		while (reader.readLine() != null)
			lines++;
		reader.close();
		return lines;
	}

	// temporal reading for the map
	private void loadFile() throws IOException {
		final BufferedReader buffer = new BufferedReader(
				new InputStreamReader(new FileInputStream("src\\main\\map.txt")));
		String line = buffer.readLine();
		int y = 0;

		this.setWidth(countWidth(line, 'b'));

		this.setHeight(countHeight());

		this.onTheMap = new IElements[this.getWidth()][this.getHeight()];

		MotionlessElementsFactory factory = new MotionlessElementsFactory();
		while (line != null) {
			for (int x = 0; x < line.toCharArray().length; x++) {
				CommonMotionless element = factory.getFromFileSymbol(line.toCharArray()[x]);
				element.setX(x);
				element.setY(y);
//            	element.getSprite().setImageName(line.toCharArray()[x]+".jpg");
				this.setOnTheMap(element, x, y);
			}
			line = buffer.readLine();
			y++;
		}
		buffer.close();
	}

	private void setOnTheMap(CommonMotionless fromFileSymbol, int x, int y) {
		this.onTheMap[x][y] = fromFileSymbol;

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
		System.out.println(height);
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

}
