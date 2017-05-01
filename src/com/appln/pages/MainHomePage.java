package com.appln.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainHomePage extends PageObject  {
	
	@FindBy(how = How.XPATH,using = "//a[contains(text(),'BUS TICKETS')]")
	@CacheLookup
	WebElement LinkInMenUBusTickets;
	
	@FindBy(how = How.XPATH,using ="//input[@id='src']")
	@CacheLookup
	WebElement TextBoxFromCity;
	
	@FindBy(how = How.XPATH,using ="//input[@id='dest']")
	@CacheLookup
	WebElement TextBoxToCity;
	
	@FindBy(how = How.XPATH,using ="//label[@class='db text-trans-uc']")
	@CacheLookup
	WebElement OnwardDate;
	
	@FindBy(how = How.XPATH,using ="//div[@id='rb-calendar_onward_cal']/table[@class='rb-monthTable first last']/tbody/tr/td[@class='current day']")
	@CacheLookup
	WebElement OnwardDateValue;
	
	
	@FindBy(how = How.XPATH,using ="//button[@id='search_btn']")
	@CacheLookup
	WebElement SearchBusButton;
	
	@FindBy(how = How.XPATH,using ="//ul[@class='autoFill']")
	WebElement TextBoxCityResults;
	
	
	public MainHomePage(WebDriver driver) {
		super(driver);
	}
	
	public SearchBusTickets searchBuses(String fromCity,String destinationCity) throws InterruptedException{
		waitForElement("visible",TextBoxFromCity);
		TextBoxFromCity.sendKeys("Bengaluru");
		waitForElement("visible",TextBoxCityResults);
		clickOnResultItem(TextBoxCityResults,"Bengaluru");
		TextBoxToCity.sendKeys("Madurai");
		waitForElement("visible",TextBoxCityResults);
		clickOnResultItem(TextBoxCityResults,"Madurai");
		/*waitForElement("visible",OnwardDate);
		OnwardDate.click();
		*/jsscriptExecutor(OnwardDateValue,"hidden");
		SearchBusButton.click();
		Thread.sleep(8000);
		return new SearchBusTickets(driver);
	}

	
	
	
}
