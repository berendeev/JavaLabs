public class Employee extends Categories {
	Employee(double income) {
		super(income);
	}

	@Override
	public void calculationOfInterestRate() {
		interestRate = 0;
	}

	@Override
	public void calculationOfTheLoanAmount() {
		loanAmount = income * 30;
	}
}
