package genericutilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * This class consists of Generic methods related to Selenium
 * @author Kavya
 */

public class Selenium_utility {
	/**
	 * This method will maximize the window.
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * THis method will minimize the window
	 * @param driver
	 */
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
/*
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void addExplicitlyWait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	*/
	/**
	 * THis method will handle dropdown by Index
	 * @param element
	 * @param index
	 */
public void handleDropdown(WebElement element, int index)
{
	Select sel=new Select(element);
	sel.selectByIndex(index);	
}
/**
 *  This method will handle dropdown by value
 * @param element
 * @param value
 */
public void handleDropdown(WebElement element, String value )
{
	Select sel=new Select(element);
	sel.selectByVisibleText(value);
}
/**
 * This method will handle dropdown by visibletext
 * @param visibletext
 * @param element
 */
public void handleDropdown(String visibletext, WebElement element)
{
	Select sel=new Select(element);
	sel.selectByVisibleText(visibletext);
}
/**
 * This method will perform Mousehover action.
 * @param driver
 * @param element
 */
public void mouseHoverAction(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 *  This method will perform Doubleclick action.
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}
/**
 *  This method will perform Right click action.
 * @param driver
 * @param element
 */

public void rightClickAction(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
}
/**
 *  This method will perform Click action.
 * @param driver
 * @param element
 */

public void ClickAction(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.click(element).perform();
}
/**
 *  This method will perform ClickandHold action.
 * @param driver
 * @param element
 */

public void clickAndHoldAction(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.clickAndHold(element).perform();
}
/**
 *  This method will perform Drag and Drop action.
 * @param driver
 * @param element
 */

public void rightClickAction(WebDriver driver, WebElement source, WebElement destiny)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(source, destiny).perform();
}
/**
 *  This method will perform Scroll To Particular Element action.
 * @param driver
 * @param element
 */

public void scrollToElementAction(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.scrollToElement(element).perform();
}


/**
 * This method will handle frame by index
 * @param driver
 * @param index
 */
public void handleFrame(WebDriver driver, int index)
{
	driver.switchTo().frame(index);
}
/**
 * This method will handle frame by Id or Name
 * @param driver
 * @param index
 */
public void handleFrame(WebDriver driver, String idOrName)
{
	driver.switchTo().frame(idOrName);
}
/**
 * This method will handle frame by element
 * @param driver
 * @param index
 */
public void handleFrame(WebDriver driver, WebElement element)
{
	driver.switchTo().frame(element);
}

/**
 * This method will switch to Parent Frame
 */
public void switchToParent(WebDriver driver)
{
	driver.switchTo().parentFrame();
}

/**
 * This method will switch to Parent Frame
 *  @param driver
 */
public void switchToMainPage(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/**
 * This method will randomly scrollup by 500 units
 * @param driver
 */
public void scrollUpAction(WebDriver driver)
{
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,-500);","");
}

/**
 * This method will randomly scrolldown by 500 units
 * @param driver
 */
public void scrollDownAction(WebDriver driver)
{
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500);","");
}
/**
 * THis method will be used to Scroll to particular element using Java Script Executor
 * @param driver
 * @param element
 */
public void scrollToElementJavaScriptExecutor(WebDriver driver, WebElement element)
{
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();",element);
}
/**
 * This method will be used to take Screenshots and return the path.
 * @param driver
 * @param screenshotName
 * @return 
 * @throws IOException 
 */

public String captureScreenshot(WebDriver driver, String screenshotName) throws IOException
{
	TakesScreenshot ts= (TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dst=new File("D:\\QSPIDERS\\Eclipse\\AutomationFramework.QCO-SOEAJD-E12\\Screenshots"+screenshotName+".png");
	Files.copy(src,dst);
	return dst.getAbsolutePath(); //It will be used for Extent reports which will be a 3rd party tool and will be explanin
	
}


}