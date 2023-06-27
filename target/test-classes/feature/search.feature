#Author: your.email@your.domain.com
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
@tag
Feature: User should sign in and search products

  @tag1
  Scenario: Clicking on Sign In button on homepage to search products
  
    Given User must be on homepage to search products "https://www.amazon.ca/"
    
    When User clicks on Sign in button to search products
   
    Then Sign in dialog box should be displayed and User should be able to sign in
    And User searches query in search box and results should be displayed with all options
    And User should be able to sort, filter results and click pagination
