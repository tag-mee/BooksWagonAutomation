Feature: Product Details Page Validation
  As a user
  I want to view complete and accurate product details
  So that I can make informed purchase decisions

  Scenario: Validate product details for a book and add to wishlist
    Given I navigate to the login page 
    And I log in with valid credentials "Adityajha9665@gmail.com" and "Aditya@9403"
    Then I navigate to search for "Adventures Of Sherlock Holmes"
    Then I should see the product title as "Adventures of Sherlock Holmes: A Collection of Gripping Detective Stories Mystery Novel Classic British Literature a Must-Read Collection of Mystery and Suspense Holmes and Watson"
    And I should see the product description
    And I should see the product price as "₹207"
    And I should see that the product is available
    And I add product to wishlist
    When I click on the "Add to Wishlist" button
    Then the product should be added to my wishlist
