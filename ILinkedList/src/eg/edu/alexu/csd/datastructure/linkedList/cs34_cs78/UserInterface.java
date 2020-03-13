package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs78;

import java.util.Scanner;

public class UserInterface 
{
	public static void main(String[] args) 
	{
		PolynomialSolver p = new PolynomialSolver();
		Scanner input = new Scanner (System.in);
		System.out.println("Please choose an action\r\n" + 
				"-----------------------\r\n" + 
				"1- Set a polynomial variable\r\n" + 
				"2- Print the value of a polynomial variable\r\n" + 
				"3- Add two polynomials\r\n" + 
				"4- Subtract two polynomials\r\n" + 
				"5- Multiply two polynomials6- Evaluate a polynomial at some point\r\n" + 
				"7- Clear a polynomial variable\r\n" + 
				"====================================================================");
		int in = input.nextInt();
		switch(in)
		{
		case 1:
			break;
		case 2:
			break;
		case 3 :
			break;
		case 4 :
			break;
		case 5 :
			break;
		case 6 :
			break;
		case 7 :
			break;
			default :
				System.out.println("WRONG INPUT");
				break;
		}
		input.close();
	}
}
