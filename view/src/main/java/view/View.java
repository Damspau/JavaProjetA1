package view;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IBoulderdashView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements IBoulderdashView, Runnable, Observer {
	
	//All the different attributes.
	
	public View view;
	private View getView() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	private int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
	/** The controller. */
	private IController				controller;
	/** The frame. */
	private View viewFrame;
	private IModel model;
	private View View;
	
	private IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	protected void setController1(final IController controller) {
		this.controller = controller;
	}


	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_G:
				return ControllerOrder.English;
			case KeyEvent.VK_F:
				return ControllerOrder.Francais;
			case KeyEvent.VK_D:
				return ControllerOrder.Deutsch;
			case KeyEvent.VK_I:
				return ControllerOrder.Indonesia;
			default:
				return ControllerOrder.English;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.view.setVisible(true);
	}

	public void keyTyped(final KeyEvent e) {

	}
	
	public void keyPressed(final KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {

	}
	
	public void ViewPanel(final View viewFrame) {
		this.setViewFrame(viewFrame, viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	private void setViewFrame(final View viewFrame, View view) {
		this.view = view;
	}
	
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.drawString(this.getView().getModel().getHelloWorld().getMessage(), 10, 20);
	}

	

	public void ViewFrame(final IModel model) throws HeadlessException {
		this.ViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param gc
	 *          the gc
	 * @return 
	 */
	public  View(final IModel model, final GraphicsConfiguration gc) {
		super();
		this.ViewFrame(model);

	}
	
	public View(final IModel model, final String title) throws HeadlessException {
		super();
		this.ViewFrame(model);
	}
	
	protected IModel getModel() {
		return this.model;
	}
	
	public void printMessage1(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}
