public class Fraction implements Comparable<Fraction> {
	private int numerator;
	private int denominator;

	Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	Fraction(String numbers) {
		String in[] = numbers.split("/");
		this.numerator = Integer.parseInt(in[0]);
		this.denominator = Integer.parseInt(in[1]);
	}

	public void print() {
		System.out.println(numerator + "/" + denominator);
	}

	public void printDec() {
		System.out.println((double) numerator / denominator);
	}

	public Fraction sum(Fraction f) {
		int newNumerator;
		int newDenominator;
		if (f.denominator == denominator) {
			newDenominator = denominator;
			newNumerator = numerator + f.numerator;
		} else {
			newDenominator = f.denominator * denominator;
			newNumerator = (numerator * f.denominator) + (f.numerator * denominator);
		}
		return new Fraction(newNumerator, newDenominator);
	}

	public Fraction subtraction(Fraction f) {
		int newNumerator;
		int newDenominator;
		if (f.denominator == denominator) {
			newDenominator = denominator;
			newNumerator = numerator - f.numerator;
		} else {
			newDenominator = f.denominator * denominator;
			newNumerator = (numerator * f.denominator) - (f.numerator * denominator);
		}
		return new Fraction(newNumerator, newDenominator);
	}

	public Fraction multiplication(Fraction f) {
		return new Fraction(numerator * f.numerator, denominator * f.denominator);
	}

	public Fraction division(Fraction f) {
		return new Fraction(numerator * f.denominator, denominator * f.numerator);
	}

//	public boolean isMore(Fraction f) {
//		boolean flag;
//		if (denominator == f.denominator) flag = numerator > f.numerator;
//		else {
//			flag = (numerator * f.denominator) > (f.numerator * numerator);
//		}
//		return flag;
//	}
//
//	public boolean isLess(Fraction f) {
//		boolean flag;
//		if (denominator == f.denominator) flag = numerator < f.numerator;
//		else {
//			flag = (numerator * f.denominator) < (f.numerator * numerator);
//		}
//		return flag;
//	}

	public String getStringFraction() {
		return numerator + "/" + denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	@Override
	public int compareTo(Fraction o) {
		int compared;
		if (denominator == o.getDenominator()) {
			compared = Integer.compare(numerator, o.getNumerator());
		} else {
			int numOfFirstFraction = numerator * o.getDenominator();
			int numOfSecondFraction = o.getNumerator() * denominator;
			compared = Integer.compare(numOfFirstFraction, numOfSecondFraction);
		}
		return compared;
	}
}
