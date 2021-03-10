package testBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import reusableComponents.PropertiesOperations;

public class TestBase extends ObjectRepo{

	public void launchBrowser(String browser) throws IOException {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().clearDriverCache();
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-features=VizDisplayCompositor");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(PropertiesOperations.getPropertyValue("url"));
	}
	

}
