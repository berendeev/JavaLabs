import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the income of Employee");
		Employee employee = new Employee(scanner.nextInt());
		System.out.println("Your loan amount = " + employee.getLoanAmount() + ";");
		System.out.println("Your interest rate = " + employee.getInterestRate() + ";\n");

		System.out.println("Enter the income of Citizen");
		Citizen citizen = new Citizen(scanner.nextInt());
		System.out.println("Your loan amount = " + citizen.getLoanAmount() + ";");
		System.out.println("Your interest rate = " + citizen.getInterestRate() + ";\n");

		System.out.println("Enter the income of NonPayer");
		NonPayer nonPayer = new NonPayer(scanner.nextInt());
		System.out.println("Your loan amount = " + nonPayer.getLoanAmount() + ";");
		System.out.println("Your interest rate = " + nonPayer.getInterestRate() + ";\n");

		System.out.println("Enter the income of Beneficiary");
		Beneficiary beneficiary = new Beneficiary(scanner.nextInt());
		System.out.println("Your loan amount = " + beneficiary.getLoanAmount() + ";");
		System.out.println("Your interest rate = " + beneficiary.getInterestRate() + ";\n");

	}
}
