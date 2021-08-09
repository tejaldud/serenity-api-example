Feature:Search Terms

  Scenario: Search Term
    Given I am on the Search page
    And I search for term toptal
    And he should only see search results containing the word toptal

