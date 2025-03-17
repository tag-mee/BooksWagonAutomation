Feature: Search Bar Functionality
		@home
    Scenario: Verify that the search bar is displayed on the home page
    Given I am on the Bookswagon home page
    When I look for the search bar
    Then the search bar should be visible
