package controller;

import java.io.IOException;

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
			Thread.sleep(100);
			this.fallAndKill();
			this.IsThereARock();
			
			

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




		if (((Map) this.getModel().getMap()).updateMap(playerActualXPosition, playerActualYPosition)) {

			this.getView().getBoardFrame().addSquare(this.getView().getMap().getOnTheMap(this.getModel().getMyPlayer().getX(),this.getModel().getMyPlayer().getY()),this.getModel().getMyPlayer().getX(), this.getModel().getMyPlayer().getY());

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
			case "YouDied" :
				 getModel().getMyPlayer().setAlive(false);
				 System.out.println("u dead");
					 
			
	
			default:
				break;
		}
		
			
				
											}

	
	
	
	public void fallAndKill() {
		
		//we go through the all map to detect if there is a rock who is waiting to fall
		for (int x = 0; x < this.getView().getMap().getWidth(); x++) {

			for (int y = 0; y < this.getView().getMap().getHeight(); y++) {

				if (	(	((Elements) this.getView().getMap().getOnTheMap(x, y)).getSprite().getImageName()==("R.jpg") 	) 	||	(	((Elements) this.getView().getMap().getOnTheMap(x, y)).getSprite().getImageName()==("D.jpg")	)	){
					if (((Elements) this.getView().getMap().getOnTheMap(x, y+1)).getSprite().getImageName()=="background.jpg") {
					
					//this line is setting up the rock in his new position
					this.getView().getMap().setOnTheMap((IElements) this.getView().getMap().getOnTheMap(x, y),x,y+1);

//					this.getView().getMap().setOnTheMap((IElements) this.getView().getMap().getOnTheMap(x, y),(((CommonMobile) this.getView().getMap().getOnTheMap(x, y)).getX()), (((CommonMobile) this.getView().getMap().getOnTheMap(x, y)).getY()));
					this.getView().getMap().setOnTheMap(this.getModel().backgroundFastCreator(), x, y);
					//adding on the boardframe
					this.getView().getBoardFrame().addSquare(this.getView().getMap().getOnTheMap(x,y),x, y);
					this.getView().getBoardFrame().addSquare(this.getView().getMap().getOnTheMap(x,y+1),x, y+1);
					}
					if (	(x==getModel().getMyPlayer().getX()) && (y+1==getModel().getMyPlayer().getY())	) {
						
						
					}
					
					
					
					}
				}
			}
		}
		
		
		
	

	private void setStackOrder(final UserOrder stackOrder) {

		this.stackOrder = stackOrder;
		
	}
	
}
