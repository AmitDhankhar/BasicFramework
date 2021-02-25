package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CMSLogin;
import reusableComponents.PropertiesOperations;
import testBase.TestBase;


public class CMSLoginTC extends TestBase{
	
	CMSLogin cmsLogin = new CMSLogin();
	
	@BeforeMethod
	public void setUp() throws IOException {
		launchBrowser(PropertiesOperations.getPropertyValue("browser"));
	}
	
	
	@Test(priority = 0)
	public void login() {
		System.out.println("Page Title: "+driver.getTitle());
		
		/*
		 * cmsLogin.enterUsername(); cmsLogin.enterPassword(); cmsLogin.clickSubmit();
		 */
	}
	
	@Test(priority = 1)
	public void getCurrentUrl() {
		System.out.println("Page url: "+driver.getCurrentUrl());
		
		/*
		 * cmsLogin.enterUsername(); cmsLogin.enterPassword(); cmsLogin.clickSubmit();
		 */
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
