Feature:Logging into Salesforce

In order to work
as test pro
I want to login


Scenario:Logging in salesforce

Given I go to "loginURL" on "Chrome"
And I enter "loginusername" as ""
And I enter "loginpassword" as ""
And I click on "loginbutton" 
Then login should be "success"
