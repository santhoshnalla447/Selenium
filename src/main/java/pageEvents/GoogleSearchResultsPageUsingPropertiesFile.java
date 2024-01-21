package pageEvents;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.GoogleSearchResultsPageElements;
import utils.ElementFetch;

public class GoogleSearchResultsPageUsingPropertiesFile {
ElementFetch ele=new ElementFetch();

	// Verifies the presence of results on the search results page.
	public void verifyResultsPage() {
		Assert.assertTrue(ele.getWebElements("XPATH", GoogleSearchResultsPageElements.resultsXpath).size()>0,"Results Found");	
	}
	
	/*
     * Verifies that the actual search result text contains the expected text.
     * Prints a message indicating whether the assertion passed or failed.
     */
	public void verifyTestResults() {
		 Properties properties = new Properties();
		  try {
			properties.load(new FileReader("src/test/resources/properties/test.properties"));
			String searchTerm = properties.getProperty("searchresults");
			System.out.println("getting search term from Properties:"+ searchTerm);
			String Expected=searchTerm;
			String Actual=ele.getWebElement("XPATH", GoogleSearchResultsPageElements.resultsXpath).getText();
			if(Actual.contains(Expected))
			{
				System.out.println("Assertion passed: Text matches!");
			}else {
	            // Assertion failed
	            System.out.println("Assertion failed: Text does not match!");
	            Assert.fail("Assertion failed: Text does not match!");
	            
	        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
