Feature: User Registration

	Scenario: Success during Registration with New User
 		Given the web browser is open
 		When user navigate to registration page
 		And fill new user details
 		Then user should get registered
 		And log out the user

	@smoke
  Scenario: Failure during Registration
    Given the web browser is open
    When user navigate to registration page
    And fill exiting user details
    Then user should get an error on submit