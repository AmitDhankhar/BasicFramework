package testCases;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.HashMap;

import pageObjects.HomePage;
import reusableComponents.ExcelOps;
import reusableComponents.PropertiesOperations;
import testBase.TestBase;


public class HomePageTC extends TestBase{
	 
	ExcelOps excel = new ExcelOps();
	
	@BeforeMethod
	public void setUp() throws IOException {
		launchBrowser(PropertiesOperations.getPropertyValue("browser"));
	}
	
	
	@Test(dataProvider = "testData")
	public void demoMenu(Object obj) {
		HashMap<String,String> hm = (HashMap<String, String>) obj;
		homePage = new HomePage();
		//homePage.clickClose();
		homePage.clickForm();		
		homePage.clicksimpleFormDemo();
		homePage.typeenterMsgTextBox(hm);
		homePage.clicksenterMsgButton();
		Assert.assertEquals(homePage.message(), hm.get("TC_Data"));
		homePage.clickProgressbar11();
		homePage.clickBootstrapProgress1();
		homePage.clickclickDownloadbtn11();
		
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
	
	@DataProvider(name="testData")
	public Object[][] getTestData() throws EncryptedDocumentException, IOException{
		Object[][] obj = new Object[excel.getRowCount()][1];
		 for (int i=1;i<=excel.getRowCount();i++) {			 
			 HashMap<String,String> hm = excel.getTestDataInMap(i);
			 obj[i-1][0] =hm;
		 }		
		return obj;
	}
	

}
