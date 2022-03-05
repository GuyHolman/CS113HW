package cs113hw32;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;



public class Polynomial {
	LinkedList<Term> Terms= new LinkedList<Term>();
	Polynomial(){
		
	}
	public void addTerm(Term other) {
		int check=0;
		for(int i=0;i<Terms.size();i++) {
			if(Terms.get(i).getExponent()==other.getExponent()) {
				Terms.get(i).changeCoeff(other.getCoefficient());
				check++;
			}
			
		}
		if(check==0)
		Terms.add(other);
	}
	public void removeTerm(Term other) {
		for(int i=0;i<Terms.size();i++) {
			if(Terms.get(i).getCoefficient()==other.getCoefficient()&&Terms.get(i).getExponent()==other.getExponent()) {
				Terms.remove(i);
			}
		}
	}
	public void clear() {
		Terms.clear();
	}
	public void organizePolynomial() {
		LinkedList<Integer> exponents=new LinkedList<Integer>();
		for(int i=0;i<Terms.size();i++) {
			exponents.add(Terms.get(i).getExponent());
		}
		Collections.sort(exponents,Collections.reverseOrder());
		for(int i=0;i<Terms.size();i++) {
			for(int j=0;j<exponents.size();j++) {
				if(Terms.get(j).getExponent()==exponents.get(i)) {
					Term fake=Terms.get(i);
					Terms.set(i, Terms.get(j));
					Terms.set(j, fake);
				}
			}
		}
	}
	public String printTerms() {
		String total = "";
		for (int i=0;i<Terms.size();i++) {
			if(i>=1 &&Terms.get(i).getCoefficient()>0)
				total+="+ ";
			if(Terms.get(i).getExponent()!=0) {
			total+=String.valueOf(Terms.get(i).getCoefficient()) + "x^";
			total+=String.valueOf(Terms.get(i).getExponent()+ " ");
			}
			else
				total+=String.valueOf(Terms.get(i).getCoefficient());
			
		}
		return total;
	}
	public int getNumTerms() {

		return Terms.size();
	}
	public Term getTerm(int i) {

		return Terms.get(i);
	}
}

