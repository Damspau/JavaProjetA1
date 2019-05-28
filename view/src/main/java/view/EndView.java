package view;

import javax.swing.*;
import java.awt.*;

public class EndView extends JFrame {

	private String endView;

	/**
	 * Generate the HelpView
	 */
	public void EndView(String endView) {
		this.endView = endView;
		this.initializeView();
		this.createLayout();
	}

	/**
	 * Initializes the view
	 */
	private void initializeView() {
		this.setVisible(true);
		this.setResizable(false);

		// UI parameters
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setBounds(300, 300, 250, 100);

		// App parameters
		this.setTitle("END ! ");
	}

	/**
	 * Creates the view layout
	 */
	private void createLayout() {
		JTextArea help = new JTextArea();
		help.setEditable(false);
		if (endView.equals("win"))
			help.setText("WIN !");
		else
			help.setText("GAME OVER !");

		this.add(help);
	}
}