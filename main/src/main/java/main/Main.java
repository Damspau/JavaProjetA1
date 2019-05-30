/**
 * @author Maxime G, Damiens et Benoît D
 * @version 1.0
 */
package main;

import java.io.IOException;

import controller.Controller;
import model.BoulderdashModel;
import view.View;

public abstract class Main {

	public static void main(final String[] args) throws IOException, InterruptedException {
		
		String fileName = "map.txt";
		
		final BoulderdashModel model = new BoulderdashModel(fileName, 0, 5);
		final View view = new View(model.getMap(), model.getMyPlayer());
		final Controller controller = new Controller(view, model);
		view.setOrderPerformer(controller.getOrderPerformer());

		controller.play();

	}
}
