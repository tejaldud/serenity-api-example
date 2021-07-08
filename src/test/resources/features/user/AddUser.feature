Feature: Add User and Get User details

  Scenario: Add User API
    Given I want to create user with below details:
      | firstName | lastName | password | phone | username | email          |
      | test      | testlast | eewe     | 42343 | test01   | test@gmail.com |
    When I create user
    Then I have user is created successfully


  Scenario: Get User Details
    Given I want to create user with below details:
      | firstName | lastName | password | phone | username | email          |
      | test      | testlast | eewe     | 42343 | test01   | test@gmail.com |
    Then I create user
    Then I have user is created successfully
    When I get user details with username as "test01"
    Then I validate response has expected details

