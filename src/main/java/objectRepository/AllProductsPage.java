package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProductsPage { // Rule1: Create a separate POM Class for the Web page
	
	//Rule 2: Identify all the Web Elements using Annotations
	
	@FindBy(linkText="Sauce Labs Bolt T-Shirt") private WebElement ProductNameBtn;
	@FindBy(linkText="Sauce Labs Backpack") private WebElement ProductNBtn1;
	@FindBy(linkText="Sauce Labs Bike Light") private WebElement ProductNBtn2;
	@FindBy(linkText="Sauce Labs Fleece Jacket") private WebElement ProductNBtn3;
	@FindBy(linkText="Sauce Labs Onesie") private WebElement ProductNBtn4;
	@FindBy(partialLinkText="Test.allTheThings") private WebElement ProductNBtn5;
	
	
	@FindBy(id="react-burger-menu-btn") 
	private WebElement MenuBtn;
	@FindBy(id="logout_sidebar_link") 
	private WebElement LogoutBtn;
	@FindBy(className="shopping_cart_link")
	private WebElement CartBtn;
	
	//Rule 3: Create Constructor and initialize the web elements

	public AllProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Rule 4: Provide Getters to access the webelements
	
	public WebElement getProductNameBtn() {
		return ProductNameBtn;
	}

	public WebElement getProductNBtn1() {
		return ProductNBtn1;
	}

	public WebElement getProductNBtn2() {
		return ProductNBtn2;
	}

	public WebElement getProductNBtn3() {
		return ProductNBtn3;
	}

	public WebElement getProductNBtn4() {
		return ProductNBtn4;
	}

	public WebElement getProductNBtn5() {
		return ProductNBtn5;
	}

	public WebElement getCartBtn() {
		return CartBtn;
	}

	public WebElement getMenuBtn() {
		return MenuBtn;
	}

	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}
}
