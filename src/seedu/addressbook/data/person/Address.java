package seedu.addressbook.data.person;

import java.util.regex.Pattern; 
import java.util.regex.Matcher;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address implements Printable {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in this format: a/BLOCK, STREET, UNIT, POSTAL_CODE ";
    public static final String ADDRESS_VALIDATION_REGEX = "(?<block>[^/]+)," + " (?<street>[^/]+)," 
			+ " (?<unit>[^/]+)," + " (?<postalCode>[^/]+)";
    private static final Pattern ADDRESS_PATTERN = Pattern.compile(ADDRESS_VALIDATION_REGEX);
    
 //   public final String completeAddress;
    private final Block block = new Block(); 
    private final Street street = new Street(); 
    private final Unit unit = new Unit(); 
    private final PostalCode postalCode = new PostalCode(); 
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        Matcher addressMatch = ADDRESS_PATTERN.matcher(address);
        if (!isValidAddress(addressMatch)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
//        this.completeAddress = address;
        this.block.setBlockNumber(addressMatch.group("block"));
        this.street.setStreetNumber(addressMatch.group("street"));;
        this.unit.setBlockNumber(addressMatch.group("unit"));;
        this.postalCode.setBlockNumber(addressMatch.group("postalCode"));;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(Matcher test) {
        return test.matches();
    }

    @Override
    public String toString() {
        return block + ", " + street + ", " + unit + ", " + postalCode;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    public static class Block {
    	private String blockNumber;
    	
    	public Block(){ 
    		this.blockNumber=null; 
    	}
    	
		public Block(String blockNumber) {
			this.blockNumber = blockNumber;
		}

		public String getBlockNumber() {
			return blockNumber;
		}

		public void setBlockNumber(String blockNumber) {
			this.blockNumber = blockNumber;
		}

		@Override
		public String toString() {
			return blockNumber;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Block other = (Block) obj;
			if (blockNumber == null) {
				if (other.blockNumber != null)
					return false;
			} else if (!blockNumber.equals(other.blockNumber))
				return false;
			return true;
		} 
    }
    
    public static class Street {
    	private String street;
    	
    	public Street(){ 
    		this.street=null; 
    	}
    	
		public Street(String street) {
			this.street = street;
		}

		public String getStreetkNumber() {
			return street;
		}

		public void setStreetNumber(String blockNumber) {
			this.street = blockNumber;
		}

		@Override
		public String toString() {
			return street;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Street other = (Street) obj;
			if (street == null) {
				if (other.street != null)
					return false;
			} else if (!street.equals(other.street))
				return false;
			return true;
		} 
    }
    
    public static class Unit {
    	private String unitNumber;

    	public Unit(){ 
    		this.unitNumber=null; 
    	}
    	
		public Unit(String blockNumber) {
			this.unitNumber = blockNumber;
		}

		public String getBlockNumber() {
			return unitNumber;
		}

		public void setBlockNumber(String blockNumber) {
			this.unitNumber = blockNumber;
		}

		@Override
		public String toString() {
			return unitNumber;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Unit other = (Unit) obj;
			if (unitNumber == null) {
				if (other.unitNumber != null)
					return false;
			} else if (!unitNumber.equals(other.unitNumber))
				return false;
			return true;
		} 
    }
    
    public static class PostalCode {
    	private String postalCode;

    	public PostalCode(){ 
    		this.postalCode=null; 
    	}
    	
		public PostalCode(String blockNumber) {
			this.postalCode = blockNumber;
		}

		public String getBlockNumber() {
			return postalCode;
		}

		public void setBlockNumber(String blockNumber) {
			this.postalCode = blockNumber;
		}

		@Override
		public String toString() {
			return postalCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PostalCode other = (PostalCode) obj;
			if (postalCode == null) {
				if (other.postalCode != null)
					return false;
			} else if (!postalCode.equals(other.postalCode))
				return false;
			return true;
		} 
    }

	@Override
	public String getPrintableString() {
		return "Address: " + this.toString();
	}
}