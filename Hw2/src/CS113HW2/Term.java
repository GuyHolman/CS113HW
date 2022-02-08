package CS113HW2;

public class Term {
	private int exponent;
	private int coeff;
	Term(){
		exponent=0;
		coeff=0;
	}
	Term(int _coeff, int _exp){
		exponent=_exp;
		coeff=_coeff;
	}
	public int getCoeff() {
		return coeff;
	}
	public int getExponent() {
		return exponent;
	}
}
