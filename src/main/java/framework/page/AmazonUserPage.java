package framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.FrameworkBase;

public class AmazonUserPage {
	By changeAccLink = new By.ByXPath("//div[3]/div/div/div[2]/div/div[1]/ul/li[1]/a");
	By divUserName = new By.ByXPath("//*[@id='cnep_1a_name_form']/div/div/div[1]/div[2]");

	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	public AmazonUserPage(){
		this.driver = FrameworkBase.driverCabinet.get();
		this.wait = new WebDriverWait(driver, 20);
	}
	
	public void goToChangeAccStngs(){
		WebElement weChangeAccLink = wait.until(ExpectedConditions.elementToBeClickable(changeAccLink));
		weChangeAccLink.click();
	}
	
	public String getUserName(){
		WebElement weUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(divUserName));
		String userName = weUserName.getText();
		return userName;
	}
}
