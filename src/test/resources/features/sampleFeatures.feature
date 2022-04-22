Feature: Amazon landing page feature

  Scenario: Check title of the landing page
    Given user is in the landing page
    When user gets the title of page
    Then the title of page should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"

  Scenario: check amazon logo is present
    Given user is in the landing page
    Then amazon logo should be there

  Scenario: search for product
    Given user is in the landing page
    Then Having search field on the amazon
    When I search for the product "iphone"
    Then Product should be displayed "iphone"

  Scenario: Selecting one product from list
    Given user is in the landing page
    Then Having search field on the amazon
    When I search for the product "iphone"
    When click on one of the product
    When user gets the title of page
    Then the title of page should be "Apple iPhone 13 (128GB) - Green : Amazon.in: Electronics"

  Scenario: Adding product to cart
    Given user is in the landing page
    Then Having search field on the amazon
    When I search for the product "iphone"
    When click on one of the product
    When clicked on add to cart
    When clicked on go to cart
    When user gets the title of page
    Then the title of page should be "Amazon.in Shopping Cart11"

  Scenario: Try to buy product without log in
    Given user is in the landing page
    Then Having search field on the amazon
    When I search for the product "iphone"
    When click on one of the product
    When clicked on add to cart
    When clicked on go to cart
    Then clicked on proceed to buy
    When user gets the title of page
    Then the title of page should be "Amazon Sign In"
