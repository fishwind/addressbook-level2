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

    /*
     * Returns true if a given string has similar name.
     */
    public boolean isSimilar(String other) {
    	if(other == null) {
    		return false;
    	}
    	
    	// Checks if both names have the same spelling, ignoring all whitespace. 
    	String thisName = this.fullName.trim().toLowerCase();
    	String thatName = other.trim().toLowerCase();
    	String thisNameNoSpace = thisName.replaceAll("\\s+", "");
    	String thatNameNoSpace = thatName.replaceAll("\\s+", "");
    	if(thisName.compareTo(thatName) == 0) {
    		return true;
    	} else if(thisNameNoSpace.equals(thatNameNoSpace)) {
    		return true;
    	}
    	
    	// Checks if both names have the same words, regardless their positions.
    	String[] thisNameArray = thisName.split("\\s+");
        String[] thatNameArray = thatName.split("\\s+");
    	HashSet<String> thisNameSet = new HashSet<String>();
    	HashSet<String> thatNameSet = new HashSet<String>();
    	for(String eachWord : thisNameArray) {
    		thisNameSet.add(eachWord.trim());
    	}
    	for(String eachWord : thatNameArray) {
    		thatNameSet.add(eachWord.trim());
    	}
    	if(thisNameSet.equals(thatNameSet)) {
    		return true;
    	}
    	
    	return false;
    }
}
