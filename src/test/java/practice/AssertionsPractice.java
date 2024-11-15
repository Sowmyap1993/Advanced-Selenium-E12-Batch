package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	@Test
	public void Sample()
	{
		//Hard Assert
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		Assert.assertEquals(false,true);
		System.out.println("Step4");
		System.out.println("Step5");
	}
	
	//Soft Assert
	@Test
	public void Sample1()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		sa.assertEquals(false,true);
		System.out.println("Step4");
		System.out.println("Step5");
		sa.assertAll();// if we use this stmt then only it shows where there is an error
	}

}
