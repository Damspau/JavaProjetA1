
package main;

import java.io.IOException;

import contract.IBoulderdashController;
import controller.Controller;
import model.BoulderdashModel;
import model.IBoulderdashModel;
import view.View;
/**
 * <h1>The Main class</h1>
 * @author Maxime G, Damien B et Benoît D
 * @version 1.0
 */
public class Main {

	public static void main(final String[] args) throws IOException, InterruptedException {

		IBoulderdashModel model = new BoulderdashModel("map.txt");
		View view = new View(model.getMap(), model.getMyPlayer());
		IBoulderdashController controller = new Controller(view, model);
		view.setOrderPerformer(controller.getOrderPerformer());

		controller.play();

	}
}
