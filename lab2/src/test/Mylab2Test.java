import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Mylab2Test {
	@Test
	void isCorrectPass() {
		Mylab2 test = new Mylab2();
		String[] testCase = {"My_coo1_password", "badpassword", "12345678"};
		assertAll(
				() -> Assertions.assertEquals(true, test.isCorrectPass(testCase[0])),
				() -> Assertions.assertEquals(false, test.isCorrectPass(testCase[1])),
				() -> Assertions.assertEquals(false, test.isCorrectPass(testCase[2]))
		);
	}

}