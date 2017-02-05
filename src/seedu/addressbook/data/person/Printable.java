package seedu.addressbook.data.person;

/**
 * Enables printing of Person's details
 * Implementations should guarantee: details are not null, field values are validated.
 */
public interface Printable {

    public String getPrintableString();
}
