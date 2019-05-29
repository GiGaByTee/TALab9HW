Feature: delete emails and undo it

Scenario Outline: User log in, check few emails, delete them and undo this action
  Given login page is open
  Then user enters "<username>" and "<password>"
  Then home page loads, user check few emails and delete them
  Then user click on Undo button and emails are not deleted
  Examples:
    |username  | password |
    |sophiepredko@gmail.com | sonichka13 |


