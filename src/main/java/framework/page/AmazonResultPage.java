package framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.FrameworkBase;

public class AmazonResultPage {
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	By primeLabel = new By.ByCssSelector
			("#result_0 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > i:nth-child(5)");
	By bestSeller = new By.ByCssSelector
			("#result_0 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > span:nth-child(1) > a:nth-child(1) > i:nth-child(1)");
	By linkToItem = new By.ByCssSelector("a.a-link-normal.s-access-detail-page");
	public AmazonResultPage(){
		this.driver = FrameworkBase.driverCabinet.get();
		this.wait = new WebDriverWait(driver, 10);
	}
	
	public void assertFirstResultHasPrime(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(primeLabel));
	}
	
	public void goToItem(){
		driver.findElement(linkToItem).click();
	}
	
	public void assertFirstResultHasBestSeller(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(bestSeller));
	}
}
