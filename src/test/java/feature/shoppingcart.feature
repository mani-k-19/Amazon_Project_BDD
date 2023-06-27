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
Feature: User should sign in, add products  to cart and checkout

  @tag1
  Scenario: User should be able to add/update products to cart and checkout
  
    Given User must be on homepage to shop products "https://www.amazon.ca/"
    
    When User signs in to shop products
   
    Then User should be able to sign in
    And User should be able to add update cart and checkout