package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[@id='navbar-brand-centered']//a[contains(text(),'Input Forms')]")
	WebElement inputForm;

	@FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'Simple Form Demo')]")
	WebElement simpleFormDemo;

	@FindBy(xpath = "//form[@id='get-input']//input")
	WebElement enterMsgTextBox;

	@FindBy(xpath = "//form[@id='get-input']//button")
	WebElement enterMsgButton;
	
	@FindBy(xpath = "//label[text()='Your Message: ']//following-sibling::span")
	WebElement checkMsg;
	
	@FindBy(id = "at-cv-lightbox-close")
	WebElement closePopup;
	
	//
	
	@FindBy(xpath = "//div[@id='navbar-brand-centered']//a[contains(text(),'Progress Bars')]")
	WebElement Progressbar;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'Bootstrap Progress bar')]")
	WebElement BootstrapProgress;
	
	@FindBy(id = "cricle-btn")
	WebElement clickDownloadbtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void clickForm() {
		inputForm.click();
	}

	public void clicksimpleFormDemo() {
		simpleFormDemo.click();

	}

	public void typeenterMsgTextBox() {
		enterMsgTextBox.sendKeys("hello");
	}
	
	public void clicksenterMsgButton() {
		enterMsgButton.click();
	}
	
	public String message() {
		return checkMsg.getText();
	}

	public void clickClose() {
		closePopup.click();
	}
	
	public void clickProgressbar11() {
		Progressbar.click();
	}
	
	public void clickBootstrapProgress1() {
		BootstrapProgress.click();
	}
	
	public void clickclickDownloadbtn11() {
		clickDownloadbtn.click();
	}

	public void clickclickDownloadbtn1() {
		// TODO Auto-generated method stub
		
	}

	

	
}
