Feature: Login related scenario

  Background:
   # Given user is navigated to HRMS application

 @sprint1 @regression @smoke @newTestcase @newFeature @login
  Scenario: Valid admin login
   When  user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application

   @employee @sprint1
   Scenario:  valid ess login
     When user enters ess username and password
     And user clicks on login button
     Then user is successfully logged in the application

     @invalid @sprint1
     Scenario: invalid admin login
       When user enters invalid admin username and password
       And user clicks on login button
       Then error message is displayed


  @negative
  Scenario Outline: negative login test
    When user enters "<username>" and "<password>" and verifying the "<error>" for the combinations
    Examples:
      | username | password | error |
      |admin     |fkfkkkj   |Invalid credentials|
      |admin1    |Hum@nhrm123|Invalid credentials|
      |          |Hum@nhrm123|Username cannot be empty|
      |admin     |           |Password cannot be empty|







         # Feature is a userStory
       #Scenario->>>> Test case
       # But ->>>  means when we want to exclude something











