package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import testBase.ObjectRepo;

public class ListenersImplementation extends ObjectRepo implements ITestListener{
	
	

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case "+ result.getMethod().getMethodName()+" is passed");
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String currentDate = sdf.format(date);
		String path = System.getProperty("user.dir")+"/Reports/ScreenShots/Screenshot"+currentDate+".jpeg";
		File destination = new File(path);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName()+" is passed");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case "+ result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String currentDate = sdf.format(date);
		currentDate = System.getProperty("timeStamp") != null && !System.getProperty("timeStamp").trim().equalsIgnoreCase("") ? System.getProperty("timeStamp").trim().toLowerCase() :currentDate;
		String path = System.getProperty("user.dir")+"/Reports/ScreenShots/Screenshot"+currentDate+".jpeg";
		File destination = new File(path);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName()+" is failed");
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		extent = ExtentSetup.setupExtentReport();
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
