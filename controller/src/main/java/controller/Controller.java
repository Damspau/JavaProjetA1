package controller;

import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import contract.IBoulderdashController;
import contract.IBoulderdashView;
import contract.IElements;
import contract.IOrderPerformer;
import contract.UserOrder;
import elements.Elements;
import elements.Map;
import mobile.CommonMobile;
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


			this.IsThereARock();
			this.resetVelocity();
			this.fallAndKill();

			Thread.sleep(100);


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

	public void IsThereARock() throws IOException {
		int playerActualXPosition = getModel().getMyPlayer().getX();
		int playerActualYPosition = getModel().getMyPlayer().getY();
		String result = ((Map) this.getModel().getMap()).updateRockMap(playerActualXPosition, playerActualYPosition, getStackOrder());


		switch (result) {
			case "rockPushRight":
				//even if this line is quite scary it only add a background to where the rock was and the next one add a rock next to it
				this.getView().getBoardFrame().addSquare(this.getView().getMap().getOnTheMap(this.getModel().getMyPlayer().getX(),this.getModel().getMyPlayer().getY()),this.getModel().getMyPlayer().getX(), this.getModel().getMyPlayer().getY());
				this.getView().getBoardFrame().addSquare(this.getView().getMap().getOnTheMap(this.getModel().getMyPlayer().getX()+1,this.getModel().getMyPlayer().getY()),this.getModel().getMyPlayer().getX()+1, this.getModel().getMyPlayer().getY());
				break;

			case "rockPushLeft":
				this.getView().getBoardFrame().addSquare(this.getView().getMap().getOnTheMap(this.getModel().getMyPlayer().getX(),this.getModel().getMyPlayer().getY()),this.getModel().getMyPlayer().getX(), this.getModel().getMyPlayer().getY());
				this.getView().getBoardFrame().addSquare(this.getView().getMap().getOnTheMap(this.getModel().getMyPlayer().getX()-1,this.getModel().getMyPlayer().getY()),this.getModel().getMyPlayer().getX()-1, this.getModel().getMyPlayer().getY());
				break;
			case "playerGoBackRight":
					getModel().getMyPlayer().moveRight();
				break;
			case "playerGoBackLeft":

					getModel().getMyPlayer().moveLeft();

				break;
			case "playerGoBackUp" :
					getModel().getMyPlayer().moveUp();





			default:
				break;
		}



											}

	public void resetVelocity	(){

		for (int x = 0; x < this.getView().getMap().getWidth(); x++) {

			for (int y = 0; y <	this.getView().getMap().getHeight(); y++) {
				if (	(	((Elements) this.getView().getMap().getOnTheMap(x, y)).getSprite().getImageName()==("R.jpg") 	) 	||	(	((Elements) this.getView().getMap().getOnTheMap(x, y)).getSprite().getImageName()==("D.jpg")	)	){
					if (	(((Elements) this.getView().getMap().getOnTheMap(x, y+1)).getSprite().getImageName()!="background.jpg" )) {
					((CommonMobile) this.getView().getMap().getOnTheMap(x, y)).setVelocity((0));
					}
				}
			}
		}

	}


	public void fallAndKill()  {

		//we go through the all map to detect if there is a rock who is waiting to fall
		for (int x = 0; x < this.getView().getMap().getWidth(); x++) {

			for (int y = 0; y < this.getView().getMap().getHeight(); y++) {

				if (	(	((Elements) this.getView().getMap().getOnTheMap(x, y)).getSprite().getImageName()==("R.jpg") 	) 	||	(	((Elements) this.getView().getMap().getOnTheMap(x, y)).getSprite().getImageName()==("D.jpg")	)	){

					if (	(	((((CommonMobile) this.getView().getMap().getOnTheMap(x, y)).getVelocity())	>=	2)	) && (	(x==getModel().getMyPlayer().getX()) && (y+1==getModel().getMyPlayer().getY())	)	) {
						getModel().getMyPlayer().setAlive(false);

							 }

					//if background under rock:
					if (	(((Elements) this.getView().getMap().getOnTheMap(x, y+1)).getSprite().getImageName()=="background.jpg" )) {




						 if (	(this.getModel().getMyPlayer().getX()!=x) || (this.getModel().getMyPlayer().getY()!=y+1)	) {

							//increase the velocity of the rock

								((CommonMobile) this.getView().getMap().getOnTheMap(x, y)).setVelocity(((CommonMobile) this.getView().getMap().getOnTheMap(x, y)).getVelocity()+1);



								//kill the player


								this.getView().getMap().setOnTheMap((IElements) this.getView().getMap().getOnTheMap(x, y),x,y+1);


								this.getView().getMap().setOnTheMap(this.getModel().backgroundFastCreator(), x, y);
							//adding on the boardframe
								this.getView().getBoardFrame().addSquare(this.getView().getMap().getOnTheMap(x,y),x, y);
								this.getView().getBoardFrame().addSquare(this.getView().getMap().getOnTheMap(x,y+1),x, y+1);
								this.getView().getMap().setMobileHasChanged();
						}
					}




					//this line is setting up the rock in his new position

					//if rock on rock :
					else if	(((Elements) this.getView().getMap().getOnTheMap(x, y+1)).getSprite().getImageName()=="R.jpg"	||	(	((Elements) this.getView().getMap().getOnTheMap(x, y)).getSprite().getImageName()==("D.jpg")	) )	{
							//empty space on left
							if	(	(((Elements) this.getView().getMap().getOnTheMap(x+1, y+1)).getSprite().getImageName()=="background.jpg" )	)	{

								if (	(this.getModel().getMyPlayer().getX()!=x+1) || (this.getModel().getMyPlayer().getY()!=y+1)	) {
									//increase the velocity of the rock
									((CommonMobile) this.getView().getMap().getOnTheMap(x, y)).setVelocity(((CommonMobile) this.getView().getMap().getOnTheMap(x, y)).getVelocity()+1);



									this.getView().getMap().setOnTheMap((IElements) this.getView().getMap().getOnTheMap(x, y),x+1,y+1);



									this.getView().getMap().setOnTheMap(this.getModel().backgroundFastCreator(), x, y);
								//adding on the boardframe

									this.getView().getBoardFrame().addSquare(this.getView().getMap().getOnTheMap(x,y),x, y);

									this.getView().getBoardFrame().addSquare(this.getView().getMap().getOnTheMap(x+1,y+1),x+1, y+1);
									this.getView().getMap().setMobileHasChanged();
								}
							}
							//empty space on right
							else if ((((Elements) this.getView().getMap().getOnTheMap(x-1, y+1)).getSprite().getImageName()=="background.jpg" )		){
									if (	(this.getModel().getMyPlayer().getX()!=x-1) || (this.getModel().getMyPlayer().getY()!=y+1)	) {
										this.getView().getMap().setOnTheMap((IElements) this.getView().getMap().getOnTheMap(x, y),x-1,y+1);
										//increase the velocity of the rock
										((CommonMobile) this.getView().getMap().getOnTheMap(x, y)).setVelocity(((CommonMobile) this.getView().getMap().getOnTheMap(x, y)).getVelocity()+1);

										this.getView().getMap().setOnTheMap(this.getModel().backgroundFastCreator(), x, y);
										//adding on the boardframe
										this.getView().getBoardFrame().addSquare(this.getView().getMap().getOnTheMap(x,y),x, y);
										this.getView().getBoardFrame().addSquare(this.getView().getMap().getOnTheMap(x-1,y+1),x-1, y+1);
										this.getView().getMap().setMobileHasChanged();
									}


									}
							}


					}



//
//
				this.getView().getMap().setMobileHasChanged();
				}




	}




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

	}

}
