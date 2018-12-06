package BasicExample.FXExamples.dynamicCalculatorOriginal;

public class Mortgage {
	
	double principal, interest, term; 
	
	public Mortgage(double principal, double interest, double term) {
		this.principal= principal;
		this.interest = interest;
		this.term = term;
	}
	
	double calculateMortgage() {
		double r = interest/1200;
		double t = -term*12;
		double m = principal * r / (1 - Math.pow(1 + r, t));
		return m;
	}
}
