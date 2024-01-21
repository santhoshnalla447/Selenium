package utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.BaseTest;

public class SuiteListener implements ITestListener,IAnnotationTransformer{

	// This method is called when a test method fails, and it captures a screenshot.
	public void onTestFailure(ITestResult result) {
		// Define the file path for storing the screenshot based on the test method name.
		String filename=System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+result.getMethod().getMethodName();
		// Capture a screenshot using Selenium's TakesScreenshot interface.
		File f1= ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		// Generate a random file name to avoid overwriting existing screenshots.
		String randomFileName = generateRandomFileName();
		try {
		// Copy the screenshot file to the specified location with the generated file name.
		FileUtils.copyFile(f1, new File(filename+randomFileName+".png"));
		} catch(IOException e) {
			e.printStackTrace();	
		}
	}
	
	private String generateRandomFileName() {
        // Generate a random UUID and convert it to a string
        return UUID.randomUUID().toString();
    }
}
