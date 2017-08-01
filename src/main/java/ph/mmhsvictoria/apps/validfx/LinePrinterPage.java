/* ************************************************************************
 *
 * LinePrinterPage.java
 *
 * An abstraction of a page that will be printed by a Line Printer.
 *
 * ************************************************************************/
package ph.mmhsvictoria.apps.validfx;

public class LinePrinterPage {
    private static final int SHORTPAGELENGTH = 66;     // Standard 66 lines per page with 8.5 x 11 US Letter.
    private static final int LONGPAGELENGTH  = 78;     // Standard for Philippine Legal 8.5 x 13.
    private static final int PAGEWIDTH       = 60;     // 60 columns?

    private int pageLength;
    private int pageWidth;

    private StringBuffer pLines[];                     // StringBuffers are mutable. Strings are not.

    // Default constructor 
    public LinePrinterPage(void) {
        pLines = new StringBuffer[78];                 // Prep 78 lines in the LinePrinterPage.
        for (int
    
    }
}
