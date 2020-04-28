package com.cucumberFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.testBase.TestBase;

public class POM_LoginPage {
	
	private WebDriver driver;
	
	@FindBy(linkText="Login/Signup")
	public WebElement linkLogin_Signup;
	
	@FindBy(xpath="//h1[text()='The Bookie']")
	public WebElement lblLadingPageHeader;
		
	@FindBy(linkText="Signup")
	public WebElement linkSignup;

	@FindBy(id="email")
	public WebElement inputemailid;
	
	@FindBy(id="password")
	public WebElement inputpassword;
	
	@FindBy(xpath="//span[text()='Log In']/parent::button")
	public WebElement btnLogin;
	
	@FindBy(xpath="//span[text()='Planner']")
	public WebElement lblPlanner;
	
	@FindBy(xpath="//span[text()='Invalid user or password, please reenter']")
	public WebElement errmsg;
	
	
WaitHelper waitHelper;
	
	public POM_LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.WaitForElement(userName, 60);
	}
	
	public void clickonLogin() throws InterruptedException{
		Thread.sleep(2000);
		linkLogin_Signup.click();;
		//waitHelper.WaitForElementInvisible(linkLogin_Signup, 1000);
		Thread.sleep(5000);
	}
	public void navigateToLandingPage() throws InterruptedException{
		this.driver.get(TestBase.config.get("applicationURL"));
		Thread.sleep(5000);
		//waitHelper.WaitForElement(lblLadingPageHeader, 1000);
		//Thread.sleep(5000);
	}
	
	public void clickOnLogin_Signup() throws InterruptedException{
		Thread.sleep(5000);
		linkLogin_Signup.click();
		
		//waitHelper.WaitForElementInvisible(linkLogin_Signup, 1000);
		Thread.sleep(5000);
		//waitHelper.WaitForElement(linkSignup, 1000);
//		waitHelper.WaitForElementToClickable(linkSignup, 1000);
		linkSignup.click();
	Thread.sleep(5000);
		//waitHelper.WaitForElementInvisible(linkSignup, 1000);
		//Thread.sleep(5000);
	}
	
	public void login(String emailid,String password) throws Exception {
		Thread.sleep(5000);
		inputemailid.sendKeys(emailid);
		inputpassword.sendKeys(password);
		btnLogin.click();
		Thread.sleep(5000);
	}
}
