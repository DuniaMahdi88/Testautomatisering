Feature: Sign up

  Scenario Outline: Add simple information
    Given I have started "<browser>" browser
    Given I have written my email "<email>"
    Given I have written my name "<name>"
    Given I have written my password "<password>"
    When  I click the Sign Up button
    Then  when I register I get the text <status>. When I type a long name, I get an error message "<message>".



    Examples:
      | browser | email                  | name                                                                                                                                                    | password     | status | message                                                                            |
      | chrome  | dunia88mahdi@gmail.com | Duniaa88Maahdi888                                                                                                                                         | Dunia88,     | pass   | Check your email                                                                   |
      | edge    | mahdi@gmail.com        | longnnameeeehHHHHVHVHVfdhf41ghggfgfffjjkkggs554rvsjss8dgdvb6j7dhdbkdjs5vsjkssss3233343536373839404142434445bjbb77bhbbhfdkjfbdkbfkdbfkdbf7uhbegeiebefjef | longName123! | faild  | Enter a value less than 100 characters long                                        |
      | chrome  | Modi@gmail.com         | Duniaa88Maahdi888                                                                                                                                         | Upptagen123! | faild  | Another user with this username already exists. Maybe it's your evil twin. Spooky. |
      | edge    |                        | EmailSaknas88                                                                                                                                           | Email13!     | faild  | Please enter a value                                                               |




