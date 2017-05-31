/* ************************************************************************************
 * TicketField.java
 *
 * (c) 2016 Robert Pascual/rtonypascual@gmail.com
 *
 * The class TicketField encapsulates information about
 * a single field in the valids ticket. Examples of fields
 * would be SEX, STATUS, etc. A TicketField is just an ordered pair
 * where the first member is the Field Name and the second member
 * is the Field Value.
 *
 * We made the following decisions
 * about this class:
 *
 * This is a refactoring: In this version of the Ticket and TicketField
 * class:
 *
 * (a) Field Names shall be case-insensitive. They will be stored as upper
 *     case values and a case insensitive search will always be carried out.
 *     There are some very subtle bugs introduced by having the fieldName be
 *     case sensitive. Those bugs are very hard to find.
 *
 * (b) Field Names and Field values will be of type String. The String class is a thoroughly
 *     debugged string class. Let us take advantage of the work done by others.
 *
 * (c) We shall also implement methods called getIntValue() and
 *     getFloatValue() which will work as intended. For example, it shall
 *     return reasonable values if confronted with a field that cannot
 *     be converted to either a double or an int.
 *
 * (d) Field Values will be stored as is. It is the responsibility of the
 *     program which shall be using this class to convert the string to a
 *     reasonable format, whether UPPER CASE or lower case.
 *
 * (e) Field Names will be stored as UPPER CASE.
 *
 * ***********************************************************************************/
package ph.mmhsvictoria.apps.validfx;

import java.lang.*;
import java.util.*;


public class TicketField {
    private String TF_Field_Name;                        // assert(TF_Field_Name is in uppercase)
    private String TF_Field_Value;                       // assert(TF_Field_Value is in uppercase)

    public String getFieldName() {                       // Return with the Field Name of this TicketField
        return TF_Field_Name;
    }

    public void setFieldName(String newValue) {          // The Field Name of this TicketField shall be ...
        TF_Field_Name = newValue.toUpperCase().trim();   // Field names are all in UPPER CASE.
    }

    public String getFieldValue() {                      // Return with the Field Value as a String.
        return TF_Field_Name;
    }

    public void setFieldValue(String newValue) {         // The Field Value for this TicketField is ...
        TF_Field_Value = newValue.trim();                // Field Values are stored as is.
    }


    public int compareFieldName(String astring) {
        String fname = TF_Field_Name;
        return fname.compareToIgnoreCase(astring);
    }


    public int compareFieldValueIgnoreCase(String astring) {
        String fname = TF_Field_Value;
        return fname.compareToIgnoreCase(astring);
    }

    public int compareFieldValue(String astring) {       // Case sensitive comparison.
        String fname = TF_Field_Value;
        return fname.compareTo(astring);
    }


    public double fieldValuetoDouble() {                 // Return with the Field Value as a double
       return Double.parseDouble(this.TF_Field_Value);   // This just might throw and Exception. 
    }


    /* This is the default constructor */
    public TicketField() {
        TF_Field_Name  = "";
        TF_Field_Value = "";
    }

    public TicketField(String fieldName, String fieldValue) {
        this.setFieldName(fieldName);
        this.setFieldValue(fieldValue);

        // assert(TF_Field_Name  == TF_Field_Name.toUpperCase()); 
        // assert(TF_Field_Value == TF_Field_Value.toUpperCase()); 
    }

    public String toString() {
        return String.format("%s:%s", TF_Field_Name, TF_Field_Value);
    }
}

