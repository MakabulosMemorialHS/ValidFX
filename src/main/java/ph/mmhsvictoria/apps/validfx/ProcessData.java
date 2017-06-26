/* ************************************************************
 * ProcessData.java
 *
 * Process the datafile and create the valid tickets.
 *
 * ***********************************************************/
package ph.mmhsvictoria.apps.validfx;

import java.lang.*;
import java.util.*;
import java.io.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ProcessData {
    public static void OpenFile(String filename, String targetField, String targetValue) {

        // File dF = new File(filename);     I am just leaving this here but
        //                                   I don't really need it anymore.

        FileReader dF2;
        BufferedReader dataFile;
        String inbuffer;
        TicketDeck  tickdeck = new TicketDeck();     // Size of the deck is the default size.

        try {
            dF2 = new FileReader(filename);
            dataFile = new BufferedReader(dF2);

            /* Get the headers and remember their column numbers. */
            String hdr = dataFile.readLine();
            String[] headers = hdr.split("\t");

            while ((inbuffer = dataFile.readLine()) != null) {
                Ticket bticket = new Ticket();
                // System.out.println("New Data");
                String[] textData = inbuffer.split("\t");
                for (int i = 0; i < textData.length; ++i) {
                    TicketField tfield = new TicketField(headers[i], textData[i]);
                    bticket.add(tfield);
                }
                if (bticket.hasFieldValue(targetField, targetValue)) {
		    tickdeck.add(bticket);
		    bticket.dump();
                }
            }
            dF2.close();
        }
        catch (FileNotFoundException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Unable to find file: " + filename);
            alert.showAndWait();
            return;
        }
        catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("An exception occurred processing file: " + filename);
            alert.showAndWait();
            return;
        }
    }
}

