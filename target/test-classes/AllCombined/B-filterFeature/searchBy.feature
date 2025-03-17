@search
Feature: Apply Filters on Bookswagon Search Results
  As a user
  I want to filter search results by price, discount, and language
  So that I can refine my search to find relevant books
  Scenario: Filter search results by Price, Discount, and Language
    Given I am on the Bookswagon search results page for "Harry Potter"
    When I click on the price filter "<price>"
    And I click on the discount filter "<percent>"
    And I click on the language "<language>"
    Then I should see the search results filtered
    
    Examples:
    				|language |price						|percent  |
    			  |English  |Rs.500 - Rs.1000 |31% - 40%|
    			  |Spanish  |Rs.100 - Rs.500  |41% - 50%|
    			  |Hindi	  |Rs.1000 - Rs.2000|51% - 60%|
    			  