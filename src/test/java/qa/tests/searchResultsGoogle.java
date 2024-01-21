package qa.tests;

import org.testng.annotations.Test;
import com.qa.base.BaseTest;

import pageEvents.GoogleHomePageEvents;
import pageEvents.GoogleSearchResultsPageEvents;
import utils.ElementFetch;
import utils.TakeScreenshot;

public class searchResultsGoogle extends BaseTest{
	ElementFetch ele=new ElementFetch();
	GoogleHomePageEvents homePage=new GoogleHomePageEvents();
	GoogleSearchResultsPageEvents resultsPage=new GoogleSearchResultsPageEvents();
	TakeScreenshot screen =new TakeScreenshot();
	
	/*
	 * Author: Santhosh Nalla
	 * Jira Number: JIRA-*
	 * Description: This test case is written to verify the search results on the Google search engine.
	 */
	
  @Test(priority = 1)
  public void sampleMethodForSearchingResultsGoogle() {
	 
	  log.info("TestMethod: Entering Test Method");
	// Validates Page Title
	  homePage.validatePageTitle(driver, "Google");
	  
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
