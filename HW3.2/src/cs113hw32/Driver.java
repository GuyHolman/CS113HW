package cs113hw32;

import java.util.Scanner;

public class Driver {
	private static String  polynameA="Polynomial A";
	private static String  polynameB="Polynomial B";
	private static Polynomial polyA,polyB;
	private static Scanner in;
	public static void main(String[] args) {
		 polyA=new Polynomial();
		 polyB=new Polynomial();
		 in = new Scanner(System.in);
		 menu();

	}
	public static void menu() {
		int userInput;
		System.out.println("-=-=- Main Menu -=-=-= ( with LinkedLists)");
		System.out.println();
		printPoly(polynameA,polyA);
		printPoly(polynameB,polyB);
		System.out.println();
		System.out.println("1) Edit polynomial A");
		System.out.println("2) Edit polynomial B");
		System.out.println("3) Sum of both polynomials");
		System.out.println("4) Exit");
		System.out.println();
		System.out.println("Select an option (1-4)");
		userInput=in.nextInt();
		switch(userInput) {
		case 1:
			menu2(polynameA,polyA);
			break;
		case 2:
			menu2(polynameB,polyB);
			break;
		case 3:
			addPoly();
			break;
		case 4:
			System.exit(0);
			break;
		}
	}
	
	public static void menu2(String polyname, Polynomial poly) {
		int userInput;
		System.out.println("-=-=- Edit Polynomial -=-=-=");
		System.out.println();
		printPoly(polyname,poly);
		System.out.println();
		System.out.println("1) Add Term");
		System.out.println("2) Remove Term");
		System.out.println("3) Clear Polynomial");
		System.out.println("4) Menu");
		System.out.println();
		System.out.println("Select an option (1-4)");
		userInput=in.nextInt();
		switch(userInput) {
		case 1:
			addTerm(polyname,poly);
			break;
		case 2:
			removeTerm(polyname,poly);
			break;
		case 3:
			clearPolynomial(polyname,poly);
			break;
		case 4:
			menu();
			break;
		}
	}
	
	public static void printPoly( String polyName, Polynomial poly) {
		String polyStr;
		if(poly.Terms.isEmpty())
			System.out.println(polyName + " : -=- Empty -=-");
		else {
			
				System.out.println(polyName +" : "+ poly.printTerms() );
		 }
		}
	
	public static void addTerm(String polyName, Polynomial poly) {
		int coeff;
		int exp;
		System.out.println("-=-=- Add Term -=-=-=");
		System.out.println();
		printPoly(polyName,poly);
		System.out.println();
		System.out.println("(put 0 if you want to leave)Enter a coefficient: ");
		coeff=in.nextInt();
		if(coeff==0) {
			menu2(polyName,poly);
				}
		System.out.println("Enter an exponent: ");
		exp=in.nextInt();
		poly.addTerm(new Term(coeff,exp));
		poly.organizePolynomial();
		addTerm(polyName,poly);
	}
	public static void removeTerm(String polyName,Polynomial poly) {
		int coeff;
		int exp;
		System.out.println("-=-=- Remove Term -=-=-=");
		System.out.println();
		printPoly(polyName,poly);
		System.out.println();
		System.out.println("(put 0 if you want to leave)Enter the coefficient of the term you want to remove: ");
		coeff=in.nextInt();
		if(coeff==0) {
			menu2(polyName,poly);
				}
		System.out.println("Enter an exponent: ");
		exp=in.nextInt();
		poly.removeTerm(new Term(coeff,exp));
		removeTerm(polyName,poly);
	}
	public static void clearPolynomial(String polyName, Polynomial poly) {
		poly.clear();
		menu2(polyName,poly);
	}
	public static void addPoly()
	{
		Polynomial polyTemp=new Polynomial();
		Polynomial polyAFake=polyA;
		Polynomial polyBFake=polyB;
		for(int i=0;i<polyA.Terms.size();i++) {
			for(int j=0;j<polyB.Terms.size();j++) {
				if(polyA.Terms.get(i).getExponent()==polyB.Terms.get(j).getExponent()) {			
					polyTemp.addTerm(new Term((polyA.Terms.get(i).getCoefficient()+polyB.Terms.get(j).getCoefficient()),polyA.Terms.get(i).getExponent()));
					polyAFake.removeTerm(polyA.Terms.get(i));
					polyBFake.removeTerm(polyB.Terms.get(j));

				}
				
			}
		}
		for(int i=0;i<polyAFake.Terms.size();i++) {
			polyTemp.addTerm(polyAFake.Terms.get(i));
		}
		for(int i=0;i<polyBFake.Terms.size();i++) {
			polyTemp.addTerm(polyBFake.Terms.get(i));
		}
		polyTemp.organizePolynomial();
		System.out.println("-=-=- Added Polynomials -=-=-=");
		System.out.println();
		printPoly("Added Polynomial : ",polyTemp);
		System.out.println();
		menu();
	}
}

