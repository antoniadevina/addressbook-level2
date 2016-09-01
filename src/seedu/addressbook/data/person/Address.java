package seedu.addressbook.data.person;

import java.util.regex.Pattern; 
import java.util.regex.Matcher;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in this format: a/BLOCK, STREET, UNIT, POSTAL_CODE ";
    public static final String ADDRESS_VALIDATION_REGEX = "(?<block>[^/]+)," + " (?<street>[^/]+)," 
			+ " (?<unit>[^/]+)," + " (?<postalCode>[^/]+)";
    private static final Pattern ADDRESS_PATTERN = Pattern.compile(ADDRESS_VALIDATION_REGEX);
    
 //   public final String completeAddress;
    private final String block; 
    private final String street; 
    private final String unit; 
    private final String postalCode; 
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
        this.block = addressMatch.group("block");
        this.street = addressMatch.group("street");
        this.unit = addressMatch.group("unit");
        this.postalCode = addressMatch.group("postalCode");
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
}