package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {// Rule1: Create a separate POM Class for the Web page
	
	//Rule 2: Identify all the Web Elements using Annotations
	@FindBy(id="add-to-cart") 
	private WebElement AddToCartBtn;
	
	@FindBy(className="shopping_cart_link") 
	private WebElement  CartBtn;

	//Rule 3: Initialization: Create Constructor and initialize the web elements
	
public ProductPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//Utilization: Rule 4: Provide Getters to access the webelements

public WebElement getAddToCartBtn() {
	return AddToCartBtn;
}

public WebElement getCartBtn() {
	return CartBtn;
}
//Business Library
/**
 * This method will click on Add to Cart
 */
public void clickOnAddToCartButton()
{
	AddToCartBtn.click();
}
/**
 * This method will click on Cart Container
 */
public void clickOnCartButton()
{
	CartBtn.click();
}
	
	

}
