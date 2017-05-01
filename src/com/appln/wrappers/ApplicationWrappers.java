package com.appln.wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ApplicationWrappers extends GenericWrappers {
	@BeforeClass
	public void setUp(){
		invokeApp();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
