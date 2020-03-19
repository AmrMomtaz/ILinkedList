package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs78;

import java.util.Scanner;

public class UserInterface 
{
	public static void main(String[] args) throws Exception 
	{
		PolynomialSolver p = new PolynomialSolver();
		Scanner input = new Scanner(System.in);
		while(true) {
			boolean wrongInput=true;
		System.out.println("Please choose an action\r\n" + 
				"-----------------------\r\n" + 
				"1- Set a polynomial variable\r\n" + 
				"2- Print the value of a polynomial variable\r\n" + 
				"3- Add two polynomials\r\n" + 
				"4- Subtract two polynomials\r\n" + 
				"5- Multiply two polynomials\r\n"+
				"6- Evaluate a polynomial at some point\r\n" + 
				"7- Clear a polynomial variable\r\n" + 
				"====================================================================");
		char in = input.next().charAt(0);
		switch(in)
		{
		case '1':
			int[][] numbers = null;
			System.out.println("Insert the variable name: A, B or C");
			char x = 0 ;
			while(wrongInput) {
				wrongInput = false;
					x=input.next().charAt(0);
					if(x!='a' && x!='A' && x!='b' && x!='B' && x!='c' && x!='C') {
						wrongInput=true;
						System.out.println("Wrong Input");
					}
			}
			System.out.println("Insert the polynomial terms in the form:\r\n" + 
					"(coeff1, exponent1), (coeff2, exponent2), ..");
			wrongInput = true;
			input.nextLine();
			while(wrongInput) {
				boolean validInput=true;
				wrongInput = false;
				String polynomial = input.nextLine();
				if(polynomial.charAt(0)!='(') {
					validInput = false;
				}
				polynomial = polynomial.replace("(","");
				polynomial = polynomial.replace(")","");
				String[] numbersString = polynomial.split(",");
				if((numbersString.length) <=0 || ((numbersString.length)%2) !=0 || !validInput) {
				wrongInput = true;
				System.out.println("Wrong Input");
				System.out.println("Insert the polynomial terms in the form:\r\n" + 
						"(coeff1, exponent1), (coeff2, exponent2), ..");
				}
				else {
				numbers = new int[(numbersString.length)/2][2];
				for(int i =0,j=0; i<numbersString.length;i+=2,j++) {
					numbers[j][0] = Integer.parseInt(numbersString[i]);
					numbers[j][1] = Integer.parseInt(numbersString[i+1]);
				}
				}
			}
			p.setPolynomial(x, numbers);
			break;
		case '2':
			System.out.println("Insert the variable name: A, B or C");
			x = 0 ;
			wrongInput = true;
			while(wrongInput) {
				wrongInput = false;
					x=input.next().charAt(0);
					if(x!='a' && x!='A' && x!='b' && x!='B' && x!='c' && x!='C') {
						wrongInput=true;
						System.out.println("Wrong Input");
					}
					else if(((x=='a' || x=='A') && PolynomialSolver.A.isEmpty()) || ((x=='b' || x=='B') && PolynomialSolver.B.isEmpty()) || ((x=='c' || x=='C') && PolynomialSolver.C.isEmpty())) {
						wrongInput=true;
						System.out.println("Variable not set");
						System.out.println("Insert the variable name: A, B or C");
					}
					}
			System.out.println(p.print(x));
			break;
		case '3' :
			System.out.println("Insert the first operand variable name: A, B or C");
			char p1 = 0 ;
			char p2 = 0 ;
			wrongInput = true;
			while(wrongInput) {
				wrongInput = false;
					p1=input.next().charAt(0);
					if(p1!='a' && p1!='A' && p1!='b' && p1!='B' && p1!='c' && p1!='C') {
						wrongInput=true;
						System.out.println("Wrong Input");
					}
					else if(((p1=='a' || p1=='A') && PolynomialSolver.A.isEmpty()) || ((p1=='b' || p1=='B') && PolynomialSolver.B.isEmpty()) || ((p1=='c' || p1=='C') && PolynomialSolver.C.isEmpty())) {
						wrongInput=true;
						System.out.println("Variable not set");
						System.out.println("Insert the first operand variable name: A, B or C");
					}
					}
			wrongInput = true;
			System.out.println("Insert the second operand variable name: A, B or C");
			while(wrongInput) {
				wrongInput = false;
					p2=input.next().charAt(0);
					if(p2!='a' && p2!='A' && p2!='b' && p2!='B' && p2!='c' && p2!='C') {
						wrongInput=true;
						System.out.println("Wrong Input");
					}
					else if(((p2=='a' || p2=='A') && PolynomialSolver.A.isEmpty()) || ((p2=='b' || p2=='B') && PolynomialSolver.B.isEmpty()) || ((p2=='c' || p2=='C') && PolynomialSolver.C.isEmpty())) {
						wrongInput=true;
						System.out.println("Variable not set");
						System.out.println("Insert the second operand variable name: A, B or C");
					}
					}
			PolynomialSolver.R = p.array_to_list(p.add(p1, p2));
			System.out.println(p.print('r'));
			break;
		case '4' :
			System.out.println("Insert the first operand variable name: A, B or C");
			p1 = 0 ;
			p2 = 0 ;
			wrongInput = true;
			while(wrongInput) {
				wrongInput = false;
					p1=input.next().charAt(0);
					if(p1!='a' && p1!='A' && p1!='b' && p1!='B' && p1!='c' && p1!='C') {
						wrongInput=true;
						System.out.println("Wrong Input");
					}
					else if(((p1=='a' || p1=='A') && PolynomialSolver.A.isEmpty()) || ((p1=='b' || p1=='B') && PolynomialSolver.B.isEmpty()) || ((p1=='c' || p1=='C') && PolynomialSolver.C.isEmpty())) {
						wrongInput=true;
						System.out.println("Variable not set");
						System.out.println("Insert the first operand variable name: A, B or C");
					}
					}
			System.out.println("Insert the second operand variable name: A, B or C");
			wrongInput = true;
			while(wrongInput) {
				wrongInput = false;
					p2=input.next().charAt(0);
					if(p2!='a' && p2!='A' && p2!='b' && p2!='B' && p2!='c' && p2!='C') {
						wrongInput=true;
						System.out.println("Wrong Input");
					}
					else if(((p2=='a' || p2=='A') &&  PolynomialSolver.A.isEmpty()) || ((p2=='b' || p2=='B') && PolynomialSolver.B.isEmpty()) || ((p2=='c' || p2=='C') && PolynomialSolver.C.isEmpty())) {
						wrongInput=true;
						System.out.println("Variable not set");
						System.out.println("Insert the second operand variable name: A, B or C");
					}
					}
			PolynomialSolver.R = p.array_to_list(p.subtract(p1, p2));
			System.out.println(p.print('r'));
			break;
		case '5' :
			System.out.println("Insert the first operand variable name: A, B or C");
			p1 = 0 ;
			p2 = 0 ;
			wrongInput = true;
			while(wrongInput) {
				wrongInput = false;
					p1=input.next().charAt(0);
					if(p1!='a' && p1!='A' && p1!='b' && p1!='B' && p1!='c' && p1!='C') {
						wrongInput=true;
						System.out.println("Wrong Input");
					}
					else if(((p1=='a' || p1=='A') && PolynomialSolver.A.isEmpty()) || ((p1=='b' || p1=='B') && PolynomialSolver.B.isEmpty()) || ((p1=='c' || p1=='C') && PolynomialSolver.C.isEmpty())) {
						wrongInput=true;
						System.out.println("Variable not set");
						System.out.println("Insert the first operand variable name: A, B or C");
					}
					}
			System.out.println("Insert the second operand variable name: A, B or C");
			wrongInput = true;
			while(wrongInput) {
				wrongInput = false;
					p2=input.next().charAt(0);
					if(p2!='a' && p2!='A' && p2!='b' && p2!='B' && p2!='c' && p2!='C') {
						wrongInput=true;
						System.out.println("Wrong Input");
					}
					else if(((p2=='a' || p2=='A') && PolynomialSolver.A.isEmpty()) || ((p2=='b' || p2=='B') && PolynomialSolver.B.isEmpty()) || ((p2=='c' || p2=='C') && PolynomialSolver.C.isEmpty())) {
						wrongInput=true;
						System.out.println("Variable not set");
						System.out.println("Insert the second operand variable name: A, B or C");
					}
					}
			PolynomialSolver.R = p.array_to_list(p.multiply(p1, p2));
			System.out.println(p.print('r'));
			break;
		case '6' :
			System.out.println("Insert the variable name: A, B or C");
			x = 0 ;
			wrongInput = true;
			while(wrongInput) {
				wrongInput = false;
					x=input.next().charAt(0);
					if(x!='a' && x!='A' && x!='b' && x!='B' && x!='c' && x!='C') {
						wrongInput=true;
						System.out.println("Wrong Input");
					}
					else if(((x=='a' || x=='A') && PolynomialSolver.A.isEmpty()) || ((x=='b' || x=='B') && PolynomialSolver.B.isEmpty()) || ((x=='c' || x=='C') && PolynomialSolver.C.isEmpty())) {
						wrongInput=true;
						System.out.println("Variable not set");
						System.out.println("Insert the variable name: A, B or C");
					}
					}
			System.out.println("Enter the value to evaluate");
			float value = input.nextFloat();
			System.out.println(p.evaluatePolynomial(x,value));
			break;
		case '7' :
			System.out.println("Insert the variable name: A, B or C");
			x = 0 ;
			wrongInput = true;
			while(wrongInput) {
				wrongInput = false;
					x=input.next().charAt(0);
					if(x!='a' && x!='A' && x!='b' && x!='B' && x!='c' && x!='C') {
						wrongInput=true;
						System.out.println("Wrong Input");
					}
					else if(((x=='a' || x=='A') && PolynomialSolver.A.isEmpty()) || ((x=='b' || x=='B') && PolynomialSolver.B.isEmpty()) || ((x=='c' || x=='C') && PolynomialSolver.C.isEmpty())) {
						wrongInput=true;
						System.out.println("Variable not set");
						System.out.println("Insert the variable name: A, B or C");
					}
					}
			p.clearPolynomial(x);
			break;
			default :
				System.out.println("WRONG INPUT");
				break;
		}
	}
	}
}
