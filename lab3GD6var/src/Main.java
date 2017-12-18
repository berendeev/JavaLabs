import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		//Для примера
//		Point a = new Point(0, 0);
//		Point b = new Point(2, 4);
//		Point c = new Point(4, 0);
//		Triangle triangle = new Triangle(a, b, c);
//		triangle.printInfo();

		ArrayList<Polygon> triangles = new ArrayList<>();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите N - кол-во треугольников");
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			System.out.println("Треугольник #" + i);
			System.out.println("Точка A");
			System.out.println("x=");
			int x = scanner.nextInt();
			System.out.println("y=");
			int y = scanner.nextInt();
			Point a = new Point(x, y);

			System.out.println("Точка B");
			System.out.println("x=");
			x = scanner.nextInt();
			System.out.println("y=");
			y = scanner.nextInt();
			Point b = new Point(x, y);

			System.out.println("Точка C");
			System.out.println("x=");
			x = scanner.nextInt();
			System.out.println("y=");
			y = scanner.nextInt();
			Point c = new Point(x, y);

			Triangle triangle = new Triangle(a, b, c);
			if (triangle.isExist()) {
				triangles.add(triangle);
			}
		}

		System.out.println("Введите M - кол-во равносторонних треугольников");
		int M = scanner.nextInt();
		for (int i = 0; i < M; i++) {
			System.out.println("Треугольник #" + i);
			System.out.println("Точка A");
			System.out.println("x=");
			int x = scanner.nextInt();
			System.out.println("y=");
			int y = scanner.nextInt();
			Point a = new Point(x, y);

			System.out.println("Точка B");
			System.out.println("x=");
			x = scanner.nextInt();
			System.out.println("y=");
			y = scanner.nextInt();
			Point b = new Point(x, y);

			System.out.println("Точка C");
			System.out.println("x=");
			x = scanner.nextInt();
			System.out.println("y=");
			y = scanner.nextInt();
			Point c = new Point(x, y);
			EquilateralTriangle equilateralTriangle = new EquilateralTriangle(a, b, c);
			if (equilateralTriangle.isExist()) {
				triangles.add(equilateralTriangle);
			}
		}

		int indexOfMinMedian = triangles.size();
		double minMedian = triangles.get(indexOfMinMedian).median();
		for (int i = 0; i < triangles.size(); i++) {
			for (int j = 0; j < triangles.size(); j++) {
				if (i != j) {
					if ((triangles.get(i).isEqual((Triangle) triangles.get(j)))) {
						System.out.println("Треугольники #" + i + " и " + j + " равны");
					}
				}
			}
			if (triangles.get(i).isEquilateral()) {
				if (triangles.get(i).median() < minMedian) {
					minMedian = triangles.get(i).median();
					indexOfMinMedian = i;
				}
			}
		}
		System.out.println("Треугольник с наименьшей медианой:" + indexOfMinMedian);
		triangles.get(indexOfMinMedian).printInfo();
	}
}

class Triangle implements Polygon {
	private final double PI = 3.141592;
	private Point a;
	private Point b;
	private Point c;

	Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double perimeter() {
		return len().a + len().b + len().c;
	}

	@Override
	public boolean isExist() {
		Parameters len = len();
		return (len.a < (len.b + len.c)) &&
				(len.b < (len.a + len.c)) &&
				(len.c < (len.b + len.a));
	}

	@Override
	public Parameters len() {
		Parameters len = new Parameters();
		len.a = Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
		len.b = Math.sqrt(Math.pow(c.x - b.x, 2) + Math.pow(c.y - b.y, 2));
		len.c = Math.sqrt(Math.pow(a.x - c.x, 2) + Math.pow(a.y - c.y, 2));
		return len;
	}

	@Override
	public Parameters angles() {
		Parameters angles = new Parameters();
		angles.a = Math.acos((len().b * len().b + len().c * len().c - len().a * len().a) / (2 * len().b * len().c)) * 180 / PI;
		angles.b = Math.acos((len().a * len().a + len().c * len().c - len().b * len().b) / (2 * len().a * len().c)) * 180 / PI;
		angles.c = Math.acos((len().b * len().b + len().a * len().a - len().c * len().c) / (2 * len().b * len().a)) * 180 / PI;
		return angles;
	}

	@Override
	public double area() {
		return Math.abs((b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y)) / 2;
	}

	@Override
	public boolean isEqual(Triangle o) {
		return (((len().a == o.len().a) || (len().a == o.len().b) || (len().a == o.len().c)) &&
				((len().b == o.len().a) || (len().b == o.len().b) || (len().b == o.len().c)) &&
				((len().c == o.len().a) || (len().c == o.len().b) || (len().c == o.len().c)));
	}

	@Override
	public void printInfo() {
		System.out.print("Треугольник " + this.hashCode());
		if (isExist()) {
			if (!isEquilateral()) System.out.print(" не ");
			System.out.println("равносторонний");
			System.out.println("Длины сторон:" + len().a + ", " + len().b + ", " + len().c);
			System.out.println("Углы:" + angles().a + ", " + angles().b + ", " + angles().c);
			System.out.println("Площадь: " + area());
			System.out.println("Периметр: " + perimeter());
		} else System.out.println(" не существует.");
	}

	public boolean isEquilateral() {
		return ((len().a == len().b) && (len().a == len().c));
	}

	@Override
	public double median() {
		//toDo
		//В задании не сказанно делать, но реализация интерфейса принуждает меня написать этот метод
		return -1;
	}
}

class EquilateralTriangle extends Triangle implements Polygon {

	EquilateralTriangle(Point a, Point b, Point c) {
		super(a, b, c);
	}

	public double median() {
		return (len().a * Math.sqrt(3)) / 2;
	}
}


class Parameters {
	public double a;
	public double b;
	public double c;

	Parameters(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	Parameters() {

	}
}

class Point {
	public double x;
	public double y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
