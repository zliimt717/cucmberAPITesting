@UpdateTesting @APITesting
Feature: Test CRUD methods in Sample Employee REST API Update
  Scenario: Update employee record
    Given I set PUT employee service api endpoint
    When I set Update request Body
    And Send PUT HTTP request
    Then I receive valid HTTP response