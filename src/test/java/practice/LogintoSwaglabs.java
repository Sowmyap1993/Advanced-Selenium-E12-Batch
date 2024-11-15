package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class LogintoSwaglabs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Step 1: Launching browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step 2: Load the URL
		driver.get("https://www.saucedemo.com/");
		
		//Step 3: Login to the application with the appropriate credentials.
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		
		//Step 4: click on the Product
		driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).click();
		Thread.sleep(1000);
		String ProductTitle=driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).getText();
		
		//Step 5: Add Product to Cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//Step 6: Click on Add to Cart button and validate the product
		driver.findElement(By.className("shopping_cart_badge")).click();
		String ProductIncart= driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).getText();
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
driver.close();
	}

}
