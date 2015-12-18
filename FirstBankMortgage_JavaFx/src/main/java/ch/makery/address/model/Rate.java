package ch.makery.address.model;

import domain.RateDomainModel;

public class Rate extends RateDomainModel {

	public double getPayment(int NumberOfPayments, double PrincipalValue, int Term)
	{
		//found this formula on wiki...i figured i use this since i can't figure out how
		//to import the finance library
		//link: https://en.wikipedia.org/wiki/Mortgage_calculator#Monthly_payment_formula
		double payment = (this.getInterestRate() * PrincipalValue) / (1 - Math.pow(1 + this.getInterestRate(), -1 * Term));
		    return payment;	
	}

	public boolean approval(double monthlyPmt, double monthlyIncome, double expenses) {
		if (monthlyPmt > monthlyIncome * 0.36) {
			return false;
		} else if (monthlyPmt > (monthlyIncome + expenses) * 0.18) {
			return false;
		} else
			return true;

	}
}
