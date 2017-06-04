Feature: To Test Broken Links.

  Scenario Outline: To test broken links of site
    When You navigate to main "<page>"
    Then Check whether links are not broken
    Then Check whether page loads without any error

    Examples: 
      | page                     |
      | http://www.astro.com.my/ |