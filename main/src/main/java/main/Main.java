/**
 * @author Maxime G, Damiens et Benoît D
 * @version 1.0
 */
package main;

import view.*;

import java.io.IOException;

import controller.Controller;
import model.*;
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
     * @throws IOException 
     * @throws InterruptedException 
     */
    public static void main(final String[] args) throws IOException, InterruptedException {
        final BoulderdashModel model = new BoulderdashModel("map.txt",0,5);
        final View view = new View(model.getMap(), model.getMyPlayer());
        final Controller controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPerformer());

        controller.play();
       
    }
}
