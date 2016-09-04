/* ********************************************************************
 * FileDialog.java
 *
 * Selects the file to be opened and read.
 *
 * (c) robert pacula 2016
 *
 * *******************************************************************/
package ph.mmhsvictoria.apps.validfx;

import java.lang.*;
import java.util.*;
import java.io.*;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;

public class FileDialog {
    public static String getFile(Window owner) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Select Student Data File");
        fc.getExtensionFilters().addAll(
            new ExtensionFilter("Text Files", "*.txt"),
            new ExtensionFilter("All Files", "*.*"));
        File selectedFile = fc.showOpenDialog(owner);
        if (selectedFile != null) {
            return selectedFile.toString();
        }
        else {
            return "none";
        }
    }
}

