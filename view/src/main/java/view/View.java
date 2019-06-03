package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.SwingUtilities;

import org.showboard.BoardFrame;

import contract.IBoulderdashView;
import contract.IMap;
import contract.IOrderPerformer;
import contract.UserOrder;
import mobile.CommonMobile;

/**
 * View
 *
 * @author Maxime G, Damiens et Benoît D
 */
public final class View implements IBoulderdashView, Runnable, KeyListener {

	// All the different attributes.

	private CommonMobile myPlayer;

	/** The Constant mapView. */
	private static final int mapView = 22;

	/** The Constant squareSize. */
	private static final int squareSize = 45;

	/** The Constant closeView. */
	private Rectangle closeView;

	/** The view. */
	private int view;

	/** The map. */
	private IMap map;

	/** The order performer. */
	private IOrderPerformer orderPerformer;

	private BoardFrame boardFrame;

	public BoardFrame getBoardFrame() {
		return boardFrame;
	}

	public void setBoardFrame(BoardFrame boardFrame) {
		this.boardFrame = boardFrame;
	}

	public View(final IMap map, CommonMobile Player) throws IOException {
		this.setView(mapView);
		this.setMap(map);
		// set the window :

		this.setMyPlayer(Player);
		this.getMyPlayer().getSprite().loadImage();
		this.setCloseView(new Rectangle(0, 0, this.getMap().getWidth(), this.getMap().getHeight()));

		SwingUtilities.invokeLater(this);

	}

	@Override
	public final void run() {
		this.setBoardFrame(new BoardFrame("BoulderDash"));
		this.getBoardFrame().setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
		this.getBoardFrame().setDisplayFrame(this.closeView);
		this.getBoardFrame().setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
		this.getBoardFrame().setHeightLooped(false);
		// add a key listener on THIS window
		this.getBoardFrame().addKeyListener(this);
		// special key disabled :
		this.getBoardFrame().setFocusTraversalKeysEnabled(false);

		for (int x = 0; x < this.getMap().getWidth(); x++) {

			for (int y = 0; y < this.getMap().getHeight(); y++) {

				this.getBoardFrame().addSquare(this.map.getOnTheMap(x, y), x, y);
			}
		}
		this.getBoardFrame().addPawn(this.getMyPlayer());

		this.getMap().getObservable().addObserver(boardFrame.getObserver());

		this.getBoardFrame().setVisible(true);
	}

	protected UserOrder keyCodeToUserOrder(int keyCode) {
		UserOrder userOrder;
		switch (keyCode) {
		case KeyEvent.VK_LEFT:
			userOrder = UserOrder.LEFT;
			break;
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			break;
		case KeyEvent.VK_RIGHT:
			userOrder = UserOrder.RIGHT;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			break;
		default:
			userOrder = UserOrder.FACE;
			break;
		}
		return userOrder;
	}

	public void keyTyped(final KeyEvent e) {
		/*
		 * not important for our program but necessary to implements because of the
		 * intefaces
		 */

	}

	@Override
	public void keyPressed(final KeyEvent keyInput) {
		try {

			this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyInput.getKeyCode()));
		} catch (final IOException exception) {
			exception.printStackTrace();
		}
	}

	public void keyReleased(final KeyEvent e) {
		/*
		 * not important for our program but necessary to implements because of the
		 * intefaces
		 */
	}

	public void followMyPlayer() {
		// this.getCloseView().y = this.getMyPlayer().getY() - 5;
	}

	public IMap getMap() {
		return map;

	}

	public void setMap(IMap map) throws IOException {
		this.map = map;
	}

	public CommonMobile getMyPlayer() {
		return myPlayer;
	}

	public void setMyPlayer(CommonMobile myPlayer) {
		this.myPlayer = myPlayer;
	}

	public Rectangle getCloseView() {
		return closeView;

	}

	public void setCloseView(Rectangle closeView) {
		this.closeView = closeView;
	}

	public IOrderPerformer getOrderPerformer() {
		return orderPerformer;
	}

	public void setOrderPerformer(IOrderPerformer orderPerformer) {

		this.orderPerformer = orderPerformer;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

}
