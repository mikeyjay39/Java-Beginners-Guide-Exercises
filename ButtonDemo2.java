/*
// Demonstrate a push button and handle action events using annonymous inner classes.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonDemo2 implements ActionListener {

	JLabel jlab;
	
	ButtonDemo2() {
		
		// Create a new JFrame container.
		JFrame jfrm = new JFrame("A Button Example");
		
		// Specify FlowLayout for the layout manager.
		jfrm.setLayout(new FlowLayout());
		
		// Give the frame an initial size.
		jfrm.setSize(420, 180);
		
		// Terminate the program when the user closes the application.
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Make two buttons.
		JButton jbtnUp = new JButton("Up");
		JButton jbtnDown = new JButton("Down");
		
		// Add action listeners.
		jbtnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jlab.setText("You pressed Up.");
			}
		});
		jbtnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jlab.setText("You pressed down. ");
			}
		});
		
		// Add the buttons to the content pane.
		jfrm.add(jbtnUp);
		jfrm.add(jbtnDown);
		
		// Create a label.
		jlab = new JLabel("Press a button.");
		
		// Add the label to the frame.
		jfrm.add(jlab);
		
		// Display the frame/
		jfrm.setVisible(true);
	}
	
	/*
	// Handle button events.
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Up"))
			jlab.setText("You pressed Up.");
		else
			jlab.setText("You pressed down. ");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ButtonDemo2();
			}
		});
	}

	
}


*/








