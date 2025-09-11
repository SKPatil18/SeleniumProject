Feature: User Login


Scenario Outline: Login with valid credentials
Given User has navigated to login page
When User enters  valid email address <Username> into email field
And User enters valid password <Password> into password field
And User clicks on login button
Then User should get successfully logged in
Examples:
|Username | Password |
|jajatest123@gmail.com | 12345|
|jajatest124@gmail.com | 12345|
|jajatest125@gmail.com | 12345|


    
Scenario: Login with invalid credentials
Given User has navigated to login page
When User enters invalid email address into email field
And User enters invalid password "1234567" into password field
And User clicks on login button
Then User should get a proper warning message


Scenario:
Login with valid email and invalid password
Given User has navigated to login page
When User enters  valid email address "jajatest123@gmail.com" into email field
And User enters invalid password "1236564567" into password field
And User clicks on login button
Then User should get a proper warning message


Scenario:
Login with invalid email and valid password
Given User has navigated to login page
When User enters invalid email address into email field
And User enters valid password "12345" into password field
And User clicks on login button
Then User should get a proper warning message


Scenario:
Login without providing credentials
Given User has navigated to login page
When User do not enter email address into email field
And User do not enter password into password field
And User clicks on login button
Then User should get a proper warning message


