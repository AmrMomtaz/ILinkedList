package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs78;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DoubleLinkedListTests 
{

	@Test
	void test1() 
	{
		DoubleLinkedList test = new DoubleLinkedList();
		assertEquals(test.contains(5), false);
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		String actual = test.DDebug();
		String expected = "[0,1,2,3]";
		assertEquals(expected, actual);
		assertEquals(true,test.contains(3));
		assertEquals(false,test.contains(5));
		test.clear();
		assertEquals(true, test.isEmpty());
	}
	@Test
	void test2()
	{
		DoubleLinkedList test = new DoubleLinkedList();
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);
		test.remove(2);
		test.add(2,99);
		test.add(0,98);
		test.add(0,4);
		String actual = test.DDebug();
		String expected = "[4,98,0,1,99,3]";
		assertEquals(expected, actual);
		assertEquals(true,test.contains(3));
		assertEquals(false,test.contains(5));
	}
	@Test
	void test3()
	{
		DoubleLinkedList test = new DoubleLinkedList();
		assertEquals(true,test.isEmpty());
		test.add(0,3);
		test.add(0,2);
		test.add(0,1);
		test.add(0,0);
		test.add(4,4);
		String actual = test.DDebug();
		String expected = "[0,1,2,3,4]";
		assertEquals(expected, actual);
		Exception IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	test.get(50);
	    });
	    String expectedMessage = "The index is out of bounds";
	    String actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	void test4()
	{
		DoubleLinkedList test = new DoubleLinkedList();
		test.add(0);
		test.add(1);
		test.add(2);
		test.add(3);		
		test.add(4);
		test.add(5);		
		test.add(6);
		test.add(7);
		DoubleLinkedList sub = test.sublist(1, 3);
		String actual = sub.DDebug();
		String expected = "[1,2,3]";
		assertEquals(expected, actual);
	}
}
