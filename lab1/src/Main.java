import java.util.Map;

public class Main {

	public static void main(String[] args) {
		MyLab1 lab = new MyLab1();
		String text = lab.inputText();
		Map words = lab.counting(text);
		lab.output(words);
	}
}
