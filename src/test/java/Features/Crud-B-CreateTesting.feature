@CreateTesting @APITesting
Feature: Test CRUD methods in Sample Employee REST API Create
  Scenario: Create employee record
    Given I set new employee service api endpoint
    When I set Create new employee request Body
    And Send POST HTTP request, so that add new employee
    Then I receive POST HTTP response
