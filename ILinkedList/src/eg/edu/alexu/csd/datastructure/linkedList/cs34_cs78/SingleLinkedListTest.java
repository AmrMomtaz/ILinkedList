package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs78;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SingleLinkedListTest {

	@Test
	void test() {
		SingleLinkedList test = new SingleLinkedList();
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(11);

		// [1,3,5,7,9,11]
		
		test.add(1, 2);
		test.add(3, 4);
		
		// [1,2,3,4,5,7,9,11]
		
		Object out = test.get(3);	 //4
		assertEquals(out,4);
		test.remove(4);
		
		//  [1,2,3,4,7,9,11]  //
		
		out = test.get(5);			 //9
		assertEquals(out,9);
		out = test.size();
		assertEquals(out,7);
		
		test.set(4,5);
		test.set(5,6);
		test.remove(6);
		test.add(7);
		
		//  [1,2,3,4,5,6,7]  //
		
		assertEquals(test.contains(1),true);
		assertEquals(test.contains(10),false);
		
		// numbers are now sorted from 1 to 7 we can assert them all with a for loop //
		for(int i=0; i<7;i++) {
			assertEquals(test.get(i),i+1);
		}
		assertEquals(test.size(),7);
		assertEquals(test.isEmpty(),false);
		
		
		test.clear();
		//  [] empty linked list  //
		assertEquals(test.size(),0);
		assertEquals(test.isEmpty(),true);
		assertEquals(test.contains(1),false);
		test.add(0,5);
		test.add(4);
		//  [5,4]  //
		assertEquals(test.size(),2);
		assertEquals(test.isEmpty(),false);
		assertEquals(test.contains(5),true);
		
	}
}
