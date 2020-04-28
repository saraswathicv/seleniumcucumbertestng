package com.cucumberFramework.testBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.*;

import com.cucumberFramework.enums.Browsers;
import com.cucumberFramework.enums.OS;
import com.cucumberFramework.stepdefinitions.ServiceHooks;


public class TestBase {

	public  static WebDriver driver;
	public static Map<String, String> config;
	
	public WebDriver selectBrowser(String browser) {
		if (System.getProperty("os.name").toLowerCase().contains(OS.WINDOW.name().toLowerCase())) {
			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
		} else if (System.getProperty("os.name").toLowerCase().contains(OS.MAC.name().toLowerCase())) {
			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
				System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver");
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
	
	public WebDriver grid() throws MalformedURLException {
		
		String hubURL = TestBase.config.get("seleniumHub");
		System.out.println("sara"+ hubURL);
		
		
		

				 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    capabilities.setBrowserName("chrome");
	    capabilities.setPlatform(Platform.LINUX);
	    driver = new RemoteWebDriver(new URL(hubURL), capabilities);

		return driver;
	}
}
