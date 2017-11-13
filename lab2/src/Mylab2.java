import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mylab2 {

	public String inputText() {
		System.out.print("Write password: ");
		Scanner input = new Scanner(System.in);
		return input.next();
	}

	public boolean isCorrectPass(String pass) {
		Pattern patternPass = Pattern.compile("((\\w*|\\d*)[A-Z](\\w*|\\d*)[a-z](\\w*|\\d*)[0-9](\\w*|\\d*))|" +
				"((\\w*|\\d*)[A-Z](\\w*|\\d*)[0-9](\\w*|\\d*)[a-z](\\w*|\\d*))|" +
				"((\\w*|\\d*)[a-z](\\w*|\\d*)[A-Z](\\w*|\\d*)[0-9](\\w*|\\d*))|" +
				"((\\w*|\\d*)[a-z](\\w*|\\d*)[0-9](\\w*|\\d*)[A-Z](\\w*|\\d*))|" +
				"((\\w*|\\d*)[0-9](\\w*|\\d*)[A-Z](\\w*|\\d*)[a-z](\\w*|\\d*))|" +
				"((\\w*|\\d*)[0-9](\\w*|\\d*)[a-z](\\w*|\\d*)[A-Z](\\w*|\\d*))");
		Matcher matcher = patternPass.matcher(pass);
		return matcher.matches() && pass.length() >= 8;
	}
}
