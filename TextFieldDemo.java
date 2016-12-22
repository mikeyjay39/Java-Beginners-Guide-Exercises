// Demonstrate a text field

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;


public class TextFieldDemo extends Application {

	TextField tf;
	Label response;
	
	public static void main(String[] args) {

		// Start the JavaFX application by calling launch().
		launch(args);
	}
	
	// Override the start() method.
	public void start(Stage myStage) {
		
		// Give the stage a title.
		myStage.setTitle("Demonstrate a TextField");
		
		// Use a FlowPane for the root node. In this case,
		// vertical and horizontal gaps of 10.
		FlowPane rootNode = new FlowPane(10, 10);
		
		// Center the controls in the scene.
		rootNode.setAlignment(Pos.CENTER);
		
		// Create a scene.
		Scene myScene = new Scene(rootNode, 230, 140);
		
		// Set the scene on the stage.
		myStage.setScene(myScene);
		
		// Create a label that will report the state of the 
		// selected check box.
		response = new Label("Enter Name: ");
		
		// Create a button that gets the text.
		Button btnGetText = new Button("Get Name");
		
		// Create a text field.
		tf = new TextField();
		
		// Set the prompt.
		tf.setPromptText("Enter a name.");
		
		// Set the preferred column count.
		tf.setPrefColumnCount(15);
		
		// Use a lambda expression to handle action events for the 
		// text field. Action events are generated when ENTER is
		// pressed while the text field has input focus. In this case,
		// the text in the field is obtained and displayed.
		tf.setOnAction((ae) -> response.setText("Enter pressed. Name is: " +
												tf.getText()));
		
		// Use a lambda expression get text from the text field
		// when the button is pressed.
		btnGetText.setOnAction((ae) -> 
									response.setText("Button pressed. Name is: " +
													tf.getText()));
		
		// Use a separator to better organize the layout.
		Separator separator = new Separator();
		separator.setPrefWidth(180);
		
		// Add controls to the scene graph.
		rootNode.getChildren().addAll(tf, btnGetText, separator, response);
		
		// Show the stage and its scene.
		myStage.show();
	}

}





















