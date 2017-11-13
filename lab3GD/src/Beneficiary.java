public class Beneficiary extends Categories {
	Beneficiary(double income) {
		super(income);
	}

	@Override
	public void calculationOfTheLoanAmount() {
		loanAmount = income * 30;
	}

	@Override
	public void calculationOfInterestRate() {
		interestRate = income /20;
	}
}
