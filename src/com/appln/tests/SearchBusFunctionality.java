package com.appln.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appln.pages.MainHomePage;
import com.appln.pages.SearchBusTickets;
import com.appln.wrappers.ApplicationWrappers;
import com.appln.wrappers.GenericWrappers;

public class SearchBusFunctionality extends ApplicationWrappers {
	@Test
	public void searchBusTicket() throws InterruptedException {
		MainHomePage homePage = new MainHomePage(driver);
		SearchBusTickets searchBusTicketsPage = homePage.searchBuses("Bengaluru", "Madurai");
		Assert.assertEquals(searchBusTicketsPage.getPageTitle(), "Search Bus Tickets");
	}
}
