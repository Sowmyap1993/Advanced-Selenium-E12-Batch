package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {

	
	//@FindBy(id="remove-sauce-labs-bike-light") private WebElement RemoveBtn;
	@FindBy(id="checkout") private WebElement CheckOutBtn;
	@FindBy(className="inventory_item_name") private WebElement ProductNameLnk;

	//Initialization
public YourCartPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//Utilization

/*
public WebElement getRemoveBtn() {
	return RemoveBtn;
}
*/

public WebElement getCheckOutBtn() {
	return CheckOutBtn;
}

public WebElement getProductNameLnk() {
	return ProductNameLnk;
}

//Business Library
/**
 * This method will capture the Product Title in cart and returns the Product Name to caller
 * @return
 */
public String getProductTitle()
{
	return ProductNameLnk.getText();
}

	

}
