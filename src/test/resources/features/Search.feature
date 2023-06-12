#language: en
Feature: Search product

  Background:
    Given I am on the Aliexpress website

  @Search
  Scenario Outline: Search second ad on the second page
    When I perform a search with the word "<keyword>"
      And I go to results page number "<page>"
      And I click the item result number "<result>"
    Then I see that the product has at least one item available
    Examples:
      | keyword | page | result |
      | Iphone  | 2    | 2      |


