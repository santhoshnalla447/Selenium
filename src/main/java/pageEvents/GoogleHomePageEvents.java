package pageEvents;

import utils.ElementFetch;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.GoogleHomePageElements;

public class GoogleHomePageEvents {
	ElementFetch ele=new ElementFetch();
	
	//Enters the specified search query into the Google search box.
	public void googleSearchBox() {
		String searchResults="SDET";
		ele.getWebElement("NAME", GoogleHomePageElements.searchBoxName).sendKeys(searchResults);
		ele.getWebElement("NAME", GoogleHomePageElements.searchButtonName).click();
	}
	
	// Validates the title of the page.
    public void validatePageTitle(WebDriver driver, String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title match");
    }

}
