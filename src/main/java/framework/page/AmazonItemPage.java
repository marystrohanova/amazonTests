package framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.FrameworkBase;

public class AmazonItemPage {
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	By inputAddBtn = new By.ByCssSelector("#add-to-cart-button");
	
	public AmazonItemPage(){
		this.driver = FrameworkBase.driverCabinet.get();
		this.wait = new WebDriverWait(driver, 10);
	}
	
	public void addToShopingCart(){
		WebElement weAddBtn = wait.until(ExpectedConditions.elementToBeClickable(inputAddBtn));
		weAddBtn.click();
	}

}
