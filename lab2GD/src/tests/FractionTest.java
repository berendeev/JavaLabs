import junit.framework.Assert;


public class FractionTest {
	@org.junit.Test
	public void sum() throws Exception {
		int testCase[][] = {{1, 1}, {1, 2}, {2, 3}};
		Fraction f1 = new Fraction(testCase[0][0], testCase[0][1]);
		Fraction f2 = new Fraction(testCase[1][0], testCase[1][1]);
		Fraction f3 = new Fraction(testCase[2][0], testCase[2][1]);

		Fraction ans1 = new Fraction("3/2");
		Assert.assertTrue(f1.sum(f2).compareTo(ans1) == 0);

		Fraction ans2 = new Fraction("7/6");
		Assert.assertTrue(f2.sum(f3).compareTo(ans2) == 0);

		Fraction ans3 = new Fraction("5/3");
		Assert.assertTrue(f1.sum(f3).compareTo(ans3) == 0);

	}

	@org.junit.Test
	public void subtraction() throws Exception {
		int testCase[][] = {{1, 1}, {1, 2}, {2, 3}};
		Fraction f1 = new Fraction(testCase[0][0], testCase[0][1]);
		Fraction f2 = new Fraction(testCase[1][0], testCase[1][1]);
		Fraction f3 = new Fraction(testCase[2][0], testCase[2][1]);

		Fraction ans1 = new Fraction("1/2");
		Assert.assertTrue(f1.subtraction(f2).compareTo(ans1) == 0);

		Fraction ans2 = new Fraction("-1/6");
		Assert.assertTrue(f2.subtraction(f3).compareTo(ans2) == 0);

		Fraction ans3 = new Fraction("1/3");
		Assert.assertTrue(f1.subtraction(f3).compareTo(ans3) == 0);
	}

	@org.junit.Test
	public void multiplication() throws Exception {
		int testCase[][] = {{1, 1}, {1, 2}, {2, 3}};
		Fraction f1 = new Fraction(testCase[0][0], testCase[0][1]);
		Fraction f2 = new Fraction(testCase[1][0], testCase[1][1]);
		Fraction f3 = new Fraction(testCase[2][0], testCase[2][1]);

		Fraction ans1 = new Fraction("1/2");
		Assert.assertTrue(f1.multiplication(f2).compareTo(ans1) == 0);

		Fraction ans2 = new Fraction("2/6");
		Assert.assertTrue(f2.multiplication(f3).compareTo(ans2) == 0);

		Fraction ans3 = new Fraction("2/3");
		Assert.assertTrue(f1.multiplication(f3).compareTo(ans3) == 0);
	}

	@org.junit.Test
	public void division() throws Exception {
		int testCase[][] = {{1, 1}, {1, 2}, {2, 3}};
		Fraction f1 = new Fraction(testCase[0][0], testCase[0][1]);
		Fraction f2 = new Fraction(testCase[1][0], testCase[1][1]);
		Fraction f3 = new Fraction(testCase[2][0], testCase[2][1]);

		Fraction ans1 = new Fraction("2/1");
		Assert.assertTrue(f1.division(f2).compareTo(ans1) == 0);

		Fraction ans2 = new Fraction("3/4");
		Assert.assertTrue(f2.division(f3).compareTo(ans2) == 0);

		Fraction ans3 = new Fraction("3/2");
		Assert.assertTrue(f1.division(f3).compareTo(ans3) == 0);
	}

	@org.junit.Test
	public void compareTo() throws Exception {
		int testCase[][] = {{1, 2}, {1, 2}, {2, 3}};
		Fraction f1 = new Fraction(testCase[0][0], testCase[0][1]);
		Fraction f2 = new Fraction(testCase[1][0], testCase[1][1]);
		Fraction f3 = new Fraction(testCase[2][0], testCase[2][1]);

		Assert.assertEquals(0, f1.compareTo(f2));
		Assert.assertEquals(-1, f1.compareTo(f3));
		Assert.assertEquals(1, f3.compareTo(f2));
	}

//	@org.junit.Test
//	public void isMore() throws Exception {
//	}
//
//	@org.junit.Test
//	public void isLess() throws Exception {
//	}

}
