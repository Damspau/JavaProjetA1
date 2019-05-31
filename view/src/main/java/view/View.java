package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.SwingUtilities;

import contract.IMap;
import contract.IOrderPerformer;
import contract.UserOrder;
import elements.Elements;
import org.showboard.*;
import mobile.CommonMobile;

/**
 * View
 *
 * @author Maxime G, Damien and Benoît D
 */
public final class View implements IBoulderdashView, Runnable, KeyListener{

	// All the different attributes.

	private CommonMobile myPlayer;

	/** The Constant mapView. */
	private static final int mapView = 16;

	/** The Constant squareSize. */
	private static final int squareSize = 50;

	/** The Constant closeView. */
	private Rectangle closeView = new Rectangle();

	/** The view. */
	private int view;

	/** The map. */
	private IMap map;

	/** The order performer. */
	private IOrderPerformer orderPerformer;





	public View(final IMap map, final CommonMobile myPlayer ) throws IOException {
		this.setView(mapView);
		this.setMap(map);
		closeView.setSize(37, 22);
//		this.setMyPlayer(myPlayer);
//		this.getMyPlayer().getSprite().loadImage();
//		this.setCloseView(new Rectangle(0, this.getMyPlayer().getY(), this.getMap().getWidth(), mapView));
	SwingUtilities.invokeLater(this);


	}

	public final void run() {
		final BoardFrame boardFrame = new BoardFrame("Close view");
		 boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
	        boardFrame.setDisplayFrame(this.closeView);
	        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
	        boardFrame.setHeightLooped(false);
	        boardFrame.addKeyListener(this);
	        boardFrame.setFocusable(true);
	        boardFrame.setFocusTraversalKeysEnabled(false);

	        for (int x = 0; x < this.getMap().getWidth(); x++) {
	        	System.out.println(x);
	            for (int y = 0; y < this.getMap().getHeight(); y++) {
		        	System.out.println("    " + y);
	                boardFrame.addSquare(this.map.getOnTheMap(x, y), x, y);
	            }
	        }
//	        boardFrame.addPawn(this.getMyPlayer());

	        this.getMap().getObservable().addObserver(boardFrame.getObserver());
	        //this.followMyPlayer();

	        boardFrame.setVisible(true);
	    }


	public void show(int yStart) {
		int y = yStart % this.getMap().getHeight();
	        for (int view = 0; view < this.getView(); view++) {
	            for (int x = 0; x < this.getMap().getWidth(); x++) {
	                if ((x == this.getMyPlayer().getX()) && (y == yStart)) {
	                    System.out.print(this.getMyPlayer().getSprite().getBddImage());
	                } else {
	                    System.out.print(((Elements) this.getMap().getOnTheMap(x, y)).getSprite().getBddImage());
	            }
	            y = (y + 1) % this.getMap().getHeight();
	            System.out.print("\n");
	            }
	        }

	}


	






	protected UserOrder keyCodeToUserOrder(int keyCode) {
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
			return UserOrder.FACE;
		}
	}

	public void keyTyped(final KeyEvent e) {
		/* not important for our program but necessary to implements because of the intefaces */

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
		/* not important for our program but necessary to implements because of the intefaces */
	}

	public void followMyPlayer() {
	//	this.getCloseView().y = this.getMyPlayer().getY() - 5;
	}

	public IMap getMap() {
		return map;

	}

	public void setMap(IMap map) throws IOException {
		this.map = map;
//        for (int x = 0; x < this.getMap().getWidth(); x++) {
//            for (int y = 0; y < this.getMap().getHeight(); y++) {
//                ((Elements) this.getMap().getOnTheMap(x, y)).getSprite().loadImage();
//            }
//        }

	}
	public CommonMobile getMyPlayer() {
		return myPlayer;
	}

	public void setMyPlayer(CommonMobile myPlayer) {
		this.myPlayer = myPlayer;
	}



	private int getView() {
		return view;

	}

	public void setView(int view) {
		this.view = view;

	}

	public Rectangle getCloseView() {
		return closeView;

	}

	public void setCloseView(Rectangle closeView) {
		this.closeView = closeView;
	}

	public IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;

	}

	public void setOrderPerformer(IOrderPerformer orderPerformer) {

	}








	}




	


	


