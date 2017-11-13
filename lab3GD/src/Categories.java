abstract public class Categories {
	protected double income;
	protected double loanAmount;
	protected double interestRate;

	Categories(double income){
		this.income = income;
		calculationOfTheLoanAmount();
		calculationOfInterestRate();
	}

	public void calculationOfInterestRate(){

	}
	public void calculationOfTheLoanAmount(){

	}

	public double getInterestRate() {
		return interestRate;
	}

	public double getLoanAmount() {
		return loanAmount;
	}
}
