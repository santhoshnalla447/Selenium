package qa.tests;

import org.testng.annotations.Test;
import com.qa.base.BaseTest;

import pageEvents.GoogleHomePageEvents;
import pageEvents.GoogleHomePageEventsUsingPropertiesFile;
import pageEvents.GoogleSearchResultsPageUsingPropertiesFile;
import utils.ElementFetch;
import utils.TakeScreenshot;

public class searchResultsGoogleUsingPropertiesFile extends BaseTest{
	ElementFetch ele=new ElementFetch();
	GoogleHomePageEventsUsingPropertiesFile homePage=new GoogleHomePageEventsUsingPropertiesFile();
	GoogleSearchResultsPageUsingPropertiesFile resultsPage=new GoogleSearchResultsPageUsingPropertiesFile();
	TakeScreenshot screen =new TakeScreenshot();
	
	/*
	 * Author: Santhosh Nalla
	 * Jira Number: JIRA-*
	 * Description: This test case is written to verify the search results on the Google search engine by getting search term from properties file.
	 */
	
  @Test(priority = 1)
  public void sampleMethodForSearchingResultsGoogleProperties() {
	    
	  log.info("TestMethod: Entering Test Method");
	  // Validate Page Title
	  homePage.validatePageTitle(driver);
	  
	// Perform a search on the Google search engine using the search box.
	  homePage.googleSearchBox();
	  
	// Capture a screenshot at this point in the test.
	  screen.screenshot();
	  
	// Verify that the search results page is displayed.
	  resultsPage.verifyResultsPage(); 
	  
	// Verify the test results on the search results page.
	  resultsPage.verifyTestResults();
	  
  }
}
