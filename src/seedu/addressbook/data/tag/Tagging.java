package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * A record of tag that is being added/removed from a person in the address book.
 */
public class Tagging {
    
    private boolean isAdd;
    private Person person;
    private Tag tag;
    
    public Tagging(boolean isAdd, Person person, Tag tag) {
    	this.isAdd = isAdd;
    	this.person = person;
    	this.tag = tag;
    }
    
    @Override
    public String toString() {
        String operator = "";
        if(isAdd) {
        	operator = "+";
        } else {
        	operator = "-";
        }
        return operator + " " + this.person.toString() + " " + this.tag.toString();
    }
}
