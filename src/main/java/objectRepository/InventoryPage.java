package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage { // Rule1: Create a separate POM Class for the Web page
	
	//Rule 2: Identify all the Web Elements using Annotations
	
	
	
	@FindBy(id="react-burger-menu-btn") 
	private WebElement MenuBtn;
	
	@FindBy(id="logout_sidebar_link") 
	private WebElement LogoutBtn;
	
	
	@FindBy(className="shopping_cart_link")
	private WebElement CartBtn;
	
	//Rule 3: Create Constructor and initialize the web elements

	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Rule 4: Provide Getters to access the webelements
	
	
	public WebElement getCartBtn() {
		return CartBtn;
	}

	public WebElement getMenuBtn() {
		return MenuBtn;
	}

	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}
	
	//Business Libraries
	/**
	 * This method will click on menu Button
	 */
	
	public void clickOnMenuButton()
	{
		 MenuBtn.click();
    }
	/**
	 * This method will click on Logout Button
	 */
	public void clickOnLogoutButton()
	{
		MenuBtn.click();
		LogoutBtn.click();
	}
	public String clickOnProductName(WebDriver driver, String PRODUCTNAME)
	{
		String ProductTitle=driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).getText();
		driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
		return ProductTitle;
	}
	
}