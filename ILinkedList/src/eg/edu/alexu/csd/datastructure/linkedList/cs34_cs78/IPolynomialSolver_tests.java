package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs78;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class IPolynomialSolver_tests 
{

	@Test
	void test1() 
	{
		//Test for array to list function
		PolynomialSolver pol = new PolynomialSolver();
		int arr [][] = new int[][] {
			{1,2},{1,1},{3,0},{5,-1}
		};
		DoubleLinkedList test = pol.array_to_list(arr);
		assertEquals(4, test.size());
		assertEquals(test.get(0),new java.awt.Point(1,2));
		assertEquals(test.get(1),new java.awt.Point(1,1));
		assertEquals(test.get(2),new java.awt.Point(3,0));
		assertEquals(test.get(3),new java.awt.Point(5,-1));
	}
	@Test
	void test2() 
	{
		//Test for list to array function
		DoubleLinkedList test = new DoubleLinkedList();
		PolynomialSolver pol = new PolynomialSolver();
		test.add(new java.awt.Point(1,3));
		test.add(new java.awt.Point(2,2));
		test.add(new java.awt.Point(3,1));
		test.add(new java.awt.Point(4,0));
		test.add(new java.awt.Point(5,-1));
		test.add(new java.awt.Point(6,-5));
		int [][] arr = pol.list_to_array(test);
		assertEquals(arr.length, test.size);
		int [][] expected = new int[][] {
			{1,3},{2,2},{3,1},{4,0},{5,-1},{6,-5}
		};
		assertArrayEquals(expected, arr);
	}
	@Test
	void test3() 
	{
		//Test for set_polynomial function and clear function
		int terms [][] = new int[][] {
			{3,6},{4,0},{5,-1},{6,-5}
		};
		char in = 'A';
		PolynomialSolver pol = new PolynomialSolver();
		pol.setPolynomial(in, terms);
		assertEquals(pol.A.size,terms.length);
		int [][] expected = pol.list_to_array(pol.A);
		assertArrayEquals(terms, expected);
		pol.clearPolynomial(in);
		assertEquals(0,pol.A.size);
		assertEquals("[]",pol.A.DDebug());
	}
	@Test
	void test4() 
	{
		//Test for print function and clear
		PolynomialSolver pol = new PolynomialSolver();
		DoubleLinkedList test = new DoubleLinkedList();
		test.add(new java.awt.Point(-1,3));
		test.add(new java.awt.Point(2,2));
		test.add(new java.awt.Point(1,1));
		test.add(new java.awt.Point(-4,0));
		test.add(new java.awt.Point(0,-1));
		test.add(new java.awt.Point(6,-5));
		pol.A = test;
		String expected = "-x^(3) + 2x^(2) + x - 4 + 6x^(-5)";
		assertEquals(expected, pol.print('a'));
		test.clear();
		test.add(new java.awt.Point(0,10));
		test.add(new java.awt.Point(-5,2));
		test.add(new java.awt.Point(5,1));
		test.add(new java.awt.Point(1,0));
		test.add(new java.awt.Point(-6,-5));
		test.add(new java.awt.Point(1,-7));
		expected = "-5x^(2) + 5x + 1 - 6x^(-5) + x^(-7)";
		pol.A = test;
		assertEquals(expected, pol.print('a'));
		pol.A.clear();
		assertEquals("", pol.print('a'));
		}
	@Test
	void test5()
	{
		//test for Polynomial Solver
		PolynomialSolver pol = new PolynomialSolver();
		DoubleLinkedList test = new DoubleLinkedList();
		test.add(new java.awt.Point(2,2));
		test.add(new java.awt.Point(1,1));
		test.add(new java.awt.Point(5,0));
		pol.A = test;
		assertEquals(26,pol.evaluatePolynomial('a', 3));
		test.clear();
		test.add(new java.awt.Point(5,3));
		test.add(new java.awt.Point(2,1));
		test.add(new java.awt.Point(-3,0));
		test.add(new java.awt.Point(9,-1));
		test.add(new java.awt.Point(-5,-2));
		pol.A = test;
		assertEquals(44.25,pol.evaluatePolynomial('a', 2));
		test.clear();
		test.add(new java.awt.Point(9,5));
		test.add(new java.awt.Point(-5,3));
		test.add(new java.awt.Point(2,1));
		test.add(new java.awt.Point(-1,-2));
		pol.A = test;
		assertEquals(27509.9609375,pol.evaluatePolynomial('a', 5));
		pol.clearPolynomial('A');
		assertEquals(0,pol.evaluatePolynomial('a', 999));
	}
	@Test
	void test6(){
		//operations test
		PolynomialSolver test = new PolynomialSolver();
		PolynomialSolver pol = new PolynomialSolver();
		int[][] a = {{1,2},{5,1},{15,0}};
		int[][] b = {{1,4},{3,1},{1,0}};
		int[][] c = {{15,1},{6,0}};
		pol.A = test.array_to_list(a);
		pol.B = test.array_to_list(b);
		pol.C = test.array_to_list(c);
		int[][] expected = {{1,4},{1,2},{8,1},{16,0}};
		assertEquals(Arrays.deepToString(test.add('a', 'b')),Arrays.deepToString(expected));
		expected = new int[][] {{1,2},{20,1},{21,0}};
		assertEquals(Arrays.deepToString(test.add('a', 'c')),Arrays.deepToString(expected));
		expected = new int[][] {{1,4},{18,1},{7,0}};
		assertEquals(Arrays.deepToString(test.add('b', 'c')),Arrays.deepToString(expected));
		expected = new int[][] {{1,6},{5,5},{15,4},{3,3},{16,2},{50,1},{15,0}};
		assertEquals(Arrays.deepToString(test.multiply('a', 'b')),Arrays.deepToString(expected));
		expected = new int[][] {{1,2},{-10,1},{9,0}};
		assertEquals(Arrays.deepToString(test.subtract('a', 'c')),Arrays.deepToString(expected));
	}
}
