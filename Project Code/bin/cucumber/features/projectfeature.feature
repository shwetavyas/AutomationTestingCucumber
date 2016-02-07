Feature: Testing the signup feature of Nordstrom website

  Scenario: Check if we can reach to signup page
    Given Navigate to Nordstrom website
    When I click Your Account link
    And I am directed to signup page
    When I fill the signup form
    And I click on Create an Account button
    Then Account should get created and I should get LoggedOut

  Scenario: Check if we can reach to Stores & Events page
    Given Navigate to Nordstrom website part-2
    When I click on Stores & Events link
    Then Store & Events page should be displayed
    When I Enter zip code in the search box
    And I click Search button
    Then List of Stores should be displayed

  Scenario: Check sign-in with emailid
    Given Navigate to Nordstrom website part-3
    When I click signin button
    And I populate the fields
    Then I should be logged in to the website

  Scenario: Enter the item to be searched and add to cart
    Given Navigate to Nordstrom website part-3
    When Search item on website
    And I filter the item
    And I sort the item
    And I select the item
    And I add the item to cart
    Then The item should be displayed in cart

  Scenario: Check the add to cart
    Given Navigate to Nordstorm website partFour
    When I click on Women link
    And I click on Clothing link
    And I click on Dresses link
    And I select first item
    And I click on Add to cart
    And I click on Shopping Bag
    And I click on CONTINUE SHOPPING
    And I select second item
    And I click on Add to cart
    And I click on Shopping Bag
    And I click on CHECKOUT
    Then I should be directed to the checkout page

  Scenario: Check the Schedule an appointment
    Given Navigate to Nordstrom website part-5
    When I click on Nordstrom Stylists Link
    And I enter zipcode to check store
    And I select a store
    And I click on Book Appointment
    And I select Personal Styling for women
    And I select Any Stylist
    And I select Quick wardrobe update for Women
    And I select a date and time
    And I enter details
    And I review the details
    And I click on confirm
    Then I should be directed to the confirmed appointment page
