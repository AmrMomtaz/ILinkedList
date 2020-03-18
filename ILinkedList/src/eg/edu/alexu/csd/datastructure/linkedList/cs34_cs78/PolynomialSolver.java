package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs78;

import java.awt.Point;
import java.util.Arrays;

public class PolynomialSolver implements IPolynomialSolver
{
	public static DoubleLinkedList A = new DoubleLinkedList();
	public static DoubleLinkedList B = new DoubleLinkedList();
	public static DoubleLinkedList C = new DoubleLinkedList();
	public static DoubleLinkedList R = new DoubleLinkedList();
	
	public DoubleLinkedList array_to_list(int [][] terms )
	{
		DoubleLinkedList result = new DoubleLinkedList ();
		for (int i = 0;i < terms.length;i++)
		{
			java.awt.Point p = new java.awt.Point (terms[i][0],terms[i][1]);
			result.add(p);
		}
		return result;
	}
	
	public int[][] list_to_array(DoubleLinkedList X)
	{
		int [][] result = new int [X.size][2];
		for (int i = 0 ; i < X.size ;i++)
		{
			for (int j = 0 ; j < 2;j++)
			{
				java.awt.Point p = (Point) X.get(i);
				result[i][0] = p.x;
				result[i][1] = p.y;
			}
		}
		return result;
	}
	public int[][] sort(DoubleLinkedList l){
		int[][] sortedArray = list_to_array(l);
		boolean unsorted = true;
		int temp;
		while(unsorted) {
			unsorted = false;
			for(int i =0; i<sortedArray.length-1 ; i++) {
				if(sortedArray[i][1]<sortedArray[i+1][1]) {
					unsorted = true;
					temp = sortedArray[i][1];
					sortedArray[i][1]=sortedArray[i+1][1];
					sortedArray[i+1][1]=temp;
					temp = sortedArray[i][0];
					sortedArray[i][0]=sortedArray[i+1][0];
					sortedArray[i+1][0]=temp;
				}
			}
		}
		return sortedArray;
	}
	public void setPolynomial(char poly, int[][] terms)
	{
		if (poly == 'a'||poly =='A')
		{
			A = array_to_list(terms);
		}
		if (poly == 'b'||poly =='B')
		{
			B = array_to_list(terms);
		}
		if (poly == 'c'||poly =='C')
		{
			C = array_to_list(terms);
		}
	}
	
	public String print(char poly)
	{
		String Result = "";
		DoubleLinkedList x = null;
		if (poly == 'a'||poly =='A')
		{
			x = A;
		}
		if (poly == 'b'||poly =='B')
		{
			x = B;
		}
		if (poly == 'c'||poly =='C')
		{
			x = C;
		}
		if (poly == 'r'||poly =='R')
		{
			x = R;
		}
		for (int i = 0 ; i < x.size ;i++)
		{
			java.awt.Point p = (java.awt.Point) x.get(i);
			if (p.x == 0)continue;
			if (p.x >0&& Result!="") Result+=" + ";
			else if (p.x <0&& Result!="")Result+=" - ";
			if (p.x <-1 && Result=="")Result+=p.x;
			else if (p.x ==-1 && Result =="")Result+='-';
			else if (p.x ==1 && p.y ==0)Result+='1';
			else if (p.x > 1)Result +=p.x;
			else if (p.x < -1)Result+= (p.x*-1);
			if(p.y!=0 && p.y!=1)Result +="x^("+p.y+")";
			else if (p.y ==1)Result+='x';
		}
		Result =Result.strip();
		return Result;
	}
	
	public void clearPolynomial(char poly)
	{
		if (poly == 'a'||poly =='A')
		{
			A.clear();
		}
		if (poly == 'b'||poly =='B')
		{
			B.clear();
		}
		if (poly == 'c'||poly =='C')
		{
			C.clear();
		}
	}
	
