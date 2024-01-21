package utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.qa.base.BaseTest;

public class TakeScreenshot {
	
	//Captures a screenshot using Selenium and saves it to the specified directory with a random filename.
	public void screenshot() {
		String filename=System.getProperty("user.dir")+File.separator+"screenshots"+File.separator;
		File f1= ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		String randomFileName = generateRandomFileName();
		try {
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
