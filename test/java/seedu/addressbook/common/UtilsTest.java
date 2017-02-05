package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {
    @Test
    public void isAnyNull_empty_returnsFalse() {
        assertFalse(Utils.isAnyNull());
    }
    
    @Test
    public void isAnyNull_nonEmptyNoNull_returnsFalse() {
        assertFalse(Utils.isAnyNull(new Object(), new Object()));
        assertFalse(Utils.isAnyNull("test"));
        assertFalse(Utils.isAnyNull(""));
    }
    
    @Test
    public void isAnyNull_oneNull_returnsTrue() {
        // non empty list with just one null at the beginning
        assertTrue(Utils.isAnyNull((Object) null));
        assertTrue(Utils.isAnyNull(null, "", new Object()));
        assertTrue(Utils.isAnyNull(null, new Object(), new Object()));
    }
    @Test
    public void isAnyNull_nullMiddle_returnsTrue() {
        assertTrue(Utils.isAnyNull(new Object(), null, null, "test"));
        assertTrue(Utils.isAnyNull("", null, new Object()));
    }
    
    @Test
    public void isAnyNull_nullLast_returnsTrue() {
        assertTrue(Utils.isAnyNull("", new Object(), null));
        assertTrue(Utils.isAnyNull(new Object(), new Object(), null));
    }
    
    @Test
    public void isAnyNull_listWithNull_returnsFalse() {
        List<Object> nullList = Arrays.asList((Object) null);
        assertFalse(Utils.isAnyNull(nullList));
    }

    @Test
    public void elementsAreUnique_empty_returnsTrue() throws Exception {
        assertAreUnique();
    }
    
    @Test
    public void elementsAreUnique_oneObject_returnsTrue() throws Exception { 
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");
    }
    
    @Test
    public void elementsAreUnique_allUnique_returnsTrue() throws Exception {
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);
    }
    
    @Test
    public void elementsAreUnique_someIdentical_returnsFalse() throws Exception {
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
