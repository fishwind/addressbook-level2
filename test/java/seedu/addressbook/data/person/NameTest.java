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
	
	@Test
	public void isSimilar_emptyName_returnsFalse() {
		assertFalse(name.isSimilar(""));
	}
	
	@Test
	public void isSimilar_ExactSpellings_returnsTrue() {
		assertTrue(name.isSimilar(this.name.toString()));
	}

	@Test
	public void isSimilar_sameIndividualWords_returnTrue() {
		assertTrue(name.isSimilar("Feng Chan Yu"));
	}
}


























