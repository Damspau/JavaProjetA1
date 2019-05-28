package view;

import controller.*;
import model.*;
import contract.*;

import javax.swing.*;
import java.awt.*;

/**
 * The Class GameGroundView.
 *
 * @author Maxime G, Benoît D et Damiens
 */

public class GameGroundView extends GroundView {

	private GameController gameController;

	/**
	 * Class constructor
	 *
	 * @param gameController Game controller
	 * @param levelModel     Level model
	 */
	public GameGroundView(Controller controller, Model model) {
		super(model);

		this.Controller = controller;

		this.addKeyListener(new GameKeyController(this.model, this.controller.getAudioLoadHelper()));

		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setFocusable(true);
	}

}
