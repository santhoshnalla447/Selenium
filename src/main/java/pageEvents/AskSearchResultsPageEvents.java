package pageEvents;

import org.testng.Assert;
import pageObjects.AskSearchResultsPageElements;
import utils.ElementFetch;

public class AskSearchResultsPageEvents {
ElementFetch ele=new ElementFetch();
	
	//Verifies the presence of results on the search results page.
	public void verifyResultsPage() {
		Assert.assertTrue(ele.getWebElements("XPATH", AskSearchResultsPageElements.resultsXpath).size()>0,"Results Found");	
	}
	
	/*
     * Verifies that the actual search result text contains the expected text.
     * Prints a message indicating whether the assertion passed or failed.
     */
	
	public void verifyTestResults() {
		String Expected="SDET";
		String Actual=ele.getWebElement("XPATH", AskSearchResultsPageElements.resultsXpath).getText();
		if(Actual.contains(Expected))
		{
			System.out.println("Assertion passed: Text matches!");
		}else {
            // Assertion failed
            System.out.println("Assertion failed: Text does not match!");
            Assert.fail("Assertion failed: Text does not match!");
            
        }
		
	}

}
