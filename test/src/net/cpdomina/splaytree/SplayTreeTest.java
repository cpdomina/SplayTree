package net.cpdomina.splaytree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

public class SplayTreeTest {
	
	private static final int NUMS = 400000;
	private static final int GAP  =   307;

	@Test
	public void testEmpty() {
		SplayTree<Integer> t = SplayTree.create();
		
		assertNull(t.findMax());
		assertNull(t.findMin());
		assertNull(t.find(0));
		assertFalse(t.contains(0));
		assertIterator(t.iterator());
	}
	
	@Test
	public void testSingle() {
		SplayTree<Integer> t = SplayTree.create(0);
		
		assertEquals(0, t.findMin().intValue());
		assertEquals(0, t.findMax().intValue());
		assertEquals(0, t.find(0).intValue());
		assertTrue(t.contains(0));
		assertIterator(t.iterator(), 0);
	}
	
	@Test
	public void testMulti() {
		SplayTree<Integer> t = SplayTree.create(0, -1, 1);
		
		assertEquals(-1, t.findMin().intValue());
		assertEquals(1, t.findMax().intValue());
		
		assertEquals(0, t.find(0).intValue());
		assertEquals(1, t.find(1).intValue());
		assertEquals(-1, t.find(-1).intValue());
		assertNull(t.find(2));
		
		assertTrue(t.contains(0));
		assertTrue(t.contains(1));
		assertTrue(t.contains(-1));
		assertFalse(t.contains(2));
		
		assertIterator(t.iterator(), -1, 0, 1);
	}
	
	@Test
	public void testInsertRemove() {
		SplayTree<Integer> t = SplayTree.create(0, -1, 1);
		
		assertIterator(t.iterator(), -1, 0, 1);
		
		assertTrue(t.insert(2));
		assertFalse(t.insert(0));
		assertIterator(t.iterator(), -1, 0, 1, 2);
		
		assertTrue(t.remove(0));
		assertFalse(t.remove(0));	
		assertIterator(t.iterator(), -1, 1, 2);
	}
	
	@Test
	public void testWeiss() {
		SplayTree<Integer> t = SplayTree.create();

		for(int i = GAP; i != 0; i = (i + GAP) % NUMS) {
			assertTrue(t.insert(i));
		}

		for(int i = 1; i < NUMS; i+= 2) {
			t.remove(i);
		}
		
		assertEquals(2, t.findMin(), 0);
		assertEquals(NUMS - 2, t.findMax(), 0);
		
		for(int i = 2; i < NUMS; i+=2) {
			assertEquals(i, t.find(i), 0);
		}

		for(int i = 1; i < NUMS; i+=2) {
			assertNull(t.find(i));
		}
	}
	
	private <T> void assertIterator(Iterator<T> iterator, T... elements) {
		for(T element: elements) {
			assertTrue(iterator.hasNext());
			assertEquals(element, iterator.next());
		}
		assertFalse(iterator.hasNext());
	}
	
}
