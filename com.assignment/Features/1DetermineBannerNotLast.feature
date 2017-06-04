Feature: To Test Banner Position is not Lat.

  Scenario Outline: To test that banner position is not Last.
    When You navigate to main "<page>"
    And Click on Last Banner
    Then Check whether it is not third banner
    And Click on Third Banner
    And Click on Register Button
    And Enter the details
      | FirstName | LastName    | AstoID   | Email Address                                             | Password   |
      | Ashwin    | Karangutkar | ashwiink | ashwin.karangutkar | test@$12345 |
    And Click on I agree Signup button
    Then Check SignUp is Successful

    Examples: 
      | page                     |
      | http://www.astro.com.my/ |
