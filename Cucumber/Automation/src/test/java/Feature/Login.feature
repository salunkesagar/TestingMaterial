Feature: Application Login;


Scenario: Home Page default Login
Given User is on neebanking page
When User enters the credentials with username "abc" and password "123"
Then Home Page should get displayed
And All cards get displayed is "true"



Scenario: Home Page default Login
Given User is on neebanking page
When User enters the credentials with username "abcd" and password "123"
Then Home Page should get displayed
And All cards get displayed is "false"