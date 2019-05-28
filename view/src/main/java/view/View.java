package view;

import java.lang.Runnable;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;
import org.mobile.*;
import javax.swing.JOptionPane;

import contract.*;


/**
 * The Class View.
 *
 * @author Maxime G, Benoît D et Damiens
 */
public final class View implements IBoulderdashView, IBoulderdashController, IBoulderdashModel{

	// All the different attributes.

	private Player myPlayer;

	/** The Constant mapView. */
	private static final int mapView = 16;

	/** The Constant squareSize. */
	private static final int squareSize = 50;

	/** The Constant closeView. */
	private Rectangle closeView;

	/** The view. */
	private int view;

	/** The map. */
	private IMap map;

	/** The order performer. */
	private IOrderPerformer orderPerformer;

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model the model
	 * @param gc    the gc
	 * @return
	 */

	

	public View(IBoulderdashModel model) {
		this.setView(mapView);
		this.setMap(map);
		this.setMyPlayer();
		


	}



	protected static void keyCodeToControllerOrder(UserOrder userOrder) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IBoulderdashView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		
	}


	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
	protected void setController(final IBoulderdashController controller) {
		
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		;
	}

	public void show(int yStart) {

	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode the key code
	 * @return the controller order
	 */
	protected UserOrder keyCodeToUserOrder(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_LEFT:
			return UserOrder.LEFT;
		case KeyEvent.VK_UP:
			return UserOrder.UP;
		case KeyEvent.VK_RIGHT:
			return UserOrder.RIGHT;
		case KeyEvent.VK_DOWN:
			return UserOrder.DOWN;
		default:
			return UserOrder.NOP;
		}
	}

	public void keyTyped(final KeyEvent e) {

	}

	public void keyPressed(final KeyEvent e) {
		;
	}


	public void keyReleased(final KeyEvent e) {

	}

	public void followMyPlayer() {

	}

	public IMap getMap() {
		return map;

	}

	public void setMap(IMap map) {

	}

	private int getView() {
		return view;

	}

	public void setView(int view) {

	}

	public Rectangle getCloseView() {
		return closeView;

	}

	public void setCloseView(Rectangle closeView) {

	}

	public IOrderPerformer getOrderPerformer() {
		return orderPerformer;

	}

	public void setOrderPerformer(IOrderPerformer orderPerformer) {

	}



	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void loadMessage(String key) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void controller() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void orderPerform(UserOrder controllerOrder) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void play() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public CommonMobile getMyPlayer() {
		// TODO Auto-generated method stub
		return null;
	}


}
