package pageEvents;

import utils.ElementFetch;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.YahooHomePageElements;

public class YahooHomePageEvents {
	ElementFetch ele=new ElementFetch();
	
	//Enters the specified search query into the Yahoo search box.
	public void yahooSearchBox() {
		String searchResults="SDET";
		ele.getWebElement("NAME", YahooHomePageElements.searchBoxName).sendKeys(searchResults);
		ele.getWebElement("ID", YahooHomePageElements.searchButtonId).click();
	}
	
	// Validates the title of the page.
    public void validatePageTitle(WebDriver driver, String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title match");
    }

}
