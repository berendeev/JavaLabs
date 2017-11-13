import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;


public class MyLab1Test {
	@org.junit.Test
	public void count() throws Exception {
		MyLab1 test = new MyLab1();
		String[] testCase = {"One Two Two Three", "One Two Three", "One Two One Three One Two"};
		Map<String, Integer> resulMap = new HashMap<>();

		resulMap.put("One", 1);
		resulMap.put("Two", 2);
		resulMap.put("Three", 1);
		assertEquals(resulMap, test.count(testCase[0]));

		resulMap.clear();
		resulMap.put("One", 1);
		resulMap.put("Two", 1);
		resulMap.put("Three", 1);
		assertEquals(resulMap, test.count(testCase[1]));

		resulMap.clear();
		resulMap.put("One", 3);
		resulMap.put("Two", 2);
		resulMap.put("Three", 1);
		assertEquals(resulMap, test.count(testCase[2]));
	}
}