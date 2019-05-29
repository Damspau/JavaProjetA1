package elements;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

import contract.IElements;
import contract.IMap;
import org.showboard.*;
import motionless.CommonMotionless;
import motionless.MotionlessElementsFactory;

public class Map extends Observable implements IMap {
	
	private int width;
	private int height;
	private IElements [][] onTheMap;
	
	
	public Map(final String fileName) throws IOException {
		super();
		this.loadFile(fileName);
	}
	

	//temporal reading for the map
	private void loadFile(final String fileName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheMap = new IElements[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                this.setOnTheMap(MotionlessElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
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
