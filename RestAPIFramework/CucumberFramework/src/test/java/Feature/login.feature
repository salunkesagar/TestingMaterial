Feature: Application Login
Scenario: Home Page Default Login
Given User is on NetBanking page
When User login with Username and Password
Then Home page is populated 
And All cards are displayed