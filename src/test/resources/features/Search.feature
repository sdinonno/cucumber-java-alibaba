#language: en
Feature: Search product

  Scenario: Search second ad on the second page
    Given that I have gone to the Alibaba page
    When I input "Iphone" to search box
    And click the search button
    And click the second page results
    And click the second result
    Then I see has at least "1" item


