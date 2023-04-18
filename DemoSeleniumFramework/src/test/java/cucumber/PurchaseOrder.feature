
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

  Background:
  
  Given User lands on ecommerce website


  @tag2
  Scenario Outline: Positive Test of Submitting the order
    Given Login with username <name> and password <password>
    When Add product <productName> from Cart
    And Checkout <productName> and submit the order 
    Then "THANKYOU FOR THE ORDER" message is displayed on ConfirmationPage

    Examples: 
      | name              | password    | productName      |
      | anshika@gmail.com | Iamking@000 | ADIDAS ORIGINAL  |
     