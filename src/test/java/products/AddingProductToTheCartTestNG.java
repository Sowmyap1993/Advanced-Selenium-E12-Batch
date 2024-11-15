package products;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericutilities.BaseClass;
import genericutilities.Excelfile_utility;
import genericutilities.Propertyfile_utility;
import genericutilities.Selenium_utility;
import objectRepository.AllProductsPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;
import objectRepository.ProductPage;
import objectRepository.YourCartPage;

/* TestCae */
public class AddingProductToTheCartTestNG extends BaseClass {
@Test  (groups={"Smoke","Regression"})//(groups="Smoke")/* Test method  or test script */ //(groups="Smoke") this is for group execution

public void  tc_001_AddSingleProductToCartTest() throws IOException, InterruptedException {
// TODO Auto-generated method stub			 
			 //Read the Test data from Excel file
				 String PRODUCTNAME=eUtil.readDataFromExcelFile("Sheet1",6,2);	
				 System.out.println(PRODUCTNAME);
				 
				 
			//Step 1: Launching browser
					//ChromeDriver driver=new ChromeDriver();
					//sUtil.maximizeWindow(driver);
					//sUtil.addImplicitlyWait(driver);		

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
//Step 8 Validate Product Name using Hard asser
Assert.assertEquals(ProductTitleInCart,productTitle);
Assert.assertTrue(ProductTitleInCart.equals(productTitle)); //using AssertTrue

	}

}
