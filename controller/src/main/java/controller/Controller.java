package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class Controller.
 */
public final class Controller implements IController, IBoulderDashController, IOrderPerformer {

	private int diamondCount;

	private IBoulderdashModel model;
	private IBoulderdashView view;

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view  the view
	 * @param model the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
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
	public void play() {
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

	@Override
	public void orderPerform(controller.ControllerOrder controllerOrder) {
		// TODO Auto-generated method stub

	}

}
