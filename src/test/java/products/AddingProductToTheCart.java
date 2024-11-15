package products;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import genericutilities.Excelfile_utility;
import genericutilities.Propertyfile_utility;
import genericutilities.Selenium_utility;
import objectRepository.AllProductsPage;
import objectRepository.LoginPage;
import objectRepository.ProductPage;
import objectRepository.YourCartPage;

public class AddingProductToTheCart {
public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//Create Object for the required generic utilities classes
				Excelfile_utility eutil=new Excelfile_utility();
				Propertyfile_utility putil=new Propertyfile_utility();
				Selenium_utility sutil=new Selenium_utility();				
		//Read data from Properties files by calling it
				 String URL=putil.readDataFromPropertyFile("url");
				 String USERNAME=putil.readDataFromPropertyFile("username");
				 String PASSWORD=putil.readDataFromPropertyFile("password");				 
			 //Read data from Excel file
				 String PRODUCTNAME=eutil.readDataFromExcelFile("Sheet1",1,2);				 
			//Step 1: Launching browser
					ChromeDriver driver=new ChromeDriver();
					sutil.maximizeWindow(driver);
					sutil.addImplicitlyWait(driver);
					//Step 2: Load the URL
					driver.get(URL);
		//Step 3: Login to the application with the appropriate credentials.					
	//Create Object for the LoginPage class POM Class.					
LoginPage lp=new LoginPage(driver);
//lp.getUsernameEdt().sendKeys(USERNAME);
//lp.getPasswordEdt().sendKeys(PASSWORD);
//lp.getLoginBtn().click();
//Another way to login i.e using Business Libraries
lp.loginToApp(USERNAME, PASSWORD);
Thread.sleep(2000);
//Create object for the AllProductsPage class
AllProductsPage ap=new AllProductsPage(driver);
ap.getProductNameBtn().click();
Thread.sleep(1000);
//ap.getMenuBtn().click();
//ap.getLogoutBtn().click();
//Create object for the ProductsPage class
	ProductPage pp=new ProductPage(driver);
	pp.getAddToCartBtn().click();
	pp.getCartBtn().click();
	Thread.sleep(2000);	
YourCartPage ycp=new YourCartPage(driver);
ycp.getCheckOutBtn().click();





	}

}
