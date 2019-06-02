/**
 * @author Maxime G, Damiens et Benoît D
 * @version 1.0
 */
package main;

import java.io.IOException;

import contract.IBoulderdashController;
import controller.Controller;
import model.BoulderdashModel;
import model.IBoulderdashModel;
import view.View;


public abstract class Main {


    public static void main(final String[] args) throws IOException, InterruptedException {
    
        final IBoulderdashModel model = new BoulderdashModel("map.txt");
        final View view = new View(model.getMap(), model.getMyPlayer());
        final IBoulderdashController controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPerformer());

        controller.play();
       
    }
}
