package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tester for HashTable 
 * 
 * 
 * @author Junlin Su && 
 *
 */

class HashTableTester {
	HashTable<Integer,Integer > test;

	@BeforeEach
	void setUp() throws Exception {
		test = new HashTable<Integer, Integer>();
		test.put(0, 8);

	}

	@Test
	void testPut() {
		assertEquals(test.put(0, 1), 8);
	}
	
	@Test
	void testPut2() {
		test.put(0, 1234);
		assertEquals(test.put(1,1), 1);
	}

	@Test
	void testGet() {
		assertEquals(test.get(0), 8);
	}

	@Test
	void testIsEmpty() {
		assertFalse(test.isEmpty());
	}
	
	@Test
	void testIsNotEmpty() {
		test.remove(0);
		assertTrue(test.isEmpty());
	}
	
	@Test
	void testRemove() {
		assertEquals(test.remove(0), 8);
	}

	@Test
	void testRemove2() {
		assertEquals(test.remove(0), 8);
	}
	
	@Test
	void testClear() {
		test.remove(0);
		assertTrue(test.isEmpty());
		test.clear();
		assertTrue(test.isEmpty());
	}	
	
}