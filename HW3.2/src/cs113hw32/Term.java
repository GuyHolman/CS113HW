package cs113hw32;

public class Term {
	private int coeff;
	private int exp;
	Term(int _coeff, int _exp){
		coeff=_coeff;
		exp=_exp;
	}
	Term(){
		coeff=1;
		exp=1;
	}
	public int getCoefficient() {
		return coeff;
	}
	public int getExponent() {	
		return exp;
	}
	public void changeCoeff(int other) {
		coeff+=other;
	}
	public void setCoefficient(int c) {
		coeff=c;
	}
	public void setExponent(int c) {
		exp=c;
	}
}
