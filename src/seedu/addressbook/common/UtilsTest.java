package seedu.addressbook.common;

import java.util.ArrayList;
import java.util.Collection;
import seedu.addressbook.common.Utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

	private Utils utils;

	@Before
	public void setup() {
		utils = new Utils();
	}
	
	/** testing the fist method in Utils **/ 
	
	@Test
	public void noNullInput_StringInput() {
		boolean result = Utils.isAnyNull ("my brother", "isn't", "studying");
		assertFalse("is this true",result);
	}

	@Test
	public void nullInput_StringInput() {
		boolean result = Utils.isAnyNull ("my brother", "isn't", "studying", null);
		assertTrue("is this true",result);
	}
	
	@Test
	public void nullInputFromAStringPointer_StringInput() {
		String str = null;
		boolean result = Utils.isAnyNull ("my brother", "isn't", "studying", str);
		assertTrue("is this true",result);
	}
	
	@Test
	public void nullInputFromMixInput_MixInput() {
		Integer str = null;
		boolean result = Utils.isAnyNull ("my brother", 'c', 321, false, "isn't", "studying", str);
		assertTrue("is this true",result);
	}
	
	/** testing the second method in Utils **/
	
	@Test
	public void elementsAreUnique_sameType() {
		Collection<String> collection = new ArrayList<>();
		collection.add("lalala"); 
		collection.add("lililili");
		collection.add("hohohoh");
		boolean result = Utils.elementsAreUnique(collection);
		assertTrue("is this true",result);
	}
	
	@Test
	public void elementsAreNotUnique_sameType() {
		Collection<String> collection = new ArrayList<>();
		collection.add("lalala"); 
		collection.add("lililili");
		collection.add("hohohoh");
		collection.add("lalala"); 
		boolean result = Utils.elementsAreUnique(collection);
		assertFalse("is this true",result);
	}
	
	@Test
	public void elementsAreUnique_intgerType() {
		Collection<Integer> collection = new ArrayList<>();
		collection.add(20); 
		collection.add(10);
		collection.add(15);
		collection.add(11); 
		boolean result = Utils.elementsAreUnique(collection);
		assertFalse("is this true",result);
	}
}