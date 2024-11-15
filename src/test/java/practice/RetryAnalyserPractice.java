package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {

	
		// TODO Auto-generated method stub
		@Test(retryAnalyzer=genericutilities.RetryAnalyserImplementation.class)
		public void sample() 
		{
			Assert.fail();
			System.out.println("Hi");
			}
		

	}
