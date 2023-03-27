@DeleteTesting @APITesting
Feature: Test CRUD methods in Sample Employee REST API Delete
  Scenario: Delete Employee record
    Given I set Delete Employee service endpoint
    When I send Delete HTTP request
    Then I receive valid Delete response