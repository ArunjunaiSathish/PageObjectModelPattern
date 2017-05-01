package com.appln.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.appln.wrappers.ApplicationWrappers;

public class PageObject extends ApplicationWrappers {
	protected WebDriver driver;
	
	public PageObject(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
