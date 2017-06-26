/* ***************************************************************************
 * Ticket.java
 *
 * Class Ticket. A Ticket is a collection of TicketFields.
 *
 * At the moment, we implement a Ticket as an array of TicketFields.
 *
 * **************************************************************************/
package ph.mmhsvictoria.apps.validfx;

import java.lang.*;
import java.util.*;

public class Ticket {
    private TicketField[] TF_Array;
    private final int defaultSize = 1024;  // Default number of TicketFields in a Ticket.
    private int nextAvailableSlot = 0;
    private int maxSize;


    // The constructors
    //
    public Ticket(int size) {
        TF_Array = new TicketField[size];
        nextAvailableSlot = 0;
        maxSize = size;
    }

    public Ticket() {
        TF_Array = new TicketField[defaultSize];
        nextAvailableSlot = 0;
        maxSize = defaultSize;
    }

    // Dump the contents of this Ticket.
    public void dump() {
        for (int i = 0; i < nextAvailableSlot; ++i) {
             System.out.printf("\t(%s: %s)\n", 
                 TF_Array[i].getFieldName(),
                 TF_Array[i].getFieldValue());
        }
    } 


    // Return TRUE if the ticket has the given field value.
    public boolean hasFieldValue(String key, String fvalue) {
        int semaphore = 0;
        TicketField tf;

        for (int i = 0; i < nextAvailableSlot; ++i) {
            tf = TF_Array[i];
            if (tf.compareFieldNameIgnoreCase(key)  == 0 &&
                   tf.compareFieldValueIgnoreCase(fvalue) == 0) {
                semaphore = 1;
                break;
            }
        }
        if (semaphore == 1) {
            return true;
        }
        else
            return false;
    }


    // Add a new TicketField and return with the
    // number of fields already in this Ticket.
    public int add(TicketField ATF) {
        if (nextAvailableSlot < maxSize-1) {
	    TF_Array[nextAvailableSlot] = ATF;
	    nextAvailableSlot++;
        }
        return nextAvailableSlot;
    }

    // This function needs improvement. Add error handling.
    public TicketField getItem(int index) {
        if (index < nextAvailableSlot) {
            return TF_Array[index];
        }
        return TF_Array[index];   // Because Java refuses to compile without this!!
    }

    public int length() {
        return nextAvailableSlot;
    }

}

