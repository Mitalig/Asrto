Feature: To Test Banner Position.

 Scenario Outline: To test that banner position is third.
    When You navigate to main "<page>"
    And Click on Third Banner
    Then Check whether it is a desired banner
    

   Examples: 
      | page                     |
      | http://www.astro.com.my/ |