	public float evaluatePolynomial(char poly, float value)
	{
		float Result =0;
		DoubleLinkedList x = null;
		if (poly == 'a'||poly =='A')
		{
			x = A;
		}
		if (poly == 'b'||poly =='B')
		{
			x = B;
		}
		if (poly == 'c'||poly =='C')
		{
			x = C;
		}
		if (poly == 'r'||poly =='R')
		{
			x = R;
		}
		for (int i = 0 ; i < x.size;i++)
		{
			java.awt.Point p = (java.awt.Point)x.get(i);
			int coff = p.x;
			int exp = p.y;
			Result += coff * Math.pow(value, exp);
		}
		return Result;
	}
	
	
	public int[][] add(char poly1, char poly2)
	{
		DoubleLinkedList S = new DoubleLinkedList();
		boolean taken=false;
		int[][] p1 = null;
		int[][] p2 = null;
		if(poly1 == 'a' || poly1 == 'A')
			p1 = list_to_array(A);
		else if(poly1 == 'b' || poly1 == 'B')
			p1 = list_to_array(B);
		else if(poly1 == 'c' || poly1 == 'C')
			p1 = list_to_array(C);
		if(poly2 == 'a' || poly2 == 'A')
			p2 = list_to_array(A);
		else if(poly2 == 'b' || poly2 == 'B')
			p2 = list_to_array(B);
		else if(poly2 == 'c' || poly2 == 'C')
			p2 = list_to_array(C);
		S = array_to_list(p2);
		for(int i=0 ; i<p1.length ; i++) {
			taken = false;
			for(int j=0 ; j<p2.length ; j++) {
				if(p1[i][1]==p2[j][1]) {
					taken = true;
					S.set(j, new Point(p1[i][0] + p2[j][0] , p1[i][1]));
				}
			}
			if(taken==false) {
				S.add(new Point(p1[i][0],p1[i][1]));
			}
		}
		return sort(S);
	}
	
	

	public int[][] subtract(char poly1, char poly2)
	{
		DoubleLinkedList S = new DoubleLinkedList();
		boolean taken=false;
		int[][] p1 = null;
		int[][] p2 = null;
		if(poly1 == 'a' || poly1 == 'A')
			p1 = list_to_array(A);
		else if(poly1 == 'b' || poly1 == 'B')
			p1 = list_to_array(B);
		else if(poly1 == 'c' || poly1 == 'C')
			p1 = list_to_array(C);
		if(poly2 == 'a' || poly2 == 'A')
			p2 = list_to_array(A);
		else if(poly2 == 'b' || poly2 == 'B')
			p2 = list_to_array(B);
		else if(poly2 == 'c' || poly2 == 'C')
			p2 = list_to_array(C);
		for(int k=0;k<p2.length;k++) {
			p2[k][0]*=-1;
		}
		S = array_to_list(p2);
		for(int i=0 ; i<p1.length ; i++) {
			taken = false;
			for(int j=0 ; j<p2.length ; j++) {
				if(p1[i][1]==p2[j][1]) {
					taken = true;
					S.set(j, new Point(p1[i][0] + p2[j][0] , p1[i][1]));
				}
			}
			if(taken==false) {
				S.add(new Point(p1[i][0],p1[i][1]));
			}
		}
		return sort(S);
	}
	public int[][] multiply(char poly1, char poly2)
	{
		DoubleLinkedList M = new DoubleLinkedList();
		int[][] p1 = null;
		int[][] p2 = null;
		if(poly1 == 'a' || poly1 == 'A')
			p1 = list_to_array(A);
		else if(poly1 == 'b' || poly1 == 'B')
			p1 = list_to_array(B);
		else if(poly1 == 'c' || poly1 == 'C')
			p1 = list_to_array(C);
		if(poly2 == 'a' || poly2 == 'A')
			p2 = list_to_array(A);
		else if(poly2 == 'b' || poly2 == 'B')
			p2 = list_to_array(B);
		else if(poly2 == 'c' || poly2 == 'C')
			p2 = list_to_array(C);
		for(int i=0; i<p1.length ; i++) {
			for(int j=0 ; j<p2.length ; j++) {
				M.add(new Point((p1[i][0]*p2[j][0]),(p1[i][1]+p2[j][1])));
			}
		}
		for(int i=0;i<M.size;i++) {
			for(int j=i+1 ; j<M.size ; j++) {
				Point m1 = (java.awt.Point) M.get(i);
				Point m2 = (java.awt.Point) M.get(j);
				if(m1.y == m2.y) {
					M.set(i,new Point(m1.x + m2.x , m2.y));
					M.remove(j);
				}}}
		return sort(M);
	}
}
