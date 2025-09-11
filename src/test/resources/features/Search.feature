 Feature: Search Functionality
 
 Scenario:
User searches for a valid product

Given User opens the application
When User enters valid product "HP" into the search field
When User clicks on search button
Then User should get a valid product displayed on the results

Scenario:
User searches for an invalid product
Given User opens the application
When User enters invalid product "Honda" into the search box field
And User clicks on search button
Then User should get a message about no product matching

Scenario:
User searches without any product
Given User opens the application
When User do not enter any product into search box 
And User clicks on search button
Then User should get a message about no product matching