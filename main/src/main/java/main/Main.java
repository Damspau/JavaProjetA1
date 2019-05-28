/**
 * @author Maxime G, Damiens et Benoît D
 * @version 1.0
 */
package main;

import view.UserOrder;
import controller.Controller;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @Maxime G, Damiens et Benoît D
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController1(controller);

        controller.control();
        controller.orderPerform(ControllerOrder.English);
    }
}
