#language: en
Feature: Search product

  Scenario: Search second ad on the second page
    Given that I have gone to the Alibaba page
    When I input "Iphone" to search box
    And click the search button
    And I go to the second results page
    Then the second ad has at least "1" item


