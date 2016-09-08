package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class _SimilarNameTest {

	@Test
	public void SameNameAndSpaces() throws IllegalValueException {
		Name name = new Name ("Antonia Devina");
		Name other = name; 
		assertEquals("The name is the same", true, name.isSimilar(other));
	}
	
	@Test
	public void SameNameWithDifferentSpaces() throws IllegalValueException {
		Name name = new Name ("Antonia Devina");
		Name other = new Name ("AntoniaDevina"); 
		assertEquals("The name is the same", true, name.isSimilar(other));
	}
	
	@Test 
	public void SameNameWithDifferentCap() throws IllegalValueException {
		Name name = new Name ("AnTOnia devina");
		Name other = new Name ("Antonia DEVINa"); 
		assertEquals("The name is the same", true, name.isSimilar(other));
	}

}
