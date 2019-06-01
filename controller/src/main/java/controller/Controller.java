package controller;

import java.io.IOException;

import contract.IBoulderdashController;
import contract.IBoulderdashView;
import contract.IOrderPerformer;
import contract.UserOrder;
import mobile.CommonMobile;
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

	/** The view. */
	private IBoulderdashView view;

	/** The Constant speed. */
	private static final int speed = 300;

	/** The stack order (RIGHT, LEFT, UP, DOWN and NOP) */
	private UserOrder stackOrder;

	private int playerActualXPosition;
	private int playerActualYPosition;

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

	private void setStackOrder(final UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	private UserOrder getStackOrder() {
		return this.stackOrder;
	}

	private void clearStackOrder() {
		this.stackOrder = UserOrder.FACE;
	}

	@Override
	public final void play() throws InterruptedException {

		while (this.getModel().getMyPlayer().isAlive()) {
			Thread.sleep(speed);
			switch (this.getStackOrder()) {
			case RIGHT:
				getModel().getMyPlayer().moveRight();
				System.out.println("test");
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

	}

	public void canBePushed() {

	}

	public void canBeDig() {

	}

	public void fallAndKill() {

	}

}
