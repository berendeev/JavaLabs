import java.util.Scanner;

public class Main {
	public static void main(String[] args) {		//точка входа
		Scanner scanner = new Scanner(System.in);	//Для чтения с коноли
		System.out.println("a1 = a + bi\na= ");
		double a = scanner.nextDouble();
		System.out.println("b= ");
		double b = scanner.nextDouble();
		ComplexNumber a1 = new ComplexNumber(a, b);	//создаем обьект класса

		System.out.println("a2 = a + bi\na= ");
		a = scanner.nextDouble();
		System.out.println("b= ");
		b = scanner.nextDouble();
		ComplexNumber a2 = new ComplexNumber(a, b);	//2 обьект

		System.out.println("a3 = a + bi\na= ");
		a = scanner.nextDouble();
		System.out.println("b= ");
		b = scanner.nextDouble();
		ComplexNumber a3 = new ComplexNumber(a, b);	//3 обьект

		ComplexNumber x = a2.pow(4).add((a1.substruct(a2).division((a3.multiplication(a1)))));//формула из задания
		x.out();	//вывод комплексного числа

		System.out.println(x.abs());
	}
}

class ComplexNumber {
	private double integer; //целая часть
	private double imaginary;	// мнимая часть

	ComplexNumber(double integer, double imaginary) {	//конструктор с 2 аргументами
		this.integer = integer;
		this.imaginary = imaginary;
	}

	public double abs() {
		return Math.sqrt(integer * integer + imaginary * imaginary);
	}	//модуль

	public ComplexNumber add(ComplexNumber complexNumber) {	//сложение
		return new ComplexNumber(integer + complexNumber.integer, imaginary + complexNumber.imaginary);
	}

	public ComplexNumber substruct(ComplexNumber complexNumber) { //вычитание
		return new ComplexNumber(integer - complexNumber.integer, imaginary - complexNumber.imaginary);
	}
	//умножение
	public ComplexNumber multiplication(ComplexNumber complexNumber) {//(a+bi)(c+di)= ac+adi+cbi+bidi=AC+ADi+CBi+(-BD);
		double intPart; // = AC - BD
		double imPart;  // = AD + CB

		intPart = integer * complexNumber.integer - imaginary * complexNumber.imaginary;
		imPart = integer * complexNumber.imaginary + complexNumber.integer * imaginary;

		return new ComplexNumber(intPart, imPart);
	}
	//деление
	public ComplexNumber division(ComplexNumber complexNumber) {
		ComplexNumber conjugate = new ComplexNumber(complexNumber.integer, -complexNumber.imaginary);//сопряженное
		ComplexNumber numerator = conjugate.multiplication(this);//перемножаем чисдитель и сопряженное this - этот класс
		double denumerator = complexNumber.integer * complexNumber.integer + (complexNumber.imaginary * complexNumber.imaginary);
		return new ComplexNumber(numerator.integer / denumerator, numerator.imaginary / denumerator);
	}

	public void out() {
		System.out.println("x = " + integer + " + (" + imaginary + "i)");
	}

	public ComplexNumber pow(int power) {
		ComplexNumber temp = new ComplexNumber(integer, imaginary);
		for (int i = 0; i < power - 1; i++) {
			temp = temp.multiplication(temp);
		}
		return temp;
	}

}
