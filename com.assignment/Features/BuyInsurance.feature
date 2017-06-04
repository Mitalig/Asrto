Feature: To Test Performance and loading time.

 Scenario Outline: To test performance and loading time of astro within one second
    When You navigate to main "<page>"
    Then Check whether page is loaded within 1 second
    

   Examples: 
      | page                     |
      | http://www.astro.com.my/ |
