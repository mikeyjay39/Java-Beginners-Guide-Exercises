
import java.io.*;



import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;


public class SelfTestQ13 extends Application {

	TextField tfFirst; // holds the first file name
	TextField tfSecond; // holds the second file name
	
	Button btnComp; // button to compare the files
	
	Label labFirst, labSecond; // displays prompts
	Label labResult; // displays results and error messages
	
	public static void main(String[] args) {
		launch(args);
	}
	
	// Override the start() method.
	public void start(Stage myStage) {
		
	
		// Give the stage a title
		myStage.setTitle("File Comparison Utility");
		
		// Use a FlowPane for the root node. In this case,
		// vertical and horizontal gaps of 10 are used.
		FlowPane rootNode = new FlowPane(10, 10);
		
		// Center the controls in the scene.
		rootNode.setAlignment(Pos.CENTER);
		
		// Create a scene.
		Scene myScene = new Scene(rootNode, 180, 180);
		
		// Set the scene on the stage.
		myStage.setScene(myScene);
		
		// Create the text fields for the file names.
		tfFirst = new TextField();
		tfSecond = new TextField();
		
		Button btnComp = new Button("Compare");
		
		// Create the labels.
		labFirst = new Label("First file: ");
		labSecond = new Label("Second file: ");
		labResult = new Label("");
		
		
		// Handlers
		tfFirst.setOnAction((ae) -> btnComp.fire());
		tfSecond.setOnAction((ae) -> btnComp.fire());
		
		
		btnComp.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				
				// Compare the files when the Compare button is pressed.

					int i=0, j=0;
					
					// First, confirm that both file names have
					// been entered.
					if(tfFirst.getText().equals("")) {
						labResult.setText("First file name missing.");
						return;
					}
					if(tfSecond.getText().equals("")) {
						labResult.setText("Second file name missing");
						return;
					}
					
					// Compare files. Use try-with-resources to manage the files.
					try(FileInputStream f1 = new FileInputStream(tfFirst.getText());
							FileInputStream f2 = new FileInputStream(tfSecond.getText()))
					{
						// Check the contents of each file.
						do {
							i = f1.read();
							j = f2.read();
							if( i != j) break;
						} while(i != -1 && j != -1);
						
						if(i != j)
							labResult.setText("Files are not the same.");
						else
							labResult.setText("Files compare equal.");
						} catch(IOException exc) {
							labResult.setText("File Error");
						}
					}
			
		});
		
		// Add the label and the buttons to the scene graph.
		rootNode.getChildren().addAll(labFirst, tfFirst, labSecond, tfSecond, btnComp, labResult);
		
		// Show the stage and its scene.
		myStage.show();
	
	}
	
}
