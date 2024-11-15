package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import genericutilities.Excelfile_utility;
import genericutilities.Propertyfile_utility;
import genericutilities.Selenium_utility;
import objectRepository.LoginPage;

public class AddingProductToCartUsingPOM {

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
			driver.get("https://www.saucedemo.com/");
			
			//Step 3: Login to the application with the appropriate credentials.
			//driver.findElement(By.id("user-name")).sendKeys("standard_user");
			//driver.findElement(By.id("password")).sendKeys("secret_sauce");
			//driver.findElement(By.id("login-button")).click();
			
			LoginPage lp=new LoginPage(driver);
			lp.getUsernameEdt().sendKeys(USERNAME);
			lp.getPasswordEdt().sendKeys(PASSWORD);
			lp.getLoginBtn().click();
			Thread.sleep(3000);
			
			//Step 4: click on the Product
			driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
			Thread.sleep(1000);
			String ProductTitle=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
			
			//Step 5: Add Product to Cart
			driver.findElement(By.id("add-to-cart")).click();
			
			//Step 6: Click on Add to Cart button and validate the product
			driver.findElement(By.className("shopping_cart_badge")).click();
			String ProductIncart= driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
			if(ProductTitle.equalsIgnoreCase(ProductIncart))
				{
				System.out.println("Product Successfully added to the cart--->PASS");
				System.out.println("Product is:"+ ProductIncart);
				}
			else
			{
				System.out.println("Product not added to the cart --->FAIL");
			}
			
			//Step 7: Logout from the application
	driver.findElement(By.id("react-burger-menu-btn")).click();
	driver.findElement(By.id("logout_sidebar_link")).click();
	//driver.close();
		}
		 
		
		

	}


