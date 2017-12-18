public interface Polygon {
	double perimeter();
	boolean isExist();
	Parameters len();
	Parameters angles();
	double area();
	boolean isEqual(Triangle triangle);
	void printInfo();

	boolean isEquilateral();

	double median();
}
