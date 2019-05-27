package controller;

import contract.*;

import java.io.IOException;

/**
 * <h1>The Class Controller.</h1>
 *
 * @author Damiens, Benoît D et Maxime G
 * @version 0.1
 * @see IOrderPerformer
 */

public final class Controller implements IBoulderdashController, IOrderPerformer, IBoulderdashModel, IBoulderdashView {

	private int diamondCount;

	/** The Constant speed. */
	private static final int speed = 300;

	/** The model. */
	private IBoulderdashModel model;

	/** The view. */
	private IBoulderdashView view;

	/** The stack order (RIGHT, LEFT, UP and DOWN) */
	private UserOrder stackOrder;

	/**
	 * Instantiates a new boulderdash controller.
	 *
	 * @param view  the view
	 * @param model the model
	 */
	public void controller(final IBoulderdashView view, final IBoulderdashModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
	}

	/**
	 * Sets the view.
	 *
	 * @param view the view to set
	 */
	private void setView(final IBoulderdashView view) {
		this.view = view;
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	private IBoulderdashView getView() {
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
			case NOP:
			default:
				this.getModel().getMyPlayer().doNothing();
				break;
			}
			this.clearStackOrder();
			if (this.getModel().getMyVehicle().isAlive()) {
				this.getModel().getMyVehicle().moveDown();
			}
			this.getView().followMyVehicle();
		}
		this.getView().displayMessage("Game over !");
	}

	/**
	 * Control.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage(
				"Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
	}

	/**
	 * Sets the view.
	 *
	 * @param pview the new view
	 */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Order perform.
	 *
	 * @param controllerOrder the controller order
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
		case English:
			this.model.loadHelloWorld("GB");
			break;
		case Francais:
			this.model.loadHelloWorld("FR");
			break;
		case Deutsch:
			this.model.loadHelloWorld("DE");
			break;
		case Indonesia:
			this.model.loadHelloWorld("ID");
			break;
		default:
			break;
		}
	}

	@Override
	public void orderPerform(UserOrder userOrder) {
		// TODO Auto-generated method stub

	}

	@Override
	public IOrderPerformer getOrderPerformer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void controller() {
		// TODO Auto-generated method stub

	}

}
