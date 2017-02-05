package seedu.addressbook.data.person;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
	
	private Name name;
	private static final String ACTUAL_NAME = "Chan Yu Feng";
	private static final String SIMILAR_NAME_ONE = "Feng Chan Yu";
	private static final String SIMILAR_NAME_TWO = "yU chan FeNG";

	
	@Before
	public void setup() throws IllegalValueException  {
	    name = new Name(ACTUAL_NAME);
	}
	
	@Test
	public void isSimilar_nullCompare_returnsFalse() {
		assertFalse(name.isSimilar(null));
	}
	
	@Test
	public void isSimilar_emptyName_returnsFalse() {
		assertFalse(name.isSimilar(""));
		assertFalse(name.toString().length() < 1);
	}
	
	
	@Test
	public void isSimilar_exactSpellings_returnsTrue() {
		assertTrue(name.isSimilar(this.name.toString()));
		assertTrue(name.isSimilar(name.toString().toUpperCase()));
		assertTrue(name.isSimilar(name.toString().toLowerCase()));
	}

	@Test
	public void isSimilar_sameIndividualWords_returnTrue() {
		assertTrue(name.isSimilar(SIMILAR_NAME_ONE));
		assertTrue(name.isSimilar(SIMILAR_NAME_TWO));
		assertTrue(name.isSimilar(SIMILAR_NAME_ONE.toUpperCase()));
		assertTrue(name.isSimilar(SIMILAR_NAME_TWO.toLowerCase()));
	}
	
	@Test
	public void isSimilar_sameSpellingDifferentWord_returnsTrue() {
		assertTrue(name.isSimilar("Chan YuFeng"));
		assertTrue(name.isSimilar("ChanYuFeng"));
		assertTrue(name.isSimilar("C han Yu Feng"));
		assertTrue(name.isSimilar("Ch an Yu Fe ng"));
	}
	
	@Test 
	public void isSimilar_similarNameExtraSpace_returnsTrue() {
		assertTrue(name.isSimilar("Chan     Yu             Feng"));
		assertTrue(name.isSimilar("Feng Yu      Chan"));
		assertTrue(name.isSimilar("chAn  FENG    yu"));
		assertTrue(name.isSimilar(SIMILAR_NAME_ONE.toUpperCase() + "    "));
		assertTrue(name.isSimilar(" " + SIMILAR_NAME_TWO.toLowerCase() + " "));
	}
}


























