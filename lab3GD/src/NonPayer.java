public class NonPayer extends Categories {

	NonPayer(double income) {
		super(income);
	}

	@Override
	public void calculationOfInterestRate() {
		interestRate = income / 6;
	}

	@Override
	public void calculationOfTheLoanAmount() {
		loanAmount = income * 3;
	}
}
