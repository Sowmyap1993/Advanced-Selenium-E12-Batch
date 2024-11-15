package genericutilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * This class provides implementation to ITestListener interfact in TestNG
 
 */

public class ListenersImplementation implements ITestListener
{
	//Capture the current Date and Time for Screenshot name and Report Name
	Date d=new Date();
	SimpleDateFormat f=new SimpleDateFormat("DD-MM-yyyy hh:mm:ss");
	String date=f.format(d);
	
	//ExtentReport report;

	@Override
	public void onTestStart(ITestResult result) {
		//@Test execution is started
		System.out.println("TestScript execution is started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//Capture the method name of @Test
		String methodName=result.getMethod().getMethodName();
		
		//@Test is PASSED
				System.out.println(methodName+"TestScript is PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//Capture the method name of @Test
		String methodName=result.getMethod().getMethodName();
				
		//@Test is Failed
		System.out.println(methodName+"TestScript is FAIL");
		System.out.println(result.getThrowable());
		
		//Capture the Screenshot
		Selenium_utility s=new Selenium_utility();
		//Screenshot Name Configured
		String screenshotName=methodName+date;
		try {
			s.captureScreenshot(BaseClass.sDriver,screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//Capture the method name of @Test
		String methodName=result.getMethod().getMethodName();
		//@Test is Skipped
		System.out.println(methodName+"TestScript is SKIPPED");
		System.out.println(result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		//This will work at Suite level
		System.out.println("Suite execution is started");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		//This will work at Suite level
				System.out.println("Suite execution is Finished");
		
	}

}
