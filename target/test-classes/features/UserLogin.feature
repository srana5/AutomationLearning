Feature: User Login

  Scenario Outline: Successful login
    Given the browser is open
    And the user is on the login page
    When the user logs in with username <name> and password <password>
    Then the user logs in, logs out, and closes the browser

    Examples:
      | name         | password  |
      | shubham.rana | Qwerty123 |
      
      
   Scenario Template: Unsuccessful Login
   Given the browser is open
   And the user is on the login page
   When the user logs in with username <name> and password <password>
   Then the user should get an error message
   
   Examples:
			| name  	| password 	|
			| john  	| psw@123  	|
			| shawn 	| qw9567   	| 
   
