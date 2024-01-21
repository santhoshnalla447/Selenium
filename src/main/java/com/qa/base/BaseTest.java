package com.qa.base;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.constants;

public class BaseTest {
	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public static final Logger log = LogManager.getLogger(BaseTest.class);
	
	// This method is executed before the test suite starts.. initializing the Extent Reports framework
	@BeforeTest
	public void beforeTestMethod() {
		log.info("BeforeTest: Initializing extent reports...");
		
		// Using a timestamp in the report file name
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String reportFileName = "reports/extent-report_" + timestamp + ".html";
		sparkReporter = new ExtentSparkReporter(reportFileName);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Automation Test Results");       
	}
	
	// This method sets up the WebDriver based on the specified browser
	public void setupDriver(String browser) {
		log.info("Setting webDriver...");
	    switch(browser.toLowerCase()) {
	        case "chrome":
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            break;
	        case "edge":
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	            break;
	        case "firefox":
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	            break;
	        default:
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	            break;
	            
	    }
	}

	// This method is executed before each test method and initializes the WebDriver
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser,Method testMethod) {
		log.info("BeforeMethod: Initializing Web Driver...");
		logger=extent.createTest(testMethod.getName());
		setupDriver(browser);
		driver.manage().window().maximize();
		driver.get(constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	// This method is executed after each test method and logs the result in the extent report
	@AfterMethod
		public void afterMethod(ITestResult result){
		log.info("AfterMethod: Log result in extent reports...");
			if(result.getStatus() == ITestResult.FAILURE){
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "-Test Case Failed", ExtentColor.RED));
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "-Test Case Failed", ExtentColor.RED));
			}else if(result.getStatus() == ITestResult.SKIP){
				logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "-Test Case Skipped", ExtentColor.ORANGE));
			}else if(result.getStatus() == ITestResult.SUCCESS){
				logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "-Test Case PASS", ExtentColor.GREEN));
			}
		}
	
	// This method is executed after the test suite completes, flushing the extent reports and quitting the WebDriver
	@AfterTest
	public void afterTest() {
		log.info("AfterTest: Flushing extent reports...");
		extent.flush();
		driver.quit();
		}
	}
