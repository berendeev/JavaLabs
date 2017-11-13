import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class Mylab3Test {
	@Test
	void pushToStack() {
		Mylab3 test = new Mylab3();
		String[] testCase = {"One Two Tree","1 2 3 4","TestOne TestTwo"};
		Stack<String> stack= new Stack<>();

		stack.push("One");
		stack.push("Two");
		stack.push("Tree");
		assertEquals(stack,test.pushToStack(testCase[0]));

		stack.clear();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		assertEquals(stack,test.pushToStack(testCase[1]));

		stack.clear();
		stack.push("TestOne");
		stack.push("TestTwo");
		assertEquals(stack,test.pushToStack(testCase[2]));
	}
}