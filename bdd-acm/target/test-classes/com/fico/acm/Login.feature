#Author: shashankrajput@fico.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


@Login
Feature: Logging into Siron ACM

@Login
Scenario Outline: Logging into Siron ACM
    Given I open <Browser>
    And I navigate to loginURL
    And I login inside application
    |Username|vishaltyagi@fico.com|
    |Password|QAZwsx1@|
    #And I type shashankrajput@fico.com in username field
    #And I type morning@12 in password field
    #And I Click on loginbutton
    Then login should be <Result>
    
		Examples:
		|Browser	|Result	|
		|Chrome		|Success|
