// A simple Swing-based applet

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="MySwingApplet" width=200 height=80>
</applet>
*/

public class MySwingApplet extends JApplet {
	JButton jbtnUp;
	JButton jbtnDown;
	
	JLabel jlab;
	
	// Initialize the applet.
	public void init() {
		
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					makeGUI(); // initialize the GUI
				}
			});
		} catch(Exception exc) {
			System.out.println("Can't create bause of " + exc);
		}
	}
	
	// This applet does not need to override start(), stop(),
	// or destroy().
	
	// Set up and initialize the GUI.
	private void makeGUI() {
		// Set the applet to use flow layout.
		setLayout(new FlowLayout());
		
		// Make two buttons.
		jbtnUp = new JButton("Up");
		jbtnDown = new JButton("Down");
		
		// Add action listener for Up button.
		jbtnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jlab.setText("You pressed Up.");
			}
		});
		
		// Add action listener for Down button.
		jbtnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jlab.setText("You pressed down.");
			}
		});
		
		// Add the buttons to the content pane.
		add(jbtnUp);
		add(jbtnDown);
		
		// Create a text-based label.
		jlab = new JLabel("Press a button");
		
		// Add the label to the content pane.
		add(jlab);
	}

}
















