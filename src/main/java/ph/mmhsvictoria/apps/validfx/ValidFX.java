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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class ValidFX extends Application {

    /* Properties of this Class */
    String file2open;   /* Full pathname of file to open and read. */
    String fieldName;   /* The target field name */
    String fieldValue;  /* The target field value */

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        /* Set the Stage and the Scene */
        primaryStage.setTitle("Valids Processing");
        BorderPane rootLayout = new BorderPane();
        Scene vscene = new Scene(rootLayout);
        vscene.getStylesheets().add("/ph/mmhsvictoria/apps/validfx/default.css");
        // vscene.getStylesheets().add(getClass().getClassLoader().getResource("default.css").toString());
        primaryStage.setScene(vscene);

        GridPane vblayout = new GridPane();
        rootLayout.setCenter(vblayout);
        vblayout.getStyleClass().add("grid");


        /* --- The first line determines the file name of the data to read. --- */

        Text t1 = new Text("File Name");
        vblayout.add(t1, 0, 0); // Column 0, row 0
        t1.getStyleClass().add("field-labels");

        TextField fnameTF = new TextField();
        fnameTF.getStyleClass().add("text-entries");
        vblayout.add(fnameTF, 1, 0, 3, 1); // column 1, row 0, colspan 3, rowspan 1

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
 

        /* The second line identifies the target field name */

        Text t2 = new Text("Target Field");
        t2.getStyleClass().add("field-labels");
        vblayout.add(t2, 0, 1); // Column 0, row 1 

        TextField targTF = new TextField();
        targTF.getStyleClass().add("text-entries");
        vblayout.add(targTF, 1, 1, 3, 1); // column 1, row 1, colspan 3, rowspan 1
 

        /* The third line identifies the target value */

        Text t3 = new Text("Target Value");
        t3.getStyleClass().add("field-labels");
        vblayout.add(t3, 0, 2); // Column 0, row 2 

        TextField tValue = new TextField();
        tValue.getStyleClass().add("text-entries");
        vblayout.add(tValue, 1, 2, 3, 1); // column 1, row 2, colspan 3, rowspan 1


        /* The last line contains the buttons */

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

        okBtn.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    if (fnameTF.getText().length() == 0) {
                        Alert alert = new Alert(AlertType.ERROR);
                        // alert.getStyleClass().add("alerts");
                        alert.setContentText("You should select a file to open first!");
                        alert.showAndWait();
                    }
                    else if (targTF.getText().length() == 0) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setContentText("You should indicate the Target Field.\nDo not leave it empty.");
                        alert.showAndWait();
                    }
                    else {
                        if (tValue.getText().length() == 0) {
                            Alert alert = new Alert(AlertType.CONFIRMATION);
                            alert.setContentText("You left the Target Value empty.\nAll valids will be printed.");
                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.isPresent() 
                                  && result.get() == ButtonType.CANCEL) {
                                return;
                            }
                        }
                        ProcessData.OpenFile(fnameTF.getText());
                    }
                }
            }
        );
 
        hb4.getChildren().addAll(clearBtn, cancelBtn, okBtn);
        rootLayout.setBottom(hb4);

        primaryStage.show();
    } 
    
}

