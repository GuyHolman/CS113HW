package cs113hw3;

public class Term {
	private int coeff;
	private int exp;
	Term(int _coeff, int _exp){
		coeff=_coeff;
		exp=_exp;
	}
	public int getCoeff() {
		return coeff;
	}
	public int getExponent() {	
		return exp;
	}
	public void changeCoeff(int other) {
		coeff+=other;
	}
}
