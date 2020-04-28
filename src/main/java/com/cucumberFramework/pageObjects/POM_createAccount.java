package com.cucumberFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.WaitHelper;

public class POM_createAccount {
	
	private WebDriver driver;
	
	@FindBy(xpath="//h1[text()='Locanda - Create Account']")
	public WebElement headerCreateAccount;
	
	@FindBy(id="firstname")
	public WebElement inputName;
	
	@FindBy(id="surname")
	public WebElement inputLastName;
	
	@FindBy(id="email")
	public WebElement inputemailid;
	
	@FindBy(id="phone")
	public WebElement inputPhoneNumber;
	
	@FindBy(xpath="//span[text()='Create Account']/parent::button")
	public WebElement btnCreateAccount;
	
	@FindBy(xpath="//h1[text()='Locanda - Account created successfully']")
	public WebElement txtCreateAccountSuccessfulMessage;
	
	@FindBy(xpath="//div[@id='home']/p[2]/br[2]")
	public WebElement txtPassword;
	
WaitHelper waitHelper;
	
	public POM_createAccount(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.WaitForElement(userName, 60);
	}
	
	public void fillDetailsinCreateAccount(String name, String lastName, String emailid, String phoneNumber) throws Exception {
		//driver.get().esm.wait(2000);
		Thread.sleep(3000);
		inputName.sendKeys(name);
		inputLastName.sendKeys(lastName);
		inputemailid.sendKeys(emailid);
		inputPhoneNumber.sendKeys(phoneNumber);
		Thread.sleep(5000);
		btnCreateAccount.click();
		Thread.sleep(5000);
		//waitHelper.WaitForElementInvisible(btnCreateAccount, 1000);
		
	}
}
