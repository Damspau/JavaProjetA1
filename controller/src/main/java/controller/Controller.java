package controller;

import java.io.IOException;

import model.IBoulderdashModel;
import view.IView;
import view.IOrderPerformer;
import view.UserOrder;

/**
 * <h1>The Class Controller.</h1>
 *
 * @author Damiens, Benoît D et Maxime G
 * @version 0.1
 * @see IOrderPerformer
 */

public final class Controller implements IBoulderdashController, IOrderPerformer {

	private int diamondCount;

	/** The Constant speed. */
	private static final int speed = 300;

	/** The model. */
	private IBoulderdashModel model;

	/** The view. */
	private IView view;

	/** The stack order (RIGHT, LEFT, UP and DOWN) */
	private UserOrder stackOrder;

	/**
	 * Instantiates a new boulderdash controller.
	 *
	 * @param view  the view
	 * @param model the model
	 */
	public void controller(final IView view, final IBoulderdashModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
	}

	/**
	 * Sets the view.
	 *
	 * @param view the view to set
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	private IView getView() {
		return this.view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the model to set
	 */
	private void setModel(final IBoulderdashModel model) {
		this.model = model;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	private IBoulderdashModel getModel() {
		return this.model;
	}

	/**
	 * Sets the stack order.
	 *
	 * @param stackOrder the new stack order
	 */
	private void setStackOrder(final UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	/**
	 * Gets the stack order.
	 *
	 * @return the stack order
	 */
	private UserOrder getStackOrder() {
		return this.stackOrder;
	}

	/**
	 * Clear stack order.
	 */
	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.2019.boulderdash.controller.IBoulderDashController#play()
	 */
	@Override
	public final void play() throws InterruptedException {
		while (this.getModel().getMyPlayer().isAlive()) {
			Thread.sleep(speed);
			switch (this.getStackOrder()) {
			case RIGHT:
				this.getModel().getMyPlayer().moveRight();
				break;
			case LEFT:
				this.getModel().getMyPlayer().moveLeft();
				break;
			case UP:
				this.getModel().getMyPlayer().moveUp();
				break;
			case DOWN:
				this.getModel().getMyPlayer().moveDown();
				break;
			case NOP:
			default:
				this.getModel().getMyPlayer().doNothing();
				break;
			}
			this.clearStackOrder();
			if (this.getModel().getMyPlayer().isAlive()) {
				this.getModel().getMyPlayer().moveDown();
			}
			this.getView().followMyPlayer();
		}
		this.getView().printMessage("Game over !");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.exia.2019.boulderdash.controller.IBoulderdashController#getOrderPeformer()
	 */
	@Override
	public IOrderPerformer getOrderPerformer() {
		return this;
	}

	/**
	 * Order perform.
	 *
	 * @param controllerOrder the controller order
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IBoulderdashController#orderPerform(contract.ControllerOrder)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IOrderPerformed#orderPerform(contract.UserOrder)
	 */
	public void orderPerform (final UserOrder userOrder) throws IOException {

		this.setStackOrder(userOrder);

		switch (userOrder) {
		case RIGHT:
			this.model.loadHelloWorld("GB");
			break;
		case LEFT:
			this.model.loadHelloWorld("FR");
			break;
		case UP:
			this.model.loadHelloWorld("DE");
			break;
		case DOWN:
			this.model.loadHelloWorld("ID");
			break;
		default:
			break;
		}
	}

	public int getDiamondCount() {
		return diamondCount;
	}

	public void setDiamondCount(int diamondCount) {
		this.diamondCount = diamondCount;
	}

	public void collect() {

	}

	public void canBePushed() {

	}

	public void canBeDig() {

	}

	public void fallAndKill() {
	}

}
