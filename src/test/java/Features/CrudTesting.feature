Feature: Test CRUD methods in Sample Employee REST API testing
  Scenario: Add Employee service api endpoint
    Given I set GET employee service api endpoint
    When I set request HEADER
    And Send a GET HTTP request
    Then I receive valid Response