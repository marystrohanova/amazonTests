package framework.page;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.FrameworkBase;

public class AmazonFrontPage {	
	String url = "http://amazon.com";
	
	By accountBtn = new By.ByCssSelector("a#nav-link-yourAccount");
	By signInBtn = new By.ByCssSelector("span.nav-action-inner");
	By spanLogo = new By.ByCssSelector("span.nav-logo-base");
	By spanUserName = new By.ByXPath("//span[text()[contains(.,'Hello')]]");
	By inputSearch = new By.ByCssSelector("input#twotabsearchtextbox");
	By spanUserAccount = new By.ByXPath("//*[@id='nav-flyout-yourAccount']/div[2]/a[1]/span");
	
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	public AmazonFrontPage(){
		this.driver = FrameworkBase.driverCabinet.get();
		this.wait = new WebDriverWait(driver, 10);
	}
	
	public void open(){
		System.out.println("Opening page: " + url);
		driver.get(url);
	}
	
	public void assertPageLoaded(){
		String text = "Amazon";
		String logoText = driver.findElement(spanLogo).getText();
		Assert.assertEquals("Strings didn't match", text, logoText);

	}
	
	public void hoverAccountBtn(){
		WebElement weSignIn = driver.findElement(accountBtn);
		Actions actions = new Actions(driver);
		
		actions.moveToElement(weSignIn).perform();
	}
	
	public void clickSignInBtn(){
		WebElement weSignInBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn));
		weSignInBtn.click();
	}
	
	public void assertUserSignedIn(String name){
		wait.until(ExpectedConditions.visibilityOfElementLocated(spanUserName));
		String spanText = driver.findElement(spanUserName).getText();
		Assert.assertEquals("Strings didn't match", "Hello, " + name, spanText);
	}
	
	public void searchFor(String text) {
		driver.findElement(inputSearch).sendKeys(text + Keys.ENTER);
	}
	
	public void goToUserAccount(){
		WebElement weAccountLink = wait.until(ExpectedConditions.elementToBeClickable(spanUserAccount));
		weAccountLink.click();
	}
	
}
