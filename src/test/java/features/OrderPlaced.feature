Feature: Process to place an order

	Scenario Outline: User should able to place an order successfully
	 	Given the browser is open
    And the user is on the login page
    When the user logs in with username <name> and password <password>
   	And user add an item <item> to cart from Menu
   	And confirm the order via checkout
   	Then order should get placed successfully
   	
   	Examples:
  	 	| name         | password  | item  			 |
  	 	| shubham.rana | Qwerty123 | ck one 		 |
  	 	| shubham.rana | Qwerty123 | after shave |