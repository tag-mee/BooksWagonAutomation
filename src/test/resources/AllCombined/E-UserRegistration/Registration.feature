Feature: User Login

		Scenario: User tries to login with different credentials
    Given I am on the login page
    When I enter "<username>" and "<password>" in the login form
    And I click on the Login button
    Then I should see a homepage address saying "https://www.bookswagon.com/myaccount.aspx"

    Examples:
      | username                     | password      |
      | Test1122@gmail.com           | Test@123      |
      | Adityajha9665@gmail.com      | Aditya@9403 	 |
      | unkowna83@gmail.com          | Test@123      |
			