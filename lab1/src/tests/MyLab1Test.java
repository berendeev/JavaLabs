import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

class MyLab1Test {

	@Test
	void counting(final Object... testData) {
		MyLab1 test = new MyLab1();
		String[] testCase = {"One Two Two Three", "One Two Three", "One Two One Three One Two"};
		Map<String, Integer> resulMap = new HashMap<>();

		resulMap.put("One", 1);
		resulMap.put("Two", 2);
		resulMap.put("Three", 1);
		assertEquals(resulMap, test.counting(testCase[0]));

		resulMap.clear();
		resulMap.put("One", 1);
		resulMap.put("Two", 1);
		resulMap.put("Three", 1);
		assertEquals(resulMap, test.counting(testCase[1]));

		resulMap.clear();
		resulMap.put("One", 3);
		resulMap.put("Two", 2);
		resulMap.put("Three", 1);
		assertEquals(resulMap, test.counting(testCase[2]));
	}
}