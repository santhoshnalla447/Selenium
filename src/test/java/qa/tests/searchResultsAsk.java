package qa.tests;

import org.testng.annotations.Test;
import com.qa.base.BaseTest;

import pageEvents.AskHomePageEvents;
import pageEvents.AskSearchResultsPageEvents;
import utils.ElementFetch;
import utils.TakeScreenshot;

public class searchResultsAsk extends BaseTest{
	ElementFetch ele=new ElementFetch();
	AskHomePageEvents homePage=new AskHomePageEvents();
	AskSearchResultsPageEvents resultsPage=new AskSearchResultsPageEvents();
	TakeScreenshot screen =new TakeScreenshot();
	
	/*
	 * Author: Santhosh Nalla
	 * Jira Number: JIRA-*
	 * Description: This test case is written to verify the search results on the Ask search engine.
	 */
  @Test(priority = 1)
  public void sampleMethodForSearchingResultsAsk() {
	  log.info("TestMethod: Entering Test Method");
	 // Validates Page Title
	  String expectedtitle="Ask.com - What's Your Question?";
	  homePage.validatePageTitle(driver, expectedtitle);
	  
	// Perform a search on the Ask search engine using the search box.
	  homePage.askSearchBox();
	  
	// Capture a screenshot at this point in the test.
	  screen.screenshot();
	  
	// Verify that the search results page is displayed.
	  resultsPage.verifyResultsPage(); 
	  
	// Verify the test results on the search results page.
	  resultsPage.verifyTestResults();
	  
  }
}
