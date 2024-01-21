package pageEvents;

import utils.ElementFetch;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.AskHomePageElements;


public class AskHomePageEvents {
	ElementFetch ele=new ElementFetch();
	
	// Validates the title of the page.
    public void validatePageTitle(WebDriver driver, String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title match");
    }
	
	//Enters the specified search query into the Ask search box.
	public void askSearchBox() {
		String searchResults="SDET";
		ele.getWebElement("XPATH", AskHomePageElements.searchBoxXpath).sendKeys(searchResults);
		ele.getWebElement("XPATH", AskHomePageElements.searchButtonXpath).click();
	}

}
