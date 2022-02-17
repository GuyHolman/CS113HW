package cs113hw3;

import java.util.ArrayList;
import java.util.Collections;



public class Polynomial {
	ArrayList<Term> Terms= new ArrayList<Term>();
	Polynomial(){
		
	}
	public void addTerm(Term other) {
		int check=0;
		for(int i=0;i<Terms.size();i++) {
			if(Terms.get(i).getExponent()==other.getExponent()) {
				Terms.get(i).changeCoeff(other.getCoeff());
				check++;
			}
			
		}
		if(check==0)
		Terms.add(other);
	}
	public void removeTerm(Term other) {
		for(int i=0;i<Terms.size();i++) {
			if(Terms.get(i).getCoeff()==other.getCoeff()&&Terms.get(i).getExponent()==other.getExponent()) {
				Terms.remove(i);
			}
		}
	}
	public void clearPolynomial() {
		Terms.clear();
	}
	public void organizePolynomial() {
		ArrayList<Integer> exponents=new ArrayList<Integer>();
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
			if(i>=1 &&Terms.get(i).getCoeff()>0)
				total+="+ ";
			if(Terms.get(i).getExponent()!=0) {
			total+=String.valueOf(Terms.get(i).getCoeff()) + "x^";
			total+=String.valueOf(Terms.get(i).getExponent()+ " ");
			}
			else
				total+=String.valueOf(Terms.get(i).getCoeff());
			
		}
		return total;
	}
}
