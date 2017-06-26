/* *******************************************************************
 * ValidFX.java
 *
 * An implementation of the Valids program in JavaFX.
 * This implementation was accomplished with the aim of
 * practicing in the use of Java and Gradle.
 *
 * Note how this application now has a valid package name.
 * I never did anything of that sort before. Now I am doing so.
 * HOORAY FOR CHANGE!
 *
 * *******************************************************************/
package ph.mmhsvictoria.apps.validfx;

import java.lang.*;
import java.util.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class ValidFX extends Application {

    /* Properties of this Class */
    private static String file2open;   /* Full pathname of file to open and read. */
    private static String fieldName;   /* The target field name */
    private static String fieldValue;  /* The target field value */

    private TextField fnameTF;
    private TextField targTF;
    private TextField tValue;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        /* Prepare the Stage and the Scene */
        primaryStage.setTitle("Valids Processing");
        BorderPane rootLayout = new BorderPane();

        Scene vscene = new Scene(rootLayout);
        vscene.getStylesheets().add("/ph/mmhsvictoria/apps/validfx/default.css");
        primaryStage.setScene(vscene);
        GridPane vblayout = new GridPane();
        rootLayout.setCenter(vblayout);
        vblayout.getStyleClass().add("grid");


        /* *****************************************************************************************************
           Note the following facts about the above line:

           (a) The relative path above is based on the relative path of default.css
               insde the jar file. Obviously, the above is an incomplete path in the project
               tree.
           (b) To fix the incomplete path name above when this program is run during test,
               the -cp flag is passed to java during the test to set the correct PWD.

               ie: java -cp build/classes/main:build/resources/main ph.mmhsvictoria.apps.validfx.ValidFX
         * *****************************************************************************************************/
        
        /* --- The first line determines the file name of the data to read. --- */

        // Add the widget/graphic elements to the scene.

        // The File to open.
        Text t1 = new Text("File Name");
        vblayout.add(t1, 0, 0); // Column 0, row 0
        t1.getStyleClass().add("field-labels");

        fnameTF = new TextField();
        fnameTF.getStyleClass().add("text-entries");
        vblayout.add(fnameTF, 1, 0, 3, 1); // column 1, row 0, colspan 3, rowspan 1

        // The browse button
        Button browseBtn = new Button("Browse");
        vblayout.add(browseBtn, 4, 0);  // col 4, row 0 
        
        browseBtn.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    file2open = FileDialog.getFile(primaryStage);
                    fnameTF.setText(file2open);    
                }
            }
        );
 

        /* The Target Field name */
        Text t2 = new Text("Target Field");
        t2.getStyleClass().add("field-labels");
        vblayout.add(t2, 0, 1); // Column 0, row 1 

        targTF = new TextField();
        targTF.getStyleClass().add("text-entries");
        vblayout.add(targTF, 1, 1, 3, 1); // column 1, row 1, colspan 3, rowspan 1
 

        /* The Target value */
        Text t3 = new Text("Target Value");
        t3.getStyleClass().add("field-labels");
        vblayout.add(t3, 0, 2); // Column 0, row 2 

        tValue = new TextField();
        tValue.getStyleClass().add("text-entries");
        vblayout.add(tValue, 1, 2, 3, 1); // column 1, row 2, colspan 3, rowspan 1


        /* The buttons */
        HBox hb4 = new HBox();
        hb4.getStyleClass().add("button-box");

        Button clearBtn = new Button("Clear");
        clearBtn.setCancelButton(true);

        clearBtn.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    fnameTF.setText("");
                    targTF.setText(""); 
                    tValue.setText(""); 
                }
            }
        );
 

        Button cancelBtn = new Button("Quit");
        cancelBtn.setCancelButton(true);

        cancelBtn.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    Platform.exit();
                }
            }
        );
 

        Button okBtn = new Button("OK");

        /* Action on clicking OK Button (okBtn) */
        okBtn.setOnAction(e -> OKButtonHandler());
 
        hb4.getChildren().addAll(clearBtn, cancelBtn, okBtn);
        rootLayout.setBottom(hb4);

        // Show the primaryStage.
        primaryStage.show();
    } 
   

    public void OKButtonHandler() {
	file2open  = fnameTF.getText().trim();
	fieldName  = targTF.getText().trim();
	fieldValue = tValue.getText().trim();

	if (file2open.length() == 0) {
	    Alert alert = new Alert(AlertType.ERROR);
	    // alert.getStyleClass().add("alerts");
	    alert.setContentText("You should select a file to open first!");
	    alert.showAndWait();
	}
	else if (fieldName.length() == 0) {
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setContentText("You should indicate the Target Field.\nDo not leave it empty.");
	    alert.showAndWait();
	}
	else {
	    if (fieldValue.length() == 0) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("You left the Target Value empty.\nAll valids will be printed.");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.isPresent() 
		      && result.get() == ButtonType.CANCEL) {
		    return;
		}
	    }
	    ProcessData.OpenFile(file2open, fieldName, fieldValue);
	}
    } 
}

