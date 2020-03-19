package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs78;

import java.awt.Point;

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
		else if (poly == 'b'||poly =='B')
		{
			B = array_to_list(terms);
		}
		else if (poly == 'c'||poly =='C')
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
		else if (poly == 'b'||poly =='B')
		{
			x = B;
		}
		else if (poly == 'c'||poly =='C')
		{
			x = C;
		}
		else if (poly == 'r'||poly =='R')
		{
			x = R;
		}
		for (int i = 0 ; i < x.size ;i++)
		{
			java.awt.Point p = (java.awt.Point) x.get(i);
			if (p.x == 0)continue;
			if (p.x >0&& Result!="") Result+=" + ";
			else if (p.x <0 && p.y!=0 && Result!="")Result+=" - ";
			if (p.x <-1 && Result=="")Result+=p.x;
			else if (p.x ==-1 && p.y!=0 && Result =="")Result+='-';
			else if (p.x ==1 && p.y ==0)Result+='1';
			else if (p.x ==-1 && p.y ==0)Result+="-1";
			else if (p.x > 1)Result +=p.x;
			else if (p.x < -1)Result+= (p.x*-1);
			if(p.y!=0 && p.y!=1)Result +="x^("+p.y+")";
			else if (p.y ==1)Result+='x';
		}
		if(Result== "") Result = "0";
		Result =Result.strip();
		return Result;
	}
	
	public void clearPolynomial(char poly)
	{
		if (poly == 'a'||poly =='A')
		{
			A.clear();
		}
		else if (poly == 'b'||poly =='B')
		{
			B.clear();
		}
		else if (poly == 'c'||poly =='C')
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
		else if (poly == 'b'||poly =='B')
		{
			x = B;
		}
		else if (poly == 'c'||poly =='C')
		{
			x = C;
		}
		else if (poly == 'r'||poly =='R')
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
		DoubleLinkedList X =null,Y =null;
		if (poly1 =='a'||poly1== 'A')	X=A;
		else if (poly1 =='b'||poly1== 'B') X =B;
		else if(poly1 =='c'||poly1== 'C') X = C;
		if (poly2 =='a'||poly2== 'A')	Y = A;
		else if (poly2 =='b'||poly2== 'B') Y = B;
		else if(poly2 =='c'||poly2== 'C') Y = C;
		R = new DoubleLinkedList();
		for (int i = 0;i < X.size ;i++)
		{
			R.add(X.get(i));
		}
		for (int i = 0 ; i < Y.size ;i++)
		{
			boolean check = false;
			java.awt.Point pointY = (Point) Y.get(i);
			int expY = pointY.y;
			int coffY = pointY.x;
			for (int j = 0 ; j < R.size ;j++)
			{
				java.awt.Point pointR = (Point) R.get(j);
				int expR = pointR.y;
				int coffR = pointR.x;
				if (expY == expR)
				{
					check = true;
					R.set(j, new java.awt.Point(coffY+coffR,expR));
					break;
				}
			}
			if (!check)
			{
				R.add(new java.awt.Point(coffY,expY));
			}
		}
		return sort(R);
	}
	
	public int[][] subtract(char poly1, char poly2)
	{
		DoubleLinkedList X =null,Y =null;
		if (poly1 =='a'||poly1== 'A')	X=A;
		else if (poly1 =='b'||poly1== 'B') X =B;
		else if(poly1 =='c'||poly1== 'C') X = C;
		if (poly2 =='a'||poly2== 'A')	Y = A;
		else if (poly2 =='b'||poly2== 'B') Y = B;
		else if(poly2 =='c'||poly2== 'C') Y = C;
		if (X ==null || Y ==null)throw new IllegalArgumentException("The polynomial is not set");
		R = new DoubleLinkedList();
		for (int i = 0;i < X.size ;i++)
		{
			R.add(X.get(i));
		}
		for (int i = 0 ; i < Y.size ;i++)
		{
			boolean check = false;
			java.awt.Point pointY = (Point) Y.get(i);
			int expY = pointY.y;
			int coffY = pointY.x;
			for (int j = 0 ; j < R.size ;j++)
			{
				java.awt.Point pointR = (Point) R.get(j);
				int expR = pointR.y;
				int coffR = pointR.x;
				if (expY == expR)
				{
					check = true;
					R.set(j, new java.awt.Point(coffR-coffY,expR));
					break;
				}
			}
			if (!check)
			{
				R.add(new java.awt.Point(coffY*-1,expY));
			}
		}
		return sort(R);
	}
	public int[][] multiply(char poly1, char poly2)
	{
		DoubleLinkedList X =null,Y =null;
		if (poly1 =='a'||poly1== 'A')	X=A;
		else if (poly1 =='b'||poly1== 'B') X =B;
		else if(poly1 =='c'||poly1== 'C') X = C;
		if (poly2 =='a'||poly2== 'A')	Y = A;
		else if (poly2 =='b'||poly2== 'B') Y = B;
		else if(poly2 =='c'||poly2== 'C') Y = C;
		if (X ==null || Y ==null)throw new IllegalArgumentException("The polynomial is not set");
		R = new DoubleLinkedList();
		for (int i = 0;i < X.size;i++)
		{
			java.awt.Point pointX = (Point) X.get(i);
			int coffX = pointX.x;
			int expX = pointX.y;
			for (int j = 0 ; j < Y.size ;j++)
			{
				java.awt.Point pointY = (Point) Y.get(j);
				int coffY = pointY.x;
				int expY = pointY.y;
				java.awt.Point result =new java.awt.Point(coffX*coffY,expX+expY);
				if (R.size == 0)R.add(result);
				else
				{
					for (int k = 0 ; k < R.size;k++)
					{
						java.awt.Point pointR = (Point) R.get(k);
						if (pointR.y == result.y)
						{
							R.set(k, new java.awt.Point(pointR.x+result.x,pointR.y));
							break;
						}
						if (k ==R.size-1)
						{
							R.add(result);
							break;
						}
					}
				}
			}
		}
		return sort(R);
	}
}
