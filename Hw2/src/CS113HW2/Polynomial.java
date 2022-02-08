package CS113HW2;

import java.util.ArrayList;


public class Polynomial {
	String tempPart;
	String other;
	ArrayList<Term> Terms= new ArrayList<Term>();

	public Polynomial() {
	}
	public void seperate(String t) {
		while(!t.isBlank()) {
		    for(int i=1;i<t.length();i++) {
		    	if(t.charAt(i)=='+' ||t.charAt(i)=='-'&& t.charAt(i-1)!='^'||i+1==t.length()) {
		    	 if(i+1==t.length()) {
		    		 String n = t.substring(0,i+1);
		    		 becomeInt(n);
		    		 t=" ";
		    	 }
		    	 else {
		    	 String n = t.substring(0,i);
		    	 becomeInt(n);
		    	 t=t.substring(i);
		    	 i=1;
		    	 		}
		    	 	}
		     	}
		     		
	     }
	}
	public void becomeInt(String part) {
			 part=part.replaceAll(" ", "");
			 other=part;
			 if(part.contains("+"))
				 other=part.replaceFirst("\\+", "");
			if(part.contains("x")) {
			 tempPart=other.replaceFirst("x", "");
			 if(part.contains("^")) {
				String[] miniPart = tempPart.split("\\^");
				Term tempTerm = new Term(Integer.parseInt(miniPart[0]),Integer.parseInt(miniPart[1]));
				Terms.add(tempTerm);
			 }
			else {
			Term tempTerm = new Term(Integer.parseInt(tempPart),1);
			Terms.add(tempTerm);
			     }
			}
			else {
				Term tempTerm = new Term(Integer.parseInt(other),0);
				Terms.add(tempTerm);
			}
		
	}
	public void printTerms() {
		for (int i=0;i<Terms.size();i++) {
			if(Terms.get(i).getExponent()!=0) {
			System.out.print(Terms.get(i).getCoeff() + "x^");
			System.out.print(Terms.get(i).getExponent() + " , ");
			}
			else
			System.out.print(Terms.get(i).getCoeff());
			
		}
	}
	public ArrayList<Term> getTermList() {
		return Terms;
	}
}
