Feature: LoginFailureCases
   Customer has ability to register to Locanda application.
    

	  
	  @loginWthInvalidCredentails
		Scenario: Customer tries login to Locanda application with invalid details
    Given customer is on landing page of Locanda Application
    When customer tries to login with invalid credentails
    Then customer is not allowed to login
    