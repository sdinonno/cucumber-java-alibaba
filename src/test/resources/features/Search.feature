#language: en
Feature: Search product

  @Search
  Scenario: Search second ad on the second page
    Given that I am on the Aliexpress website
    When I do a search with the word "Iphone"
    And I go to the second page results
    And click the second result
    Then I see has at least "1" item


