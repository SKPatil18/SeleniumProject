Feature: Register Functionality


Scenario:
User creates an account only with mandatory fields
Given User navigates to register account page
When User enters the below fields
|firstName | sunil | 
|lastName | kumar |
|number | 9900184486|
|password | 12345 |
|confirmPassword | 12345|
And User selects privacy policy
And User clicks on create account
Then User account should be created successfully


Scenario:
User creates an account with all fields
Given User navigates to register account page
When User enters the below fields
|firstName | sunil | 
|lastName | kumar |
|number | 9900184486|
|password | 12345 |
|confirmPassword | 12345|
And User selects yes for newsletter
And User selects privacy policy
And User clicks on create account
Then User account should be created successfully



Scenario:
User creates a duplicate account
Given User navigates to register account page
When User enters the below fields with duplicate email
|firstName | sunil | 
|lastName | kumar |
|email | jajatest123dsf@gmail.com|
|number | 9900184486|
|password | 12345 |
|confirmPassword | 12345|
And User selects yes for newsletter
And User selects privacy policy
And User clicks on create account
Then User should get a warning message














