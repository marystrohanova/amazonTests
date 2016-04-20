package framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.FrameworkBase;

public class AmazonSignInPage {
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	By formSingIn = new By.ByCssSelector("form[name='signIn']");
	By inputEmail = new By.ByCssSelector("input#ap_email");
	By inputPassword = new By.ByCssSelector("input#ap_password");
	By inputSignIn = new By.ByCssSelector("input#signInSubmit");
	
	public AmazonSignInPage(){
		this.driver = FrameworkBase.driverCabinet.get();
		this.wait = new WebDriverWait(driver, 20);
	}
	
	public void signInWith(String email, String password){
		wait.until(ExpectedConditions.visibilityOfElementLocated(formSingIn));
		
		driver.findElement(inputEmail).sendKeys(email);
		driver.findElement(inputPassword).sendKeys(password);
		driver.findElement(inputSignIn).click();
	}
}
