package framework;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class FrameworkBase {
	public static ThreadLocal<RemoteWebDriver> driverCabinet = 
			new ThreadLocal<RemoteWebDriver>();

	@BeforeMethod
	public void setup(){
		System.out.println("Starting driver.");
		RemoteWebDriver driver = DriverManager.getDriver();
		driverCabinet.set(driver);
	}

	@AfterMethod
	public void tearDown(){
		System.out.println("Closing driver.");
		RemoteWebDriver driver = driverCabinet.get();
		driver.quit();
	}

}
