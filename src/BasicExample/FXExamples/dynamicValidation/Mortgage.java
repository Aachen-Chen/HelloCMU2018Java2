package BasicExample.FXExamples.dynamicValidation;

import javafx.scene.control.Alert;

public class Mortgage {
	
	double principal, interest, term; 

	public Mortgage(){

	}

	public Mortgage(double principal, double interest, double term) {
//		this.principal= principal;
//		this.interest = interest;
//		this.term = term;
		this.setInterest(interest);
		this.setPrincipal(principal);
		this.setTerm(term);
	}
	
	double calculateMortgage() {
		double r = interest/1200;
		double t = -term*12;
		double m = principal * r / (1 - Math.pow(1 + r, t));
		return m;
	}

	public void setInterest(double interest){
		if (interest < 0 || interest > 25)
			throw new InputOutOfRangeException("Interest out of range. Must be between 0 and 25");
		this.interest = interest;
	}

	public void setPrincipal(double principal) {
		if (principal < 10000 || principal  > 1000000)
			throw new InputOutOfRangeException("Principal out of range. Must be between 10k and 1m");
		this.principal = principal;
	}

	public void setTerm(double term) {
		if (term < 15 || term > 30)
			throw new InputOutOfRangeException("Term out of range. Must be between 15 and 30");
		this.term = term;
	}
	



	
}

