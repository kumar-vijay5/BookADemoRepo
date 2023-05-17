Feature: Book a request for Demo to the given test data

  Scenario: Visit home page
    Given I am on Request demo form page with empty fields
    When I enter the required information and submit the page
    Then I should see career guide page