package CS113HW2;

import java.util.ArrayList;
import java.util.Scanner;


public class Source {

	public static void main(String[] args) {
	ArrayList<Polynomial> polyList= new ArrayList<Polynomial>();
	Scanner in = new Scanner(System.in);
	int count=0;
	while(count!=3) {
		System.out.println("Enter a Polynomial: ");
		String userInput=in.nextLine();
		Polynomial p = new Polynomial();
		p.seperate(userInput);
		polyList.add(p);
		count++;
	}
	
	     for(int i=0;i<polyList.size();i++) {
				polyList.get(i).printTerms();
				System.out.println();
			}

	}

}
