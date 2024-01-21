package pageEvents;

import utils.ElementFetch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.GoogleHomePageElements;
import pageObjects.GoogleSearchResultsPageElements;

public class GoogleHomePageEventsUsingPropertiesFile {
	ElementFetch ele=new ElementFetch();
	
		//Validates the title of the page.
		public void validatePageTitle(WebDriver driver) {
			 Properties properties = new Properties();
			  try {
				properties.load(new FileReader("src/test/resources/properties/test.properties"));
				String urlexpected = properties.getProperty("googleurl");
				System.out.println("getting search term from Properties:"+ urlexpected);
				String Expected=urlexpected;
				 String actual = driver.getCurrentUrl();
				if(actual.equals(Expected))
				{
					System.out.println("Assertion passed: URL matches!");
				}else {
		            // Assertion failed
		            System.out.println("Assertion failed: URL does not match!");
		            Assert.fail("Assertion failed: URL does not match!");
		            
		        }
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
	//Enters the specified search query into the Google search box.
	public void googleSearchBox() {
		String searchResults="SDET";
		ele.getWebElement("NAME", GoogleHomePageElements.searchBoxName).sendKeys(searchResults);
		ele.getWebElement("NAME", GoogleHomePageElements.searchButtonName).click();
	}

}
