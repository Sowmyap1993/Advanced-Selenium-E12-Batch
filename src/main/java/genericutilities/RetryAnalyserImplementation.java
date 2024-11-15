package genericutilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * THis class provides implementation for IRetryAnalyser interface of TestNG
 * 
 
 **/


public class RetryAnalyserImplementation implements IRetryAnalyzer{
	int count=0;
	int retryCount=3;
	public boolean retry(ITestResult result)
	{
		if(count<retryCount)
		{
			count++;
			return true;  //retry for 3 times
		}
		return false; //not retry
	}
	

}
