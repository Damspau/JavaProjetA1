package controller;

import java.io.IOException;

import contract.IBoulderdashController;
import contract.IOrderPerformer;
import contract.UserOrder;
import model.IBoulderdashModel;
import view.IBoulderdashView;

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

	/** The stack order (RIGHT, LEFT, UP, DOWN and NOP) */
	private UserOrder stackOrder;

	public Controller(IBoulderdashView view, IBoulderdashModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
	}

	private void setView(IBoulderdashView view) {
		this.view = view;
	}

	private IBoulderdashView getView() {
		return this.view;
	}

	private void setModel(IBoulderdashModel model) {
		this.model = model;
	}

	private IBoulderdashModel getModel() {
		return this.model;
	}

	private void setStackOrder(UserOrder stackOrder) {
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
			case FACE:
			default:
				this.getModel().getMyPlayer().doNothing();
				break;
			}
			this.clearStackOrder();


		}

	}




	public IOrderPerformer getOrderPerformer() {
		return this;
	}

	public void orderPerform(UserOrder userOrder) throws IOException {

		this.setStackOrder(userOrder);

	}

	public int getDiamondCount() {
		return diamondCount;
	}

	public void setDiamondCount(int diamondCount) {
		this.diamondCount = diamondCount;
	}

	public void collect() {

//		if (levelMap[move.x][move.y] == '+') {
//			numFulfilledDiamonds++;
//			score += (numFulfilledDiamonds < numNeededDiamonds ? scorePerDiamond : scorePerExtraDiamond);
//			updateScore();
//			redrawAndSound(move, MOVE_DIAMOND_SOUND);
//			if (numFulfilledDiamonds == numNeededDiamonds) {
//				levelMap[coordExit.x][coordExit.y] = '[';
//				redrawAndSound(coordExit, MOVE_OPENEXIT_SOUND);
//			}
//			validMove = true;
//		}

	}

	public void canBePushed() {
//		if ((levelMap[move.x][move.y] == 'O') && (move2.y != move.y - 1)) {
//			if (((move2.x >= 0) && (move2.x <= X_DIMEN)) && ((move2.y >= 0) && (move2.y <= Y_DIMEN))) {
//				if (levelMap[move2.x][move2.y] == '.') {
//					// "look-ahead" is an empty space. Move the rock.
//					levelMap[move2.x][move2.y] = levelMap[move.x][move.y];
//					redrawAndSound(move2, MOVE_ROCK_SOUND);
//					redrawAndSound(move, MOVE_NULL_SOUND);
//					validMove = true;
//				}
//			}
//		}
	}

	public void canBeDig() {

	}

	public void fallAndKill() {

	}





}
