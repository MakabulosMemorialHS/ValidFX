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
import javafx.scene.Parent;
import javafx.event.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.net.URL;

public class ValidFX extends Application {

    public static void systemProperties() {
        System.out.println("OS : " + System.getProperty("os.name"));
        System.out.println("OS Arch : " + System.getProperty("os.arch"));
        System.out.println("Classpath : " + System.getProperty("java.class.path"));
    }

    public static void main(String[] args) {
        System.out.println("Hello Michelle Fuentebella!");
        systemProperties();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();

        // We need to find the absolute location of the resource file. 
        // This is because the FXMLLoader.setLocation() function requires an
        // absolute path including a protocol.
        // In order to successfully do this while still keeping our application portable.
        // we need to do the following:
        // 1. Determine the absolute path where the JVM was invoked.
        // 2. From that location, we then move to the relative path of the resource file
        //    that we need.
        // Let's try this.
        String cwd = System.getProperty("user.dir");   // This locates where the JVM was invoked.
        System.out.println("Invoked from " + cwd);
        String path_to_resource = cwd + "/src/main/resources/validfx.fxml";

        loader.setLocation(new URL("file://" + path_to_resource));
        
        VBox root = loader.load(); // This one works the same as loader.<VBox>load() because
                                   // the return value of FXMLLoader.load() is <T> T.

        primaryStage.setTitle("Valids Ticket Creator JavaFX Version");
        primaryStage.setScene(new Scene(root, 500, 200));
        primaryStage.show();
    }
}

