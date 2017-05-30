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
    private TicketField[] TF_Array = new TicketField[1024];     // Default number of TicketFields in a Ticket.
    private int next_available_slot = 0;                        // The next available slot in the array.

    public void addTicketField(TicketField ATF) {
        TF_Array[next_available_slot++] = ATF;
    }

    /* Commented out.

    public TicketField getTicketField(String ticketFieldName) {
    }
    */
}

