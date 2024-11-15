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
public class RemovingProductFromCartTestNG extends BaseClass {
@Test (groups="Regression")/* Test method  or test script */ //(groups="Smoke")

public void TC02()
{
	System.out.println("Removing the Product Successfully");
}

}
