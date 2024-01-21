package qa.tests;

import org.testng.annotations.Test;
import com.qa.base.BaseTest;

import pageEvents.YahooHomePageEvents;
import pageEvents.YahooSearchResultsPageEvents;
import utils.ElementFetch;
import utils.TakeScreenshot;

public class searchResultsYahoo extends BaseTest{
	ElementFetch ele=new ElementFetch();
	YahooHomePageEvents homePage=new YahooHomePageEvents();
	YahooSearchResultsPageEvents resultsPage=new YahooSearchResultsPageEvents();
	TakeScreenshot screen =new TakeScreenshot();
	

	/*
	 * Author: Santhosh Nalla
	 * Jira Number: JIRA-*
	 * Description: This test case is written to verify the search results on the Yahoo search engine.
	 */
  @Test(priority = 1)
  public void sampleMethodForSearchingResultsYahoo() {
	  
	  log.info("TestMethod: Entering Test Method");
	// Validates Page Title
	  String expectedTitle="Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";
	  homePage.validatePageTitle(driver,expectedTitle);
	  
	// Perform a search on the Yahoo search engine using the search box.
	  homePage.yahooSearchBox();
	  
	// Capture a screenshot at this point in the test.
	  screen.screenshot();
	  
	// Verify that the search results page is displayed.
	  resultsPage.verifyResultsPage(); 
	  
	// Verify the test results on the search results page.
	  resultsPage.verifyTestResults();
	  
  }
}
