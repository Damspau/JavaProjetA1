package view;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IMap;

/**
 * The Class View.
 *
 * @author Maxime G, Benoît D et Damiens
 */
public final class View extends JFrame implements IBoulderdashView, Runnable, Observer {

	// All the different attributes.

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
	public View(final IModel model, final GraphicsConfiguration gc) {
		super();
		this.ViewFrame(model);

	}

	public View(final IModel model, final String title) throws HeadlessException {
		super();
		this.ViewFrame(model);
	}

	/**
	 * Instantiates a new view.
	 *
	 * @param model the model
	 */
	public View(IModel model) {

	}

	protected static void keyCodeToControllerOrder(UserOrder userOrder) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IBoulderdashView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	public void printMessage1(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
	protected void setController(final IBoulderdashController controller) {
		this.controller = controller;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.view.setVisible(true);
	}

	public void show(int yStart) {

	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode the key code
	 * @return the controller order
	 */
	protected UserOrder keyCodeToUserOrder(final int keyCode) {
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
		this.getController().orderPerform(View.keyCodeToUserOrder(e.getKeyCode()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {

	}

	public void followMyPlayer() {

	}

	public IMap getMap() {

	}

	public void setMap(IMap map) {

	}

	private int getView() {

	}

	public void setView(int view) {

	}

	public Rectangle getCloseView() {

	}

	public void setCloseView(Rectangle closeView) {

	}

	public IOrderPerformer getOrderPerformer() {

	}

	public void setOrderPerformer(IOrderPerformer orderPerformer) {

	}

	/** CODE DE BASE */

	private int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

	protected IModel getModel() {
		return this.model;
	}

	/** The controller. */
	private IController controller;
	/** The frame. */
	private View viewFrame;
	private IModel model;
	private View View;

	private IController getController() {
		return this.controller;
	}

	public void ViewPanel(final View viewFrame) {
		this.setViewFrame(viewFrame, viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);

	}

	private void setViewFrame(final View viewFrame, View view) {
		this.view = view;
	}

	public void ViewFrame(final IModel model) throws HeadlessException {
		this.ViewFrame(model);
	}

}
