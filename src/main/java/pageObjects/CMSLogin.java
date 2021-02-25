package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class CMSLogin extends TestBase {

	@FindBy(id = "edit-name")
	WebElement txtBox_username;

	@FindBy(id = "edit-pass")
	WebElement txtBox_password;

	@FindBy(id = "edit-submit")
	WebElement btn_submit;

	public CMSLogin() {
		PageFactory.initElements(driver, this);
	}

	public void enterUsername() {
		txtBox_username.sendKeys("automationsuport4");
	}

	public void enterPassword() {
		txtBox_password.sendKeys("123456");

	}

	public void clickSubmit() {
		btn_submit.click();
	}

}
