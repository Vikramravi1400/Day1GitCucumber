@P1 @FBUI @Login
Feature: Facebook Page Login Function
  Background: 
    Given User launch the browser
    And User enters the URL

  @TC01 @FBLogin @Regression @Smoke
  Scenario: To validate FB page login function with invalid credentials
  
    When User enters the username and password
      | userName | password |
      | vicky    | 2345 |
      | Course   | selenium |
    When User clicks the login button
    Then User navigates to login failure page

  @TC02 @FBLogin @Regression @Smoke
  Scenario Outline: To validate FB page login function with combination of all credentials
   
    When User enters the "<userName>" and "<password>"
    And User clicks the login button
    Then User navigates to login failure page

    Examples: 
      | userName | password |
      | Selenium |    12345 |
      | Welcome  |     6789 |
      | Java     |     9876 |

  Scenario: To validate FB page login function with invalid credentials
   
    When User enters the username and password
    When User clicks the login button
    Then User navigates to login failure page
