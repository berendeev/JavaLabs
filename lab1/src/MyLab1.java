import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MyLab1 {

	String inputText() {
		System.out.println("Enter the text: ");
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}

	Map counting(String text) {
		Map<String, Integer> words = new HashMap<>();
		String[] word = text.split(" ");

		for (String aWord : word) {
			int value = 1;
			if (words.containsKey(aWord)) {
				value = words.get(aWord) + 1;
			}
			words.put(aWord, value);
		}
		return words;
	}

	void output(Map map) {
		System.out.println("Output");
		for (Object key : map.keySet()) {
			System.out.println(key + " - " + map.get(key));
		}
	}
}
