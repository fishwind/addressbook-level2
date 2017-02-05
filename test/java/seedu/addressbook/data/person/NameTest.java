package seedu.addressbook.data.person;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
	
	private Name name;
	
	@Before
	public void setup() throws IllegalValueException  {
	    name = new Name("Chan Yu Feng");
	}
	
	@Test
	public void isSimilar_nullCompare_returnsFalse() {
		assertFalse(name.isSimilar(null));
	}
}


























