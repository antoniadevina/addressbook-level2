package seedu.addressbook.data.person;

/**
 * Represents an contact details.
 */
public abstract class Contact {
    
	protected boolean isPrivate;
    protected final String value;

    protected Contact(String value, boolean isPrivate) {
    	this.value = value; 
    	this.isPrivate = isPrivate; 
    }
	
	public abstract String toString();
	
    public abstract int hashCode(); 
    
    public abstract boolean equals(Object other);
    
    public abstract boolean isPrivate();
}