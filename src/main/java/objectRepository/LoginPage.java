package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {// Rule1: Create a separate POM Class for the Web page
	
	//Rule 2: Identify all the Web Elements using Annotations
	
	@FindBy(id="user-name") private WebElement usernameEdt;
	@FindBy(id="password") private WebElement passwordEdt;
	@FindBy(id="login-button") 
	private WebElement loginBtn;
	
	//Rule 3: Create Constructor and initialize the web elements

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Rule 4: Provide Getters to access the webelements

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	/**
	 * This method will perform Login Opeation
	 * @param USERNAME
	 * @param PASSWORD
	 */

	public void loginToApp(String USERNAME, String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME); //data will read from Property file at the time of calling
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
		
	}
	
	
	

	}


