package view;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import contract.*;
import model.*;
import controller.*;

/**
 * View
 *
 * @author Maxime G, Damiens et Benoît D
 */
public final class View extends JFrame implements IView, Observer {

	private JPanel actionPanel;
	private JPanel informationPanel;

	private GameGroundView gamegroundView;
	
	private BoulderDashController boulderdashcontroller;

	private BoulderDashLevelModel boulderdashlevelmodel;
	
}
