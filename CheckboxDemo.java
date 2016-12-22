// Demonstrate Check Boxes.

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class CheckboxDemo extends Application {

	CheckBox cbSmartphone;
	CheckBox cbTablet;
	CheckBox cbNotebook;
	CheckBox cbDesktop;
	
	Label response;
	Label selected;
	
	String computers;
	
	public static void main(String[] args) {

		// Start the JavaFX application by calling launch().
		launch(args);
	}
	
	// Override the start() method.
	public void start(Stage myStage) {
		
		// Give the stage a title.
		myStage.setTitle("Demonstrate CHeck Boxes");
		
		// Use a vertical FlowPane for the root node. In this case,
		// vertical and horizontal gaps of 10.
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);
		
		// Center the controls in the scene.
		rootNode.setAlignment(Pos.CENTER);
		
		// Create a scene.
		Scene myScene = new Scene(rootNode, 230, 200);
		
		// Set the scene on the stage.
		myStage.setScene(myScene);
		
		Label heading = new Label("What Computers Do You Own?");
		
		// Create a label that will report the state change of a check box.
		response = new Label("");
		
		// Create a label that will report all selected check boxes.
		selected = new Label("");
		
		// Create the check boxes.
		cbSmartphone = new CheckBox("Smartphone");
		cbTablet = new CheckBox("Tablet");
		cbNotebook = new CheckBox("Notebook");
		cbDesktop = new CheckBox("Desktop");
		
		cbSmartphone.setAllowIndeterminate(true);
		cbSmartphone.setOnAction(new EventHandler<ActionEvent> () {
			public void handle(ActionEvent ae) {
				if(cbSmartphone.isIndeterminate())
					response.setText("Smartphone is indeterminate.");
				else if(cbSmartphone.isSelected())
					response.setText("Smartphone was just selected.");
				else
					response.setText("Smartphone was just cleared.");
				
				showAll();
			}
		});
		
		// Handle action events for the check boxes.
		cbTablet.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				if(cbTablet.isSelected())
					response.setText("Tablet was just selected.");
				else
					response.setText("Tablet was just cleared.");
				
				showAll();
			}
		});
		
		cbNotebook.setOnAction(new EventHandler<ActionEvent> () {
			public void handle(ActionEvent ae) {
				if(cbNotebook.isSelected())
					response.setText("Notebook was just selected.");
				else
					response.setText("Notebook was just cleared.");
				
				showAll();
			}
		});
		
		cbDesktop.setOnAction(new EventHandler<ActionEvent> () {
			public void handle(ActionEvent ae) {
				if(cbDesktop.isSelected())
					response.setText("Desktop was just selected.");
				else
					response.setText("Desktop was just cleared.");
				
				showAll();
			}
		});
		
		// Add controls to the scene graph.
		rootNode.getChildren().addAll(heading, cbSmartphone, cbTablet,
										cbNotebook, cbDesktop, response, selected);
		
		// Show the stage and its scene.
		myStage.show();
		
		showAll();
		
	}
	
	// Update and show the selections.
	void showAll() {
		computers = "";
		if(cbSmartphone.isSelected()) computers = "Smartphone ";
		if(cbTablet.isSelected()) computers += "Tablet ";
		if(cbNotebook.isSelected()) computers += "Notebook ";
		if(cbDesktop.isSelected()) computers += "Desktop";
		
		selected.setText("Computers selected: " + computers);
	}

}

















