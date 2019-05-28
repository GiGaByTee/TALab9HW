# new feature
# Tags: optional

Feature: A description

  Scenario Outline: A scenario
    Given Message data
    When I enter correct "<userName>" and "<userPassword>"
    Then Login Successfully
    When I send message
    Then Delete the message
    And Check if message sent
    Then Close browser

    Examples:
      | userName       | userPassword   |
      | testmy12341234 | 1234test1234My |
      | tt8517837      | 856ttestmy856  |
      | test28832      | 12345test54321 |
      | test28361      | 12345test12345 |
      | test283611     | 1234512345t    |


