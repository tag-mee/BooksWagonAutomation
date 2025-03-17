Feature: Automate Cart Functionality
  As a user
  I want to manage my cart with items
  So that I can proceed to checkout with desired changes

  Scenario: Add, update, and checkout with items in the cart
    Given I am on the Bookswagon website
    When I add an item to the cart
    And I open the cart
    And I update the quantity to "3"
    And I remove an item from the cart
    And I should proceed to checkout 
    Then I login with valid credentials for checkout
