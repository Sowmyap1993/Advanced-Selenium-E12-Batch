package products;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericutilities.Excelfile_utility;
import genericutilities.Propertyfile_utility;
import genericutilities.Selenium_utility;
import objectRepository.AllProductsPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;
import objectRepository.ProductPage;
import objectRepository.YourCartPage;

/* TestCae */
public class AddingProductToTheCartPOM {
@Test /* Test method  or test script */

public void  tc_001_AddSingleProductToCartTest() throws IOException, InterruptedException {
// TODO Auto-generated method stub
		//Create Object for the required generic utilities classes
				Excelfile_utility eutil=new Excelfile_utility();
				Propertyfile_utility putil=new Propertyfile_utility();
				Selenium_utility sutil=new Selenium_utility();				
		//Read data from Properties files by calling it
				 String URL=putil.readDataFromPropertyFile("url");
				 String USERNAME=putil.readDataFromPropertyFile("username");
				 String PASSWORD=putil.readDataFromPropertyFile("password");				 
			 //Read the Test data from Excel file
				 String PRODUCTNAME=eutil.readDataFromExcelFile("Sheet1",6,2);	
				 System.out.println(PRODUCTNAME);
				 
				 
			//Step 1: Launching browser
					ChromeDriver driver=new ChromeDriver();
					sutil.maximizeWindow(driver);
					sutil.addImplicitlyWait(driver);		
			
			//Step 2: Load the URL
					driver.get(URL);
					Thread.sleep(2000);
					
//Step 3: Login to the application 					
LoginPage lp=new LoginPage(driver);
lp.loginToApp(USERNAME, PASSWORD);
Thread.sleep(2000);

//Step 4: click on the Product
InventoryPage ap=new InventoryPage(driver);
String productTitle=ap.clickOnProductName(driver,PRODUCTNAME);
//Step 5: Add Product to cart 
ProductPage pp=new ProductPage(driver);
pp.clickOnAddToCartButton();
Thread.sleep(2000);
//Step 6 Navigate to Cart
pp.clickOnCartButton();
Thread.sleep(2000);
//Step 7 Capture Product Details in Cart

YourCartPage ycp=new YourCartPage(driver);
String ProductTitleInCart=ycp.getProductTitle();
Thread.sleep(2000);
//Step 8 Validate Product Name
if (ProductTitleInCart.equalsIgnoreCase(productTitle)) 
{ System.out.println("product successfully added to cart"); 
System.out.println("PASS");
 System.out.println(ProductTitleInCart);
 } else 
{ 
System.out.println("Product NOt added to cart -> FAIL"); 
} 
// Step 9: LOgout of Application
ap.clickOnLogoutButton();
Thread.sleep(2000);

	}

}
