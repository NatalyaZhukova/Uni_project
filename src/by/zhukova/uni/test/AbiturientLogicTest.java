
package by.zhukova.uni.test;

import org.junit.Assert;
import org.junit.Test;

import by.zhukova.uni.logic.AbiturientLogic;

/**
 * The Class {@code AbiturientLogicTest} is designed to test the class
 * {@code by.zhukova.uni.logic.AbiturientLogic}.
 * 
 * @author Natallya Zhukova
 * @since 1.0
 */
public class AbiturientLogicTest {

	/**
	 * Test the method which calculate school score.
	 */
	@Test
	public void calculateSchoolScoreTest() {

		int toDoubleDigit = AbiturientLogic.TO_DOUBLE_DIGIT;
		double mark = 8.3;

		int expected = (int) (mark * toDoubleDigit);
		int actual = AbiturientLogic.calculateSchoolScore(mark);

		Assert.assertEquals(expected, actual);

	}

}