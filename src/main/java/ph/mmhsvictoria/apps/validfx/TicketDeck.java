/* ****************************************************************************
 * TicketDeck.java
 *
 * A collection of Tickets.
 *
 * *****************************************************************************/
package ph.mmhsvictoria.apps.validfx;


public class TicketDeck {
    private Ticket ticketArray[];
    private int nextAvailableSlot;
    private int maxSize;
    private final int defaultSize = 4096;


    // The constructors.
    //

    public void TicketDeck(int deckSize) {
    // Prepare a TicketDeck of the specified number of Tickets.
        ticketArray = new Ticket[deckSize];
        nextAvailableSlot = 0;
        maxSize = deckSize;
    }


    public void TicketDeck() {
    // Prepare a TicketDeck of defaultSize.
        ticketArray = new Ticket[defaultSize];
        nextAvailableSlot = 0;
        maxSize = defaultSize;
    }


    // Add Ticket and return with number of Tickets already in Deck
    // No error checking yet!!
    //
    public int add(Ticket ticket) {
        if (nextAvailableSlot < maxSize-1) {
	    ticketArray[nextAvailableSlot] = ticket;
	    ++nextAvailableSlot;
        }
        return nextAvailableSlot;
    }

    public Ticket getItem(int index) {
        if (index < nextAvailableSlot) {
            return ticketArray[index];
        }
        return ticketArray[index];
    }
}

