package com.appln.wrappers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericWrappers {

	public Properties config;
	public static String appUrl;
	public String browser;
	public static WebDriver driver;

	public GenericWrappers() {
		config = new Properties();
		try {
			config.load(new FileInputStream("./properties/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		appUrl = config.getProperty("Appln_URL");
		browser = config.getProperty("Browser");
	}

	public boolean invokeApp() {
		boolean flag = false;
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Arun\\Pictures\\LinkedInPostSharing\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setBrowserName(browser);
			capabilities.setPlatform(Platform.WINDOWS);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			driver.get(appUrl);
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			if (!driver.getWindowHandle().equalsIgnoreCase("")) {
				if (driver.getTitle().equalsIgnoreCase(
						"Online Bus tickets Booking, Book Volvo AC Bus Tickets, Confirmed Bus Reservation"))
					flag = true;
			}
		}
		return flag;
	}

	public void waitForElement(String elementState, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		switch (elementState) {
		case "visible":
			wait.until(ExpectedConditions.visibilityOf(element));
			break;
		default:
			System.out.println("Element State in correct");
		}
	}

	public boolean jsscriptExecutor(WebElement element, String elementState) {
		boolean flag = false;
		String jse = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (elementState.equalsIgnoreCase("hidden")) {
			js.executeScript(jse, element);
			element.click();
		} else if (elementState.equalsIgnoreCase("generalclick")) {
			js.executeScript("arguments[0].click();", element);

		}

		return flag;
	}

	public boolean clickOnResultItem(WebElement element, String valueToSelect) {
		boolean flag = false;
		try {
			List<WebElement> elements = element.findElements(By.tagName("li"));
			for (WebElement e : elements) {
				if (e.getText().equals(valueToSelect)) {
					e.click();
					flag = true;
				}
			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
