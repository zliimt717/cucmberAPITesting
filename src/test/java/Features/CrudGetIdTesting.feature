Feature: Test CRUD methods in Sample Employee REST API Get Id
  Scenario: Check an Employee service api endpoint
    Given I set GET Id employee service api
    When I set request HEADER for an employee
    And Send GET with Id HTTP request
    Then I receive valid Response for an employee