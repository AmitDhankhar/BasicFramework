package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import pageObjects.HomePage;
import reusableComponents.PropertiesOperations;
import testBase.TestBase;


public class HomePageTC extends TestBase{
	 
	
	@BeforeMethod
	public void setUp() throws IOException {
		launchBrowser(PropertiesOperations.getPropertyValue("browser"));
	}
	
	
	@Test(priority = 0)
	public void demoMenu() {
		homePage = new HomePage();
		homePage.clickClose();
		homePage.clickForm();		
		homePage.clicksimpleFormDemo();
		homePage.typeenterMsgTextBox();
		homePage.clicksenterMsgButton();
		homePage.clickProgressbar11();
		homePage.clickBootstrapProgress1();
		homePage.clickclickDownloadbtn11();
	//	Assert.assertEquals(homePage.message(), "hello");
	}
	
	@Test(enabled = false)
	public void getCurrentUrl() {
		System.out.println("Page url: "+driver.getCurrentUrl());
		Assert.assertEquals(1, 2);
		
		/*
		 * cmsLogin.enterUsername(); cmsLogin.enterPassword(); cmsLogin.clickSubmit();
		 */
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
