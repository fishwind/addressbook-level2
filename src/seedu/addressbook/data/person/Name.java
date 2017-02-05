package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;
import java.util.HashSet;


/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        String trimmedName = name.trim();
        if (!isValidName(trimmedName)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = trimmedName;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

    public boolean isSimilar(String other) {
    	String thisName = this.fullName;
    	String thatName = other;
    	if(other == null) {
    		return false;
    	} else if(this.fullName.compareToIgnoreCase(other) == 0) {
    		return true;
    	} else if(thisName.replaceAll("\\s+", "").equalsIgnoreCase(thatName.replaceAll("\\s+", ""))) {
    		return true;
    	}
    	List<String> thisNameArray = Arrays.asList(thisName.toLowerCase().split(" "));
    	List<String> thatNameArray = Arrays.asList(thatName.toLowerCase().split(" "));
    	HashSet<String> thisNameSet = new HashSet<String>(thisNameArray);
    	HashSet<String> thatNameSet = new HashSet<String>(thatNameArray);
    	if(thisNameSet.equals(thatNameSet)) {
    		return true;
    	}
    	return false;
    }
}
