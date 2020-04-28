Feature: CreateNewAccount
   Customer has ability to register to Locanda application.

  @CreateNewAccount
  Scenario: Customer registers to Locanda application and able o login
    Given customer is on landing page of Locanda Application
    When customer create a new account in Locanda
    Then custome able to login with newly ceated account
    
   # @UserAlreadyRegistered
    #Scenario: Customer tries to re-registers to Locanda application with same details
    #Given customer is on landing page of Locanda Application
	  #Then customer is not allowed to create new accout with already registerd details
