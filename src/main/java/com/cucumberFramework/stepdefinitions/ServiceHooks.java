package com.cucumberFramework.stepdefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumberFramework.enums.Browsers;
import com.cucumberFramework.helper.FileRead;
import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class ServiceHooks {

	TestBase testBase;

	Logger log = LoggerHelper.getLogger(ServiceHooks.class);

	@Before
	public void initializeTest() throws FileNotFoundException, IOException {
		TestBase.config = FileRead.readProperties();
		testBase = new TestBase();
		if(TestBase.config.get("seleniumEnvironment").equalsIgnoreCase("local"))
			testBase.selectBrowser(Browsers.CHROME.name());
		else if(TestBase.config.get("seleniumEnvironment").equalsIgnoreCase("grid"))
			testBase.grid();
	}

	@After
	public void endTest(Scenario scenario) {
		if (scenario.isFailed()) {

			try {
				log.info(scenario.getName() + " is Failed");
				if (TestBase.driver != null){
					final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
					scenario.embed(screenshot, "image/png"); // ... and embed it in
				}
				
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				log.info(scenario.getName() + " is pass");
				scenario.embed(((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES), "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		TestBase.driver.quit();
	}
}
