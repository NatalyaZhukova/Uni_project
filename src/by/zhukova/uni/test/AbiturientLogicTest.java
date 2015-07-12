package by.zhukova.uni.test;
import org.junit.Assert;
import org.junit.Test;

import by.zhukova.uni.logic.AbiturientLogic;

public class AbiturientLogicTest {
	
    @Test
	public void calculateSchoolScoreTest() {
		
		int toDoubleDigit = AbiturientLogic.TO_DOUBLE_DIGIT;
		double mark = 8.3;
		
		int expected = (int)(mark*toDoubleDigit);
		int actual = AbiturientLogic.calculateSchoolScore(mark);
		
		Assert.assertEquals(expected, actual);
		
		
		
	}
	

}