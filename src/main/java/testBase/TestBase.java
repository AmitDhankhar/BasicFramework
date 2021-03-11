package testBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import reusableComponents.PropertiesOperations;

public class TestBase extends ObjectRepo{

	public void launchBrowser(String browser) throws IOException {

		if (browser.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().clearDriverCache();
			//WebDriverManager.chromedriver().setup();
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("--disable-features=VizDisplayCompositor");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setCapability("marionette", true);
		    FirefoxOptions options = new FirefoxOptions();
		    options.merge(capabilities);
		    driver = new FirefoxDriver(options);
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(PropertiesOperations.getPropertyValue("url"));
	}
	

}
