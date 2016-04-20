package framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import framework.configuration.PropertiesLoader;

public class DriverManager {
	public static RemoteWebDriver getDriver(){
		RemoteWebDriver driver = null;
		String browser = PropertiesLoader.getValue("browser");
		
		switch (browser) {
		case "chrome":
			System.out.println("Browser requested: Chrome.");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.out.println("Browser requested: Firefox.");
			driver = new FirefoxDriver();
			break;
		default:
			String msg = "Unknown browser requested: " + browser;
			System.out.println(msg);
			Assert.fail(msg);
			break;
		}
		return driver;
	}
}
