package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * FieldView. This view is basically drawing into the Frame the model.
 *
 * FieldView, created by controller.
 *
 * @author Maxime G, Damiens et Benoît D
 */
public abstract class GroundView extends JPanel implements Observer {
	
	protected Model model;

	/**
	 * Class constructor
	 */
	public GroundView(Model model) {
		this.model = model;
		this.model.addObserver(this);
	}
	
	/**
	 * Set the view to inform the user that he won
	 */
	private void displayWin() {
		new EndView("win");
	}

	/**
	 * Set the view to inform the user that he is not good at this game
	 */
	private void displayLose() {
		new EndView("lose");
	}

	/**
	 * Draws the map
	 *
	 * @param width  Map width
	 * @param height Map height
	 * @param g      Map graphical object
	 */
	public void drawTerrain(int width, int height, Graphics g) {
		// Draw items
		if (this.model.getMode() == "game") {
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					g.drawImage(this.model.getImage(x, y), (x * 16), (y * 16), this);
				}
			}

			if (!this.model.isGameRunning()) {
				if (!this.model.getRockford().getHasExplosed()) {
					this.displayWin();
				} else {
					this.displayLose();
				}
			}
		} else {
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					g.drawImage(this.model.getImage(x, y), (x * 16), (y * 16), this);
				}
			}
			if (this.model.getShowCursor()) {
				g.drawImage(this.model.getCursorImage(), ((this.model.getCursorXPosition() + 1) * 16),
						((this.model.getCursorYPosition() + 1) * 16), this);
			}
		}
	}

	

	/**
	 * Paints the map
	 *
	 * @param g Map graphical object
	 */
	public void paint(Graphics g) {
		this.drawTerrain(this.model.getSizeWidth(), this.model.getSizeHeight(), g);
	}

	/**
	 * Updates the view
	 *
	 * @param obs Observable item
	 * @param obj Object item
	 */
	@Override
	public void update(Observable obs, Object obj) {
		repaint();
	}
}