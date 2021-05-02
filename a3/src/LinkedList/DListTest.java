package LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DListTest {

	@Test
	void testConstructor() {
		DList<Integer> a= new DList<>();
		assertEquals("[]", a.toString());
		assertEquals("[]", a.toStringR());
		assertEquals(0, a.size());
	}

	@Test
	void testPrepend() {
		DList<Integer> a= new DList<>();

		a.prepend(2);
		assertEquals("[2]", a.toString());
		assertEquals("[2]", a.toStringR());
		assertEquals(1, a.size());

		a.prepend(4);
		assertEquals("[4, 2]", a.toString());
		assertEquals("[2, 4]", a.toStringR());
		assertEquals(2, a.size());

		a.prepend(4);
		assertEquals("[4, 4, 2]", a.toString());
		assertEquals("[2, 4, 4]", a.toStringR());
		assertEquals(3, a.size());

		a.prepend(2);
		assertEquals("[2, 4, 4, 2]", a.toString());
		assertEquals("[2, 4, 4, 2]", a.toStringR());
		assertEquals(4, a.size());

		a.prepend(null);
		assertEquals("[null, 2, 4, 4, 2]", a.toString());
		assertEquals("[2, 4, 4, 2, null]", a.toStringR());
		assertEquals(5, a.size());
	}

	@Test
	void testAppend() {
		DList<Integer> a= new DList<>();

		a.append(2);
		assertEquals("[2]", a.toString());
		assertEquals("[2]", a.toStringR());
		assertEquals(1, a.size());

		a.append(4);
		assertEquals("[2, 4]", a.toString());
		assertEquals("[4, 2]", a.toStringR());
		assertEquals(2, a.size());

		a.append(4);
		assertEquals("[2, 4, 4]", a.toString());
		assertEquals("[4, 4, 2]", a.toStringR());
		assertEquals(3, a.size());

		a.append(2);
		assertEquals("[2, 4, 4, 2]", a.toString());
		assertEquals("[2, 4, 4, 2]", a.toStringR());
		assertEquals(4, a.size());

		a.append(null);
		assertEquals("[2, 4, 4, 2, null]", a.toString());
		assertEquals("[null, 2, 4, 4, 2]", a.toStringR());
		assertEquals(5, a.size());
	}

	@Test
	void testGetNode() {
		DList<Integer> a= new DList<>();
		a.append(4);
		assertEquals(a.lastNode(), a.getNode(0));
		a.prepend(9);
		assertEquals(a.firstNode(), a.getNode(0));
		a.append(2);
		assertEquals(a.lastNode(), a.getNode(2));
		a.prepend(5);
		assertEquals(a.firstNode(), a.getNode(0));
		a.append(7);
		assertEquals(a.lastNode(), a.getNode(4));
		a.prepend(6);
		assertEquals(a.firstNode(), a.getNode(0));
	}

	@Test
	void testDelete() {
		DList<Integer> a= new DList<>();

		a.append(4);
		a.delete(a.lastNode());
		assertEquals("[]", a.toString());
		assertEquals("[]", a.toStringR());
		assertEquals(0, a.size());

		a.append(4);
		a.prepend(9);
		a.delete(a.firstNode());
		assertEquals("[4]", a.toString());
		assertEquals("[4]", a.toStringR());
		assertEquals(1, a.size());

		a.prepend(9);
		a.delete(a.lastNode());
		assertEquals("[9]", a.toString());
		assertEquals("[9]", a.toStringR());
		assertEquals(1, a.size());

		a.append(4);
		a.append(2);
		a.delete(a.getNode(1));
		assertEquals("[9, 2]", a.toString());
		assertEquals("[2, 9]", a.toStringR());
		assertEquals(2, a.size());
	}

	@Test
	void testInsertBefore() {
		DList<Integer> a= new DList<>();

		a.append(4);
		a.insertBefore(2, a.lastNode());
		assertEquals("[2, 4]", a.toString());
		assertEquals("[4, 2]", a.toStringR());
		assertEquals(2, a.size());

		a.insertBefore(2, a.firstNode());
		assertEquals("[2, 2, 4]", a.toString());
		assertEquals("[4, 2, 2]", a.toStringR());
		assertEquals(3, a.size());
	}

}
