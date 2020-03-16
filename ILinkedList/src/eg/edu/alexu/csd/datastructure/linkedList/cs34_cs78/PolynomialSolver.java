package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs78;

import java.awt.Point;

public class PolynomialSolver implements IPolynomialSolver
{
	DoubleLinkedList A,B,C,R = new DoubleLinkedList();
	
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
	
	
	/**
	* Add two polynomials
	* @param poly1
	* first polynomial
	* @param poly2
	* second polynomial
	* @return the result polynomial
	*/
	public int[][] add(char poly1, char poly2)
	{
		return null;
	}
	
	
	/**
	* Subtract two polynomials
	* @param poly1
	* first polynomial
	* @param poly2
	* second polynomial
	* @return the result polynomial
	*/
	public int[][] subtract(char poly1, char poly2)
	{
		return null;
	}
	
	
	/**
	* Multiply two polynomials
	* @param poly1
	* first polynomial
	* @param poly2
	* second polynomial
	* @return the result polynomial
	*/
	public int[][] multiply(char poly1, char poly2)
	{
		return null;
	}
}
