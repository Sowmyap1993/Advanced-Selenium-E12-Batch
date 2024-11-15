package genericutilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class BaseClass {
	
	
	public static WebDriver sDriver;
	public Excelfile_utility eUtil=new Excelfile_utility();
	public Propertyfile_utility pUtil=new Propertyfile_utility();
	public Selenium_utility sUtil=new Selenium_utility();
	
	public WebDriver driver;
	@BeforeSuite (groups={"Smoke","Regression"})
	public void bsConfig()
	{
		System.out.println("--------Database COnnection Successful-------------");
	}
	@BeforeClass (groups={"Smoke","Regression"})    //(groups="Smoke")
	public void bcConfig() throws IOException
	{
	String URL=pUtil.readDataFromPropertyFile("url");
	driver= new ChromeDriver();
	sUtil.maximizeWindow(driver);
	//sUtil.addImplicitlyWait(driver);
	driver.get(URL);
	System.out.println("Browser Launch Successful");	
	
	/*used for listeners */
	 sDriver = driver;
	}
 @BeforeMethod(alwaysRun=true)
 public void bmConfig() throws IOException
 {
	 String USERNAME=pUtil.readDataFromPropertyFile("username");
	 String PASSWORD=pUtil.readDataFromPropertyFile("password");
	 
	 LoginPage lp=new LoginPage(driver);
	 lp.loginToApp(USERNAME, PASSWORD);
	 System.out.println("Login to APplication successful");
 }
 @AfterMethod   (groups={"Smoke","Regression"})  //(groups="Smoke")
 public void amConfig()
 
 {
	InventoryPage app=new InventoryPage(driver);
	app.clickOnLogoutButton();
	System.out.println("Logout from the application is successful");
	
 }
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("Browser closure successful");
	}
	@AfterSuite(alwaysRun=true)
	public void asConfig()

	{
		System.out.println("--------Database Disconnection Successful-------------");
	}
}
