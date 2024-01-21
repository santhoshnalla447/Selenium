package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.base.BaseTest;

public class ElementFetch {
	
	
	/*
	 * Retrieves a single WebElement based on the provided identifier type and value.
	 * @param identifierType The type of identifier (XPATH, CSS, ID, NAME, TAGNAME).
	 * @param identifierValue The value of the identifier.
	 * @return WebElement corresponding to the specified identifier.
	 */
	public WebElement getWebElement(String identifierType, String identifierValue) {
		switch(identifierType) {
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(identifierValue));
		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(identifierValue));
		case "ID":
			return BaseTest.driver.findElement(By.id(identifierValue));
		case "NAME":
			return BaseTest.driver.findElement(By.name(identifierValue));
		case "TAGNAME":
			return BaseTest.driver.findElement(By.tagName(identifierValue));
			default:
				return null;
		}	
	}
	
	/*
	 * Retrieves a list of WebElements based on the provided identifier type and value.
	 * @param identifierType The type of identifier (XPATH, CSS, ID, NAME, TAGNAME).
	 * @param identifierValue The value of the identifier.
	 * @return List of WebElements corresponding to the specified identifier.
	 */
	public List<WebElement> getWebElements(String identifierType, String identifierValue) {
		switch(identifierType) {
		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(identifierValue));
		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(identifierValue));
		case "ID":
			return BaseTest.driver.findElements(By.id(identifierValue));
		case "NAME":
			return BaseTest.driver.findElements(By.name(identifierValue));
		case "TAGNAME":
			return BaseTest.driver.findElements(By.tagName(identifierValue));
			default:
				return null;
		}	
	}

}
