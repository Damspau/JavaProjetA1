package controller;

import java.awt.Color;
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

			this.collect();

			this.exidDoorAvailable();

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

	public void collect() throws IOException {

		int playerActualXPosition = getModel().getMyPlayer().getX();
		int playerActualYPosition = getModel().getMyPlayer().getY();

		if (((Map) this.getModel().getMap()).updateMapDiams(playerActualXPosition, playerActualYPosition)) {

			this.getView().getBoardFrame().addSquare(
					this.getView().getMap().getOnTheMap(this.getModel().getMyPlayer().getX(),
							this.getModel().getMyPlayer().getY()),
					this.getModel().getMyPlayer().getX(), this.getModel().getMyPlayer().getY());
			diamondCount = diamondCount + 1;
			System.out.println("nbr diams" + diamondCount);

		}

	}


	public void exidDoorAvailable() throws IOException {

		int playerActualXPosition = getModel().getMyPlayer().getX();
		int playerActualYPosition = getModel().getMyPlayer().getY();

//		if (((Map) this.getModel().getMap()).ifiamonExitDoor(playerActualXPosition, playerActualYPosition)) {

//			if (getDiamondCount() == 5) {
				
				news("You Win !!!");
				
				this.getView().getBoardFrame().setVisible(false);
				
//			}

//		}

	}

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
				g.setColor(Color.BLUE);
				g.fillRect(0, 0, 100, 100);
			}
		};
		frame.add(panel);

		Graphics g = panel.getGraphics();

		int SQUARE_DIMEN = 25;
		g.setColor(Color.darkGray);
		g.fillRect(SQUARE_DIMEN * 2, SQUARE_DIMEN * 4, SQUARE_DIMEN * 16, SQUARE_DIMEN * 5);

		g.fillRect(SQUARE_DIMEN * 3, SQUARE_DIMEN * 5, SQUARE_DIMEN * 14, SQUARE_DIMEN * 3);

		g.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 20));
		g.drawString(msg, SQUARE_DIMEN * 6 - 10, SQUARE_DIMEN * 7 - 5);

		frame.validate(); // because you added panel after setVisible was called
		frame.repaint(); // because you added panel after setVisible was called

	}

	public void canBePushed() {

	}

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

	public void fallAndKill() {

	}

	private void setStackOrder(final UserOrder stackOrder) {

		this.stackOrder = stackOrder;
		System.out.println(stackOrder);
	}

}
