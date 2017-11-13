import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the f1 fraction[num/num]: ");
		Fraction f1 = new Fraction(scanner.next());
		f1.print();
		f1.printDec();

		System.out.println("Enter the f2 fraction[num/num]: ");
		Fraction f2 = new Fraction(scanner.next());
		f2.print();
		f2.printDec();

//		System.out.println(f1.getStringFraction() + ">" + f2.getStringFraction() + "? " + f1.isMore(f2));
//		System.out.println(f1.getStringFraction() + "<" + f2.getStringFraction() + "? " + f1.isLess(f2));

		System.out.println(f1.getStringFraction() + "+" + f2.getStringFraction() + " = " + f1.sum(f2).getStringFraction());

	}
}