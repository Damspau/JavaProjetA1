package controller;

import java.io.IOException;

import contract.IBoulderdashController;
import contract.IBoulderdashView;
import contract.IOrderPerformer;
import contract.UserOrder;
import elements.Map;
import model.IBoulderdashModel;

/**
 * <h1>The Class Controller.</h1>
 *
 * @author Damiens, Benoît D et Maxime G
 */

public final class Controller implements IBoulderdashController, IOrderPerformer {

	private int diamondCount;

	/** The model. */
	private IBoulderdashModel model;

	/** The stack order (RIGHT, LEFT, UP, DOWN and NOP) */
	private UserOrder stackOrder;

	private IBoulderdashView view;

	public Controller(final IBoulderdashView view, final IBoulderdashModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
	}

	private void setView(final IBoulderdashView view) {
		this.view = view;
	}

	private IBoulderdashView getView() {
		return this.view;
	}

	private void setModel(final IBoulderdashModel model) {
		this.model = model;
	}

	private IBoulderdashModel getModel() {
		return this.model;
	}

	private UserOrder getStackOrder() {

		return stackOrder;
	}

	private void clearStackOrder() {
		setStackOrder(UserOrder.FACE);
	}

	@Override
	public final void play() throws InterruptedException, IOException {

		while (this.getModel().getMyPlayer().isAlive()) {

			Thread.sleep(300);

			switch (this.getStackOrder()) {
			case RIGHT:
				getModel().getMyPlayer().moveRight();
				break;

			case LEFT:
				getModel().getMyPlayer().moveLeft();

				break;

			case UP:
				getModel().getMyPlayer().moveUp();
				break;

			case DOWN:
				getModel().getMyPlayer().moveDown();
				break;

			case FACE:

			default:
				getModel().getMyPlayer().doNothing();
				break;
			}

			this.canBeDig();

			this.clearStackOrder();

		}

	}

	public IOrderPerformer getOrderPerformer() {
		return this;
	}

	public void orderPerform(final UserOrder userOrder) throws IOException {

		this.setStackOrder(userOrder);

	}

	public int getDiamondCount() {
		return diamondCount;
	}

	public void setDiamondCount(int diamondCount) {
		this.diamondCount = diamondCount;
	}

	public void collect() {

//		if getMyPlayer

	}

	public void canBePushed() {

	}

	public void canBeDig() throws IOException {

		int playerActualXPosition = getModel().getMyPlayer().getX();
		int playerActualYPosition = getModel().getMyPlayer().getY();

		System.out.println(playerActualXPosition);
		System.out.println(playerActualYPosition);

		if (((Map) this.getModel().getMap()).updateMap(playerActualXPosition, playerActualYPosition)) {

			this.getView().getBoardFrame().addSquare(this.getView().getMap().getOnTheMap(this.getModel().getMyPlayer().getX(),this.getModel().getMyPlayer().getY()),this.getModel().getMyPlayer().getX(), this.getModel().getMyPlayer().getY());

		}
	}

	public void fallAndKill() {

	}

	private void setStackOrder(final UserOrder stackOrder) {

		this.stackOrder = stackOrder;
		System.out.println(stackOrder);
	}

}
