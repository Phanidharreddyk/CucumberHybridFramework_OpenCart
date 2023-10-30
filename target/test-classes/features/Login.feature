Feature: User Login

  Scenario Outline: Login with valid credentials
    Given the user is on the login page
    When the user enters a valid email <email> into email field
    And the user enters a valid password <password> into password field
    And the user clicks the login button
    Then the user should be logged in successfully
    
    Examples:
    |email							|password	|
    |phani21@gmail.com	|admin		|
    |phani22@gmail.com	|admin		|
    |phani23@gmail.com	|admin		|

  Scenario: Login with invalid credentials
  	Given the user is on the login page
    When the user enters a invalid email into email field
    And the user enters a invalid password "adin" into password field
    And the user clicks the login button
    Then the user should see an warning message "Warning: No match for E-Mail Address and/or Password."

  Scenario: Login with invalid email
   	Given the user is on the login page
    When the user enters a invalid email into email field
    And the user enters a valid password "admin" into password field
    And the user clicks the login button
    Then the user should see an warning message "Warning: No match for E-Mail Address and/or Password."
    
  Scenario: Login with invalid password
   	Given the user is on the login page
    When the user enters a valid email "phajvh@gmail.com" into email field
    And the user enters a invalid password "adijjbn" into password field
    And the user clicks the login button
    Then the user should see an warning message "Warning: No match for E-Mail Address and/or Password."

 	Scenario: Login with empty Email and Password
    Given the user is on the login page
    When the user leaves both email and password fields empty
    And the user clicks the login button
    Then the user should see an warning message "Warning: No match for E-Mail Address and/or Password."