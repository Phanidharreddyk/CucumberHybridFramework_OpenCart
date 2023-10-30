Feature: User Registration

  Scenario: User registers with all fields
    Given the user is on the registration page
    When the user enters the following information:
      | first-name  | John |
      | last-name   | Doe |
      | email       | john.doe@example.com |
      | mobile      | 1234567890 |
      | password | admin|
    And the user clicks the Register button
    Then the user should be successfully registered

  Scenario: User registers with mandatory fields
   Given the user is on the registration page
   When the user enters the mandatory fields
      | first-name  | John |
      | last-name   | Doe |
      | email       | john.doe@example.com |
      | mobile      | 1234567890 |
      | password | admin|
    And the user clicks the Register button
    Then the user should be successfully registered

  Scenario: User registers with an existing email
    Given the user is on the registration page
    When the user enters the information with existing email:
      | first-name  | John |
      | last-name   | Doe |
      | email       | phani1@gmail.com |
      | mobile      | 1234567890 |
      | password | admin|
    And the user clicks the Register button
    Then the registration should fail with an error "Warning: E-Mail Address is already registered!" message


  Scenario: User leaves all required fields empty
    Given the user is on the registration page
    And the user clicks the Register button
    Then the registration should fail with an error messages
