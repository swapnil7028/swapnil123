Feature: Login

Scenario: Successful Login with Valid Credentials
 Given User Launch Chrome browser
 When  User Opens URL " https://admin-demo.nopcommerce.com/login "
 And  User enters Email as "admin@yourstore.com" and Password as "admin"
 And Click on Login
# Then Page Title should be "Dashboard / nopCommarce administration"
 When User Click on Log out link
 Then Page Title should be "Your store. Login"
 And  close browser