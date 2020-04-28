package com.cucumberFramework.stepdefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.*;
import com.cucumberFramework.testBase.TestBase;


public class Steps_createAccount extends TestBase {
	
	private String name="Annie1123";
	private String lastName="Besant112";
	private String emailid="Annei2234@wipro.com";
	private String phoneNumber="4845484373123";
	
	POM_LoginPage loginPage = new POM_LoginPage(driver);
	POM_createAccount createPage = new POM_createAccount(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	
	
	@Given("customer is on landing page of Locanda Application")
	public void customer_is_on_landing_page_of_Locanda_Application() throws Exception {
		
		loginPage.navigateToLandingPage();
	
	}

	@When("customer create a new account in Locanda")
	public void customer_create_a_new_account_in_Locanda() throws Exception {
		loginPage.clickOnLogin_Signup();
		createPage.fillDetailsinCreateAccount(name,lastName,emailid,phoneNumber);
			
	}

	@Then("custome able to login with newly ceated account")
	public void custome_able_to_login_with_newly_ceated_account() throws Exception {
		loginPage.clickonLogin();
		loginPage.login(emailid,"");
		
	}

	@Then("customer is not allowed to create new accout with already registerd details")
	public void customer_is_not_allowed_to_create_new_accout_with_already_registerd_details() throws Exception {
		loginPage.clickOnLogin_Signup();
		createPage.fillDetailsinCreateAccount(name,lastName,emailid,phoneNumber);
	}

	@When("customer tries to login with invalid credentails")
	public void customer_tries_to_login_with_invalid_credentails() throws Exception {
		loginPage.clickonLogin();
		loginPage.login(emailid,"password");
	}

	@Then("customer is not allowed to login")
	public void customer_is_not_allowed_to_login() {
		Assert.assertTrue(loginPage.errmsg.isDisplayed());
	}
	
	
}
