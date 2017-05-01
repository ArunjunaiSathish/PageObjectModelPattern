package com.appln.pages;

import org.openqa.selenium.WebDriver;

public class SearchBusTickets extends PageObject{
	
	public SearchBusTickets(WebDriver driver){
		super(driver);
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
}
