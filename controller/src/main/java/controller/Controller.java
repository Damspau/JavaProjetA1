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

public final class Controller implements IController, IBoulderDashController, IOrderPerformer, IBoulderdashModel, IBoulderDashView,  {
	
	private int diamondCount;
	
	/** The Constant speed. */
	private static final int speed = 300;

	/** The model. */
	private IBoulderdashModel model;
	
	/** The view. */
	private IBoulderdashView view;
	
	private UserOrder stackOrder;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view  the view
	 * @param model the model
	 */
	public Controller(final IBoulderdashView view, final IBoulderdashModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
	}
	
	/*
     * (non-Javadoc)
     * @see fr.exia.2019.boulderdash.controller.IBoulderDashController#play()
     */
    @Override
    public final void play() throws InterruptedException {
        while (this.getModel().getMyVehicle().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getMyVehicle().moveRight();
                    break;
                case LEFT:
                    this.getModel().getMyVehicle().moveLeft();
                    break;
                case NOP:
                default:
                    this.getModel().getMyVehicle().doNothing();
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
