package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table.Cell;

//import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class DDT_properties_file_Addingproducttocart_using_Dynamic_xpath {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Reading common data from properties file
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p=new Properties();
		p.load(fisp);
		
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		
		//Read data from Excel field
		
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\Testdata1.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		Sheet sh=wb.getSheet("Sheet1");
		Row rw=sh.getRow(1);
		Cell cl= rw.getCell(2);
		String PRODUCTNAME=cl.getStringCellValue();
		
		//Step 1: Launching browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step 2: Load the URL
		driver.get(URL);
		
		//Step 3: Login to the application with the appropriate credentials.
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		
		//Step 4: click on the Product
		System.out.println(PRODUCTNAME);
		driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
		Thread.sleep(1000);
		String ProductTitle=driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).getText();
		
		//Step 5: Add Product to Cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//Step 6: Click on Add to Cart button and validate the product
		driver.findElement(By.className("shopping_cart_badge")).click();
		String ProductIncart= driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
		if(ProductTitle.equalsIgnoreCase(ProductIncart))
			{
			System.out.println("Product Successfully added to the cart------>PASS");
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
