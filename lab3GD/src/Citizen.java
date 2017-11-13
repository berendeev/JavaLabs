public class Citizen extends Categories {
	Citizen(double income) {
		super(income);
	}

	@Override
	public void calculationOfTheLoanAmount() {
		loanAmount = income * 30;
	}

	@Override
	public void calculationOfInterestRate() {
		interestRate = income / 10;
	}
}
