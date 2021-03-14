package reusableComponents;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentSetup {
	
	
	public static ExtentReports setupExtentReport() {
		SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy HH-mm");
		Date date = new Date();
		String currentDate = sdf.format(date);
		currentDate = System.getProperty("timeStamp") != null && !System.getProperty("timeStamp").trim().equalsIgnoreCase("") ? System.getProperty("timeStamp").trim().toLowerCase() :currentDate;
		String path = System.getProperty("user.dir")+"/Reports/"+currentDate+"/ExecutionReport.html";
		
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setDocumentTitle("Doc Title");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("First report");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		return extent;
		
	}
	

}
