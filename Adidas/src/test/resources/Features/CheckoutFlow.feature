Feature: As an adidas user i am able to navigate through checkout flow

  Scenario: User is on Adidas site to to buy a product
    Given I am on the Adidas homepage
    Then I search for any word and from the opened page PLP click on the first product
    When I pick a size and click on Add to Bag button
    And I click on View Bag button and navigate to the cart page
    Then I click on the Checkout button
    Then from the Get Your Order module click From A Collection Point option
    Then type London in the location text box
    Then click Search for Collection Points button
    Then from the list pick any collection point
    Then Proceed to the payment step by Review and Pay button
    Then verify that major payment methods PayPal and Credit Card are present
