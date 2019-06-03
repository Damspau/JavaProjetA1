package controller;

import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

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

	private int diamondCount = 0;

	private IBoulderdashModel model;

	/** The stack order (RIGHT, LEFT, UP, DOWN and FACE) */
	private UserOrder stackOrder;

	private IBoulderdashView view;

	public Controller(final IBoulderdashView view, final IBoulderdashModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
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

			this.checkBorderPlayer();

			this.canBeDig();

			this.collect();

			this.exidDoorAvailable();

			this.clearStackOrder();

		}

	}

	/**
	 * Manage the map borders
	 * 
	 */
	public void checkBorderPlayer() throws IOException {

		int playerActualXPosition = getModel().getMyPlayer().getX();
		int playerActualYPosition = getModel().getMyPlayer().getY();

		if (((Map) this.getModel().getMap()).ifiamonBorder(playerActualXPosition, playerActualYPosition)) {

			if (playerActualXPosition == 0) {
				getModel().getMyPlayer().moveRight();
			}
			if (playerActualXPosition == 39) {
				getModel().getMyPlayer().moveLeft();
			}
			if (playerActualYPosition == 0) {
				getModel().getMyPlayer().moveDown();
			}
			if (playerActualYPosition == 21) {
				getModel().getMyPlayer().moveUp();
			}

		}

	}

	public int getDiamondCount() {
		return diamondCount;
	}

	public void setDiamondCount(int DiamondCount) {
		this.diamondCount = diamondCount + 1;
	}

	/**
	 * collect diamonds
	 * 
	 */
	public void collect() throws IOException {

		int playerActualXPosition = getModel().getMyPlayer().getX();
		int playerActualYPosition = getModel().getMyPlayer().getY();

		if (((Map) this.getModel().getMap()).updateMapDiams(playerActualXPosition, playerActualYPosition)) {

			this.getView().getBoardFrame().addSquare(
					this.getView().getMap().getOnTheMap(this.getModel().getMyPlayer().getX(),
							this.getModel().getMyPlayer().getY()),
					this.getModel().getMyPlayer().getX(), this.getModel().getMyPlayer().getY());
			setDiamondCount(diamondCount);

		}

	}

	/**
	 * Open the door when you have 5 diamonds
	 * 
	 */
	public void exidDoorAvailable() throws IOException {

		int playerActualXPosition = getModel().getMyPlayer().getX();
		int playerActualYPosition = getModel().getMyPlayer().getY();

		if (((Map) this.getModel().getMap()).ifiamonExitDoor(playerActualXPosition, playerActualYPosition)) {

			if (getDiamondCount() == 5) {

				getModel().getMyPlayer().setAlive(false);

				news("You Win !!!");

			}

		}

	}

	/**
	 * Displays msg : "you win !"
	 * 
	 */
	public void news(String msg) {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(600, 400);

		JPanel panel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				int SQUARE_DIMEN = 25;

				g.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 20));
				g.drawString(msg, SQUARE_DIMEN * 6 - 10, SQUARE_DIMEN * 7 - 5);
			}
		};
		frame.add(panel);

		frame.validate(); // because you added panel after setVisible was called
		frame.repaint(); // because you added panel after setVisible was called

	}
	
	/**
	 * the player can dig the dirt
	 * 
	 */
	public void canBeDig() throws IOException {

		int playerActualXPosition = getModel().getMyPlayer().getX();
		int playerActualYPosition = getModel().getMyPlayer().getY();

		if (((Map) this.getModel().getMap()).updateMapDirt(playerActualXPosition, playerActualYPosition)) {

			this.getView().getBoardFrame().addSquare(
					this.getView().getMap().getOnTheMap(this.getModel().getMyPlayer().getX(),
							this.getModel().getMyPlayer().getY()),
					this.getModel().getMyPlayer().getX(), this.getModel().getMyPlayer().getY());

		}
	}

	public void canBePushed() {

	}



	public void fallAndKill() {

	}

	public IOrderPerformer getOrderPerformer() {
		return this;
	}

	public void orderPerform(final UserOrder userOrder) throws IOException {

		this.setStackOrder(userOrder);

	}

	private UserOrder getStackOrder() {

		return stackOrder;
	}

	private void clearStackOrder() {
		setStackOrder(UserOrder.FACE);
	}

	private void setStackOrder(final UserOrder stackOrder) {

		this.stackOrder = stackOrder;
		System.out.println(stackOrder);
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

}
