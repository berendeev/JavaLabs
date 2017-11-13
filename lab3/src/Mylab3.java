import java.util.Scanner;
import java.util.Stack;

public class Mylab3 {
	public String inputText() {
		System.out.println("Enter the text");
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}

	public Stack pushToStack(String string) {
		Stack stack = new Stack();
		String words[] = string.split(" ");
		for (int i = 0; i < words.length; i++) {
			stack.push(words[i]);
		}
		return stack;
	}

	public void output(Stack stack) {
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
	}
}
