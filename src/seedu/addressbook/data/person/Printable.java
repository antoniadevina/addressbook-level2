package seedu.addressbook.data.person;

/**
 * Produce an output string of all the detail given
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface Printable {
	
	
	/**
	  * Returns a concatenated version of the printable strings of each object.
	  */
	String getPrintableString ();

	
	default String getPrintableString(Printable... data) {
        String combinedData = new String(); 
		for (Printable d : data) {
            combinedData = combinedData + ", " + d.getPrintableString();
        }
		return combinedData;	   
	}
}
